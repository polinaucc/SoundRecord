package com.company.View;

import com.company.Model.Disk;
import com.company.Model.MusicalComposition;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View{
    private static final String FILENAME= "messages";
    public static final ResourceBundle bundle = ResourceBundle.
            //getBundle(FILENAME, new Locale("en"));
            getBundle(FILENAME, new Locale("ua"));

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
