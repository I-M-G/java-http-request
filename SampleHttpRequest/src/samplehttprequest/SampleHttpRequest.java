/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samplehttprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

/**
 *
 * @author Ian <https://github.com/I-M-G>
 */
public class SampleHttpRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            makeHttpRequest();
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
    
    public static void makeHttpRequest() throws IOException {
        URL url = new URL("http://iangwillim.com");
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        con.setRequestMethod("GET");
        
        con.setConnectTimeout(1000 * 5);
        con.setReadTimeout(1000 * 5);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = "";
        StringBuffer content = new StringBuffer();
        
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
            content.append(inputLine);
        }
        in.close();
        
        // Do something with content
//        System.out.println(content.toString());
        
        con.disconnect();
    }
    
}
