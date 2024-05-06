package us.kanddys.pov.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import us.kanddys.pov.client.models.dtos.ShopProductDetailDTO;
import us.kanddys.pov.client.services.ShopService;

@Controller
public class ShopController {

   @Autowired
   private ShopService shopService;

   @QueryMapping
   public ShopProductDetailDTO gClientShopProductDetail(@Argument Long product, @Argument String slug) {
      return shopService.gClientShopProductDetail(product, slug);
   }
}
