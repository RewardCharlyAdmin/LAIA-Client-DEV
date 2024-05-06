package us.kanddys.pov.client.exceptions;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public class InvoiceNotFoundException extends RuntimeException {

   private static final long serialVersionUID = 1L;

   public InvoiceNotFoundException(String message) {
      super(message);
   }
}
