package projeto.unipar.java_front_end_desktop_pdv.Util;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SetIconJFrame {
    
    private Log log = new Log();
    
    public void setIconJFrame(JFrame parent){
        URL iconUrl = getClass().getResource("/META-INF/pdvIcon256px.png");
        if (iconUrl != null) {
            ImageIcon icon = new ImageIcon(iconUrl);
            parent.setIconImage(icon.getImage());
        } else {
            log.escreverLog("Icon URL is null", 500);
        }
    }
    
}
