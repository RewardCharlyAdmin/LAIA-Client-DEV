package us.kanddys.pov.client.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Table(name = "product_segments")
@Entity
public class ProductSegment {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "product")
   private Long product;
   @Column(name = "title")
   private String title;
   @Column(name = "description")
   private String description;
   @Column(name = "media")
   private String media;

   public ProductSegment() {
   }
}
