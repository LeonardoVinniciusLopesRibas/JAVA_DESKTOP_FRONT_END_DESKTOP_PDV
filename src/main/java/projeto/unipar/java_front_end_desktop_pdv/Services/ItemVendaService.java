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
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import projeto.unipar.java_front_end_desktop_pdv.Dto.ItemVendaDtoRequest;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;

public class ItemVendaService {

    private static final String SECURITY = "http://";
    private static final String IP = "localhost";
    private static final String DOIS_PONTOS = ":";
    private static final String PORT = "4848";
    private static final String BASE_URL = "/pdv/util";

    private static final String CALCULAR = "/calcular";

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

}