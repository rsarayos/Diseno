package dao;

/**
 *
 * @author alex_
 */
public class ConstantesPersistencia {
    
    public static class bases {

        public static final String CITAS_MEDICAS = "citas_medicas";
        
    }
    
    public static class colecciones {

        public static final String PACIENTES = "pacientes";
        public static final String MEDICOS = "medicos";
        public static final String CITAS = "citas";
        
    }
    
    public static class conexiones {

        public static final String CONEXION_MONGO = "mongodb://127.0.0.1:27017";
        
    }
    
}
