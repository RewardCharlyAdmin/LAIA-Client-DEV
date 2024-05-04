package us.kanddys.pov.client.services.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import us.kanddys.pov.client.exceptions.UserNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.User;
import us.kanddys.pov.client.repositories.jpas.UserJpaRepository;
import us.kanddys.pov.client.services.UserService;
import us.kanddys.pov.client.services.storage.impl.FirebaseStoreServiceImpl;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserJpaRepository userJpaRepository;

   @Autowired
   private FirebaseStoreServiceImpl firebaseStoreService;

   @Override
   public Long cClientUser(Optional<String> email, Optional<String> name, Optional<String> password,
         Optional<String> phone) {
      return userJpaRepository
            .save(new User(email.orElse(null), name.orElse(null), phone.orElse(null), password)).getId();
   }

   @Override
   public String uClientUserMedia(MultipartFile media, String user) {
      User existUser = userJpaRepository.findById(Long.valueOf(user.toString()))
            .orElseThrow(() -> new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND));
      existUser.setMedia(firebaseStoreService.uploadFile(media,
            "user-media-" + existUser.getId().toString() + "-" + UUID.randomUUID().toString(),
            "userMedias", 128, 128));
      userJpaRepository.save(existUser);
      return existUser.getMedia();
   }

}
