package us.kanddys.pov.client.controllers.rests;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import us.kanddys.pov.client.services.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopRestController {

   @Autowired
   private ShopService shopService;

   @GetMapping("get")
   public ResponseEntity<Map<String, Object>> get(@RequestParam(required = true) Long merchant,
         @RequestParam(required = true) Long library) {
      return ResponseEntity.ok(shopService.getShop(merchant, library));
   }
}
