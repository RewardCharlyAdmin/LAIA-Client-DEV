package us.kanddys.pov.client.services;

import java.util.Map;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface ShopService {

   public Map<String, Object> getShop(Long merchantId, Long libraryId);
}
