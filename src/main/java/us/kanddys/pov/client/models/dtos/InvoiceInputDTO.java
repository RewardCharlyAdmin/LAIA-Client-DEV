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
public class InvoiceInputDTO {
   @JsonProperty
   private Long user;
   @JsonProperty
   private String userEmail;
   @JsonProperty
   private String userName;
   @JsonProperty
   private String userSurname;
   @JsonProperty
   private String userPhone;
   @JsonProperty
   private String userMedia;
   @JsonProperty
   private String userRef;

   public InvoiceInputDTO() {
   }
}
