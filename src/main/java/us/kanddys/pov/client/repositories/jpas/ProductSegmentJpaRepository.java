package us.kanddys.pov.client.repositories.jpas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.ProductSegment;

@Repository
public interface ProductSegmentJpaRepository extends JpaRepository<ProductSegment, Long> {

   @Query("SELECT ps FROM ProductSegment ps WHERE ps.product = :product")
   List<ProductSegment> findByProduct(Long product);

}
