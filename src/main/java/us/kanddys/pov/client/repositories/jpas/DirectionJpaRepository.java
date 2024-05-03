package us.kanddys.pov.client.repositories.jpas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Direction;

@Repository
public interface DirectionJpaRepository extends JpaRepository<Direction, Long> {

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   List<Direction> findByUser(Long user);
}
