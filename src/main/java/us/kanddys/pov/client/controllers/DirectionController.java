package us.kanddys.pov.client.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import us.kanddys.pov.client.models.dtos.DirectionDTO;
import us.kanddys.pov.client.services.DirectionService;

@Controller
public class DirectionController {

   @Autowired
   private DirectionService directionService;

   @MutationMapping("cClientDirection")
   public Long cClientDirection(@Argument Long user, @Argument Optional<String> code,
         @Argument Optional<String> country,
         @Argument Optional<String> state, @Argument Optional<String> city, @Argument Optional<String> street,
         @Argument Optional<String> number, @Argument Optional<String> reference, @Argument Optional<String> note,
         @Argument Optional<String> lat,
         @Argument Optional<String> lng) {
      return directionService.cClientDirection(user, code, country, state, city, street, number, reference, note, lat,
            lng);
   }

   @MutationMapping("uClientDirection")
   public Integer uClientDirection(@Argument Long id, @Argument Optional<String> code,
         @Argument Optional<String> country,
         @Argument Optional<String> state, @Argument Optional<String> city, @Argument Optional<String> street,
         @Argument Optional<String> number, @Argument Optional<String> reference, @Argument Optional<String> note,
         @Argument Optional<String> lat,
         @Argument Optional<String> lng) {
      return directionService.uClientDirection(id, code, country, state, city, street, number, reference, note, lat,
            lng);
   }

   @MutationMapping("dClientDirection")
   public Integer dClientDirection(@Argument Long id) {
      return directionService.dClientDirection(id);
   }

   @QueryMapping("gClientDirections")
   public Set<DirectionDTO> gClientDirections(@Argument Long user) {
      return directionService.gClientDirections(user);
   }
}
