import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class SOAP{
    public static void main(String[] args) {


        try {

            URL url = new URL("https://www.tcmb.gov.tr/kurlar/today.xml");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();


                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                    informationString.append("\n");
                }

                System.out.println(informationString);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}