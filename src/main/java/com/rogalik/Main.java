package com.rogalik;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CommandLineParser commandLineParser = new CommandLineParser(args);

        LinkedList<String> lines = new LinkedList<String>();
        for (String filename : commandLineParser.getInputFiles()) {
            lines.addAll(File.readFile(filename));
        }

        Distribution distribution = new Distribution();
        distribution.sort(lines);

        Lines[] distribution_lines = distribution.getLines();

        String output_filename = commandLineParser.getOutputFileName();

        for (Lines line : distribution_lines) {
            if (line.getCount() > 0) {
                File.writeFile(output_filename + line.filename + ".txt", line.getLines(), commandLineParser.getIsAppend());
                if (commandLineParser.getIsFullStatistic())
                    line.printFullStatistic();
                else if (commandLineParser.getIsShortStatistic())
                    line.printShortStatistic();
            }
        }
    }
}
