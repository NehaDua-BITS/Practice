package lld.tinyurl.src.service;

import lld.tinyurl.src.exception.NoTokenFound;
import lld.tinyurl.src.exception.PersistTokenException;
import lld.tinyurl.src.exception.ReadTokenException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileService {

    private Logger logger = Logger.getLogger(FileService.class.getName());

    public String readData(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();
            String data = bufferedReader.readLine();
            while (data != null && !data.isEmpty()) {
                sb.append(data);
                sb.append("\n");
                data = bufferedReader.readLine();
            }

            data = sb.toString().trim();

            if (data.isEmpty()) {
                throw new NoTokenFound("No data found in file : " + fileName);
            }
            return data;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to read token from file : " + e.getMessage());
            throw new ReadTokenException(e.getMessage());
        }
    }

    public void persistData(String data, String fileName, boolean append) {
        try (FileWriter fileWriter = new FileWriter(fileName, append)) {
            fileWriter.write(String.valueOf(data));
            fileWriter.write("\n");
        } catch (IOException e) {
            logger.log(Level.SEVERE, String.format("Failed to save data in file : %s; Error = %s", fileName, e.getMessage()));
            throw new PersistTokenException(e.getMessage());
        }
    }

}
