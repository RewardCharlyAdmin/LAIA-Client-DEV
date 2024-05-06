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
public class ShopProductDetailMediaDTO {
   @JsonProperty
   private Long id;
   @JsonProperty
   private Long product;
   @JsonProperty
   private String url;
   @JsonProperty
   private String type;

   public ShopProductDetailMediaDTO() {
   }
}
