package com.rogalik;

import java.util.LinkedList;

public class CommandLine {

    private LinkedList<String> input_files = new LinkedList<>();
    private String output_prefix;
    private String output_path;
    private boolean is_append;
    private boolean is_short_statistic;
    private boolean is_full_statistic;

    {
        output_prefix = "";
        output_path = "";
        is_append = false;
        is_short_statistic = false;
        is_full_statistic = false;
    }
    
    public CommandLine(String[] args) {
        Parser(args);
    }

    private void Parser(String[] args) {
        ArgMode arg_mode = ArgMode.INPUT_FILE;

        for (String arg : args) {
            switch (arg) {
                case "-a":
                    is_append = true;
                    break;
                case "-o":
                    arg_mode = ArgMode.OUTPUT_PATH;
                    break;
                case "-p":
                    arg_mode = ArgMode.OUTPUT_PREFIX;
                    break;
                case "-s":
                    is_short_statistic = true;
                    break;
                case "-f":
                    is_full_statistic = true;
                    break;
                default:
                    if (arg_mode == ArgMode.INPUT_FILE) {
                        input_files.add(arg);
                    }
                    else if (arg_mode == ArgMode.OUTPUT_PATH) {
                        output_path = arg;
                    }
                    else {
                        output_prefix = arg;
                    }
                    arg_mode = ArgMode.INPUT_FILE;
                    break;
            }
        }
    }
}
