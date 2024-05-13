package pruebasPersistencia;

import dao.Conexion;
import dao.ConstantesPersistencia;
import dao.FacturaDAO;
import dao.IConexion;
import dao.IFacturaDAO;
import entidades.DatosFiscales;
import entidades.Factura;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex_
 */
public class PruebasPersisFactura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IConexion conexion = new Conexion(ConstantesPersistencia.colecciones.FACTURAS, Factura.class);
        
        IFacturaDAO facturaDAO = new FacturaDAO(conexion);

        Medico medico = new Medico();
        List<DatosFiscales> datos = new LinkedList<>();
        DatosFiscales d = new DatosFiscales();
        d.setRfc("MEDI200503PRU");
        datos.add(d);
        medico.setDatosFiscales(datos);
        
        try {
            Factura factura = facturaDAO.consultarUltimaFacturaMedico(medico);
            System.out.println(factura);
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebasPersisFactura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
