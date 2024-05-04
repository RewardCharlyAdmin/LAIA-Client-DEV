package us.kanddys.pov.client.services.storage.impl;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

import us.kanddys.pov.client.services.storage.FirebaseStoreService;
import us.kanddys.pov.client.services.storage.utils.ImageFormat;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public class FirebaseStoreServiceImpl implements FirebaseStoreService {

   public String uploadFile(MultipartFile multipartFile, String imageName, String folderName, Integer width,
         Integer height) {
      try {
         StorageOptions storageOptions = StorageOptions.newBuilder()
               .setProjectId("laia-c5d59")
               .setCredentials(
                     GoogleCredentials.fromStream(new ClassPathResource("firebase_admin.json").getInputStream()))
               .build();
         Storage storage = storageOptions.getService();
         String objectName = folderName + "/" + imageName;
         BlobInfo blobInfo = BlobInfo.newBuilder(BlobId.of("laia-c5d59.appspot.com", objectName))
               .setContentType("image/png")
               .build();
         storage.create(blobInfo, ImageFormat.resizeImage(multipartFile, width, height));
         return storage.signUrl(blobInfo, 3650, TimeUnit.DAYS).toString();
      } catch (IOException e) {
         throw new RuntimeException(e.getMessage());
      }
   }
}
