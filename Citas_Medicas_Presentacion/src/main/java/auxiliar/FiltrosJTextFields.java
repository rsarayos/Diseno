package auxiliar;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/**
 * La clase FiltrosJTextFields proporciona métodos para aplicar filtros a componentes JTextFields.
 */
public class FiltrosJTextFields {

    /**
     * Constructor por defecto de la clase FiltrosJTextFields.
     */
    public FiltrosJTextFields() {
    }
    
    /**
     * Aplica un filtro para permitir únicamente letras en un JTextField.
     * @return Un PlainDocument con el filtro aplicado.
     */
    public PlainDocument filtroJTextLetras() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo letras
                if (string.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo letras
                if (text.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
    /**
     * Aplica un filtro para permitir únicamente números en un JTextField.
     * @return Un PlainDocument con el filtro aplicado.
     */
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
    
    /**
     * Aplica un filtro para permitir letras y números en un JTextField.
     * @return Un PlainDocument con el filtro aplicado.
     */
    public PlainDocument filtroJTextLetrasNumeros() {
        PlainDocument doc = new PlainDocument();

        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (string.matches("[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ  ]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Permitir solo letras y dígitos
                if (text.matches("[a-zA-Z0-9ñÑáéíóúÁÉÍÓÚ  ]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        
        return doc;
    }
    
    /**
     * Aplica un filtro para permitir letras en mayúsculas y números en un JTextField.
     * @return Un PlainDocument con el filtro aplicado.
     */
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
