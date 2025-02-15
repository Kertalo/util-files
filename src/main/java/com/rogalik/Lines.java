package com.rogalik.lines;

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
    public String getFilename() {
        return filename;
    }

    public abstract void addLine(String line, String[] words);

    public abstract void printShortStatistic();

    public abstract void printFullStatistic();
}
