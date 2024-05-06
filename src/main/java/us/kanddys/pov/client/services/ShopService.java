package us.kanddys.pov.client.services;

import java.util.Map;

import us.kanddys.pov.client.models.dtos.ShopProductDetailDTO;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface ShopService {

   public Map<String, Object> getShop(Long merchantId, Long libraryId);

   /**
    * @author Igirod0
    * @version 1.0.0
    */
   public ShopProductDetailDTO gClientShopProductDetail(Long product, String slug);
}
