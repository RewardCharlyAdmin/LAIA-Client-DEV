package us.kanddys.pov.client.models.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@AllArgsConstructor
@Data
public class ShopProductDetailDTO {
   @JsonProperty
   private Long id;
   @JsonProperty
   private Long merchant;
   @JsonProperty
   private String title;
   @JsonProperty
   private String price;
   @JsonProperty
   private String frontPage;
   @JsonProperty
   private List<ShopProductDetailMediaDTO> medias;
   @JsonProperty
   private List<ShopProductDetailSegmentDTO> segments;
   @JsonProperty
   private Integer stock;
   @JsonProperty
   private String merchantDirection;
   @JsonProperty
   private String firstShippinDate;
   @JsonProperty
   private Long batchId;
   @JsonProperty
   private String batchFrom;
   @JsonProperty
   private String batchTo;

   public ShopProductDetailDTO() {
   }

}
