package aibot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpURLConnectionExample {


    public static void main(String[]args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        String test = "誕生日プレゼントをもらってうれしい。";

        var result = http.getResult(test);

        var arrays1= result;

        int len = arrays1.get("target").toString().length();
        var tar = arrays1.get("target").toString().substring(1, len-1);

        System.out.println("target:" + tar);
        System.out.println("polarity:" + arrays1.get("polarity").doubleValue());

    }

    public JsonNode getResult(String urlString) {
    	 String result = "";
    	 JsonNode root = null;
    	 String urlLink = "http://127.0.0.1:5001/slot/";

    	 try {
    	    URL url = new URL(urlLink + URLEncoder.encode(urlString, "UTF-8"));
    	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    	    con.connect(); // URL接続
    	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
    	    String tmp = "";
    	    while ((tmp = in.readLine()) != null) {
    	        result += tmp;
    	    }
    	    ObjectMapper mapper = new ObjectMapper();
    	    root = mapper.readTree(result);
    	    in.close();
    	    con.disconnect();
    	 }catch(Exception e) {
    	    e.printStackTrace();
    	 }

    	 return root;
    }

    public JsonNode getPolarity(String urlString) {
   	 String result = "";
   	 JsonNode root = null;
   	 String urlLink = "http://127.0.0.1:5001/polarity/";

   	 try {
   	    URL url = new URL(urlLink + URLEncoder.encode(urlString, "UTF-8"));
   	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
   	    con.connect(); // URL接続
   	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
   	    String tmp = "";
   	    while ((tmp = in.readLine()) != null) {
   	        result += tmp;
   	    }
   	    ObjectMapper mapper = new ObjectMapper();
   	    root = mapper.readTree(result);
   	    in.close();
   	    con.disconnect();
   	 }catch(Exception e) {
   	    e.printStackTrace();
   	 }

   	 return root;
   }

    public JsonNode getResponse(String urlString) {
   	 String result = "";
   	 JsonNode root = null;
   	 String urlLink = "http://127.0.0.1:5001/question/";

   	 try {
   	    URL url = new URL(urlLink + URLEncoder.encode(urlString, "UTF-8"));
   	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
   	    con.connect(); // URL接続
   	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
   	    String tmp = "";
   	    while ((tmp = in.readLine()) != null) {
   	        result += tmp;
   	    }
   	    ObjectMapper mapper = new ObjectMapper();
   	    root = mapper.readTree(result);
   	    in.close();
   	    con.disconnect();
   	 }catch(Exception e) {
   	    e.printStackTrace();
   	 }

   	 return root;
   }

    public JsonNode getAizuti(String urlString) {
      	 String result = "";
      	 JsonNode root = null;
      	 String urlLink = "http://127.0.0.1:5001/aizuti/";

      	 try {
      	    URL url = new URL(urlLink + URLEncoder.encode(urlString, "UTF-8"));
      	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
      	    con.connect(); // URL接続
      	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
      	    String tmp = "";
      	    while ((tmp = in.readLine()) != null) {
      	        result += tmp;
      	    }
      	    ObjectMapper mapper = new ObjectMapper();
      	    root = mapper.readTree(result);
      	    in.close();
      	    con.disconnect();
      	 }catch(Exception e) {
      	    e.printStackTrace();
      	 }

      	 return root;
      }


    private static String characterCode(String str, String chraCode) throws UnsupportedEncodingException {
        byte[] tmp = new String(str).getBytes(chraCode);
        return new String(tmp);
      }
}
