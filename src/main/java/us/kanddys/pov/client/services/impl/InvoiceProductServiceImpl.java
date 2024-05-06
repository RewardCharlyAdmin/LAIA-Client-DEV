package us.kanddys.pov.client.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.kanddys.pov.client.exceptions.InvoiceNotFoundException;
import us.kanddys.pov.client.exceptions.MerchantNotFoundException;
import us.kanddys.pov.client.exceptions.ProductNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.Invoice;
import us.kanddys.pov.client.models.InvoiceProduct;
import us.kanddys.pov.client.models.Merchant;
import us.kanddys.pov.client.models.Product;
import us.kanddys.pov.client.repositories.jpas.InvoiceJpaRepository;
import us.kanddys.pov.client.repositories.jpas.InvoiceProductJpaRepository;
import us.kanddys.pov.client.repositories.jpas.MerchantJpaRepository;
import us.kanddys.pov.client.repositories.jpas.ProductJpaRepository;
import us.kanddys.pov.client.services.InvoiceProductService;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService {

   @Autowired
   private MerchantJpaRepository merchantJpaRepository;

   @Autowired
   private ProductJpaRepository productJpaRepository;

   @Autowired
   private InvoiceJpaRepository invoiceJpaRepository;

   @Autowired
   private InvoiceProductJpaRepository invoiceProductJpaRepository;

   @Override
   public Integer aClientInvoiceProduct(Long invoice, Long product) {
      Invoice existInvoice = invoiceJpaRepository.findById(invoice)
            .orElseThrow(() -> new InvoiceNotFoundException(ExceptionMessage.INVOICE_NOT_FOUND));
      Product existProduct = productJpaRepository.findById(product)
            .orElseThrow(() -> new ProductNotFoundException(ExceptionMessage.PRODUCT_NOT_FOUND));
      Merchant existMerchant = merchantJpaRepository.findById(existProduct.getMerchant())
            .orElseThrow(() -> new MerchantNotFoundException(ExceptionMessage.MERCHANT_NOT_FOUND));
      // ! En caso de que la factura no tenga asociado un merchant.
      if (existInvoice.getMerchantId() == null)
         setMerchantAtributtes(existMerchant, existInvoice);
      invoiceProductJpaRepository.save(
            new InvoiceProduct(invoice, existProduct.getTitle(), existProduct.getPrice(), existProduct.getStockType()));
      return 1;
   }

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   private void setMerchantAtributtes(Merchant existMerchant, Invoice invoice) {
      invoice.setMerchantId(existMerchant.getId());
      invoice.setMerchantEmail((existMerchant.getEmail() == null) ? null : existMerchant.getEmail());
      invoice.setMerchantPhone((existMerchant.getPhone() == null) ? null : existMerchant.getPhone());
      invoice.setMerchantTitle((existMerchant.getTitle() == null) ? null : existMerchant.getTitle());
      invoiceJpaRepository.save(invoice);
   }

   @Override
   public Integer dClientInvoiceProduct(Long invoiceProduct) {
      invoiceProductJpaRepository.deleteById(invoiceProduct);
      return 1;
   }
}
