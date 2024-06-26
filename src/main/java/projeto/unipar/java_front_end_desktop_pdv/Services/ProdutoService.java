package projeto.unipar.java_front_end_desktop_pdv.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;
import projeto.unipar.java_front_end_desktop_pdv.View.CadastrarProduto;

public class ProdutoService {

    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/produto";

    private static final String POST = "/post";
    private static final String GETTUDO = "/get/tudo";
    private static final String PUT = "/put/";
    private static final String GETID = "/get/";

    private final Log log;

    public ProdutoService(Log log) {
        this.log = log;
        startScheduledClientUpdate();
    }
    
    public void post(Produto produto, CadastrarProduto cadastrarProduto) {
        String operacao = "PRODUTO INSERIDO";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + POST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = Produto.marshalToJson(produto);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
                cadastrarProduto.limparCampos();
                log.escreverLog(operacao, responseCode);
            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> errorResponse = mapper.readValue(response.toString(), Map.class);
                List<String> errorList = (List<String>) errorResponse.get("errorList");
                StringBuilder formattedErrors = new StringBuilder();
                for (String error : errorList) {
                    formattedErrors.append(error).append("\n");
                }

                JTextArea textArea = new JTextArea(formattedErrors.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar produto", JOptionPane.ERROR_MESSAGE);
            }

            connection.disconnect();

        } catch (Exception e) {
            
        }
    }

    public List<Produto> getProdutosFromAPI() {
        String operacao = "PRODUTOS RECUPERADOS";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + GETTUDO);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                String jsonResponse = response.toString();
                log.escreverLog(operacao, responseCode);
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

    public void put(Produto produto) {
        String operacao = "PRODUTO ATUALIZADO";
        try{
            URL url = new URL(SECURITY+IP+DOIS_PONTOS+PORT+BASE_URL+PUT+produto.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            
            String json = Produto.marshalToJson(produto);
            
            try(OutputStream os = connection.getOutputStream()){
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
                log.escreverLog(operacao, responseCode);
            }else{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();
                
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> errorResponse = mapper.readValue(response.toString(), Map.class);
                List<String> errorList = (List<String>) errorResponse.get("errorList");
                StringBuilder formattedErrors = new StringBuilder();
                for(String error : errorList){
                    formattedErrors.append(error).append("\n");
                }
                
                JTextArea textArea = new JTextArea(formattedErrors.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(400, 200));
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao editar produto", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();
            
        }catch(Exception e){
            
        }

    }
    
    public Produto getById(Long id){
        String operacao = "PRODUTO BY ID";
        try{
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + GETID + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String jsonResponse = response.toString();
            log.escreverLog(operacao, responseCode);
            return Produto.unmarshalFromJsonProduto(jsonResponse);
            }
        }catch(IOException ioe){
            return null;
        }
        return null;
    }
    
    private void startScheduledClientUpdate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> getProdutosFromAPI(), 0, 5, TimeUnit.MINUTES);
    }

   
}