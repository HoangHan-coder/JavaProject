package projectjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Lam Ngoc Diem My - CE190083
 */
public class StorageManager{
    public void saveDataToFile(String filename, String data) throws IOException {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
            
    }
    public String loadDataFromFile(String filename) throws FileNotFoundException, IOException {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
        return data.toString();
    }
}
