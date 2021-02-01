package com.charlotte;

import java.util.*;

public class Main {

    private static  ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {



        Album album = new Album("Fearless", "Taylor Swift");
        album.addSong("cardigan", 3.40);
        album.addSong("Romeo and Juliet", 2.59);
        album.addSong("Hey Stephen", 3.02);
        album.addSong("Flawless", 2.59);
        album.addSong("Love Story", 2.49);
        album.addSong("Breathe", 2.29);
        album.addSong("You Belong With Me", 2.58);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("cardigan",playlist);
        albums.get(0).addToPlaylist("Flawless",playlist);
        albums.get(0).addToPlaylist("Romeo and Juliet",playlist);
        albums.get(0).addToPlaylist("Hey Stephen",playlist);
        albums.get(0).addToPlaylist("Breathe",playlist);
        albums.get(0).addToPlaylist("You Belong With Me",playlist);


        play(playlist);

        //printMenu();

    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator =playlist.listIterator();
        if(playlist.size() == 0) {
            System.out.println("no songs");
            return;
        }else{
            System.out.println("now playing:" + listIterator.next().toString());
            printInstructions();

        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();


            switch (action) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    printAllSongs(playlist);
                    break;

                case 2:
                    if (!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("now playing: " + listIterator.next().toString());
                    }else{
                        System.out.println("end of playlist");
                    }

                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;

                        }
                    if (listIterator.hasPrevious()) {
                        System.out.println(("now playing:" + listIterator.previous().toString()));
                    }else{
                        System.out.println("start of playlist");
                    }

                    break;

                case 4:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            System.out.println("now replaying" + listIterator.previous().toString());
                            forward = false;
                        }else{
                            System.out.println("start of playlist");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("now playing: " + listIterator.next().toString());
                            forward = true;
                        } else{
                            System.out.println("end of playlist");
                        }
                    }

                    break;



                case 5:
                    quit = true;
                    break;


            }


        }

    }



















    public static void printInstructions() {

        System.out.println(" 0 - print menu. " +
                "\n 1 - print all songs. " +
                "\n 2 - skip forward. " +
                "\n 3 - skip backwards " +
                "\n 4 - replay current song" +
                "\n 5 - quit");
    }


    public static void printAllSongs(LinkedList<Song> linkedList) {
//        for (int i = 0; i<linkedList.size(); i++){
//            System.out.println(linkedList.get(i));
//        }
//        for (Song song : linkedList){
//            System.out.println(song);
//        }
        Iterator<Song> i = linkedList.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("-------------------------");
    }
}
