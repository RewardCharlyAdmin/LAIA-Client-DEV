package us.kanddys.pov.client.services;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface UserService {

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Long cClientUser(Optional<String> email, Optional<String> name, Optional<String> password,
         Optional<String> phone);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public String uClientUserMedia(MultipartFile media, String user);
}
