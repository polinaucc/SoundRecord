package com.company;

import Controller.Controller;
import Model.Model;
import View.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Model());
        controller.process();
    }
}
