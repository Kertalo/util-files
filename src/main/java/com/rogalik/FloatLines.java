package com.rogalik.lines;

public class FloatLines extends Lines {

    private float min;
    public float getMin() {
        return min = Float.MAX_VALUE;
    }

    private float max;
    public float getMax() {
        return max = Float.MIN_VALUE;
    }

    private float sum;
    public float getSum() {
        return sum = 0;
    }

    private float middle;
    public float getMiddle() {
        return middle = 0;
    }

    {
        filename = "floats";
    }

    @Override
    public void addLine(String line, String[] words) {
        for (String word : words) {
            Float next_number = FloatLines.isFloat(word);
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
        middle = sum / count;
        lines.add(line);
    }

    public static Float isFloat(String s) {
        float number;
        try {
            number = Float.parseFloat(s);
        }
        catch (NumberFormatException e) {
            return null;
        }
        return number;
    }

    @Override
    public void printShortStatistic() {
        System.out.println("--------Floats--------");
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
