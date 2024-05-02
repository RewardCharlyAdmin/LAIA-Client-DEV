package us.kanddys.pov.client.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.kanddys.pov.client.models.dtos.RCheckEmailDTO;
import us.kanddys.pov.client.models.dtos.RLoginClientDTO;
import us.kanddys.pov.client.repositories.jpas.UserJpaRepository;
import us.kanddys.pov.client.services.SqqService;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@Service
public class SqqServiceImpl implements SqqService {

   @Autowired
   private UserJpaRepository userJpaRepository;

   @Override
   public RCheckEmailDTO sqqCheck(String email) {
      var userId = userJpaRepository.findUserIdByEmail(email);
      if (userId == null)
         return new RCheckEmailDTO(0L, 0);
      return new RCheckEmailDTO(userId, 1);
   }

   @Override
   public RLoginClientDTO sqqLogin(Long userId, String password) {
      var userAtributtes = userJpaRepository.findNameAndSurnameAndMediaAndPasswordByUserId(userId);
      if (userAtributtes.get("password").equals(password))
         return new RLoginClientDTO((userAtributtes.get("name") == null ? null : userAtributtes.get("name").toString()),
               (userAtributtes.get("surname") == null ? null : userAtributtes.get("surname").toString()),
               (userAtributtes.get("media") == null ? null : userAtributtes.get("media").toString()), 1);
      return new RLoginClientDTO(null, null, null, 0);
   }
}
