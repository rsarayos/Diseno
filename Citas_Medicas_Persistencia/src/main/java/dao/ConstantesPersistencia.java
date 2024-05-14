package dao;

/**
 * Clase que contiene constantes relacionadas con la persistencia de datos.
 */
public class ConstantesPersistencia {
    
    /**
     * Clase interna que contiene nombres de bases de datos.
     */
    public static class bases {

        /**
         * Nombre de la base de datos para citas médicas.
         */
        public static final String CITAS_MEDICAS = "citas_medicas";
        
    }
    
    /**
     * Clase interna que contiene nombres de colecciones en la base de datos.
     */
    public static class colecciones {

        /**
         * Nombre de la colección para pacientes.
         */
        public static final String PACIENTES = "pacientes";
        
        /**
         * Nombre de la colección para médicos.
         */
        public static final String MEDICOS = "medicos";
        
        /**
         * Nombre de la colección para citas.
         */
        public static final String CITAS = "citas";
        
        /**
         * Nombre de la colección para facturas.
         */
        public static final String FACTURAS = "facturas";
        
        /**
         * Nombre de la coleccion para Recetas
         */
        public static final String RECETAS = "recetas";
        
    }
    
    /**
     * Clase interna que contiene cadenas de conexión para bases de datos.
     */
    public static class conexiones {

        /**
         * Cadena de conexión para MongoDB.
         */
        public static final String CONEXION_MONGO = "mongodb://127.0.0.1:27017";
        
    }
    
}
