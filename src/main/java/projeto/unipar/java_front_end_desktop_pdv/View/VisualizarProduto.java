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
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;
import projeto.unipar.java_front_end_desktop_pdv.Services.ProdutoService;
import projeto.unipar.java_front_end_desktop_pdv.Util.CustomRowHeight;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;

public class VisualizarProduto extends javax.swing.JFrame {

    private Log log = new Log();
    private Produto produto = new Produto();
    private ProdutoService produtoService = new ProdutoService(log);
    private DefaultTableModel model;
    private VisualizarProduto visualizarProduto;
    private int rowHeight = 40;

    public VisualizarProduto(JFrame parent) {
        initComponents();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        preencherTabela();
        addDoubleClickAction();
        jTable1.setDefaultRenderer(Object.class, new CustomRowHeight(rowHeight));
    }

    private void addDoubleClickAction() {
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        Long id = (Long) model.getValueAt(row, 0);
                        String descricao = (String) model.getValueAt(row, 1);
                        double valor = (double) model.getValueAt(row, 2);
                        String categoria = (String) model.getValueAt(row, 3);

                        produto.setId(id);
                        produto.setDescricao(descricao);
                        produto.setValor_unitario(valor);
                        produto.setCategoria(categoria);

                        EditarProduto editarProduto = new EditarProduto(VisualizarProduto.this);
                        editarProduto.setVisible(true);
                        log.escreverLog("Tela de edição de produtos aberta", 200);
                        editarProduto.recebeDados(produto);

                    }
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
        setTitle("LISTAGEM DE PRODUTOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Valor", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
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

    public void preencherTabela() {
        List<Produto> produtos = produtoService.getProdutosFromAPI();
        model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Produto produto : produtos) {
            Object[] row = {
                produto.getId(),
                produto.getDescricao(),
                produto.getValor_unitario(),
                produto.getCategoria()
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
