

import com.itextpdf.text.DocumentException;
import com.neoris.pichincha.controller.MovimientoController;
import com.neoris.pichincha.model.Movimiento;
import com.neoris.pichincha.model.MovimientoCuentaPersonaDTO;
import com.neoris.pichincha.model.ReporteDTO;
import com.neoris.pichincha.service.MovimientoCuentaPersonaService;
import com.neoris.pichincha.service.MovimientoCuentaService;
import com.neoris.pichincha.service.MovimientoService;
import com.neoris.pichincha.service.ReporteService;
import com.neoris.pichincha.util.PDFExporter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class MovimientoControllerTest {

    @Mock
    private MovimientoService movimientoService;

    @Mock
    private MovimientoCuentaService movimientoCuentaService;

    @Mock
    private MovimientoCuentaPersonaService movimientoCuentaPersonaService;

    @Mock
    private ReporteService reporteService;

    @Mock
    private PDFExporter pdfExporter;

    @InjectMocks
    private MovimientoController movimientoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<MovimientoCuentaPersonaDTO> expected = new ArrayList<>();
        when(movimientoCuentaPersonaService.obtenerResultadoJoin()).thenReturn(expected);

        List<MovimientoCuentaPersonaDTO> actual = movimientoController.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void testGetAllReporte() throws ParseException {
        List<ReporteDTO> expected = new ArrayList<>();
        Date fechaInicio = new Date();
        Date fechaFin = new Date();

        when(reporteService.obtenerResultadoJoin(any(Date.class), any(Date.class), anyInt())).thenReturn(expected);

        List<ReporteDTO> actual = movimientoController.getAllReporte(
                "2021-01-01",
                "2021-12-31",
                1
        );

        assertEquals(expected, actual);
    }

    @Test
    void testGetById() {
        Movimiento expected = new Movimiento();
        when(movimientoService.findById(anyLong())).thenReturn(java.util.Optional.of(expected));

        Movimiento actual = movimientoController.getById(1L);

        assertEquals(expected, actual);
    }
}

