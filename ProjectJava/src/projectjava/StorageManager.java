import java.io.*;


/**
 *
 * @author Lam Ngoc Diem My - CE190083
 */
public class StorageManager{
 public void saveDataToFile(String filename, String data) {
        File file = new File(filename);
        FileWriter fw = null;
        BufferedWriter writer = null;

        if (!file.exists()) {
            System.out.println("File does not exist, creating a new file.");
        }

        try {
            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);
            writer.write(data);
            System.out.println("Data has been saved successfully.");
        } catch (Exception e) {
            System.out.println("Error while saving the file!");
        }

        if (writer != null) {
            try {
                writer.close();
                System.out.println("File has been closed.");
            } catch (Exception e) {
                System.out.println("Error while closing BufferedWriter.");
            }
        }

        if (fw != null) {
            try {
                fw.close();
            } catch (Exception e) {
                System.out.println("Error while closing FileWriter.");
            }
        }
    }

    public String loadDataFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return "File does not exist!";
        }

        FileReader filereader = null;
        BufferedReader reader = null;
        StringBuilder data = new StringBuilder();

        try {
            filereader = new FileReader(file);
            reader = new BufferedReader(filereader);
            String line;

            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (Exception e) {
            return "Error while reading the file!";
        }

        if (reader != null) {
            try {
                reader.close();
            } catch (Exception e) {
                return "Error while closing BufferedReader!";
            }
        }

        if (filereader != null) {
            try {
                filereader.close();
            } catch (Exception e) {
                return "Error while closing FileReader!";
            }
        }

        return data.toString();
    }
}
