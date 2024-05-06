package us.kanddys.pov.client.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import us.kanddys.pov.client.models.ProductSegment;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@AllArgsConstructor
@Data
public class ShopProductDetailSegmentDTO {
   @JsonProperty
   private Long id;
   @JsonProperty
   private Long product;
   @JsonProperty
   private String title;
   @JsonProperty
   private String description;
   @JsonProperty
   private String media;

   public ShopProductDetailSegmentDTO() {
   }

   /**
    * Constructor personalizado utilizado en diferentes servicios.
    */
   public ShopProductDetailSegmentDTO(ProductSegment productSegment) {
      this.id = (productSegment.getId() != null) ? productSegment.getId() : null;
      this.product = (productSegment.getProduct() != null) ? productSegment.getProduct() : null;
      this.title = (productSegment.getTitle() != null) ? productSegment.getTitle() : null;
      this.description = (productSegment.getDescription() != null) ? productSegment.getDescription() : null;
      this.media = (productSegment.getMedia() != null) ? productSegment.getMedia() : null;
   }
}
