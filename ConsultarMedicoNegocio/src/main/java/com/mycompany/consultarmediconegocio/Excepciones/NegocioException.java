package com.mycompany.consultarmediconegocio.Excepciones;

/**
 * Excepción personalizada para manejar errores de lógica de negocio.
 *
 * Esta excepción se utiliza para indicar que ha ocurrido un error relacionado
 * con la lógica de negocio del sistema.
 *
 */
public class NegocioException extends Exception {

    /**
     * Constructor predeterminado de NegocioException.
     */
    public NegocioException() {
    }

    /**
     * Constructor de NegocioException con un mensaje descriptivo del error.
     *
     * @param message El mensaje descriptivo del error.
     */
    public NegocioException(String message) {
        super(message);
    }

    /**
     * Constructor de NegocioException con un mensaje descriptivo del error y la
     * causa subyacente.
     *
     * @param message El mensaje descriptivo del error.
     * @param cause La causa subyacente del error.
     */
    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor de NegocioException con la causa subyacente del error.
     *
     * @param cause La causa subyacente del error.
     */
    public NegocioException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor de NegocioException con un mensaje descriptivo del error, la
     * causa subyacente, y opciones para habilitar la supresión de excepciones y
     * configurar si la traza de la pila es escribible.
     *
     * @param message El mensaje descriptivo del error.
     * @param cause La causa subyacente del error.
     * @param enableSuppression Indica si la supresión de excepciones está
     * habilitada o deshabilitada.
     * @param writableStackTrace Indica si la traza de la pila es escribible o
     * no.
     */
    public NegocioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
