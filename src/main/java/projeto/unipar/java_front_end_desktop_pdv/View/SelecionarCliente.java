package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.java_front_end_desktop_pdv.Model.Cliente;
import projeto.unipar.java_front_end_desktop_pdv.Services.ClienteService;
import projeto.unipar.java_front_end_desktop_pdv.Util.CustomRowHeight;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class SelecionarCliente extends javax.swing.JFrame {

    private SetIconJFrame setIcon = new SetIconJFrame();
    private int rowHeight = 40;
    private Log log = new Log();
    private ClienteService clienteService = new ClienteService(log);
    private DefaultTableModel model;
    private Cliente cliente = new Cliente();
    private Pdv pdv;

    public SelecionarCliente(Pdv parent) {
        this.pdv = parent;
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jTable1.setDefaultRenderer(Object.class, new CustomRowHeight(rowHeight));
        preencherTabela();
        addDoubleClickAction();
        addKeyboardNavigation();
        selecionarPrimeiraLinha();
        setIcon.setIconJFrame(this);
    }

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

    public void selecionarCliente() {

        int row = jTable1.getSelectedRow();
        if (row != -1) {
            Long id = (Long) model.getValueAt(row, 0);
            String nome = (String) model.getValueAt(row, 1);
            String telefone = (String) model.getValueAt(row, 2);
            String email = (String) model.getValueAt(row, 3);

            cliente.setId(id);
            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);

            pdv.enviaDados(cliente);
            dispose();

        }

    }

    private void addKeyboardNavigation(){
        jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = jTable1.getSelectedRow();
                if(e.getKeyCode() == KeyEvent.VK_ENTER && row != -1){
                    selecionarCliente();
                }
            }
        
            
        
        });
    }

    
    private void addDoubleClickAction() {
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selecionarCliente();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SELECIONAR CLIENTE");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane1.setViewportView(jTable1);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void selecionarPrimeiraLinha() {

        if(jTable1.getRowCount() > 0){
            jTable1.setRowSelectionInterval(0, 0);
            jTable1.requestFocus();
        }

    }
}
