package projeto.unipar.java_front_end_desktop_pdv.Services;

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
import projeto.unipar.java_front_end_desktop_pdv.View.CadastrarCliente;

public class ClienteService {

    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/cliente";

    private static final String POST = "/post";
    private static final String GETTUDO = "/get/tudo";
    private static final String PUT = "/put/";

    private final Log log;

    public ClienteService(Log log) {
        this.log = log;
        startScheduledClientUpdate();
    }

    public void post(Cliente cliente, CadastrarCliente cadastrarCliente) {
        String operacao = "CLIENTE INSERIDO";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + POST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = Cliente.marshalToJson(cliente);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                cadastrarCliente.limparCampos();
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar cliente", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();
        } catch (Exception e) {

        }

    }

    public List<Cliente> getClientesFromAPI() {
        String operacao = "CLIENTES RECUPERADOS";
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
                return Cliente.unmarshalFromJson(jsonResponse);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void put(Cliente cliente) {
        String operacao = "CLIENTE ATUALIZADO";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + PUT + cliente.getId());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = Cliente.marshalToJson(cliente);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao editar produto", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();

        } catch (Exception e) {

        }
    }
    
    private void startScheduledClientUpdate() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(() -> getClientesFromAPI(), 0, 5, TimeUnit.MINUTES);
    }

}
