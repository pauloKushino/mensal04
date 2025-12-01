package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCEPUtil {
    public static String buscarEnderecoPorCEP(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000); // 5 segundos de timeout
        con.setReadTimeout(5000);
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        con.disconnect();
        return response.toString();
    }
}
