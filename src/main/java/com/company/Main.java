package com.company;

import com.company.controller.Controller;
import com.company.model.Computer;
import com.company.view.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Computer());
        controller.process();
    }
}
