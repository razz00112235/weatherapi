import java.util.*;
import java.net.*;
import java.io.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

class Location{

    public static void main(String[] args) {
         try {
            
            URL url=new URL("http://api.openweathermap.org/geo/1.0/direct?q=jaipur,rj,IN&limit=10&appid=b535fff314794c34cb57ab212fb13379");
            HttpURLConnection url_data=(HttpURLConnection)url.openConnection();
            url_data.setRequestMethod("GET");

            InputStreamReader in=new InputStreamReader(url_data.getInputStream());
            BufferedReader in1=new BufferedReader(in);
            String st="";
           
            FileWriter fw = new FileWriter("location.txt");
         
             // returns strin

             st=in1.readLine();
             fw.write(st+"\n");           
             fw.close();  
             System.out.println(st);

                    System.out.println("--------------++++++++---------------");
                  
                    JSONParser par=new JSONParser();
                    JSONArray arr=(JSONArray)par.parse(st);
                    for(int i=0;i<arr.size();i++)
                    {
                        
                        JSONObject obj=(JSONObject)arr.get(i);
                        System.out.println(obj);
                        Object city,lat,lng,lname;
                    
                        city=obj.get("name");
                        lat=obj.get("lat");
                        lng=obj.get("lon");
                        System.out.println("\n");

                        lname=obj.get("local_names");

                        JSONObject obj2=(JSONObject)obj.get("local_names");
                        System.out.println(obj2.get("ml"));                        
                        System.out.println("\n"+city+" latutide is: "+lat+", Longitude is: "+lng);
                        
                    }
                   
             
         } catch (Exception e) {
            // TODO: handle exception
         }    
     
     
    }
}