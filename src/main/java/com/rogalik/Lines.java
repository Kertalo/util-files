package com.rogalik;

import java.util.LinkedList;

public abstract class Lines {
    protected LinkedList<String> lines = new LinkedList<>();
    public LinkedList<String> getLines() {
        return lines;
    }

    protected int count = 0;
    public int getCount() {
        return count;
    }

    protected String filename = "";

    public abstract void addLine(String[] words);

    public abstract void printShortStatistic();

    public abstract void printFullStatistic();
}
