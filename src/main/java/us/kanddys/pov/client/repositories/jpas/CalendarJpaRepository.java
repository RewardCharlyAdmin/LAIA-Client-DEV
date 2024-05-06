package us.kanddys.pov.client.repositories.jpas;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.models.Calendar;

@Repository
public interface CalendarJpaRepository extends JpaRepository<Calendar, Long> {

   @Query(value = "SELECT delay, delay_type, id FROM calendars WHERE merchant = ?1", nativeQuery = true)
   Map<String, Object> findDelayAndDelayTypeAndIdByMerchant(Long merchant);
}
