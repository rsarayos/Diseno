package facturacion;

import dtos.DetalleFacturaDTO;
import dtos.FacturaDTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Clase que se encarga de generar la factura impresa.
 */
public class GenerarFacturaImpresa {
    
    /**
     * Genera la factura impresa a partir de los datos de la factura.
     * 
     * @param factura Los datos de la factura.
     */
    public void generarImpresion(FacturaDTO factura) {
        
        Map<String, Object> parameters = mapeoParametros(factura);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Reporte");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();

            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            try (InputStream input = new FileInputStream(new File("Factura.jrxml"))) {
                JasperDesign jasperDesign = JRXmlLoader.load(input);

                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                try (OutputStream outputStream = new FileOutputStream(new File(filePath))) {
                    JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                }

                // visualiza el reporte en el lector jasper
                JasperViewer.viewReport(jasperPrint);

            } catch (Exception ex) {
                Logger.getLogger(GenerarFacturaImpresa.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Error al generar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            System.out.println("File Generated");
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            System.out.println("Save command cancelled by user.");
        }

    }
    
    /**
     * Convierte los detalles de la factura a un formato adecuado para el reporte.
     * 
     * @param detalles La lista de detalles de la factura.
     * @return Una lista de detalles de factura en formato para el reporte.
     */
    private List<DetalleFacturaReporte> convertirDetallesAReporte(List<DetalleFacturaDTO> detalles) {
        List<DetalleFacturaReporte> listaDetalles = new ArrayList<DetalleFacturaReporte>();

        for (DetalleFacturaDTO detalle : detalles) {
            String cantidad = detalle.getCantidad().toString();
            String unidad = detalle.getUnidad();
            String claveUnidad = detalle.getClaveUnidad();
            String claveProducto = detalle.getClaveProducto();
            String descripcion = detalle.getDescripcion();
            String valorUnitario = NumberFormat.getCurrencyInstance().format(detalle.getValorUnitario());
            String importe = NumberFormat.getCurrencyInstance().format(detalle.getImporte());;

            DetalleFacturaReporte detalleReporte = new DetalleFacturaReporte(
                    cantidad,
                    unidad,
                    claveUnidad,
                    claveProducto,
                    descripcion,
                    valorUnitario,
                    importe);

            listaDetalles.add(detalleReporte);
        }

        return listaDetalles;

    }
    
    /**
     * Realiza el mapeo de los parámetros para el reporte de factura.
     * 
     * @param factura Los datos de la factura.
     * @return Un mapa de parámetros para el reporte.
     */
    private Map<String, Object> mapeoParametros(FacturaDTO factura){
        Map<String, Object> parametros = new HashMap<String, Object>();
        
        JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(
                convertirDetallesAReporte(factura.getDetallesFactura()));
        
        String emisor = factura.getEmisor().getDatosFiscales().get(0).getRazonSocial();
        String rfcEmisor = factura.getEmisor().getDatosFiscales().get(0).getRFC();     
        StringBuilder direccionEComp = new StringBuilder();
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getCalle());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getNumExterior());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getColonia());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getCodigoPostal());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getCiudad());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getMunicipio());
        direccionEComp.append(" ");
        direccionEComp.append(factura.getEmisor().getDatosFiscales().get(0).getEstado());
        direccionEComp.append(" ");       
        String direccionEmisor = direccionEComp.toString();
        String telefonoEmisor = factura.getEmisor().getTelefono();
        String regimenEmisor = factura.getEmisor().getDatosFiscales().get(0).getRegimenFiscal();
        
        
        String receptor = factura.getReceptor().getDatosFiscales().get(0).getRazonSocial();
        String rfcReceptor = factura.getReceptor().getDatosFiscales().get(0).getRFC();
        StringBuilder direccionRComp = new StringBuilder();
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getCalle());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getNumExterior());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getColonia());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getCodigoPostal());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getCiudad());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getMunicipio());
        direccionRComp.append(" ");
        direccionRComp.append(factura.getReceptor().getDatosFiscales().get(0).getEstado());
        direccionRComp.append(" ");           
        String domicilioReceptor = direccionRComp.toString();
        String usoCFDI = factura.getUsoCFDI();
        String folioFactura = factura.getFolioInterno().toString();
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaTimbrado = fechaActual.format(formato);
        String folioFiscal = factura.getFolioFiscal();
        String subTotal = NumberFormat.getCurrencyInstance().format(factura.getSubTotal());
        String impuesto = NumberFormat.getCurrencyInstance().format(factura.getImpuesto());
        String total = NumberFormat.getCurrencyInstance().format(factura.getTotal());
        NumeroALetras convertidor = new NumeroALetras();
        String importeLetra = convertidor.convertirNumeroALetras(factura.getTotal());
        String formaDePago = factura.getFormaPago();
        String metodoDePago = factura.getMetodoPago();
        
        parametros.put("CollectionBeanParam", itemsJRBean);
        parametros.put("emisor", emisor);
        parametros.put("rfcEmisor", rfcEmisor);
        parametros.put("direccionEmisor", direccionEmisor);
        parametros.put("telefonoEmisor", telefonoEmisor);
        parametros.put("regimenEmisor", regimenEmisor);
        parametros.put("receptor", receptor);
        parametros.put("rfcReceptor", rfcReceptor);
        parametros.put("domicilioReceptor", domicilioReceptor);
        parametros.put("usoCFDI", usoCFDI);
        parametros.put("folioFactura", folioFactura);
        parametros.put("fechaTimbrado", fechaTimbrado);
        parametros.put("folioFiscal", folioFiscal);
        parametros.put("subTotal", subTotal);
        parametros.put("impuesto", impuesto);
        parametros.put("total", total);
        parametros.put("importeLetra", importeLetra);
        parametros.put("formaDePago", formaDePago);
        parametros.put("metodoDePago", metodoDePago);
    
        return parametros;
        
    }

}
