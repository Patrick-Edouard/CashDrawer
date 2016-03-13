package ch.qiminfo.demo.ressources;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by patrick-edouard on 3/7/16.
 */
public class RessourcesParsor {

    /**
     * Reg exp between key and value
     */
    private static final String REGEXP = "=";

    /**
     * Name of the file
     */
    private static String DB_PROPERTIES_FILE_NAME = "db.properties";

    /**
     * Get a map of the properties
     * @return dbProperties a map of properties
     */
    public static Map<String, String> getDbProperties(){
        Map<String, String> dbProperties = new HashMap<String, String>();

        try {
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(DB_PROPERTIES_FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            String[] lineInformation;
            while ((line = reader.readLine()) != null) {
                lineInformation=line.split(REGEXP);
                dbProperties.put(lineInformation[0], lineInformation[1]);
            }

            inputStream.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return dbProperties;
    }
}
