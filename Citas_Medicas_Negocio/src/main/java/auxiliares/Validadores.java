package auxiliares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que proporciona métodos para validar diferentes tipos de datos, como nombres,
 * apellidos, números de teléfono y direcciones de correo electrónico.
 * 
 * Esta clase utiliza expresiones regulares para realizar las validaciones.
 * 
 */
public class Validadores {

    /**
     * Constructor de la clase Validadores.
     */
    public Validadores() {
    }
    
    /**
     * Valida un nombre.
     * 
     * @param nombre El nombre a validar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    public boolean validaNombre(String nombre) {

        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{1,100}$");
        Matcher matcher = patron.matcher(nombre);

        return matcher.matches();

    }

    /**
     * Valida un apellido.
     * 
     * @param apellido El apellido a validar.
     * @return true si el apellido es válido, false en caso contrario.
     */
    public boolean validaApellidos(String apellido) {

        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]{1,50}$");
        Matcher matcher = patron.matcher(apellido);

        return matcher.matches();

    }

    /**
     * Valida un número de teléfono.
     * 
     * @param telefono El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false en caso contrario.
     */
    public boolean validaTelefono(String telefono) {

        Pattern patron = Pattern.compile("^\\d{10}$");
        Matcher matcher = patron.matcher(telefono);

        
        return matcher.matches();

    }

    /**
     * Valida una dirección de correo electrónico.
     * 
     * @param email La dirección de correo electrónico a validar.
     * @return true si la dirección de correo electrónico es válida, false en caso contrario.
     */
    public boolean validaEmail(String email) {    
        Pattern patron = Pattern.compile("[-A-Za-z0-9.,_]+(?:\\.[-A-Za-z0-9.,_]+)*@(?:[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?",Pattern.CASE_INSENSITIVE);
        Matcher matcher = patron.matcher(email);
        
        return matcher.matches();
    
    }
    
    /**
     * Valida el formato de rfc.
     * 
     * @param rfc El rfc a validar.
     * @return true si el rfc es válida, false en caso contrario.
     */
    public boolean validaRFC(String rfc) {

        Pattern patron = Pattern.compile("^[A-Z&Ñ]{4}[0-9]{6}[A-Z0-9]{3}$");
        Matcher matcher = patron.matcher(rfc);

        return matcher.matches();

    }
    
}
