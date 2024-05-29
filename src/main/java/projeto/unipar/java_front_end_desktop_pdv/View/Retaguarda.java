
package projeto.unipar.java_front_end_desktop_pdv.View;

import javax.swing.JFrame;

public class Retaguarda extends javax.swing.JFrame {

    public Retaguarda() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastrarEditar = new javax.swing.JMenu();
        jmProduto = new javax.swing.JMenu();
        jmiCadastrarProduto = new javax.swing.JMenuItem();
        jmCliente = new javax.swing.JMenu();
        jmiCadastrarCliente = new javax.swing.JMenuItem();
        jmVenda = new javax.swing.JMenu();
        jmiPdv = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        jmCadastrarEditar.setText("Cadastrar/Editar");

        jmProduto.setText("Produto");

        jmiCadastrarProduto.setText("Cadastrar");
        jmiCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarProdutoActionPerformed(evt);
            }
        });
        jmProduto.add(jmiCadastrarProduto);

        jmCadastrarEditar.add(jmProduto);

        jmCliente.setText("Cliente");

        jmiCadastrarCliente.setText("Cadastrar");
        jmCliente.add(jmiCadastrarCliente);

        jmCadastrarEditar.add(jmCliente);

        jMenuBar1.add(jmCadastrarEditar);

        jmVenda.setText("Venda");

        jmiPdv.setText("PDV");
        jmVenda.add(jmiPdv);

        jMenuBar1.add(jmVenda);

        setJMenuBar(jMenuBar1);

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

    private void jmiCadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarProdutoActionPerformed
        // TODO add your handling code here:
        CadastrarProduto cadastrarProduto = new CadastrarProduto(this);
        cadastrarProduto.setVisible(true); 
    }//GEN-LAST:event_jmiCadastrarProdutoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Retaguarda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retaguarda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retaguarda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retaguarda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retaguarda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmCadastrarEditar;
    private javax.swing.JMenu jmCliente;
    private javax.swing.JMenu jmProduto;
    private javax.swing.JMenu jmVenda;
    private javax.swing.JMenuItem jmiCadastrarCliente;
    private javax.swing.JMenuItem jmiCadastrarProduto;
    private javax.swing.JMenuItem jmiPdv;
    // End of variables declaration//GEN-END:variables
}
