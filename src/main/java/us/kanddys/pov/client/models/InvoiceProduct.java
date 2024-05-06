package us.kanddys.pov.client.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import us.kanddys.pov.client.models.utils.enums.StockTypeEnum;

@AllArgsConstructor
@Data
@Table(name = "invoice_products")
@Entity
public class InvoiceProduct {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "invoice")
   private Long invoice;
   @Column(name = "title")
   private String title;
   @Column(name = "price")
   private Double price;
   @Column(name = "count")
   private Integer count;
   @Column(name = "count_type")
   @Enumerated(value = EnumType.STRING)
   private StockTypeEnum countType;

   public InvoiceProduct() {
   }

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public InvoiceProduct(Long invoice, String title, Double price, StockTypeEnum countType) {
      this.id = null;
      this.invoice = invoice;
      this.title = (title == null) ? null : title;
      this.price = (price == null) ? null : price;
      this.count = 1;
      this.countType = (countType == null) ? null : countType;
   }
}
