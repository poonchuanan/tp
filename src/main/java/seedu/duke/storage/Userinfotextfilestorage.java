package seedu.duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Userinfotextfilestorage {
    private static final String PATH = new File("").getAbsolutePath();
    public static final String FILE_PATH = PATH + "/tp.txt";

    public static ArrayList<String> update() {
        if (Files.exists(Path.of(PATH))) {
            File file = new File(FILE_PATH);
            ArrayList<String> data = new ArrayList<>();
            try {
                file.createNewFile();
                Scanner s = new Scanner(file);
                while (s.hasNext()) {
                    String dataString = s.nextLine();
                    data.add(dataString);
                }
                s.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        } else {
            try {
                createDataFile();
            } catch (IOException e) {
                System.out.println("IO Exception found");
            }
            return new ArrayList<>();
        }
    }

    private static void createDataFile() throws IOException {
        File file = new File(Userinfotextfilestorage.PATH);
        boolean isDirCreated = file.mkdir();

        if (isDirCreated) {
            file = new File(Userinfotextfilestorage.PATH + "/tp.txt");
            file.createNewFile();
        }
    }

    public void save(String test) throws IOException {
        String[] parts = test.split(",");
        Files.write(Path.of(FILE_PATH), Arrays.asList(parts));
    }
}
