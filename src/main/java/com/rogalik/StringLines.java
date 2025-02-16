package com.rogalik;

public class StringLines extends Lines {

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    {
        filename = "strings";
    }

    @Override
    public void addLine(String[] words) {
        String line = String.join(" ", words);
        for (String word : words) {
            count++;
            if (word.length() < min) {
                min = word.length();
            }
            if (word.length() > max) {
                max = word.length();
            }
        }
        lines.add(line);
    }

    @Override
    public void printShortStatistic() {
        System.out.println("--------Strings--------");
        System.out.println("Count: " + count);
    }

    @Override
    public void printFullStatistic() {
        printShortStatistic();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
