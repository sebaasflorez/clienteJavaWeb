/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgUtilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;

/**
 *
 * @author dhursa
 */
public class ConsumidorWebServices {
    
    public String ObtenerListado() throws MalformedURLException, ProtocolException, IOException{
        String webService = "http://localhost/ws_sso/index_ws.php?funcion=reporte_clientes&filtro=Se";
        URL url = new URL (webService);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("ACCEPT", "Application/json");
        String output = "";
        
        if(conn.getResponseCode()== 200){
            
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String line = "";
            
            while((line = br.readLine()) != null){
                    //System.out.println(output);
                    //salida = json.getString("OK");
                    output += line;
                    
            }
            
            //JSONObject obj = new JSONObject(output);
            //String estado = obj.getString("estado");
            //System.out.println(output);
            br.close();
            
            
        }
        
        return output;
    }
    
}
