package com.rogalik;

public class IntegerLines extends Lines {

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int sum = 0;
    private float middle = 0;

    {
        filename = "integers";
    }

    @Override
    public void addLine(String[] words) {
        StringBuilder line = new StringBuilder();
        for (String word : words) {
            Integer next_number = IntegerLines.isInteger(word);
            if (next_number == null) {
                continue;
            }
            count++;
            sum += next_number;
            if (next_number < min) {
                min = next_number;
            }
            if (next_number > max) {
                max = next_number;
            }
            line.append(word).append(" ");
        }
        middle = sum / (float)count;

        if (!line.isEmpty() && line.charAt(line.length() - 1) == ' ') {
            line.deleteCharAt(line.length() - 1);
        }
        lines.add(line.toString());
    }

    public static Integer isInteger(String s) {
        int number;
        try {
            number = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            return null;
        }
        return number;
    }

    @Override
    public void printShortStatistic() {
        System.out.println("--------Integers--------");
        System.out.println("Count: " + count);
    }

    @Override
    public void printFullStatistic() {
        printShortStatistic();
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Avg: " + middle);
    }
}
