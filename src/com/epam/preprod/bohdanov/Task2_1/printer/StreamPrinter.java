package com.epam.preprod.bohdanov.Task2_1.printer;

import java.io.PrintWriter;

public class StreamPrinter implements Printer {
    private PrintWriter out;

    public StreamPrinter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void print(String s) {
        out.println(s);
        out.flush();
    }

    @Override
    public void print(Object s) {
        out.println(s);
        out.flush();
    }

}
