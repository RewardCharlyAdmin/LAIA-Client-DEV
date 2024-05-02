package us.kanddys.pov.client.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@AllArgsConstructor
@Data
public class RCheckEmailDTO {
   @JsonProperty
   private Long userId;
   @JsonProperty
   private Integer exist;

   public RCheckEmailDTO() {
   }
}
