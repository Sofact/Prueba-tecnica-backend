

import com.neoris.pichincha.controller.CuentaController;
import com.neoris.pichincha.model.Cuenta;
import com.neoris.pichincha.model.CuentaPersonaDTO;
import com.neoris.pichincha.service.CuentaPersonaService;
import com.neoris.pichincha.service.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class CuentaControllerTest {

    @Mock
    private CuentaService cuentaService;

    @Mock
    private CuentaPersonaService cuentaPersonaService;

    @InjectMocks
    private CuentaController cuentaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<CuentaPersonaDTO> expected = new ArrayList<>();
        when(cuentaPersonaService.obtenerResultadoJoin()).thenReturn(expected);

        List<CuentaPersonaDTO> actual = cuentaController.getAll();

        assertEquals(expected, actual);
    }

    @Test
    void testGetById() {
        Cuenta expected = new Cuenta();
        when(cuentaService.findById(anyLong())).thenReturn(java.util.Optional.of(expected));

        Cuenta actual = cuentaController.getById(1L);

        assertEquals(expected, actual);
    }

    @Test
    void testCreate() {
        Cuenta cuenta = new Cuenta();
        Cuenta expected = new Cuenta();
        when(cuentaService.saveCuenta(any(Cuenta.class))).thenReturn(expected);

        Cuenta actual = cuentaController.create(cuenta);

        assertEquals(expected, actual);
    }

    @Test
    void testUpdate() {
        Cuenta cuenta = new Cuenta();
        Cuenta expected = new Cuenta();
        when(cuentaService.findById(anyLong())).thenReturn(Optional.of(new Cuenta()));
        when(cuentaService.updateCuenta(any(Optional.class))).thenReturn(expected);

        Cuenta actual = cuentaController.update(cuenta, 1L);

        assertEquals(expected, actual);
    }

    @Test
    void testDelete() {
        long ctaId = 1L;
        Long expected = ctaId;

        Long actual = cuentaController.delete(ctaId);

        assertEquals(expected, actual);
    }
}
