package com.example.reproductorenterointerfaces1.reproductorFunciontsSongs;

import com.example.reproductorenterointerfaces1.utiles.Config;
import com.example.reproductorenterointerfaces1.models.Song;


import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControllerSong {

    //le pasa una cancion y la para rebobina o pone en play







    private Media media ;
    private MediaPlayer player;

    public void play(Song s){

        // todo print
        System.out.println("das a play en controller song");

        if(media==null){
            media = new Media(Config.URL+ s.getFile());
            player = new MediaPlayer(media);
        }


        player.play();

    }

    public void resetSong(){
        if(media!=null){

            player.stop();
            media = null;
            player = null;
        }


    }
    public void stop(){

        // todo print
        System.out.println("das a stop en controller song");
        if (player!=null){
            player.pause();
        }


    }

    public void adelantar(){
        if (player!=null){
            player.setRate(player.getRate() +1);
        }


    }
    public void atrasar(){
        if (player!=null){
            player.setRate(player.getRate()-1);
        }


    }




}
