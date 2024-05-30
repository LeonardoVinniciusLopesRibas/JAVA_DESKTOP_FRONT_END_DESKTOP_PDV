/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.unipar.java_front_end_desktop_pdv.Util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author leona
 */
public class NumberOnlyDocument extends PlainDocument {

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(str);
        boolean hasDecimalSeparator = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!Character.isDigit(c)) {
                if (c == '.' && !hasDecimalSeparator) {
                    sb.setCharAt(i, '.');
                    hasDecimalSeparator = true;
                } else {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }
        super.insertString(offs, sb.toString(), a);

    }
}
