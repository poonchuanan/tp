package seedu.duke;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Storage {
    String filePath;
    File dataFile;
    //ICsvMapWriter writer;



    public Storage(String filePath) {
        this.filePath = filePath;
        dataFile = new File(filePath);
    }

    private void createFileHierarchy() throws IOException {
        if (dataFile.getParentFile().exists()) {
            if (dataFile.exists()) {
                return;
            } else {
                dataFile.createNewFile();
            }
        } else {
            dataFile.getParentFile().mkdir();
            dataFile.createNewFile();
        }
    }

    private void appendToFile(String textToAdd) {
        try {
            FileWriter fw = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(textToAdd);
            pw.flush();
            pw.close();
            System.out.println("record saved");
        } catch (Exception e) {
            System.out.println("record not saved");
        }
    }

    private void writeToFile(String textToAdd)  {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath);
            fw.write(textToAdd);
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file!");
        }

    }

    public void updateFile(DayMap dayMap) {
        HashMap<LocalDate, ActivityList> dayHashMap;
        dayHashMap = dayMap.getHashMap();
        Iterator it = dayHashMap.entrySet().iterator();
        writeToFile("");
        final String[] header = new String[]{"Date", "Activities"};
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            String activities = pair.getValue().toString();
            activities = activities.substring(1, activities.length() - 1);
            appendToFile(pair.getKey().toString() + "," + activities);
        }
    }

    public void loadData() {
        try {
            createFileHierarchy();
        } catch (IOException e) {
            System.out.println("Unable to load data");
        }
    }

}