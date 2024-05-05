package facturacion;

/**
 *
 * @author alex_
 */
public class NumeroALetras {
    
    private static final String[] unidades = {"", "UN", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
    private static final String[] decenas = {"", "DIEZ", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};
    private static final String[] diezAVeinte = {"DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE"};
    private static final String[] centenas = {"", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS"};
    
    public String convertirNumeroALetras(float numero) {
        String resultado = "";
        
        // Separar la parte entera de la parte decimal
        int parteEntera = (int) numero;
        int parteDecimal = Math.round((numero - parteEntera) * 100);
        
        // Convertir la parte entera a letras
        if (parteEntera == 0) {
            resultado = "CERO";
        } else {
            resultado = convertirEntero(parteEntera);
        }
        
        // Agregar "PESOS"
        resultado += " PESOS ";
        
        // Agregar la parte decimal
        if (parteDecimal > 0) {
            resultado += convertirEntero(parteDecimal) + "/100";
        } else {
            resultado += "00/100";
        }
        
        // Agregar "M.N."
        resultado += " M.N.";
        
        return resultado;
    }
    
    private String convertirEntero(int numero) {
        String letras = "";
        
        // Convertir las centenas
        if (numero >= 100) {
            letras += centenas[numero / 100] + " ";
            numero %= 100;
        }
        
        // Convertir las decenas
        if (numero >= 10 && numero <= 19) {
            letras += diezAVeinte[numero - 10];
            return letras;
        } else if (numero >= 20) {
            letras += decenas[numero / 10] + " ";
            numero %= 10;
        }
        
        // Convertir las unidades
        if (numero > 0) {
            letras += unidades[numero];
        }
        
        return letras;
    }
    
}
