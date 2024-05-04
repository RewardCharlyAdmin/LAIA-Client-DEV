package us.kanddys.pov.client.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import us.kanddys.pov.client.services.UserService;

@Controller
public class UserController {

   @Autowired
   private UserService userService;

   @MutationMapping
   public Long cClientUser(@Argument Optional<String> email, @Argument Optional<String> name,
         @Argument Optional<String> password, @Argument Optional<String> phone) {
      return userService.cClientUser(email, name, password, phone);
   }
}