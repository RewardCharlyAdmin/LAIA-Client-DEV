package us.kanddys.pov.client.services;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface InvoiceProductService {

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Integer aClientInvoiceProduct(Long invoice, Long product);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Integer dClientInvoiceProduct(Long invoiceProduct);
}
