package projeto.unipar.java_front_end_desktop_pdv.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projeto.unipar.java_front_end_desktop_pdv.Dto.VendaDtoRequest;
import projeto.unipar.java_front_end_desktop_pdv.Model.Venda;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;

public class VendaService {

    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/util";
    private static final String BASE_URL_VENDA = "/pdv/venda";

    private static final String CALCULAR = "/calcular/tudo";
    private static final String POST = "/post";
    private static final String GETID = "/get/";

    private final Log log;

    public VendaService(Log log) {
        this.log = log;
    }

    public Double calcularValorTotal(VendaDtoRequest vendaDtoRequest) {
        String operacao = "CALCULO DO VALOR TOTAL";
        Double valorTotal = 0.0;
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + CALCULAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = VendaDtoRequest.marshalToJson(vendaDtoRequest);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                log.escreverLog(operacao, responseCode);
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                valorTotal = Double.parseDouble(response.toString());

            } else {
            }
            connection.disconnect();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
        return valorTotal;

    }

    public Venda insert(Venda venda) {

        String operacao = "VENDA SENDO INSERIDA";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL_VENDA + POST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = Venda.marshalVendaToJson(venda);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            System.out.println(venda.toString());
            int responseCode = connection.getResponseCode();

            //System.out.println("INSERINDO ITEM VENDA, CÓDIGO: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                //JOptionPane.showMessageDialog(null, "VENDA INSERIDA COM SUCESSO");
                System.out.println("Venda salva");
                log.escreverLog(operacao, responseCode);

                try (InputStream is = connection.getInputStream(); InputStreamReader isr = new InputStreamReader(is); BufferedReader br = new BufferedReader(isr)) {

                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }

                    Venda vendaRetornada = Venda.unmarshalFromJsonVenda(response.toString());
                    return vendaRetornada;
                }
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar venda", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Venda findById(Long idVenda) {

        String operacao = "VENDA BY ID";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL_VENDA + GETID + idVenda);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            int responseCode = connection.getResponseCode();
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
                return Venda.unmarshalFromJsonVenda(jsonResponse);
            }
        } catch (IOException ioe) {
            return null;
        }
        return null;
    }
}
