package us.kanddys.pov.client.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import us.kanddys.pov.client.models.Direction;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@AllArgsConstructor
@Data
public class DirectionDTO {
   @JsonProperty
   private Long id;
   @JsonProperty
   private String code;
   @JsonProperty
   private String note;
   @JsonProperty
   private String reference;
   @JsonProperty
   private String street;
   @JsonProperty
   private String number;
   @JsonProperty
   private String city;
   @JsonProperty
   private String state;
   @JsonProperty
   private String country;
   @JsonProperty
   private String lat;
   @JsonProperty
   private String lng;

   public DirectionDTO() {
   }

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public DirectionDTO(Direction direction) {
      super();
      this.id = (direction.getId() != null ? direction.getId() : null);
      this.code = (direction.getCode() != null ? direction.getCode() : null);
      this.note = (direction.getNote() != null ? direction.getNote() : null);
      this.reference = (direction.getReference() != null ? direction.getReference() : null);
      this.street = (direction.getStreet() != null ? direction.getStreet() : null);
      this.number = (direction.getNumber() != null ? direction.getNumber() : null);
      this.city = (direction.getCity() != null ? direction.getCity() : null);
      this.state = (direction.getState() != null ? direction.getState() : null);
      this.country = (direction.getCountry() != null ? direction.getCountry() : null);
      this.lat = (direction.getLat() != null ? direction.getLat() : null);
      this.lng = (direction.getLng() != null ? direction.getLng() : null);
   }
}
