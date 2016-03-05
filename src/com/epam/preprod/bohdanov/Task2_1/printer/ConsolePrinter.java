package com.epam.preprod.bohdanov.Task2_1.printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String s) {
        System.out.println(s);
    }

    @Override
    public void print(Object s) {
        System.out.println(s.toString());
    }

}
