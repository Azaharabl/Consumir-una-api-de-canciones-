package com.example.reproductorenterointerfaces1.servicies;

import com.example.reproductorenterointerfaces1.models.Song;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface ApiEstoreService {


    // crud cancion solo necesitamos el get y get by id -----------------------------------------------------------
    /**
     * Obtener canciones con limite y ordenacion
     * @param limit
     * @param sort
     * @return
     */
    @GET("/songs")
    Call<List<Song>> getSongs(@Query("limit") int limit, @Query("sort") String sort);

    /**
     * Obtener todas las canciones
     * @return
     */
    @GET("/songs")
    Call<List<Song>> getAllSongs();

    /**
     * Obtener una cancion por id
     * @return
     */
    @GET("/songs/{id}")
    Call<Song> getSong(@Path("id") int id);

    /**
     * Eliminar una cancion por id
     * @return
     *

     @DELETE("/songs/{id}")
     Boolean delleteSong(@Path("id") int id);


     */


    /**
     * refresca una cancion por id
     * @return


     @PATCH("/songs/{id}")
     Boolean delleteSong(@Path("id") int id);


     */



    // crus de cancion en una lista ----------------------------------------------------


}
