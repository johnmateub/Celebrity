package co.mateusbello.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.mateusbello.exception.ResourceException;

public class TextFile implements Resource {
    public static final String FILE_DELIMITER = ",";
    
    public List<String> loadData() throws ResourceException {
        List<String> data = new ArrayList<>();
        BufferedReader br = null;
        try {
            String path = System.getProperty("user.dir")+"\\src\\main\\resources\\people.csv";
            br = new BufferedReader(new FileReader(path));
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(FILE_DELIMITER);
                data.addAll(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            throw new ResourceException("people.csv file does not exist", e);
        } catch (IOException e) {
            throw new ResourceException("Error loading people.csv file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new ResourceException("people.csv file cannot be close", e);
                }
            }
        }
        return data;
    }
    
    

}
