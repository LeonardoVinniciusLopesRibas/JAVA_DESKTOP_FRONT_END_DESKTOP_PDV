package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIcon;

public class Retaguarda extends javax.swing.JFrame {
    
    private SetIcon setIcon = new SetIcon();
    
    private boolean isCadastrarProdutoOpen;
    private CadastrarProduto cadastrarProdutoInstance;
    
    private boolean isVisualizarProdutoOpen;
    private VisualizarProduto visualizarProdutoInstance;
    
    private boolean isCadastrarClienteOpen;
    private CadastrarCliente cadastrarClienteInstance;
    
    private boolean isVisualizarClienteOpen;
    private VisualizarCliente visualizarClienteInstance;
    
    public Retaguarda() {
        initComponents();
        isCadastrarProdutoOpen = false;
        isVisualizarProdutoOpen = false;
        cadastrarProdutoInstance = null;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon.setIconCadastrar_Editar(jmCadastrarEditar);
        setIcon.setIconProduto(jmProduto);
        setIcon.setIconCadastrarProduto(jmiCadastrarProduto);
        setIcon.setIconVisualizarProduto(jmiVisualizarProduto);
        setIcon.setIconCliente(jmCliente);
        setIcon.setIconCadastrarCliente(jmiCadastrarCliente);
        setIcon.setIconVisualizarCliente(jmiVisualizarCliente);                
        setIcon.setIconVenda(jmVenda);
        setIcon.setIconPdv(jmiPdv);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        Retaguarda.this,
                        "Você tem certeza que deseja fechar o sistema?",
                        "Confirmar saída",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    Retaguarda.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    if(isCadastrarProdutoOpen)
                        cadastrarProdutoInstance.dispose();
                    if(isVisualizarProdutoOpen)
                        visualizarProdutoInstance.dispose();
                    if(isCadastrarClienteOpen)
                        cadastrarClienteInstance.dispose();
                    if(isVisualizarClienteOpen)
                        visualizarClienteInstance.dispose();
                } else {
                    Retaguarda.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastrarEditar = new javax.swing.JMenu();
        jmProduto = new javax.swing.JMenu();
        jmiCadastrarProduto = new javax.swing.JMenuItem();
        jmiVisualizarProduto = new javax.swing.JMenuItem();
        jmCliente = new javax.swing.JMenu();
        jmiCadastrarCliente = new javax.swing.JMenuItem();
        jmiVisualizarCliente = new javax.swing.JMenuItem();
        jmVenda = new javax.swing.JMenu();
        jmiPdv = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDV");

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

        jmiVisualizarProduto.setText("Visualizar");
        jmiVisualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVisualizarProdutoActionPerformed(evt);
            }
        });
        jmProduto.add(jmiVisualizarProduto);

        jmCadastrarEditar.add(jmProduto);

        jmCliente.setText("Cliente");

        jmiCadastrarCliente.setText("Cadastrar");
        jmiCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarClienteActionPerformed(evt);
            }
        });
        jmCliente.add(jmiCadastrarCliente);

        jmiVisualizarCliente.setText("Visualizar");
        jmiVisualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVisualizarClienteActionPerformed(evt);
            }
        });
        jmCliente.add(jmiVisualizarCliente);

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
        if (isCadastrarProdutoOpen) {
            cadastrarProdutoInstance.toFront();
            cadastrarProdutoInstance.repaint();
        } else {
            isCadastrarProdutoOpen = true;
            cadastrarProdutoInstance = new CadastrarProduto(this);
            cadastrarProdutoInstance.setVisible(true);
            cadastrarProdutoInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isCadastrarProdutoOpen = false;
                    cadastrarProdutoInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isCadastrarProdutoOpen = false;
                    cadastrarProdutoInstance = null;
                }
            });
        }   
        
    }//GEN-LAST:event_jmiCadastrarProdutoActionPerformed

    private void jmiVisualizarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVisualizarProdutoActionPerformed
        // TODO add your handling code here:
        if(isVisualizarProdutoOpen){
            visualizarProdutoInstance.toFront();
            visualizarProdutoInstance.repaint();
        } else {
            isVisualizarProdutoOpen = true;
            visualizarProdutoInstance = new VisualizarProduto(this);
            visualizarProdutoInstance.setVisible(true);
            visualizarProdutoInstance.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    isVisualizarProdutoOpen = false;
                    cadastrarProdutoInstance = null;

                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isVisualizarProdutoOpen = false;
                    cadastrarProdutoInstance = null;
                }
                
            });
        }
    }//GEN-LAST:event_jmiVisualizarProdutoActionPerformed

    private void jmiCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCadastrarClienteActionPerformed
        // TODO add your handling code here:
        if(isCadastrarClienteOpen){
            cadastrarClienteInstance.toFront();
            cadastrarClienteInstance.repaint();
        }else {
            isCadastrarClienteOpen = true;
            cadastrarClienteInstance = new CadastrarCliente(this);
            cadastrarClienteInstance.setVisible(true);
            cadastrarClienteInstance.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    isCadastrarClienteOpen = false;
                    cadastrarClienteInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isCadastrarClienteOpen = false;
                    cadastrarClienteInstance = null;
                   
                }
                
            });
        }
    }//GEN-LAST:event_jmiCadastrarClienteActionPerformed

    private void jmiVisualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVisualizarClienteActionPerformed
        // TODO add your handling code here:
        if(isVisualizarClienteOpen){
            visualizarClienteInstance.toFront();
            visualizarClienteInstance.repaint();
        }else{
            isVisualizarClienteOpen = true;
            visualizarClienteInstance = new VisualizarCliente(this);
            visualizarClienteInstance.setVisible(true);
            visualizarClienteInstance.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosed(WindowEvent e) {
                    isVisualizarClienteOpen = false;
                    visualizarClienteInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isVisualizarClienteOpen = false;
                    visualizarClienteInstance = null;
                }
                
            });
        }
    }//GEN-LAST:event_jmiVisualizarClienteActionPerformed

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
    private javax.swing.JMenuItem jmiVisualizarCliente;
    private javax.swing.JMenuItem jmiVisualizarProduto;
    // End of variables declaration//GEN-END:variables
}
