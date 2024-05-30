package projeto.unipar.java_front_end_desktop_pdv.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    
    private static final String DIRETORIO = System.getProperty("user.home") + "/.pdvlog";
    private static final String ARQUIVO = DIRETORIO + "/log.txt"; // Ajustado para incluir o diretório completo
    
    public Log(){
        criarArquivo();
    }
    
    public void criarArquivo() {
        try {
            File logDir = new File(DIRETORIO);
            if (!logDir.exists()) {
                logDir.mkdirs();
            }
            File logFile = new File(ARQUIVO);
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void escreverLog(String operacao, int code) {
        try {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            String logEntry = String.format("%s - %s - %s%n", timestamp, operacao, code);
            Files.write(Paths.get(ARQUIVO), logEntry.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
