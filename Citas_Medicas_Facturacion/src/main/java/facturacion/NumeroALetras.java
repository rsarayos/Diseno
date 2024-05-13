package facturacion;

/**
 * Clase que proporciona métodos para convertir números a letras en formato de pesos mexicanos.
 */
public class NumeroALetras {

    private static final String[] unidades = {"", "UN", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE"};
    private static final String[] decenas = {"", "DIEZ", "VEINTE", "TREINTA", "CUARENTA", "CINCUENTA", "SESENTA", "SETENTA", "OCHENTA", "NOVENTA"};
    private static final String[] diezAVeinte = {"DIEZ", "ONCE", "DOCE", "TRECE", "CATORCE", "QUINCE", "DIECISEIS", "DIECISIETE", "DIECIOCHO", "DIECINUEVE"};
    private static final String[] centenas = {"", "CIENTO", "DOSCIENTOS", "TRESCIENTOS", "CUATROCIENTOS", "QUINIENTOS", "SEISCIENTOS", "SETECIENTOS", "OCHOCIENTOS", "NOVECIENTOS"};
    private static final String[] unidadesDeMillar = {"", "UN MIL", "DOS MIL", "TRES MIL", "CUATRO MIL", "CINCO MIL", "SEIS MIL", "SIETE MIL", "OCHO MIL", "NUEVE MIL"};
    private static final String[] decenasDeMillar = {"", "DIEZ MIL", "VEINTE MIL", "TREINTA MIL", "CUARENTA MIL", "CINCUENTA MIL", "SESENTA MIL", "SETENTA MIL", "OCHENTA MIL", "NOVENTA MIL"};
    private static final String[] entreDeLasDecenas = {"", "UN MIL", "DOS MIL", "TRES MIL", "CUATRO MIL", "CINCO MIL", "SEIS MIL", "SIETE MIL", "OCHO MIL", "NUEVE MIL"};

    /**
     * Convierte un número en formato float a letras en formato de pesos
     * mexicanos.
     *
     * @param numero El número a convertir.
     * @return Una cadena de texto que representa el número en letras.
     */
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
            resultado += parteDecimal + "/100";
        } else {
            resultado += "00/100";
        }

        // Agregar "M.N."
        resultado += " M.N.";

        return resultado;
    }

    /**
     * Convierte un número entero en letras.
     *
     * @param numero El número entero a convertir.
     * @return Una cadena de texto que representa el número en letras.
     */
    private String convertirEntero(int numero) {
        String letras = "";

        // Convertir las decenas de millar
        if (numero >= 10000) {
            int decenasDeMillar = numero / 10000;
            if (decenasDeMillar == 1) {
                letras += "DIEZ ";
            } else if (decenasDeMillar >= 2 && decenasDeMillar <= 9) {
                letras += decenas[decenasDeMillar] + " ";
            }
            letras += "MIL ";
            numero %= 10000;
        }

        // Convertir las unidades de millar
        if (numero >= 1000) {
            int unidadesDeMillar = numero / 1000;
            if (unidadesDeMillar == 1) {
                letras += "MIL ";
            } else if (unidadesDeMillar >= 2 && unidadesDeMillar <= 9) {
                letras += unidades[unidadesDeMillar] + " MIL ";
            }
            numero %= 1000;
        }

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
