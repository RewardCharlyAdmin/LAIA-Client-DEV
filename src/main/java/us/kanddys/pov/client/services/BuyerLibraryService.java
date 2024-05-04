package us.kanddys.pov.client.services;

import java.util.List;
import java.util.Map;

/**
 * @author Igirod0
 * @version 1.0.0
 */
public interface BuyerLibraryService {
   /**
    * Este metodo se encarga de obtener la biblioteca de vendedores.
    *
    * @author Igirod0
    * @version 1.0.0
    */
   public List<Map<String, Object>> gBuyerLibraryCollectionItems(Long libraryCollectionId, String[] miniatureHeader,
         String[] miniatureTitle, String[] miniatureSubtitle, String ordering, Integer ascDsc, Long userId,
         Integer page, Integer maxResults);

   /**
    * Este método se encarga de obtener el total de elementos de una colección.
    * 
    * @author Igirod0
    * @version 1.0.0
    */
   public Integer gBuyerLibraryCollectionTotalItems(Long libraryCollectionId,
         String[] miniatureHeader,
         String[] miniatureTitle, String[] miniatureSubtitle, String ordering, Integer ascDsc, Long userId);
}
