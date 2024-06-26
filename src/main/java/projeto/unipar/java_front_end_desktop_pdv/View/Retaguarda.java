package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projeto.unipar.java_front_end_desktop_pdv.Services.ClienteService;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class Retaguarda extends javax.swing.JFrame {

    Log log = new Log();
    private SetIconJFrame setIcon = new SetIconJFrame();

    private boolean isCadastrarProdutoOpen;
    private CadastrarProduto cadastrarProdutoInstance;

    private boolean isVisualizarProdutoOpen;
    private VisualizarProduto visualizarProdutoInstance;

    private boolean isCadastrarClienteOpen;
    private CadastrarCliente cadastrarClienteInstance;

    private boolean isVisualizarClienteOpen;
    private VisualizarCliente visualizarClienteInstance;

    private boolean isPdvOpen;
    private Pdv pdvInstance;

    public Retaguarda() {
        initComponents();
        log.escreverLog("Aplicação iniciada", 200);
        isCadastrarProdutoOpen = false;
        isVisualizarProdutoOpen = false;
        cadastrarProdutoInstance = null;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIcon.setIconJFrame(this);

//        URL iconUrl = getClass().getResource("/META-INF/pdvIcon256px.png");
//        if (iconUrl != null) {
//            ImageIcon icon = new ImageIcon(iconUrl);
//            this.setIconImage(icon.getImage());
//        } else {
//            log.escreverLog("Icon URL is null", 500);
//        }

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
                    if (isCadastrarProdutoOpen) {
                        cadastrarProdutoInstance.dispose();
                    }
                    if (isVisualizarProdutoOpen) {
                        visualizarProdutoInstance.dispose();
                    }
                    if (isCadastrarClienteOpen) {
                        cadastrarClienteInstance.dispose();
                    }
                    if (isVisualizarClienteOpen) {
                        visualizarClienteInstance.dispose();
                    }
                    if (isPdvOpen) {
                        pdvInstance.dispose();
                    }
                    log.escreverLog("Aplicação fechada com sucesso", 200);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" PARA ABRIR O LOG, UTILIZE A COMBINAÇÃO DE TECLAS (WINDOWS + R) E COLOQUE .pdvlog");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/pdvIcon256px.png"))); // NOI18N

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1354, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(92, 92, 92))
        );

        jmCadastrarEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cadastrar_editar32px.png"))); // NOI18N
        jmCadastrarEditar.setMnemonic('C');
        jmCadastrarEditar.setText("Cadastrar/Editar");

        jmProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/produtos32px.png"))); // NOI18N
        jmProduto.setMnemonic('P');
        jmProduto.setText("Produto");

        jmiCadastrarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/novo32px.png"))); // NOI18N
        jmiCadastrarProduto.setText("Cadastrar");
        jmiCadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarProdutoActionPerformed(evt);
            }
        });
        jmProduto.add(jmiCadastrarProduto);

        jmiVisualizarProduto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiVisualizarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/visualizar32px.png"))); // NOI18N
        jmiVisualizarProduto.setText("Visualizar");
        jmiVisualizarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVisualizarProdutoActionPerformed(evt);
            }
        });
        jmProduto.add(jmiVisualizarProduto);

        jmCadastrarEditar.add(jmProduto);

        jmCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cliente32px.png"))); // NOI18N
        jmCliente.setMnemonic('L');
        jmCliente.setText("Cliente");

        jmiCadastrarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiCadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/novo32px.png"))); // NOI18N
        jmiCadastrarCliente.setText("Cadastrar");
        jmiCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCadastrarClienteActionPerformed(evt);
            }
        });
        jmCliente.add(jmiCadastrarCliente);

        jmiVisualizarCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiVisualizarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/visualizar32px.png"))); // NOI18N
        jmiVisualizarCliente.setText("Visualizar");
        jmiVisualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVisualizarClienteActionPerformed(evt);
            }
        });
        jmCliente.add(jmiVisualizarCliente);

        jmCadastrarEditar.add(jmCliente);

        jMenuBar1.add(jmCadastrarEditar);

        jmVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/venda32px.png"))); // NOI18N
        jmVenda.setMnemonic('V');
        jmVenda.setText("Venda");

        jmiPdv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiPdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/pdv32px.png"))); // NOI18N
        jmiPdv.setText("PDV");
        jmiPdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPdvActionPerformed(evt);
            }
        });
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
        if (isCadastrarProdutoOpen) {
            cadastrarProdutoInstance.toFront();
            cadastrarProdutoInstance.repaint();
        } else {
            isCadastrarProdutoOpen = true;
            cadastrarProdutoInstance = new CadastrarProduto(this);
            cadastrarProdutoInstance.setVisible(true);
            log.escreverLog("Tela de cadastro de produtos aberta", 200);
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
        if (isVisualizarProdutoOpen) {
            visualizarProdutoInstance.toFront();
            visualizarProdutoInstance.repaint();
        } else {
            isVisualizarProdutoOpen = true;
            visualizarProdutoInstance = new VisualizarProduto(this);
            visualizarProdutoInstance.setVisible(true);
            log.escreverLog("Tela de visualização de produtos aberta", 200);
            visualizarProdutoInstance.addWindowListener(new WindowAdapter() {
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
        if (isCadastrarClienteOpen) {
            cadastrarClienteInstance.toFront();
            cadastrarClienteInstance.repaint();
        } else {
            isCadastrarClienteOpen = true;
            cadastrarClienteInstance = new CadastrarCliente(this);
            cadastrarClienteInstance.setVisible(true);
            log.escreverLog("Tela de cadastro de clientes aberta", 200);
            cadastrarClienteInstance.addWindowListener(new WindowAdapter() {
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
        if (isVisualizarClienteOpen) {
            visualizarClienteInstance.toFront();
            visualizarClienteInstance.repaint();
        } else {
            isVisualizarClienteOpen = true;
            visualizarClienteInstance = new VisualizarCliente(this);
            visualizarClienteInstance.setVisible(true);
            log.escreverLog("Tela de visualização de clientes aberta", 200);
            visualizarClienteInstance.addWindowListener(new WindowAdapter() {
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

    private void jmiPdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPdvActionPerformed
        if (isPdvOpen) {
            pdvInstance.toFront();
            pdvInstance.repaint();
        } else {
            isPdvOpen = true;
            pdvInstance = new Pdv(this);
            pdvInstance.setVisible(true);
            log.escreverLog("Pdv aberto", 200);
            pdvInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isPdvOpen = false;
                    pdvInstance = null;

                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isPdvOpen = false;
                    pdvInstance = null;
                }

            });
        }
    }//GEN-LAST:event_jmiPdvActionPerformed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
