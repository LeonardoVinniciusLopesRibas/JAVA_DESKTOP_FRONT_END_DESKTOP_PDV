package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Services.ClienteService;
import projeto.unipar.java_front_end_desktop_pdv.Util.CustomRowHeight;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class VisualizarCliente extends javax.swing.JFrame {

    private SetIconJFrame setIcon = new SetIconJFrame();
    private Log log = new Log();
    private Cliente cliente = new Cliente();
    private ClienteService clienteService = new ClienteService(log);
    private DefaultTableModel model;
    private VisualizarCliente visualizarCliente;
    private int rowHeight = 40;

    public VisualizarCliente(JFrame parent) {
        this.clienteService = new ClienteService(log);
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        preencherTabela();
        addDoubleClickAction();
        setIcon.setIconJFrame(this);
        jTable1.setDefaultRenderer(Object.class, new CustomRowHeight(rowHeight));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Dê um clique duplo para editar um cliente");

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void preencherTabela() {

        List<Cliente> clientes = clienteService.getClientesFromAPI();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Cliente cliente : clientes) {
            Object[] row = {
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEmail()
            };
            model.addRow(row);
        }
        ajustarLarguraColunas();
    }

    private void addDoubleClickAction() {

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        Long id = (Long) model.getValueAt(row, 0);
                        String nome = (String) model.getValueAt(row, 1);
                        String telefone = (String) model.getValueAt(row, 2);
                        String email = (String) model.getValueAt(row, 3);

                        cliente.setId(id);
                        cliente.setNome(nome);
                        cliente.setTelefone(telefone);
                        cliente.setEmail(email);

                        EditarCliente editarCliente = new EditarCliente(VisualizarCliente.this);
                        editarCliente.setVisible(true);
                        log.escreverLog("Tela de edição de clientes aberta", 200);
                        editarCliente.recebeDados(cliente);
                    }
                }

            }

        });

    }

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
}
