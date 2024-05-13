
package com.mycompany.consultarmediconegocio.Validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que proporciona métodos para validar diferentes tipos de datos, como
 * nombres, apellidos, cedulas, especialidad y contraseñas.
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
     * Valida una especialidad.
     *
     * @param especialidad La especialidad a validar.
     * @return true si la especialidad es válida, false en caso contrario.
     */
    public boolean validaEspecialidad(String especialidad) {

        Pattern patron = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{1,100}$");
        Matcher matcher = patron.matcher(especialidad);

        return matcher.matches();

    }

    /**
     * Valida una cedula.
     *
     * @param cedula La cedula a validar.
     * @return true si la cedula es válida, false en caso contrario.
     */
    public boolean validaCedula(String cedula) {

        Pattern patron = Pattern.compile("^[0-9]+$");
        Matcher matcher = patron.matcher(cedula);

        return matcher.matches();

    }

    /**
     * Valida una contraseña
     *
     * @param password La contraseña a validar.
     * @return true si la contraseña es válida, false en caso contrario.
     */
    public boolean validaPassword(String password) {

        Pattern patron = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        Matcher matcher = patron.matcher(password);

        return matcher.matches();

    }
}
