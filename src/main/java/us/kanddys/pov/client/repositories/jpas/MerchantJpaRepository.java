package us.kanddys.pov.client.repositories.jpas;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Merchant;

@Repository
public interface MerchantJpaRepository extends JpaRepository<Merchant, Long> {

   @Query(value = "SELECT id, title FROM merchants WHERE slug = :slug", nativeQuery = true)
   public Map<String, Object> findMerchantIdAndTitle(String slug);
}
