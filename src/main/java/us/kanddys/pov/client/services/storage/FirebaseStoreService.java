package us.kanddys.pov.client.services.storage;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface FirebaseStoreService {

   /**
    * @author Igirod
    * @version 1.0.0
    */
   public String uploadFile(MultipartFile multipartFile, String imageName, String folderName, Integer width,
         Integer height);
}
