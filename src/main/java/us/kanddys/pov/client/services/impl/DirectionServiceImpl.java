package us.kanddys.pov.client.services.impl;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.kanddys.pov.client.exceptions.DirectionNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.Direction;
import us.kanddys.pov.client.models.dtos.DirectionDTO;
import us.kanddys.pov.client.repositories.jpas.DirectionJpaRepository;
import us.kanddys.pov.client.services.DirectionService;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@Service
public class DirectionServiceImpl implements DirectionService {

   @Autowired
   private DirectionJpaRepository directionJpaRepository;

   @Override
   public Long cClientDirection(Long user, Optional<String> code, Optional<String> country, Optional<String> state,
         Optional<String> city, Optional<String> street,
         Optional<String> number, Optional<String> reference, Optional<String> note, Optional<String> lat,
         Optional<String> lng) {
      return directionJpaRepository
            .save(new Direction(null, user, (code.isPresent() ? code.get().toString() : null),
                  (country.isPresent() ? country.get().toString() : null),
                  (state.isPresent() ? state.get().toString() : null),
                  (city.isPresent() ? city.get().toString() : null),
                  (street.isPresent() ? street.get().toString() : null),
                  (number.isPresent() ? number.get().toString() : null),
                  (reference.isPresent() ? reference.get().toString() : null),
                  (note.isPresent() ? note.get().toString() : null), (lat.isPresent() ? lat.get().toString() : null),
                  (lng.isPresent() ? lng.get().toString() : null)))
            .getId();
   }

   @Override
   public Integer uClientDirection(Long id, Optional<String> code, Optional<String> country, Optional<String> state,
         Optional<String> city, Optional<String> street, Optional<String> number, Optional<String> reference,
         Optional<String> note, Optional<String> lat, Optional<String> lng) {
      Direction direction = directionJpaRepository.findById(id)
            .orElseThrow(() -> new DirectionNotFoundException(ExceptionMessage.DIRECTION_NOT_FOUND));
      code.ifPresent(direction::setCode);
      country.ifPresent(direction::setCountry);
      state.ifPresent(direction::setState);
      city.ifPresent(direction::setCity);
      street.ifPresent(direction::setStreet);
      number.ifPresent(direction::setNumber);
      reference.ifPresent(direction::setReference);
      note.ifPresent(direction::setNote);
      lat.ifPresent(direction::setLat);
      lng.ifPresent(direction::setLng);
      directionJpaRepository.save(direction);
      return 1;
   }

   @Override
   public Integer dClientDirection(Long id) {
      directionJpaRepository.deleteById(id);
      return 1;
   }

   @Override
   public Set<DirectionDTO> gClientDirections(Long user) {
      return directionJpaRepository.findByUser(user).stream().map(DirectionDTO::new).collect(Collectors.toSet());
   }
}
