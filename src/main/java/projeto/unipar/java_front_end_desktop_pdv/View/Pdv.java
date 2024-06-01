package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.java_front_end_desktop_pdv.Dto.ItemVendaDtoResponse;
import projeto.unipar.java_front_end_desktop_pdv.Dto.VendaDtoRequest;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Services.VendaService;
import projeto.unipar.java_front_end_desktop_pdv.Util.CustomRowHeight;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class Pdv extends javax.swing.JFrame {

    Log log = new Log();
    private SetIconJFrame setIcon = new SetIconJFrame();

    private int rowHeight = 40;

    private boolean isSelecionarClienteOpen;
    private SelecionarCliente selecionarClienteInstance;

    private boolean isSelecionarProdutoOpen;
    private SelecionarProduto selecionarProdutoInstance;

    public Pdv(JFrame parent) {
        initComponents();
        log.escreverLog("Pdv sendo aberto", 200);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jTable1.setDefaultRenderer(Object.class, new CustomRowHeight(rowHeight));
        fecharTelaPdv();
        setIcon.setIconJFrame(this);

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int r = jTable1.rowAtPoint(e.getPoint());
                if (r >= 0 && r < jTable1.getRowCount()) {
                    jTable1.setRowSelectionInterval(r, r);
                } else {
                    jTable1.clearSelection();
                }
                int rowindex = jTable1.getSelectedRow();
                if (rowindex < 0) {
                    return;
                }
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    JPopupMenu popup = new JPopupMenu();
                    JMenuItem removeItem = new JMenuItem("Remover Produto");
                    removeItem.addActionListener(e1 -> {
                        removerProdutoSelecionado();
                    });
                    popup.add(removeItem);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }

            private void removerProdutoSelecionado() {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    model.removeRow(selectedRow);
                    getValueTotal();
                    updateRowCount();

                }
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtfNomeCliente = new javax.swing.JTextField();
        jtfId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jbFinalizar = new javax.swing.JButton();
        jbAddCliente = new javax.swing.JButton();
        jbAddProduto = new javax.swing.JButton();
        jtfQuantItens = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfValorTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jbLimpaCliente = new javax.swing.JButton();
        jbLimparTabelaProdutos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDV");
        setResizable(false);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Quant", "Valor", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jtfNomeCliente.setEditable(false);
        jtfNomeCliente.setBackground(new java.awt.Color(0, 0, 0));
        jtfNomeCliente.setForeground(new java.awt.Color(255, 255, 255));

        jtfId.setEditable(false);
        jtfId.setBackground(new java.awt.Color(0, 0, 0));
        jtfId.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefone");

        jtfTelefone.setEditable(false);
        jtfTelefone.setBackground(new java.awt.Color(0, 0, 0));
        jtfTelefone.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        jtfEmail.setEditable(false);
        jtfEmail.setBackground(new java.awt.Color(0, 0, 0));
        jtfEmail.setForeground(new java.awt.Color(255, 255, 255));

        jbFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/salvar32px.png"))); // NOI18N
        jbFinalizar.setMnemonic('F');
        jbFinalizar.setText("Finalizar");
        jbFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinalizarActionPerformed(evt);
            }
        });

        jbAddCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cliente32px.png"))); // NOI18N
        jbAddCliente.setMnemonic('C');
        jbAddCliente.setText("Add Cliente");
        jbAddCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddClienteActionPerformed(evt);
            }
        });

        jbAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/produtos32px.png"))); // NOI18N
        jbAddProduto.setMnemonic('P');
        jbAddProduto.setText("Add Produto");
        jbAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddProdutoActionPerformed(evt);
            }
        });

        jtfQuantItens.setEditable(false);
        jtfQuantItens.setBackground(new java.awt.Color(0, 0, 0));
        jtfQuantItens.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jtfQuantItens.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Quantidade de Itens");

        jtfValorTotal.setEditable(false);
        jtfValorTotal.setBackground(new java.awt.Color(0, 0, 0));
        jtfValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jtfValorTotal.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Valor Total ");

        jbLimpaCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jbLimpaCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbLimpaCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lixeira32px.png"))); // NOI18N
        jbLimpaCliente.setToolTipText("Limpar cliente");
        jbLimpaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpaClienteActionPerformed(evt);
            }
        });

        jbLimparTabelaProdutos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jbLimparTabelaProdutos.setForeground(new java.awt.Color(255, 255, 255));
        jbLimparTabelaProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/lixeira32px.png"))); // NOI18N
        jbLimparTabelaProdutos.setToolTipText("Limpar Tabela de Produtos");
        jbLimparTabelaProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparTabelaProdutosActionPerformed(evt);
            }
        });

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfNomeCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfId, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfTelefone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbFinalizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbAddCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbAddProduto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfQuantItens, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jtfValorTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbLimpaCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jbLimparTabelaProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(882, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 835, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimparTabelaProdutos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfQuantItens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(86, 86, 86))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                            .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNomeCliente))
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpaCliente)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jtfQuantItens, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbLimparTabelaProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jbLimpaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
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

    private void jbAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddProdutoActionPerformed
        // TODO add your handling code here:
        if (isSelecionarProdutoOpen) {
            selecionarProdutoInstance.toFront();
            selecionarProdutoInstance.repaint();
        } else {
            isSelecionarProdutoOpen = true;
            selecionarProdutoInstance = new SelecionarProduto(this);
            selecionarProdutoInstance.setVisible(true);
            log.escreverLog("Tela de selecionar produto aberto", 200);
            selecionarProdutoInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isSelecionarProdutoOpen = false;
                    selecionarProdutoInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isSelecionarProdutoOpen = false;
                    selecionarProdutoInstance = null;
                }

            });
        }
    }//GEN-LAST:event_jbAddProdutoActionPerformed

    private void jbAddClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddClienteActionPerformed
        if (isSelecionarClienteOpen) {
            selecionarClienteInstance.toFront();
            selecionarClienteInstance.repaint();
        } else {
            isSelecionarClienteOpen = true;
            selecionarClienteInstance = new SelecionarCliente(this);
            selecionarClienteInstance.setVisible(true);
            log.escreverLog("Tela de selecionar cliente aberto", 200);
            selecionarClienteInstance.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    isSelecionarClienteOpen = false;
                    selecionarClienteInstance = null;
                }

                @Override
                public void windowClosing(WindowEvent e) {
                    isSelecionarClienteOpen = false;
                    selecionarClienteInstance = null;
                }

            });
        }
    }//GEN-LAST:event_jbAddClienteActionPerformed

    private void jbFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinalizarActionPerformed
    }//GEN-LAST:event_jbFinalizarActionPerformed

    private void jbLimpaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpaClienteActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar os campos do cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            limparCamposCliente();
        }
    }//GEN-LAST:event_jbLimpaClienteActionPerformed

    private void jbLimparTabelaProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimparTabelaProdutosActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Deseja realmente limpar a tabela de produtos?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            limparTabelaProdutos();
            jtfQuantItens.setText("");
            jtfValorTotal.setText("");
        }
    }//GEN-LAST:event_jbLimparTabelaProdutosActionPerformed

    public void ajustarLarguraColunas() {
        for (int col = 0; col < jTable1.getColumnCount(); col++) {
            TableColumn tableColumn = jTable1.getColumnModel().getColumn(col);
            int maxWidth = 0;

            for (int row = 0; row < jTable1.getRowCount(); row++) {
                TableCellRenderer cellRenderer = jTable1.getCellRenderer(row, col);
                Component c = jTable1.prepareRenderer(cellRenderer, row, col);
                int width = c.getPreferredSize().width + jTable1.getIntercellSpacing().width;
                maxWidth = Math.max(maxWidth, width);
            }

            tableColumn.setPreferredWidth(maxWidth);
        }
    }

    public void preencheTabelaVenda(ItemVendaDtoResponse itemVendaDtoResponse) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = {
            itemVendaDtoResponse.getId(),
            itemVendaDtoResponse.getNome(),
            itemVendaDtoResponse.getQuantidade(),
            itemVendaDtoResponse.getValor(),
            itemVendaDtoResponse.getValor_total()
        };
        model.addRow(row);
        getValueTotal();
        updateRowCount();
    }

    private void fecharTelaPdv() {

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int response = JOptionPane.showConfirmDialog(
                        Pdv.this,
                        "Você tem certeza que deseja fechar o PDV?",
                        "Confirmar saída",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (response == JOptionPane.YES_OPTION) {
                    Pdv.this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    if (isSelecionarClienteOpen) {
                        selecionarClienteInstance.dispose();
                    }
                    if (isSelecionarProdutoOpen) {
                        selecionarProdutoInstance.dispose();
                    }
                    log.escreverLog("Pdv sendo fechado", 200);
                } else {
                    Pdv.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }

        });

    }

    public void enviaDados(Cliente cliente) {
        Long idLong = cliente.getId();
        String idString = String.valueOf(idLong);
        jtfId.setText(idString);
        jtfNomeCliente.setText(cliente.getNome());
        jtfTelefone.setText(cliente.getTelefone());
        jtfEmail.setText(cliente.getEmail());
    }

    private void limparCamposCliente() {
        jtfId.setText("");
        jtfNomeCliente.setText("");
        jtfTelefone.setText("");
        jtfEmail.setText("");
    }

    private void limparTabelaProdutos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    public void getValueTotal() {
        ArrayList<Object> valores = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            valores.add(model.getValueAt(i, 4));
        }

        ArrayList<Double> valoresDouble = new ArrayList<>();
        for (Object valor : valores) {
            if (valor instanceof Number) {
                valoresDouble.add(((Number) valor).doubleValue());
            }
        }

        VendaDtoRequest vendaDtoRequest = new VendaDtoRequest();
        vendaDtoRequest.setValorTotalVenda(valoresDouble);
        VendaService vendaService = new VendaService(log);
        Double valorTotal = vendaService.calcularValorTotal(vendaDtoRequest);

        String valorTotalStr = String.valueOf(valorTotal);
        jtfValorTotal.setText(valorTotalStr);
    }

    private void updateRowCount() {
        int rowCount = jTable1.getRowCount();
        jtfQuantItens.setText(String.valueOf(rowCount));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAddCliente;
    private javax.swing.JButton jbAddProduto;
    private javax.swing.JButton jbFinalizar;
    private javax.swing.JButton jbLimpaCliente;
    private javax.swing.JButton jbLimparTabelaProdutos;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JTextField jtfQuantItens;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JTextField jtfValorTotal;
    // End of variables declaration//GEN-END:variables

}
