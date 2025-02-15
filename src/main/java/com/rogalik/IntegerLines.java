package com.rogalik.lines;

public class IntegerLines extends Lines {

    private int min = Integer.MAX_VALUE;
    public int getMin() {
        return min;
    }

    private int max = Integer.MIN_VALUE;
    public int getMax() {
        return max;
    }

    private int sum = 0;
    public int getSum() {
        return sum;
    }

    private float middle = 0;
    public float getMiddle() {
        return middle;
    }

    {
        filename = "integers";
    }

    @Override
    public void addLine(String line, String[] words) {
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
        }
        middle = sum / (float)count;
        lines.add(line);
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
        System.out.println("Mid: " + middle);
    }
}
