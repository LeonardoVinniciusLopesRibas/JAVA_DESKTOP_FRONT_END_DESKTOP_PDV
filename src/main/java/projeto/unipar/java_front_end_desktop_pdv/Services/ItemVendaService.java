package projeto.unipar.java_front_end_desktop_pdv.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projeto.unipar.java_front_end_desktop_pdv.Dto.ItemVendaDtoRequest;
import projeto.unipar.java_front_end_desktop_pdv.Model.ItemVenda;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;

public class ItemVendaService {

    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/util";
    private static final String BASE_URL_ITEMVENDA = "/pdv/itemvenda";

    private static final String CALCULAR = "/calcular";
    private static final String POST = "/post";

    private final Log log;

    public ItemVendaService(Log log) {
        this.log = log;
    }

    public Double calcular(ItemVendaDtoRequest itemVendaDto) {
        String operacao = "CALCULO FEITO";
        Double valorTotal = 0.0;
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL + CALCULAR);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = ItemVendaDtoRequest.marshalToJson(itemVendaDto);

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
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return valorTotal;
    }

    public void insert(ItemVenda itemVenda) {

        String operacao = "ITEM VENDA SENDO INSERIDA";
        try {
            URL url = new URL(SECURITY + IP + DOIS_PONTOS + PORT + BASE_URL_ITEMVENDA + POST);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");

            String json = ItemVenda.marshalVendaToJson(itemVenda);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            System.out.println(itemVenda.toString());
            int responseCode = connection.getResponseCode();

            System.out.println("INSERINDO ITEM VENDA, CÓDIGO: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                JOptionPane.showMessageDialog(null, "ITEM VENDA INSERIDA COM SUCESSO");
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
                JOptionPane.showMessageDialog(null, scrollPane, "Erro ao salvar venda", JOptionPane.ERROR_MESSAGE);
            }
            connection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
