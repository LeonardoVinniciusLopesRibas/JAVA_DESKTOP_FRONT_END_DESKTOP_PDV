package projeto.unipar.java_front_end_desktop_pdv.View;

import javax.swing.JFrame;
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;
import projeto.unipar.java_front_end_desktop_pdv.Services.ProdutoService;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.NumberOnlyDocument;

public class EditarProduto extends javax.swing.JFrame {

    private Log log = new Log();
    private Produto produto = new Produto();
    private ProdutoService produtoService = new ProdutoService(log);
    private VisualizarProduto visualizarProduto;
    
    public EditarProduto(VisualizarProduto parent) {
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jtfValorProdutoEditar.setDocument(new NumberOnlyDocument());
        this.visualizarProduto = parent;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jbEditarProduto = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfIdProdutoEditar = new javax.swing.JTextField();
        jtfNomeProdutoEditar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfValorProdutoEditar = new javax.swing.JTextField();
        jtfCategoriaEditar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EDITAR PRODUTO");
        setResizable(false);

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
        jLabel2.setText("Nome do Produto");

        jtfIdProdutoEditar.setEditable(false);
        jtfIdProdutoEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfIdProdutoEditar.setForeground(new java.awt.Color(255, 255, 255));

        jtfNomeProdutoEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfNomeProdutoEditar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Valor Produto");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");

        jtfValorProdutoEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfValorProdutoEditar.setForeground(new java.awt.Color(255, 255, 255));

        jtfCategoriaEditar.setBackground(new java.awt.Color(0, 0, 0));
        jtfCategoriaEditar.setForeground(new java.awt.Color(255, 255, 255));

        jDesktopPane1.setLayer(jbEditarProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfIdProdutoEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNomeProdutoEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfValorProdutoEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfCategoriaEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfValorProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfCategoriaEditar))
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel5)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfIdProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jtfNomeProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
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
                    .addComponent(jtfNomeProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfIdProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfValorProdutoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCategoriaEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        visualizarProduto.preencherTabela();
        this.dispose();
    }//GEN-LAST:event_jbEditarProdutoActionPerformed

    public void recebeDados(Produto produto) {

        Long id = produto.getId();
        String idString = String.valueOf(id);
        String descricao = produto.getDescricao();
        double valorProduto = produto.getValor_unitario();
        String valorProdutoString = String.valueOf(valorProduto);
        String categoria = produto.getCategoria();

        jtfIdProdutoEditar.setText(idString);
        jtfNomeProdutoEditar.setText(descricao);
        jtfValorProdutoEditar.setText(valorProdutoString);
        jtfCategoriaEditar.setText(categoria);

    }

    public void enviaDados() {

        String idString = jtfIdProdutoEditar.getText();
        String descricao = jtfNomeProdutoEditar.getText();
        String valorProdutoString = jtfValorProdutoEditar.getText();
        String categoria = jtfCategoriaEditar.getText();

        Long id = Long.parseLong(idString);
        double valorProduto = Double.parseDouble(valorProdutoString);
        
        produto.setId(id);
        produto.setDescricao(descricao);
        produto.setValor_unitario(valorProduto);
        produto.setCategoria(categoria);
        
        produtoService.put(produto);
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbEditarProduto;
    private javax.swing.JTextField jtfCategoriaEditar;
    private javax.swing.JTextField jtfIdProdutoEditar;
    private javax.swing.JTextField jtfNomeProdutoEditar;
    private javax.swing.JTextField jtfValorProdutoEditar;
    // End of variables declaration//GEN-END:variables
}
