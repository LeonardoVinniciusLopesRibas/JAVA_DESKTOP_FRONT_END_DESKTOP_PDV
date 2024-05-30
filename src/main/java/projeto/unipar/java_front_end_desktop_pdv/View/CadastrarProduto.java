
package projeto.unipar.java_front_end_desktop_pdv.View;

import projeto.unipar.java_front_end_desktop_pdv.Util.NumberOnlyDocument;
import javax.swing.JFrame;
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;
import projeto.unipar.java_front_end_desktop_pdv.Services.ProdutoService;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIcon;

public class CadastrarProduto extends javax.swing.JFrame {

    private Log log = new Log();
    private Produto produto = new Produto();
    private SetIcon setIcon = new SetIcon();
    
    public CadastrarProduto(JFrame parent) {
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jtfValorProduto.setDocument(new NumberOnlyDocument());
        setIcon.setSalvarButton(jbSalvar);
        setIcon.setIconLimparCampos(jbLimparCampos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeProduto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfIdProduto = new javax.swing.JTextField();
        jtfValorProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jbSalvar = new javax.swing.JButton();
        jbLimparCampos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE PRODUTO");
        setResizable(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do Produto");

        jtfNomeProduto.setBackground(new java.awt.Color(0, 0, 0));
        jtfNomeProduto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id");

        jtfIdProduto.setEditable(false);
        jtfIdProduto.setBackground(new java.awt.Color(0, 0, 0));
        jtfIdProduto.setForeground(new java.awt.Color(255, 255, 255));

        jtfValorProduto.setBackground(new java.awt.Color(0, 0, 0));
        jtfValorProduto.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Produto");

        jtfCategoria.setBackground(new java.awt.Color(0, 0, 0));
        jtfCategoria.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");

        jbSalvar.setBackground(new java.awt.Color(0, 0, 0));
        jbSalvar.setForeground(new java.awt.Color(255, 255, 255));
        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbLimparCampos.setBackground(new java.awt.Color(0, 0, 0));
        jbLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        jbLimparCampos.setText("Limpar Campos");
        jbLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparCamposActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNomeProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfIdProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfValorProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCategoria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbLimparCampos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(432, 432, 432)
                        .addComponent(jbLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jtfCategoria))
                                .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(jLabel5)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(jDesktopPane1Layout.createSequentialGroup()
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jtfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparCamposActionPerformed
        // TODO add your handling code here:
        jtfCategoria.setText("");
        jtfNomeProduto.setText("");
        jtfValorProduto.setText("");
    }//GEN-LAST:event_jbLimparCamposActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        // TODO add your handling code here:
        produto.setDescricao(jtfNomeProduto.getText());
        produto.setCategoria(jtfCategoria.getText());
        String valorProdutoString = jtfValorProduto.getText();
        double valorProduto = Double.parseDouble(valorProdutoString);
        produto.setValor_unitario(valorProduto); 
        
        getDadosCampos(produto);

        
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void getDadosCampos(Produto produto){
        
        ProdutoService produtoService = new ProdutoService(log);
        produtoService.post(produto, this);
    }
    
    public void limparCampos(){
        jtfCategoria.setText("");
        jtfNomeProduto.setText("");
        jtfValorProduto.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbLimparCampos;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JTextField jtfCategoria;
    private javax.swing.JTextField jtfIdProduto;
    private javax.swing.JTextField jtfNomeProduto;
    private javax.swing.JTextField jtfValorProduto;
    // End of variables declaration//GEN-END:variables
}
