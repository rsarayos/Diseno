
package com.mycompany.consultarmedicopersistencia.Excepciones;

/**
 * Excepción personalizada para manejar errores de persistencia.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor de la excepción de persistencia sin mensaje de error.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor de la excepción de persistencia con un mensaje de error.
     *
     * @param message El mensaje de error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor de la excepción de persistencia con un mensaje de error y una
     * causa raíz.
     *
     * @param message El mensaje de error.
     * @param cause La causa raíz de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor de la excepción de persistencia con una causa raíz.
     *
     * @param cause La causa raíz de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor de la excepción de persistencia con un mensaje de error, una
     * causa raíz, y opciones para habilitar la supresión y la traza apilable.
     *
     * @param message El mensaje de error.
     * @param cause La causa raíz de la excepción.
     * @param enableSuppression Indica si la supresión de la excepción está
     * habilitada o no.
     * @param writableStackTrace Indica si la traza apilable debe ser registrada
     * en la excepción.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
