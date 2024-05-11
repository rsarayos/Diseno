package dao;

import entidades.Factura;
import excepcionesPersistencia.PersistenciaException;

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
    
}
