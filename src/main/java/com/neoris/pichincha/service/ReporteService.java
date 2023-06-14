package com.neoris.pichincha.service;

import com.itextpdf.text.DocumentException;
import com.neoris.pichincha.model.ReporteDTO;
import com.neoris.pichincha.repository.ReporteRepository;
import com.neoris.pichincha.util.PDFExporter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public ReporteService(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }


    public List<ReporteDTO> obtenerResultadoJoin(Date fechaInicio, Date fechaFin, int opcionSeleccionada) {
        List<Object[]> resultados = reporteRepository.obtenerResultadoJoin( fechaInicio,  fechaFin, (long) opcionSeleccionada);
        List<ReporteDTO> reporte = new ArrayList<>();

        for (Object[] resultado : resultados) {
            ReporteDTO reporteDTO = new ReporteDTO();
            reporteDTO.setPerId((Long) resultado[0]);
            reporteDTO.setPerNombre((String) resultado[1]);
            reporteDTO.setCtaId((Long) resultado[2]);
            reporteDTO.setCtaEstado((String) resultado[3]);
            reporteDTO.setCtaNumero((Long) resultado[4]);
            reporteDTO.setCtaSaldoInicial((Long) resultado[5]);
            reporteDTO.setCtaTipoCuenta((String) resultado[6]);
            reporteDTO.setTotalCreditos((BigDecimal) resultado[7]);
            reporteDTO.setTotalDebitos((BigDecimal) resultado[8]);
            reporteDTO.setMovSaldo((Long) resultado[9]);



            reporte.add(reporteDTO);
        }

        return reporte;
    }
    public byte[] generarReportePDF(List<ReporteDTO> reporte) throws DocumentException {

        return PDFExporter.exportToPDF(reporte);
    }
}
