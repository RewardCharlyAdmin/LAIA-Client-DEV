package us.kanddys.pov.client.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@AllArgsConstructor
@Data
@Table(name = "user_directions")
@Entity
public class Direction {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "user")
   private Long user;
   @Column(name = "code")
   private String code;
   @Column(name = "country")
   private String country;
   @Column(name = "state")
   private String state;
   @Column(name = "city")
   private String city;
   @Column(name = "street")
   private String street;
   @Column(name = "number")
   private String number;
   @Column(name = "reference")
   private String reference;
   @Column(name = "note")
   private String note;
   @Column(name = "lat")
   private String lat;
   @Column(name = "lng")
   private String lng;

   public Direction() {
   }
}
