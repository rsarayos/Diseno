/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Clase de excepciones propias
 * @author JESUS
 */
public class PersistenciaException extends Exception{
    
    /**
     * Constructor por defecto de la excepción.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     * 
     * @param message El mensaje de la excepción.
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Constructor que inicializa la excepción con un mensaje específico y una causa.
     * 
     * @param message El mensaje de la excepción.
     * @param cause La causa de la excepción.
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor que inicializa la excepción con una causa.
     * 
     * @param cause La causa de la excepción.
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructor que inicializa la excepción con un mensaje específico, una causa,
     * y habilita o deshabilita la supresión de excepciones y la capacidad de ser
     * modificada.
     * 
     * @param message El mensaje de la excepción.
     * @param cause La causa de la excepción.
     * @param enableSuppression Indica si la supresión de excepciones está habilitada o no.
     * @param writableStackTrace Indica si la traza de pila debe ser escrita o no.
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
