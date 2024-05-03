package us.kanddys.pov.client.services;

import java.util.Optional;
import java.util.Set;

import us.kanddys.pov.client.models.dtos.DirectionDTO;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface DirectionService {

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Long cClientDirection(Long user, Optional<String> code, Optional<String> country, Optional<String> state,
         Optional<String> city, Optional<String> street,
         Optional<String> number, Optional<String> reference, Optional<String> note, Optional<String> lat,
         Optional<String> lng);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Integer uClientDirection(Long id, Optional<String> code, Optional<String> country, Optional<String> state,
         Optional<String> city, Optional<String> street, Optional<String> number, Optional<String> reference,
         Optional<String> note, Optional<String> lat, Optional<String> lng);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Integer dClientDirection(Long id);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public Set<DirectionDTO> gClientDirections(Long user);
}
