package us.kanddys.pov.client.exceptions;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public class UserNotFoundException extends RuntimeException {

   public UserNotFoundException(String message) {
      super(message);
   }
}
