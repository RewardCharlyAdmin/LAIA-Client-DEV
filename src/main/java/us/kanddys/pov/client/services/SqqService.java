package us.kanddys.pov.client.services;

import us.kanddys.pov.client.models.dtos.RCheckEmailDTO;
import us.kanddys.pov.client.models.dtos.RLoginClientDTO;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface SqqService {

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public RCheckEmailDTO sqqCheck(String email);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public RLoginClientDTO sqqLogin(Long merchantId, String password);
}
