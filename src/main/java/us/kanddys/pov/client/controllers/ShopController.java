package us.kanddys.pov.client.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class ShopController {

   @GetMapping("get")
   public ResponseEntity<Map<String, Object>> get(@RequestParam Long merchantId) {
      return null;
   }
}
