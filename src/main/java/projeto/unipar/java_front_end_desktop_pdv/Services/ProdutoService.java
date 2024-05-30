package projeto.unipar.java_front_end_desktop_pdv.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;

public class ProdutoService {
    
    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/produto";

    private static final String POST = "/post";
    private static final String GETTUDO = "/get/tudo";

    public void post(Produto produto) {

        try {
            URL url = new URL(SECURITY+IP+DOIS_PONTOS+PORT+BASE_URL+POST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            
            String json = Produto.marshalToJson(produto);
            
            try(OutputStream os = connection.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            
            int code = connection.getResponseCode();
            JOptionPane.showMessageDialog(null, code);
            
            connection.disconnect();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Produto> getProdutosFromAPI() {
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + GETTUDO);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            JOptionPane.showMessageDialog(null, responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String jsonResponse = response.toString();
                return Produto.unmarshalFromJson(jsonResponse);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao obter dados da API: " + responseCode);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao obter dados da API: " + e.getMessage());
            return null;
        }
    }
    
    

}
