package us.kanddys.pov.client.repositories.jpas;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.LibraryCollection;

@Repository
public interface LibraryCollectionJpaRepository extends JpaRepository<LibraryCollection, Long> {

   @Query(value = "SELECT * FROM library_collections WHERE library = ?1", nativeQuery = true)
   List<LibraryCollection> findByLibraryId(Long id);
}
