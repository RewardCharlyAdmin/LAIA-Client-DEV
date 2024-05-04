package us.kanddys.pov.client.models;

import java.util.Optional;
import java.util.UUID;

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
@Table(name = "users")
@Entity
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "email")
   private String email;
   @Column(name = "name")
   private String name;
   @Column(name = "password")
   private String password;
   @Column(name = "surname")
   private String surname;
   @Column(name = "phone")
   private String phone;
   @Column(name = "media")
   private String media;
   @Column(name = "first")
   private Integer first;
   @Column(name = "reference")
   private String reference;

   public User() {
   }

   /**
    * Constructor personalizado utilizado cuando el usuario se registra por primera
    * vez.
    *
    * @author Igirod0
    * @version 1.0.0
    * @param email
    * @param name
    * @param phone
    * @param password
    */
   public User(String email, String name, String phone, Optional<String> password) {
      super();
      this.id = null;
      this.email = email;
      this.name = name;
      this.phone = phone;
      this.password = (password.isPresent()) ? password.get() : UUID.randomUUID().toString().substring(0, 10);
      this.first = 1;
      this.reference = UUID.randomUUID().toString().substring(0, 10);
   }
}
