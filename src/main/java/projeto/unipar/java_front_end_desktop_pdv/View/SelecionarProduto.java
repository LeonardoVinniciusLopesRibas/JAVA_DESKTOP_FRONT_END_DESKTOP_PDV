package projeto.unipar.java_front_end_desktop_pdv.View;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import projeto.unipar.java_front_end_desktop_pdv.Dto.ItemVendaDtoRequest;
import projeto.unipar.java_front_end_desktop_pdv.Dto.ItemVendaDtoResponse;
import projeto.unipar.java_front_end_desktop_pdv.Model.Produto;
import projeto.unipar.java_front_end_desktop_pdv.Services.ItemVendaService;
import projeto.unipar.java_front_end_desktop_pdv.Services.ProdutoService;
import projeto.unipar.java_front_end_desktop_pdv.Util.CustomRowHeight;
import projeto.unipar.java_front_end_desktop_pdv.Util.Log;
import projeto.unipar.java_front_end_desktop_pdv.Util.SetIconJFrame;

public class SelecionarProduto extends javax.swing.JFrame {

    private SetIconJFrame setIcon = new SetIconJFrame();
    private Log log = new Log();
    private Produto produto = new Produto();
    private ProdutoService produtoService = new ProdutoService(log);
    private ItemVendaService itemVendaService = new ItemVendaService(log);
    private ItemVendaDtoRequest itemVendaDto = new ItemVendaDtoRequest();
    private DefaultTableModel model;
    private int rowHeight = 40;
    private Pdv parent;

    public SelecionarProduto(Pdv parent) {
        this.parent = parent;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SELECIONAR PRODUTO");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor Unit", "Categoria"
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
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
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

    private void preencherTabela() {

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

    private void selecionarProduto() {

        int row = jTable1.getSelectedRow();
        if (row != -1) {

            Long id = (Long) model.getValueAt(row, 0);
            String descricao = (String) model.getValueAt(row, 1);
            String quantidadeStr = (String) JOptionPane.showInputDialog(null, "Digite a quantidade do produto:",
                    "Quantidade", JOptionPane.PLAIN_MESSAGE, null, null, "1");

            double valor = (double) model.getValueAt(row, 2);

            double quantidade = Double.parseDouble(quantidadeStr);

            ItemVendaDtoRequest itemVendaDto = new ItemVendaDtoRequest();
            itemVendaDto.setId(id);
            itemVendaDto.setProduto(descricao);
            itemVendaDto.setQuantidade(quantidade);
            itemVendaDto.setPrecoUnitario(valor);
            
            Double valor_total = itemVendaService.calcular(itemVendaDto);

            ItemVendaDtoResponse itemVendaDtoResponse = new ItemVendaDtoResponse();
            itemVendaDtoResponse.setId(itemVendaDto.getId());
            itemVendaDtoResponse.setNome(itemVendaDto.getProduto());
            
            itemVendaDtoResponse.setQuantidade(itemVendaDto.getQuantidade());
            itemVendaDtoResponse.setValor(itemVendaDto.getPrecoUnitario());
            itemVendaDtoResponse.setValor_total(valor_total);

            parent.preencheTabelaVenda(itemVendaDtoResponse);

            dispose();

        }

    }

    private void addKeyboardNavigation() {
        jTable1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int row = jTable1.getSelectedRow();
                if (e.getKeyCode() == KeyEvent.VK_ENTER && row != -1) {
                    selecionarProduto();
                }
            }
        });
    }

    private void addDoubleClickAction() {

        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    selecionarProduto();
                }
            }

        });

    }

    private void selecionarPrimeiraLinha() {
        if (jTable1.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
            jTable1.requestFocus();
        }
    }
}
