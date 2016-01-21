package org.mule.modules.openweatherretrofit;

import org.mule.extension.annotations.Operation;

import retrofit.http.GET;
import retrofit.http.Query;


public interface ServiceInterface {

    @Operation
    @GET("/data/2.5/weather")
    String weatherCoords(@Query("lat") String lat, @Query("lon") String lon, @Query("appid") String id);

} 
