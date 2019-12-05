package View;

import Model.Disk;
import Model.MusicalComposition;

import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View{
    public static final String INVITATION = "input.invitation.data";
    public static final String ENTER = "input.enter.data";
    public static final String INCORRECT_INPUT = "input.incorrect.disk.name.data";
    public static final String INVITATION_FOR_RECORD = "input.invitation.for.record.data";
    public static final String SONG_LIST = "input.song.list.data";
    public static final String DISK = "input.disk.data";
    public static final String SONG = "input.song.data";
    public static final String SUCCESSFUL_RECORD = "input.successful.record.data";
    public static final String NOT_SUCCESSFUL_RECORD = "input.not.successful.record";
    public static final String PLAY_DISK="input.play.disk.data";
    public static final String PLAYER_FUNCTIONS = "input.player.functions.data";
    public static final String WRONG_DATA = "input.wrong.data.data";
    public static final String ENTER_BOUND= "input.enter.bound.data";
    public static final String DIFFERENCE_BOUND= "input.difference.bound.data";


    private static final String filename= "messages";
    public static final ResourceBundle bundle = ResourceBundle.getBundle(filename, new Locale("en"));

    public void printDiskNames(List<Disk> disks){
        for(Disk d : disks) {
            System.out.print(d.getName() + " ");
        }
        System.out.println();
    }

    public void printCompositionNames(List<MusicalComposition> compositions){
        for(MusicalComposition mc : compositions) {
            System.out.print(mc.getName() + " ");
        }
        System.out.println();
    }

    public void printMessage(String message, String name) {
        System.out.println(bundle.getString(message) + " " + name);
    }
    public void printMessageWithLoc(String message, String name) {
        System.out.println(bundle.getString(message) + " " + bundle.getString(name));
    }

    public void printMessage(String message){
        System.out.print(bundle.getString(message));
    }

    public void printList(String message){
        System.out.println(message);
    }
}
