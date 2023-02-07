package com.example.reproductorenterointerfaces1.models;

import java.io.Serializable;

public class Song implements Serializable {
    private String file;

    private Integer year;

    private Album album;

    private Integer track_num;

    private String publisher;

    private Integer album_id;

    private Integer id;

    private String title;

    private Integer genre_id;

    @Override
    public String toString() {
        return "Cancion : " + this.title  + ", Artista : "+ this.publisher;
    }

    public String showInList(){
       return "Cancion : " + this.title  + ", Artista : "+ this.publisher;
   }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Integer getTrack_num() {
        return this.track_num;
    }

    public void setTrack_num(Integer track_num) {
        this.track_num = track_num;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getAlbum_id() {
        return this.album_id;
    }

    public void setAlbum_id(Integer album_id) {
        this.album_id = album_id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGenre_id() {
        return this.genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public static class Album implements Serializable {
        private Object mbid;

        private Integer year;

        private Artist artist;

        private Integer id;

        private String title;

        private Integer artist_id;

        private String picture;

        public Object getMbid() {
            return this.mbid;
        }

        public void setMbid(Object mbid) {
            this.mbid = mbid;
        }

        public Integer getYear() {
            return this.year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        public Artist getArtist() {
            return this.artist;
        }

        public void setArtist(Artist artist) {
            this.artist = artist;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getArtist_id() {
            return this.artist_id;
        }

        public void setArtist_id(Integer artist_id) {
            this.artist_id = artist_id;
        }

        public String getPicture() {
            return this.picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public static class Artist implements Serializable {
            private String artist_thumbnail;

            private String artist_background;

            private String mbid;

            private String artist_logo;

            private String name;

            private String artist_banner;

            private Integer id;

            public String getArtist_thumbnail() {
                return this.artist_thumbnail;
            }

            public void setArtist_thumbnail(String artist_thumbnail) {
                this.artist_thumbnail = artist_thumbnail;
            }

            public String getArtist_background() {
                return this.artist_background;
            }

            public void setArtist_background(String artist_background) {
                this.artist_background = artist_background;
            }

            public String getMbid() {
                return this.mbid;
            }

            public void setMbid(String mbid) {
                this.mbid = mbid;
            }

            public String getArtist_logo() {
                return this.artist_logo;
            }

            public void setArtist_logo(String artist_logo) {
                this.artist_logo = artist_logo;
            }

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getArtist_banner() {
                return this.artist_banner;
            }

            public void setArtist_banner(String artist_banner) {
                this.artist_banner = artist_banner;
            }

            public Integer getId() {
                return this.id;
            }

            public void setId(Integer id) {
                this.id = id;
            }
        }
    }
}
