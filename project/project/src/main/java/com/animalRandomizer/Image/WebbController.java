package com.animalRandomizer.Image;



import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import java.util.Base64;


//@Controller
@Service
@RestController
public class WebbController extends InData{
    public static InData inData;
    public static URL url;
    public static BufferedImage bufferedImage, image;
    public static byte[] imageByte;
    public static Base64 base64;
    public static ServletContext servletContext;
    public static InputStream in;
    /*@GetMapping(
            value = "",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        in = getClass().getResourceAsStream(inData.getUrl());
        in.close();
        return IOUtils.toByteArray(in);
    }*/


    /*@RequestMapping(value = "", method = RequestMethod.GET)
     public void getImageAsByteArray(HttpServletResponse response) throws IOException {
         in = servletContext.getResourceAsStream(getImage());
         response.setContentType(MediaType.IMAGE_JPEG_VALUE);
         IOUtils.copy(in, response.getOutputStream());

     }*/
    //@RequestMapping( value = "", method = RequestMethod.GET)
    public String imageData(@RequestParam(name = "image", required = false, defaultValue = "Error") Model model, String image  ) throws Exception {
        //Base64.Encoder simpleEncoder = Base64.getUrlEncoder();
        model.addAttribute("image", getCleanUrl());
        return "index";
    }
    //@GetMapping(value = "")
    public ImageIcon readyImage(){
        Image image = null;
        ImageIcon imageI = null;
        try {
            URL url = new URL(inData.getUrl());
            image = ImageIO.read(url);
            imageI = new ImageIcon(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageI;
    }
/*    @RequestMapping(value = "/get_goods_detail", method = RequestMethod.GET)
    public String getGoodsDetail(@RequestParam(value = "itemid") final int itemid,
                                 ModelMap model) {
        // get image
        String image =

        model.addAttribute("image", image);
        return  "goods_detail";  // return name of html view with thymeleaf
    }*/


    //@RequestMapping(value = "", method = RequestMethod.GET)
    public String getImage()  {
        System.out.println(inData.getUrl());
        return inData.getUrl();
    }

    //@GetMapping(value = "")
    public URL getCleanUrl() throws Exception {
        return url = new URL(getImage());
    }



    @GetMapping(value = "/JSON")
    public InData getInData(){
        return inData;
    }

    //@GetMapping(value = "")
    public BufferedImage readImage() throws Exception{

        try {
            URL url = new URL(getImage());
            bufferedImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }
    @GetMapping(value = "index", produces = "jpg/image")
    public BufferedImage genImage(){

        try{
            Base64.Encoder simpleEncoder = Base64.getUrlEncoder();
            String encodedString = simpleEncoder.encodeToString(getImage().getBytes());
            Base64.Decoder simpleDecoder = Base64.getDecoder();
            imageByte = simpleDecoder.decode(encodedString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            //bis.close();
            ModelMap map = new ModelMap();
            map.put("image", encodedString);

        } catch (Exception e){

        }
        return image;
    }
    @GetMapping(value = "/test")
    public String test(){
        return "test.html";
    }


}
  /*  @Configuration
   public class WebMvcConfig implements WebMvcConfigurer {
       @Override
       public void addResourceHandlers(ResourceHandlerRegistry registry) {
           registry
                   .addResourceHandler("/images/**")
                   .addResourceLocations("file:C:\\Users\\doug9\\OneDrive\\Skrivbord\\Ny mapp\\panda.jpg")
                   .setCachePeriod(0);
       }
   }*/
//InData inData = new InData();
   /*@GetMapping(value = "/cats")
    public String getCats() {
        String url = "https://api.thecatapi.com/v1/images/search";
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);

        return this.restTemplate.getForObject(url, String.class);
    } */

   /* ServletContext servletContext;

    @RequestMapping(value = "/image-manual-response", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
        InputStream in = servletContext.getResourceAsStream("/WEB-INF/images/image-example.jpg");
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }*/
    /*@RequestMapping("/hello")
    public String hello(){
        return "hello World!";
    }*/
   /* @GetMapping(value = "/home")
    public List<Object> getJsonCat(){
        String uri = "https://api.thecatapi.com/v1/images/search";
        RestTemplate restTemplate = new RestTemplate();
        Object[] cats = restTemplate.getForObject(uri, Object[].class);
        String print = cats[0].toString();
        String[] words = print.split(" ", 5);
        String breed = words[0];
        String id = words[1];
        String url = words[2];
        String width = words[3];
        String height = words[4];
        String cleanURL = url.substring(4, url.length()-1);
        inData.setUrl(cleanURL);
        System.out.println(cleanURL);
        System.out.println(cats[0]);

        return Arrays.asList(cats);
    } */
    /*@GetMapping(value = "/RandomCats")
    public String getRandomCat(){
        String uri = "https://api.thecatapi.com/v1/images/search";
        RestTemplate restTemplate = new RestTemplate();
        Object[] cats = restTemplate.getForObject(uri, Object[].class);
        String print = cats[0].toString();
        String[] words = print.split(" ", 5);
        String breed = words[0];
        String id = words[1];
        String url = words[2];
        String width = words[3];
        String height = words[4];
        String cleanURL = url.substring(4, url.length()-1);
        inData.setUrl(cleanURL);
        System.out.println(cleanURL);
        System.out.println(cats[0]);

        return cleanURL;
    }*/
    /*@RequestMapping(value = "/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response) throws IOException {
        InputStream in = servletContext.getResourceAsStream(getRandomCat());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());

    }*/
    /*@GetMapping(
            value = "/image",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        InputStream in = getClass()
                .getResourceAsStream("https://api.thecatapi.com/v1/images/search");
        return IOUtils.toByteArray(in);
    }*/
    /*@GetMapping(value = "/image")
    public Image getImage(){
       Image image = null;
       try {
           URL url = new URL(inData.getUrl());
           image = ImageIO.read(url);
       } catch (IOException e) {
           e.printStackTrace();
       }
        return image;
   }*/