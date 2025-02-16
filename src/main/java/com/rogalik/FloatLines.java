package com.rogalik;

public class FloatLines extends Lines {

    private float min = Integer.MAX_VALUE;
    private float max = Integer.MIN_VALUE;
    private float sum = 0;
    private float middle = 0;

    {
        filename = "floats";
    }

    @Override
    public void addLine(String[] words) {
        StringBuilder line = new StringBuilder();
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
            line.append(word).append(" ");
        }
        middle = sum / count;

        if (!line.isEmpty() && line.charAt(line.length() - 1) == ' ') {
            line.deleteCharAt(line.length() - 1);
        }
        lines.add(line.toString());
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
        System.out.println("Avg: " + middle);
    }
}
