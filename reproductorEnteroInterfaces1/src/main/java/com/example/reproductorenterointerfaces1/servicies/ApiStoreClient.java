package com.example.reproductorenterointerfaces1.servicies;

import com.example.reproductorenterointerfaces1.utiles.Config;
import com.example.reproductorenterointerfaces1.models.Song;
import javafx.application.Platform;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApiStoreClient {


    private static ApiEstoreService apiEstoreService;






    public ApiStoreClient() {

        Retrofit rettrofit = new Retrofit.Builder()
                .baseUrl(Config.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiEstoreService = rettrofit.create(ApiEstoreService.class);

    }


    /**
     * return a list of songs of javiers api
     *
     * @return list of song
     */
    public static ArrayList<Song> getDataSongsAsincrono() throws InterruptedException {


        //lista a devolver
        ArrayList<Song> listSongs = new ArrayList<>();

        Call<List<Song>> call = apiEstoreService.getAllSongs();

        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                //todo print
                System.out.printf("carga correcta");

                if (response.isSuccessful()) {
                    List<Song> songs = response.body();

                    Platform.runLater(() -> {
                        //todo print
                        System.out.println(songs.size());
                    });
                    for (int i = 0; i < songs.size(); i++) {
                        listSongs.add(songs.get(i));
                    }
                    //todo print
                    System.out.println("lista de canciones" + listSongs.size());


                }

            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable throwable) {
                System.out.printf("fallo en la carga");
            }
        });

        call.wait();
        //todo print
        System.out.println("mandamos las canciones ");
        System.out.println(listSongs.size());
        return listSongs;

    }


    public static List<Song> getDataSongs() throws InterruptedException, IOException {

        Call<List<Song>> songsCall = apiEstoreService.getAllSongs();
        return songsCall.execute().body();
    }
}

