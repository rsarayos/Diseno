package auxiliar;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 *
 * @author alex_
 */
public class FiltrosJTextFields {

    public FiltrosJTextFields() {
    }
    
    public PlainDocument filtroJTextLetras() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo letras
                if (string.matches("[a-zA-Z ]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo letras
                if (text.matches("[a-zA-Z ]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
    public PlainDocument filtroJTextNumeros() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo dígitos
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo dígitos
                if (text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
    public PlainDocument filtroJTextLetrasNumeros() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (string.matches("[a-zA-Z0-9 ]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (text.matches("[a-zA-Z0-9 ]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
    public PlainDocument filtroJTextLetrasNumerosCase() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (string.matches("[A-Z0-9]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (text.matches("[A-Z0-9]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
}
