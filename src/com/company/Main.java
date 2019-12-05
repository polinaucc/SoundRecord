package com.company;

import com.company.Controller.Controller;
import com.company.Model.Model;
import com.company.View.View;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new View(), new Model());
        controller.process();
    }
}
