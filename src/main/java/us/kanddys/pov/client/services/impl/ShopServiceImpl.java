package us.kanddys.pov.client.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.exceptions.LibraryNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.Library;
import us.kanddys.pov.client.models.LibraryCollection;
import us.kanddys.pov.client.repositories.jpas.BuyerJpaRepository;
import us.kanddys.pov.client.repositories.jpas.LibraryCollectionJpaRepository;
import us.kanddys.pov.client.repositories.jpas.LibraryJpaRepository;
import us.kanddys.pov.client.services.BuyerLibraryService;
import us.kanddys.pov.client.services.ShopService;

/**
 * @author Igirod0
 * @version 1.0.0
 */
@Repository
public class ShopServiceImpl implements ShopService {

   @Autowired
   private LibraryJpaRepository libraryJpaRepository;

   @Autowired
   private LibraryCollectionJpaRepository libraryCollectionJpaRepository;

   @Autowired
   private BuyerJpaRepository buyerJpaRepository;

   @Autowired
   private BuyerLibraryService buyerLibraryService;

   @Override
   public Map<String, Object> getShop(Long merchant, Long libraryId) {
      Map<String, Object> response = new HashMap<String, Object>();
      List<Map<String, Object>> collections = new ArrayList<Map<String, Object>>();
      Library library = libraryJpaRepository.findById(libraryId)
            .orElseThrow(() -> new LibraryNotFoundException(
                  ExceptionMessage.LIBRARY_NOT_FOUND));
      if (!library.getMerchant().equals(merchant)) {
         response.put("operation", 0);
         return response;
      }
      // * Propiedades generales.
      response.put("title", (library.getTitle() == null ? null : library.getTitle()));
      response.put("type", library.getTypeCollection());
      response.put("count", buyerJpaRepository.findCountBuyersByUserId(merchant));
      response.put("operation", 1);
      switch (library.getTypeCollection()) {
         case 1:
            // * Colleciones pertenecientes a la biblioteca de vendedores.
            List<LibraryCollection> sellerLibraryCollections = libraryCollectionJpaRepository
                  .findByLibraryId(library.getId());
            for (LibraryCollection libraryCollection : sellerLibraryCollections) {
               Map<String, Object> collectionData = new HashMap<String, Object>();
               collectionData.put("id", libraryCollection.getId());
               collectionData.put("title", libraryCollection.getTitle());
               collectionData.put("miniatureHeader", (libraryCollection.getMiniatureHeader()) == null ? null
                     : libraryCollection.getMiniatureHeader().split(" "));
               collectionData.put("miniatureTitle", (libraryCollection.getMiniatureTitle()) == null ? null
                     : libraryCollection.getMiniatureTitle().split(" "));
               collectionData.put("miniatureSubtitle", (libraryCollection.getMiniatureSubtitle()) == null ? null
                     : libraryCollection.getMiniatureSubtitle().split(" "));
               collectionData.put("items",
                     // ! La miniature define las propiedades de los objetos de la collection.
                     buyerLibraryService.gBuyerLibraryCollectionItems(libraryCollection.getId(),
                           (libraryCollection.getMiniatureHeader() != null
                                 ? libraryCollection.getMiniatureHeader().split(" ")
                                 : null),
                           (libraryCollection.getMiniatureTitle() != null
                                 ? libraryCollection.getMiniatureTitle().split(" ")
                                 : null),
                           (libraryCollection.getMiniatureSubtitle() != null
                                 ? libraryCollection.getMiniatureSubtitle().split(" ")
                                 : null),
                           libraryCollection.getOrdering(),
                           libraryCollection.getAscDsc(), merchant, 1, 10));
               collectionData.put("count",
                     buyerLibraryService.gBuyerLibraryCollectionTotalItems(libraryCollection.getId(),
                           (libraryCollection.getMiniatureHeader() != null
                                 ? libraryCollection.getMiniatureHeader().split(" ")
                                 : null),
                           (libraryCollection.getMiniatureTitle() != null
                                 ? libraryCollection.getMiniatureTitle().split(" ")
                                 : null),
                           (libraryCollection.getMiniatureSubtitle() != null
                                 ? libraryCollection.getMiniatureSubtitle().split(" ")
                                 : null),
                           libraryCollection.getOrdering(),
                           libraryCollection.getAscDsc(), merchant));
               collections.add(collectionData);
            }
            break;
      }
      // ! Colleciones totales.
      response.put("collections", collections);
      return response;
   }

}
