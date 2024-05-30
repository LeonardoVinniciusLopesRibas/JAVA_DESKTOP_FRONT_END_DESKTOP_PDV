package projeto.unipar.java_front_end_desktop_pdv.Util;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class SetIcon {
    
    public void setIconCadastrar_Editar(JMenu jmCadastrarEditar) {
        
        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\cadastrar_editar32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmCadastrarEditar.setIcon(imageIcon);
        
    }
    
    public void setSalvarButton(JButton jbSalvar) {
        
        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\salvar32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbSalvar.setIcon(imageIcon);
        
    }

    public void setIconLimparCampos(JButton jbLimparCampos) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\limparCampos32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jbLimparCampos.setIcon(imageIcon);

    }

    public void setIconProduto(JMenu jmProduto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\produtos32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmProduto.setIcon(imageIcon);

    }

    public void setIconCadastrarProduto(JMenuItem jmiCadastrarProduto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\novo32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmiCadastrarProduto.setIcon(imageIcon);

    }

    public void setIconVisualizarProduto(JMenuItem jmiVisualizarProduto) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\visualizar32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmiVisualizarProduto.setIcon(imageIcon);

    }

    public void setIconCliente(JMenu jmCliente) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\cliente32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmCliente.setIcon(imageIcon);

    }

    public void setIconCadastrarCliente(JMenuItem jmiCadastrarCliente) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\novo32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmiCadastrarCliente.setIcon(imageIcon);

    }

    public void setIconVisualizarCliente(JMenuItem jmiVisualizarCliente) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\visualizar32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmiVisualizarCliente.setIcon(imageIcon);

    }

    public void setIconVenda(JMenu jmVenda) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\venda32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmVenda.setIcon(imageIcon);

    }   

    public void setIconPdv(JMenuItem jmiPdv) {

        Image iconImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\leona\\OneDrive\\Documentos\\NetBeansProjects\\JAVA_FRONT_END_DESKTOP_PDV\\src\\main\\java\\resource\\pdv32px.png");
        ImageIcon imageIcon = new ImageIcon(iconImage);
        jmiPdv.setIcon(imageIcon);

    }
    
}
