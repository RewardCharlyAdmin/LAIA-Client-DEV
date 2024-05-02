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
public class RLoginClientDTO {
   @JsonProperty
   private String name;
   @JsonProperty
   private String surname;
   @JsonProperty
   private String media;
   @JsonProperty
   private Integer status;

   public RLoginClientDTO() {
   }
}
