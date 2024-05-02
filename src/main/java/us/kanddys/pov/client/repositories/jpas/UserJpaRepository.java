package us.kanddys.pov.client.repositories.jpas;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.User;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {

   @Query(value = "SELECT id FROM users WHERE email = :email", nativeQuery = true)
   Long findUserIdByEmail(String email);

   @Query(value = "SELECT name, surname, media, password FROM users WHERE id = :userId", nativeQuery = true)
   Map<String, Object> findNameAndSurnameAndMediaAndPasswordByUserId(Long userId);
}
