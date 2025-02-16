package com.rogalik;

import java.util.LinkedList;

public class Distribution {

    private IntegerLines integer_lines;
    private FloatLines float_lines;
    private StringLines string_lines;

    public Lines[] getLines() {
        return new Lines[] {integer_lines, float_lines, string_lines};
    }

    {
        integer_lines = new IntegerLines();
        float_lines = new FloatLines();
        string_lines = new StringLines();
    }

    public void sort(LinkedList<String> lines) {
        for (String line : lines) {
            String[] words = line.split(" ");
            if (IntegerLines.isInteger(words[0]) != null) {
                integer_lines.addLine(words);
            }
            else if (FloatLines.isFloat(words[0]) != null) {
                float_lines.addLine(words);
            }
            else {
                string_lines.addLine(words);
            }
        }
    }
}
