package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Services.ClienteService;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class EditarCliente extends javax.swing.JFrame {

    private SetIconJFrame setIcon = new SetIconJFrame();
    private Log log = new Log();
    private Cliente cliente = new Cliente();
    private ClienteService clienteService = new ClienteService(log);
    private VisualizarCliente visualizarCliente;
    
    
    public EditarCliente(VisualizarCliente parent) {
        Log log = new Log(); 
        this.clienteService = new ClienteService(log);
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.visualizarCliente = parent;
        setIcon.setIconJFrame(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jbEditarProduto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdClienteEditar = new javax.swing.JTextField();
        jtfNomeClienteEditar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefoneClienteEditar = createFormattedTextField();
        jtfEmailClienteEditar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbEditarProduto.setBackground(new java.awt.Color(0, 0, 0));
        jbEditarProduto.setForeground(new java.awt.Color(255, 255, 255));
        jbEditarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/salvar32px.png"))); // NOI18N
        jbEditarProduto.setText("Salvar Edição");
        jbEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarProdutoActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");

        jtfIdClienteEditar.setEditable(false);
        jtfIdClienteEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfIdClienteEditar.setForeground(new java.awt.Color(255, 255, 255));

        jtfNomeClienteEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfNomeClienteEditar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefone");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jtfTelefoneClienteEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfTelefoneClienteEditar.setForeground(new java.awt.Color(255, 255, 255));

        jtfEmailClienteEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfEmailClienteEditar.setForeground(new java.awt.Color(255, 255, 255));

        jDesktopPane1.setLayer(jbEditarProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfIdClienteEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNomeClienteEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfTelefoneClienteEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfEmailClienteEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfEmailClienteEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(236, 236, 236)
                                .addComponent(jLabel5))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIdClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jtfNomeClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jtfTelefoneClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTelefoneClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmailClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128)
                .addComponent(jbEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jbEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarProdutoActionPerformed
        enviaDados();
        visualizarCliente.preencherTabela();
        this.dispose();
        
    }//GEN-LAST:event_jbEditarProdutoActionPerformed

    public void recebeDados(Cliente cliente){
        Long id = cliente.getId();
        String idString = String.valueOf(id);
        String nome = cliente.getNome();
        String telefone = cliente.getTelefone();
        String email = cliente.getEmail();
        
        jtfIdClienteEditar.setText(idString);
        jtfNomeClienteEditar.setText(nome);
        jtfTelefoneClienteEditar.setText(telefone);
        jtfEmailClienteEditar.setText(email);
        
    }
    
    private void enviaDados() {

        String idString = jtfIdClienteEditar.getText();
        String nome = jtfNomeClienteEditar.getText();
        String telefone = jtfTelefoneClienteEditar.getText();
        String email = jtfEmailClienteEditar.getText();
        
        Long id = Long.parseLong(idString);
        
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        
        clienteService.put(cliente);

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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbEditarProduto;
    private javax.swing.JTextField jtfEmailClienteEditar;
    private javax.swing.JTextField jtfIdClienteEditar;
    private javax.swing.JTextField jtfNomeClienteEditar;
    private javax.swing.JTextField jtfTelefoneClienteEditar;
    // End of variables declaration//GEN-END:variables

    

    
}
