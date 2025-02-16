package com.rogalik;

import java.util.LinkedList;
import java.io.*;

public class File {
    public static LinkedList<String> readFile(String filename) {
        LinkedList<String> lines = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while(line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        }
        catch(IOException ex) {
            System.out.println("Внимание: Файл " + filename + " не найден");
        }
        return lines;
    }

    public static void writeFile(String filename, LinkedList<String> lines, boolean append) {
        try(FileWriter writer = new FileWriter(filename, append)) {
            for (String line : lines) {
                writer.write(line + '\n');
            }
            writer.flush();
        }
        catch(IOException ex) {
            System.out.println("Внимание: Не удается найти указанный путь " + filename);
        }
    }
}
