package aibot;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpURLConnectionExample {

    private final String USER__AGENT = "Mozilla/5.0";

    public static void main(String[]args) throws Exception {

        HttpURLConnectionExample http = new HttpURLConnectionExample();

        String test = "誕生日プレゼントをもらってうれしい";
        var result = http.getResult(test);

        var arrays1= result.get("predictions");
        var arrays2= result.get("raw_outputs");

        System.out.println(arrays1);
        System.out.println(arrays2);
        System.out.println("angry:" + arrays1.get("angry").intValue());
        System.out.println("happy:" + arrays1.get("happy").intValue());
        System.out.println("sad:" + arrays1.get("sad").intValue());
        System.out.println("surprise:" + arrays1.get("surprise").intValue());
        System.out.println("scared:" + arrays1.get("scared").intValue());



    }

    public JsonNode getResult(String urlString) {
    	 String result = "";
    	 JsonNode root = null;
    	 String urlLink = "http://12fa-34-74-49-206.ngrok.io/";
    	 try {
    	    URL url = new URL(urlLink + "api/"+ urlString);
    	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
    	    con.connect(); // URL接続
    	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
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

   //HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://www.google.com/search?q=mkyong";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

       //optional default is GET
        con.setRequestMethod("GET");

       //add request header
        con.setRequestProperty("User-Agent", USER__AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

       //print result
        System.out.println(response.toString());

    }

   //HTTP POST request
    private void sendPost() throws Exception {

        String url = "https://selfsolve.apple.com/wcResults.do";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

       //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER__AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";

       //Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

       //print result
        System.out.println(response.toString());

    }

}
