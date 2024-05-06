package us.kanddys.pov.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import us.kanddys.pov.client.services.InvoiceProductService;

@Controller
public class InvoiceProductController {

   @Autowired
   private InvoiceProductService invoiceProductService;

   @MutationMapping
   public Integer aClientInvoiceProduct(Long invoice, Long product) {
      return invoiceProductService.aClientInvoiceProduct(invoice, product);
   }

   @MutationMapping
   public Integer dClientInvoiceProduct(Long invoiceProduct) {
      return invoiceProductService.dClientInvoiceProduct(invoiceProduct);
   }
}
