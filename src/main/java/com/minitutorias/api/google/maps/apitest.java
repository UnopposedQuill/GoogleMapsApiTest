/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minitutorias.api.google.maps;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esteban
 */
public class apitest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GeoApiContext context = new GeoApiContext.Builder()
            .apiKey("AIzaSyBzMykFGPuNJu8L2kq3wm0MNErDZkzjbZ4").maxRetries(3)
            .build();
        try{            
            GeocodingResult[] results =  GeocodingApi.geocode(context,
                "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(results[0].addressComponents));
        }catch(ApiException | InterruptedException | IOException exc){
            Logger.getLogger(apitest.class.getName()).log(Level.SEVERE, null, exc);
        }
    }
}
