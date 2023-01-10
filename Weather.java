import java.util.*;
import java.net.*;
import java.io.*;
import org.json.simple.parser.JSONParser;

import netscape.javascript.JSObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Weather{

    public static void main(String[] args) {
         try {
            URL url=new URL("https://api.openweathermap.org/data/2.5/weather?lat=26.912434&lon=75.787270&appid=b535fff314794c34cb57ab212fb13379");
            HttpURLConnection url_data=(HttpURLConnection)url.openConnection();
            url_data.setRequestMethod("GET");

            InputStreamReader in=new InputStreamReader(url_data.getInputStream());
            BufferedReader in1=new BufferedReader(in);
            String st="";
           
           // File myObj = new File("cite_weather.txt");
            FileWriter fw = new FileWriter("cite_weather2.txt",true);
            
            st=in1.readLine();
            fw.write(st+"\n");           
            fw.close();  
            System.out.println(st);
            
            JSONParser par=new JSONParser();
            JSONObject arr=(JSONObject)par.parse(st);
               
            JSONObject obj2=(JSONObject)arr.get("coord");
            System.out.println(obj2);
            System.out.println(obj2.get("lon"));
            
            System.out.println(obj2.get("lat"));
            JSONObject obj3=(JSONObject)arr.get("wind");
            JSONArray wth = (JSONArray)arr.get("weather");
            JSONObject ob4 = (JSONObject)wth.get(0);
            System.out.println(ob4.get("id"));

           
            System.out.println(arr.get("visibility"));


            
           
    
                
                
            
           
            
            

           
                 
                    
               
             
         } catch (Exception e) {
            // TODO: handle exception
         }    
     
     
    }
}