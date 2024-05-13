package dao;

import entidades.Factura;
import entidades.Medico;
import excepcionesPersistencia.PersistenciaException;
import java.util.List;

/**
 * Interfaz que define un contrato para operaciones de acceso a datos relacionadas con facturas.
 */
public interface IFacturaDAO {
    
    /**
     * Registra una factura en el sistema.
     *
     * @param factura La factura a ser registrada.
     * @return La factura registrada.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    public Factura registrarFactura(Factura factura) throws PersistenciaException;
    
    /**
     * Consulta las factura en el sistema relacionadas a un medico en especifico para encontrar
     * la ultima factura segun su folio interno
     *
     * @param medico Medico al cual corresponden las facturas.
     * @return La ultima factura encontradas en el sistema correspondientes al medico.
     * @throws PersistenciaException Si ocurre un error durante el proceso de persistencia.
     */
    public Factura consultarUltimaFacturaMedico(Medico medico) throws PersistenciaException;
    
}
