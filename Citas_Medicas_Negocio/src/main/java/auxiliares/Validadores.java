package auxiliares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alex_
 */
public class Validadores {
    
    public boolean validaNombre(String nombre) {

        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{1,100}$");
        Matcher matcher = patron.matcher(nombre);

        return matcher.matches();

    }

    public boolean validaApellidos(String apellido) {

        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ]{1,50}$");
        Matcher matcher = patron.matcher(apellido);

        return matcher.matches();

    }

    public boolean validaTelefono(String telefono) {

        Pattern patron = Pattern.compile("^\\d{10}$");
        Matcher matcher = patron.matcher(telefono);

        
        return matcher.matches();

    }

    public boolean validaEmail(String email) {    
        Pattern patron = Pattern.compile("[-A-Za-z0-9.,_]+(?:\\.[-A-Za-z0-9.,_]+)*@(?:[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?\\.)+[A-Za-z0-9](?:[-A-Za-z0-9]*[A-Za-z0-9])?",Pattern.CASE_INSENSITIVE);
        Matcher matcher = patron.matcher(email);
        
        return matcher.matches();
    
    }
    
}
