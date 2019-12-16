package com.company.controller;

import com.company.model.*;
import com.company.model.entity.DiskImpl;
import com.company.model.entity.MusicalComposition;
import com.company.view.*;

import java.util.Scanner;

public class Controller {
    private View view;
    private Computer computer;

    public Controller(View view, Computer computer) {
        this.view = view;
        this.computer = computer;
    }

    void recordSong(Scanner scanner){
            String[] songNames = inputSongWithSacnner(scanner);
            try {
                computer.recordCompositionOnDisk(songNames);
                this.view.printMessage(TextConstants.SUCCESSFUL_RECORD);
            } catch (IllegalArgumentException exc) {
                this.view.printMessage(TextConstants.NOT_SUCCESSFUL_RECORD);
            }
    }

    public void playDisk(){
        view.printMessage(TextConstants.PLAY_DISK);
        computer.getPlayer().inputDisk(computer.getCurrentDisk());
        view.printList(computer.getPlayer().play());
        view.printMessage(TextConstants.PLAYER_FUNCTIONS);
    }

    public void changeDisk(Scanner scanner){
        this.view.printMessage(TextConstants.INVITATION);
        String diskName = inputDiskWithSacnner(scanner);
        computer.setCurrentDisk(diskName);
        this.view.printMessage(TextConstants.INVITATION_FOR_RECORD, String.valueOf(computer.getCurrentDisk().getAmountOfTracks()));


    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        changeDisk(scanner);
        recordSong(scanner);
        playDisk();
        while(true){
        int status = inputStatusWithScanner(scanner);
        switch (status) {
            case 1:
                view.printList(computer.getPlayer().play());
                break;
            case 2: {
                computer.getPlayer().sort();
                view.printList(computer.getPlayer().play());
                break;
            }
            case 3: {
                float min = 0f, max = 0f;
                while (min >= max) {
                    view.printMessage(TextConstants.DIFFERENCE_BOUND);
                    min = inputDiapasonWithScanner(scanner);
                    max = inputDiapasonWithScanner(scanner);
                }
                view.printCompositionNames(computer.getPlayer().findInDiapason(min, max));
                break;
            }
            case 4: {
                computer.getPlayer().outputDisk();
                changeDisk(scanner);
                recordSong(scanner);
                playDisk();
                break;
            }
            case 5:
                break;
        }
        if(status==5) break;
        }

    }

    public boolean isExist(String name) {
        for (MusicalComposition mc : computer.getCompositions()) {
            if (mc.getName().equals(name)) {
                return true;
            }
        }

        for (DiskImpl d : computer.getDisks()) {
            if (d.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    private String inputDiskWithSacnner(Scanner scanner) {
        String res = "";
        while (true) {
            view.printMessageWithLoc(TextConstants.ENTER, TextConstants.DISK);
            view.printDiskNames(computer.getDisks());
            res = scanner.next();
            if (!isExist(res)) {
                this.view.printMessage(TextConstants.INCORRECT_INPUT, res);
                continue;
            }
            break;
        }
        return res;
    }

    private String[] inputSongWithSacnner(Scanner scanner) {
        String res = "";
        String[] songs;
        while (true) {
            view.printMessageWithLoc(TextConstants.ENTER, TextConstants.SONG);
            view.printMessage(TextConstants.SONG_LIST);
            view.printCompositionNames(computer.getCompositions());
            res = scanner.next();
            System.out.println(res);
            songs = res.split(",");
            if (!isNormNames(songs)) {
                this.view.printMessage(TextConstants.INCORRECT_INPUT);
                continue;
            }
            break;
        }
        return songs;
    }

    private boolean isNormNames(String... names) {
        for (String s : names) {
            if (!isExist(s)) return false;
        }
        return true;
    }

    private int inputStatusWithScanner(Scanner scanner) {
        int status = 0;
        while (true) {
            while (!scanner.hasNextInt()) {
                view.printMessage(TextConstants.WRONG_DATA);
                scanner.next();
            }
            if ((status = scanner.nextInt()) < 0 || status > 5) {
                view.printMessage(TextConstants.WRONG_DATA);
                continue;
            }
            break;
        }
        return status;

    }

    private float inputDiapasonWithScanner(Scanner scanner) {
        view.printMessage(TextConstants.ENTER_BOUND);
        while (!scanner.hasNextFloat()) {
            view.printMessage(TextConstants.WRONG_DATA);
            scanner.next();
        }
        return scanner.nextFloat();
    }
}
