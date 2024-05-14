/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Clase de excepciones para validadores
 * @author JESUS
 */
public class ValidacionException extends Exception{
    
    /**
     * Constructor predeterminado de ValidacionException.
     */
    public ValidacionException() {
    }

    /**
     * Constructor de ValidacionException con un mensaje descriptivo del error.
     * 
     * @param message El mensaje descriptivo del error.
     */
    public ValidacionException(String message) {
        super(message);
    }

    /**
     * Constructor de ValidacionException con un mensaje descriptivo del error y la causa subyacente.
     * 
     * @param message El mensaje descriptivo del error.
     * @param cause La causa subyacente del error.
     */
    public ValidacionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor de ValidacionException con la causa subyacente del error.
     * 
     * @param cause La causa subyacente del error.
     */
    public ValidacionException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor de ValidacionException con un mensaje descriptivo del error, la causa subyacente,
     * y opciones para habilitar la supresión de excepciones y configurar si la traza de la pila es escribible.
     * 
     * @param message El mensaje descriptivo del error.
     * @param cause La causa subyacente del error.
     * @param enableSuppression Indica si la supresión de excepciones está habilitada o deshabilitada.
     * @param writableStackTrace Indica si la traza de la pila es escribible o no.
     */
    public ValidacionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
