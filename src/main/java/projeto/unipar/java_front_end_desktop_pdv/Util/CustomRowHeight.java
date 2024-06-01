package projeto.unipar.java_front_end_desktop_pdv.Util;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomRowHeight extends DefaultTableCellRenderer{
    
    private int rowHeight;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        table.setRowHeight(row, rowHeight); 
        return c;
    }
    
    
    
}
