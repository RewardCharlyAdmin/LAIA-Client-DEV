package us.kanddys.pov.client.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import us.kanddys.pov.client.exceptions.LibraryNotFoundException;
import us.kanddys.pov.client.exceptions.MerchantNotFoundException;
import us.kanddys.pov.client.exceptions.ProductNotFoundException;
import us.kanddys.pov.client.exceptions.utils.ExceptionMessage;
import us.kanddys.pov.client.models.Library;
import us.kanddys.pov.client.models.LibraryCollection;
import us.kanddys.pov.client.models.Product;
import us.kanddys.pov.client.models.dtos.ShopProductDetailDTO;
import us.kanddys.pov.client.models.dtos.ShopProductDetailSegmentDTO;
import us.kanddys.pov.client.repositories.jpas.BuyerJpaRepository;
import us.kanddys.pov.client.repositories.jpas.CalendarJpaRepository;
import us.kanddys.pov.client.repositories.jpas.LibraryCollectionJpaRepository;
import us.kanddys.pov.client.repositories.jpas.LibraryJpaRepository;
import us.kanddys.pov.client.repositories.jpas.MerchantJpaRepository;
import us.kanddys.pov.client.repositories.jpas.ProductJpaRepository;
import us.kanddys.pov.client.repositories.jpas.ProductSegmentJpaRepository;
import us.kanddys.pov.client.services.BuyerLibraryService;
import us.kanddys.pov.client.services.FirstShippingDateService;
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

   @Autowired
   private MerchantJpaRepository merchantJpaRepository;

   @Autowired
   private ProductSegmentJpaRepository productSegmentJpaRepository;

   @Autowired
   private CalendarJpaRepository calendarJpaRepository;

   @Autowired
   private ProductJpaRepository productJpaRepository;

   @Autowired
   private FirstShippingDateService firstShippingDateService;

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

   @Override
   public ShopProductDetailDTO gClientShopProductDetail(Long product, String slug) {
      Map<String, Object> merchantAtributtes = merchantJpaRepository.findMerchantIdAndTitle(slug);
      if (merchantAtributtes == null)
         throw new MerchantNotFoundException(ExceptionMessage.MERCHANT_NOT_FOUND);
      Set<ShopProductDetailSegmentDTO> segments = productSegmentJpaRepository.findByProduct(product).stream()
            .map(ShopProductDetailSegmentDTO::new)
            .collect(Collectors.toSet());
      Map<String, Object> calendarAtributtes = calendarJpaRepository.findDelayAndDelayTypeAndIdByMerchant(
            merchantAtributtes.get("id") == null ? null : Long.valueOf(merchantAtributtes.get("id").toString()));
      Product productAtributtes = productJpaRepository.findById(product)
            .orElseThrow(() -> new ProductNotFoundException(ExceptionMessage.PRODUCT_NOT_FOUND));
      // ! CALCULO DE FECHA DE ENVÍO.
      String firstShippingDate = firstShippingDateService.gClientShippingDate(null, null, null, null);
      return null;
   }
}
