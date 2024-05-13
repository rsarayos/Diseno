package pruebas;

import facturacion.NumeroALetras;

/**
 *
 * @author alex_
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        NumeroALetras conv = new NumeroALetras();
        
        System.out.println(conv.convertirNumeroALetras(4540.36f));
    }
    
}
