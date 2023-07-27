import com.neoris.pichincha.model.CuentaPersonaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public record CuentaPersonaDTOTest() {

    @InjectMocks
    private static CuentaPersonaDTO cuentaPersonaDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCtaId() {
        Long expectedCtaId = 123L;
        cuentaPersonaDTO.setCtaId(expectedCtaId);
        Long actualCtaId = cuentaPersonaDTO.getCtaId();
        assertEquals(expectedCtaId, actualCtaId);
    }

    @Test
    public void testGetCtaNumero() {
        BigDecimal expectedCtaNumero = new BigDecimal("1000.50");
        cuentaPersonaDTO.setCtaNumero(expectedCtaNumero);
        BigDecimal actualCtaNumero = cuentaPersonaDTO.getCtaNumero();
        assertEquals(expectedCtaNumero, actualCtaNumero);
    }

    @Test
    public void testGetCtaTipoCuenta() {
        String expectedTipoCuenta = ("Ahorros");
        cuentaPersonaDTO.setCtaTipoCuenta(expectedTipoCuenta);
        String actualTipoCuenta = cuentaPersonaDTO.getCtaTipoCuenta();
        assertEquals(expectedTipoCuenta, actualTipoCuenta);
    }
}
