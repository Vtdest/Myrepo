package com.cloudairlines;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {

    }

    public static String readFileBufferedReader(String path) {
        BufferedReader objReader = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(path));
            while ((strCurrentLine = objReader.readLine()) != null) {
                fileContent.append(strCurrentLine);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } finally {
            if (objReader != null) {
                try {
                    objReader.close();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }

        }
        return fileContent.toString();
    }

    public static String readFileBufferedReaderSimpler(String pathToFile) {
        try(var reader = new BufferedReader(new FileReader(pathToFile))) {
            // while loop > build a string > return
        } catch (IOException e) {
            // handle
        }
        return "";
    }


    /**
     *
     * @param pathToFile
     * @return
     * @throws IOException
     */
    public static String readSmallFile(String pathToFile) throws IOException {
       return Files.readString(Path.of(pathToFile));

    }
}
