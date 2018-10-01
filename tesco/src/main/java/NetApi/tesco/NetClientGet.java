package NetApi.tesco;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NetClientGet {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://pvcspidera001uk.global.tesco.org:4007/api/tillConfig?macAddress=300ED53674A6");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output=br.readLine();
            
      
           System.out.println("Get Request Returns : "+output);
           final JSONObject jsonobject = new JSONObject(output);
      
              
                
                System.out.println("isSetForRebuild : "+jsonobject.getBoolean("isSetForRebuild"));
                System.out.println("Getting host Name : "+jsonobject.getString("hostName"));
                System.out.println("Getting known Mac Address : "+jsonobject.getString("macAddress"));
            
            
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}