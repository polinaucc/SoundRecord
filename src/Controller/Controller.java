package Controller;

import Model.*;
import View.*;

import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        this.view.printMessage(TextConstants.INVITATION);
        String diskName = inputDiskWithSacnner(scanner);
        model.setCurrentDisk(diskName);
        this.view.printMessage(TextConstants.INVITATION_FOR_RECORD, String.valueOf(model.getCurrentDisk().getAmountOfTracks()));
        while (true) {
            String[] songNames = inputSongWithSacnner(scanner);
            try {
                model.recordCompositionOnDisk(songNames);
                this.view.printMessage(TextConstants.SUCCESSFUL_RECORD);
                break;
            } catch (IllegalArgumentException exc) {
                this.view.printMessage(TextConstants.NOT_SUCCESSFUL_RECORD);
            }
        }
        view.printMessage(TextConstants.PLAY_DISK);
        model.getPlayer().setDisk(model.getCurrentDisk());
        view.printList(model.getCurrentDisk().toString());
        view.printMessage(TextConstants.PLAYER_FUNCTIONS);
        while(true){
        int status = inputStatusWithScanner(scanner);
        switch (status) {
            case 1:
                view.printList(model.getPlayer().getDisk().toString());
                break;
            case 2: {
                model.getPlayer().sortByStyle();
                view.printList(model.getPlayer().getDisk().toString());
                break;
            }
            case 3: {
                float min = 0f, max = 0f;
                while (min >= max) {
                    view.printMessage(TextConstants.DIFFERENCE_BOUND);
                    min = inputDiapasonWithScanner(scanner);
                    max = inputDiapasonWithScanner(scanner);
                }
                view.printCompositionNames(model.getPlayer().findInDiapason(min, max));
                break;
            }
            case 4:
                break;
        }
        if(status==4) break;
        }

    }

    public boolean isExist(String name) {
        for (MusicalComposition mc : model.getCompositions()) {
            if (mc.getName().equals(name)) {
                return true;
            }
        }

        for (Disk d : model.getDisks()) {
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
            view.printDiskNames(model.getDisks());
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
            view.printCompositionNames(model.getCompositions());
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
            if ((status = scanner.nextInt()) < 0 || status > 4) {
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
