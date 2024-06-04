package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Services.ClienteService;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class CadastrarCliente extends javax.swing.JFrame {

    private SetIconJFrame setIcon = new SetIconJFrame();
    private Log log = new Log();
    private final ClienteService clienteService;
    private Cliente cliente = new Cliente();

    public CadastrarCliente(JFrame parent) {
        Log log = new Log();
        this.clienteService = new ClienteService(log);
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setIcon.setIconJFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefoneCliente = createFormattedTextField();
        jtfEmailCliente = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE CLIENTE");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");

        jtfNomeCliente.setBackground(new java.awt.Color(0, 0, 0));
        jtfNomeCliente.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefone");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jtfTelefoneCliente.setBackground(new java.awt.Color(0, 0, 0));
        jtfTelefoneCliente.setForeground(new java.awt.Color(255, 255, 255));

        jtfEmailCliente.setBackground(new java.awt.Color(0, 0, 0));
        jtfEmailCliente.setForeground(new java.awt.Color(255, 255, 255));

        jbSalvar.setBackground(new java.awt.Color(0, 0, 0));
        jbSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/salvar32px.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimparCampos.setBackground(new java.awt.Color(0, 0, 0));
        jbLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        jbLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/limparCampos32px.png"))); // NOI18N
        jbLimparCampos.setText("Limpar Campos");
        jbLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparCamposActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNomeCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfTelefoneCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfEmailCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbLimparCampos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jtfTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(261, 261, 261)
                            .addComponent(jLabel5))
                        .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 36, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(139, 139, 139)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        cliente.setNome(jtfNomeCliente.getText());
        cliente.setEmail(jtfEmailCliente.getText());
        cliente.setTelefone(jtfTelefoneCliente.getText());

        getDadosCampos(cliente);
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        jtfNomeCliente.setText("");
        jtfTelefoneCliente.setText("");
        jtfEmailCliente.setText("");
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void getDadosCampos(Cliente cliente) {
        ClienteService clienteService = new ClienteService(log);
        clienteService.post(cliente, this);

    }

    public void limparCampos() {
        jtfNomeCliente.setText("");
        jtfTelefoneCliente.setText("");
        jtfEmailCliente.setText("");
    }

    private JFormattedTextField createFormattedTextField() {
        JFormattedTextField formattedTextField = new JFormattedTextField();
        formattedTextField.setColumns(14);
        formattedTextField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) {
                    return;
                }

                String original = getText(0, getLength());
                StringBuilder buffer = new StringBuilder(original);
                buffer.insert(offs, str);

                String onlyDigits = buffer.toString().replaceAll("[^\\d]", "");
                String mask = onlyDigits.length() <= 10 ? "(##) ####-####" : "(##) #####-####";

                super.remove(0, getLength());
                super.insertString(0, applyMask(mask, onlyDigits), a);
            }

            @Override
            public void remove(int offs, int len) throws BadLocationException {
                super.remove(offs, len);

                String original = getText(0, getLength());
                String onlyDigits = original.replaceAll("[^\\d]", "");
                String mask = onlyDigits.length() <= 10 ? "(##) ####-####" : "(##) #####-####";

                super.remove(0, getLength());
                super.insertString(0, applyMask(mask, onlyDigits), null);
            }

            private String applyMask(String mask, String digits) {
                StringBuilder result = new StringBuilder();
                int maskCharIndex = 0;
                int digitsCharIndex = 0;

                while (maskCharIndex < mask.length() && digitsCharIndex < digits.length()) {
                    char maskChar = mask.charAt(maskCharIndex);
                    char digitsChar = digits.charAt(digitsCharIndex);

                    if (maskChar == '#') {
                        result.append(digitsChar);
                        digitsCharIndex++;
                    } else {
                        result.append(maskChar);
                    }

                    maskCharIndex++;
                }

                return result.toString();
            }
        });

        formattedTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && !Character.isISOControl(c)) {
                    e.consume();
                }
            }
        });

        return formattedTextField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtfEmailCliente;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfTelefoneCliente;
    // End of variables declaration//GEN-END:variables
}
