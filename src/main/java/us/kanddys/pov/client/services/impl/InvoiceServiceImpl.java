package us.kanddys.pov.client.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import us.kanddys.pov.client.exceptions.UserNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.Invoice;
import us.kanddys.pov.client.models.User;
import us.kanddys.pov.client.repositories.jpas.InvoiceJpaRepository;
import us.kanddys.pov.client.repositories.jpas.UserJpaRepository;
import us.kanddys.pov.client.services.InvoiceService;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {

   @Autowired
   private UserJpaRepository userJpaRepository;

   @Autowired
   private InvoiceJpaRepository invoiceJpaRepository;

   @Override
   public Long cClientInvoice(@Argument Optional<Long> user) {
      if (user.isPresent()) {
         User existUser = userJpaRepository.findById(user.get())
               .orElseThrow(() -> new UserNotFoundException(ExceptionMessage.USER_NOT_FOUND));
         return invoiceJpaRepository
               .save(new Invoice(existUser.getId(), (existUser.getName() != null ? existUser.getName() : null),
                     (existUser.getSurname() != null ? existUser.getSurname() : null),
                     (existUser.getEmail() != null ? existUser.getEmail() : null),
                     (existUser.getMedia() != null ? existUser.getMedia() : null),
                     (existUser.getPhone() != null ? existUser.getPhone() : null)))
               .getId();
      }
      return invoiceJpaRepository.save(new Invoice(null, null, null, null, null, null)).getId();
   }
}
