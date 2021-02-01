package com.charlotte;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
private String name;
private String artist;
private ArrayList<Song> songsInAlbums;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songsInAlbums = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songsInAlbums.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for(Song checkedSong : this.songsInAlbums){
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if((index >=0) && (index <= this.songsInAlbums.size())){
            playlist.add(this.songsInAlbums.get(index));
            return true;
        }
        System.out.println("this album does not have the track:    " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("this album does not have the track:    " + title);
        return false;
    }
}