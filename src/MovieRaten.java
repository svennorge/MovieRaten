//package com.smalltoolrent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MovieRaten {
    public static void main(String arg[]){
        String debuggingMode = arg[0];
        String fileToRead = arg[1];
        boolean debug = true;
        if (debuggingMode.equals("false")){
            debug = false;
        }
        Game Movie = new Game(fileToRead,debug);
    }
}

class Game{
    String fileName = "Movie";
    String fileNameExtention = ".txt";
    boolean Spielende = true;
    int Counter = 0;
    boolean DevDebugging = true; // false = keine Debugging true = Debugging
    String[] MovieList = new String[100]; // Array with 100 Values

    // ArrayList; // ggf kann auch eine Array Liste genutzt werden bis ich weiss wir ich mit Pointern arbeiten kann.

    // Default constructor
    Game(){
        if(DevDebugging){
            DevMessage("Debugging On");
        }
        // Initialize the score here
        this.fileName = this.fileName + this.fileNameExtention;
        DevMessage(("Filename: " + this.fileName));
        if (this.initGame()) {
            DevMessage("Init Successful");
        }
        if (this.StartGame()){
            DevMessage("Start Successful");

        }
    }
    // Second constructor
    Game(String FileName, boolean DevDebugging){
        boolean DevDebuging;
        this.DevDebugging = DevDebugging;
        if(this.DevDebugging){
            DevMessage("Debugging On");
        }
        this.fileName = FileName;
        this.fileName = this.fileName + this.fileNameExtention;
        DevMessage("Filename: " + this.fileName);
        if (this.initGame()) {
            DevMessage("Init Successful");
        }
        if (this.StartGame()){
            DevMessage("Start Successful");

        }
    }

    public boolean readData(){
        boolean ReturnValue = true;
        int rowCount = 0;
        //try{
        File fileToOpen = new File(fileName);
        Scanner scanner = new Scanner(fileToOpen);
        while(scanner.hasNextLine()) {
            System.out.println("REad Data");
            MovieList[rowCount] = scanner.nextLine();
            System.out.println(MovieList[rowCount]);
            // allMovies[rowCount] = scanner.nextLine();
            rowCount++;

        }
        DevMessage("Reihen : "+ rowCount);
        DevMessage("Position :" + getRandom(rowCount));
        scanner.close();
        //} catch(Exception exception) {
        //    DevMessage("Kann die Datei " + fileName + " nicht einlesen");

        //    ReturnValue = false;
        //    }

        return ReturnValue;
    }

    private boolean endGame(){
        this.Counter++;
        return this.Counter >= 10;
    }

    private boolean StartGame(){
        readData();
        //if (!readData()) {
            //DevMessage("Programm Abbruch beim Start");
            //return false;}
        return true;
    }


    private boolean initGame(){
        return true;
    }

    private void DevMessage(String Message){
        if (DevDebugging) System.out.println(Message);
    }
    private int getRandom(int range){
        return (int) (Math.random() * range) + 1;
    }

}