package us.kanddys.pov.client.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import us.kanddys.pov.client.services.InvoiceService;

@Controller
public class InvoiceController {

   @Autowired
   private InvoiceService invoiceService;

   @MutationMapping
   public Long cClientInvoice(@Argument Optional<Long> user) {
      return invoiceService.cClientInvoice(user);
   }
}
