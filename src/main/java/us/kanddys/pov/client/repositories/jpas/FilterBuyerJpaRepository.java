package us.kanddys.pov.client.repositories.jpas;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.FilterBuyer;

@Repository
public interface FilterBuyerJpaRepository extends JpaRepository<FilterBuyer, Long> {

   @Query("SELECT fb FROM FilterBuyer fb WHERE fb.collection = ?1")
   public Optional<FilterBuyer> findByCollectionId(Long collectionId);
}
