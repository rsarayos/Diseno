package org.itson.diseno.citas_medicas_guis;

import citas_medicas_dao.CitaDAOListas;
import citas_medicas_dao.ICitaDAO;
import citas_medicas_dao.IMedicoDAO;
import citas_medicas_dao.IPacienteDAO;
import citas_medicas_dao.MedicoDAOListas;
import citas_medicas_dao.PacienteDAOListas;

/**
 * Clase principal de la aplicacion
 */
public class Citas_Medicas_GUIs {

    /**
     * Inicializa la aplicacion con el frm principal
     * @param args 
     */
    public static void main(String[] args) {
        
        FrmInicioSesion inicio = new FrmInicioSesion();
        inicio.setVisible(true);
    }
}
