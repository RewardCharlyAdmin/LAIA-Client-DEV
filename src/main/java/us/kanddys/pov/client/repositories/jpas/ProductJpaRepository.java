package us.kanddys.pov.client.repositories.jpas;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Product;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
