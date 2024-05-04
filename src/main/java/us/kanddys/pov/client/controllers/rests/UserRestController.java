package us.kanddys.pov.client.controllers.rests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import us.kanddys.pov.client.services.UserService;

@RestController
@RequestMapping("users")
public class UserRestController {

   @Autowired
   private UserService userService;

   @RequestMapping(method = { RequestMethod.PATCH }, value = "/update-media", produces = {
         "application/json" }, consumes = { "multipart/form-data" })
   public ResponseEntity<String> updateMedia(@RequestPart(required = true) MultipartFile media,
         @RequestPart(required = true) String user) {
      return ResponseEntity.ok(userService.uClientUserMedia(media, user));
   }
}
