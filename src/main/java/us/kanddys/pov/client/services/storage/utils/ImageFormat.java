package us.kanddys.pov.client.services.storage.utils;

import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class ImageFormat {
   /**
    * Este método rescala la imagen a una resolución de 300x300.
    *
    * @author Igirod0
    * @version 1.0.0
    * @param image
    * @return byte[]
    */
   public static byte[] resizeImage(MultipartFile inputFile, Integer width, Integer height) {
      byte[] imageInByte = null;
      try {
         BufferedImage originalImage = ImageIO.read(inputFile.getInputStream());
         BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
         Graphics2D g = resizedImage.createGraphics();
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         g.drawImage(originalImage, 0, 0, width, height, 0, 0, originalImage.getWidth(),
               originalImage.getHeight(), null);
         g.dispose();
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         String format = "png";
         Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(format);
         if (writers.hasNext()) {
            ImageWriter writer = writers.next();
            try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
               writer.setOutput(ios);
               writer.write(resizedImage);
            } finally {
               writer.dispose();
            }
         }
         baos.flush();
         imageInByte = baos.toByteArray();
         baos.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return imageInByte;
   }
}
