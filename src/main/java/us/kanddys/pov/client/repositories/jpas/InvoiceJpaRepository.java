package us.kanddys.pov.client.repositories.jpas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Invoice;

@Repository
public interface InvoiceJpaRepository extends JpaRepository<Invoice, Long> {
}
