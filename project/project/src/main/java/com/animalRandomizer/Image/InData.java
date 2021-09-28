package com.animalRandomizer.Image;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.net.URL;
import javax.print.DocFlavor;
import java.net.URL;
import java.util.List;
import java.util.*;
@JsonIgnoreProperties(ignoreUnknown = true)
public class InData {


        private String message;
        private String url;
        private URL con;



        public InData(){
        }
        public InData(String message, String url){
            this.message = message;
            this.url = url;
        }
        public InData(URL con) {
            this.con = con;
        }
        public void setCon(URL url)throws  Exception{
            this.con = url;
        }
        public URL getCon(){return con;}

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        @Override
        public String toString() {
            return "{" +
                    "message=" + message +
                    ", url=" + url +
                    "}";

        }

    }

