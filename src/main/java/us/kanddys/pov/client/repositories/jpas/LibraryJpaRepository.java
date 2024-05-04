package us.kanddys.pov.client.repositories.jpas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Library;

@Repository
public interface LibraryJpaRepository extends JpaRepository<Library, Long> {
}
