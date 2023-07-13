package com.neoris.pichincha.controller;


import com.itextpdf.text.DocumentException;
import com.neoris.pichincha.model.Movimiento;
import com.neoris.pichincha.model.MovimientoCuentaPersonaDTO;
import com.neoris.pichincha.model.ReporteDTO;
import com.neoris.pichincha.service.MovimientoCuentaPersonaService;
import com.neoris.pichincha.service.MovimientoCuentaService;
import com.neoris.pichincha.service.MovimientoService;
import com.neoris.pichincha.service.ReporteService;
import com.neoris.pichincha.util.PDFExporter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private MovimientoCuentaService movimientoCuentaService;

    @Autowired
    private MovimientoCuentaPersonaService movimientoCuentaPersonaService;

    @Autowired
    private ReporteService reporteService;


    @GetMapping("/all")
    public List<MovimientoCuentaPersonaDTO> getAll(){

        return movimientoCuentaPersonaService.obtenerResultadoJoin();
    }

    @GetMapping("/reporte")
    public List<ReporteDTO> getAllReporte(@RequestParam("fechaInicio") String fechaInicio,
                                          @RequestParam("fechaFin") String fechaFin,
                                          @RequestParam("opcion") int opcionSeleccionada){

        Date dateInicio =null;
        Date dateFin= null;

        try {

            dateInicio = PDFExporter.convertStringToDate(fechaInicio, "yyyy-MM-dd");
            dateFin = PDFExporter.convertStringToDate(fechaFin, "yyyy-MM-dd");



        } catch (ParseException e) {
            System.out.println("Error casteando la fecha");
        }

        return reporteService.obtenerResultadoJoin(dateInicio, dateFin, opcionSeleccionada);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generarReportePDF( @RequestParam("fechaInicio") String fechaInicio,
                                                     @RequestParam("fechaFin") String fechaFin,
                                                     @RequestParam("opcion") int opcionSeleccionada) {

        Date dateInicio =null;
        Date dateFin= null;

        try {

            dateInicio = PDFExporter.convertStringToDate(fechaInicio, "yyyy-MM-dd");
            dateFin = PDFExporter.convertStringToDate(fechaFin, "yyyy-MM-dd");



        } catch (ParseException e) {
           System.out.println("Error casteando la fecha");
        }

        try {


            List<ReporteDTO> reporte = reporteService.obtenerResultadoJoin(dateInicio, dateFin, opcionSeleccionada);
            byte[] pdfBytes = PDFExporter.exportToPDF(reporte);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "reporte.pdf");
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (DocumentException e) {
            System.err.println("Error al generar el archivo PDF: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/id/{movId}")
    public Movimiento getById(@PathVariable Long movId){

        return movimientoService.findById(movId).orElse(null);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Movimiento create (@RequestBody Movimiento movimiento) {

        Date fechaActual = new Date();
        //LocalDate fechaAct = LocalDate.now();
        movimiento.setMovfecha(fechaActual);
        return movimientoService.saveMovimiento(movimiento);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Movimiento update(@RequestBody Movimiento movimiento, @PathVariable Long id){

        Optional<Movimiento> movimientoActual = movimientoService.findById(id);


        movimientoActual.orElse(null).setMovfecha(movimiento.getMovfecha());
        movimientoActual.orElse(null).setMovTipo(movimiento.getMovTipo());
        movimientoActual.orElse(null).setMovValor(movimiento.getMovValor());
        movimientoActual.orElse(null).setMovSaldo(movimiento.getMovSaldo());

        return movimientoService.updateMovimiento(movimientoActual);
    }

    @DeleteMapping("/del/{movId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public Long delete (@PathVariable long movId){

        movimientoService.deleteByMovId(movId);
        return movId;
    }

}
