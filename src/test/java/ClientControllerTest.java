import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.neoris.pichincha.controller.ClienteController;
import com.neoris.pichincha.model.Cliente;
import com.neoris.pichincha.service.ClienteService;
import com.neoris.pichincha.service.PersonaService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)


public class ClientControllerTest {
    @Mock
    private PersonaService personaService;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
    }

    @Test
    public void testGetAll() throws Exception {
        List<Cliente> clientes = Arrays.asList(
                new Cliente(/* datos de prueba */),
                new Cliente(/* datos de prueba */)
        );

        Mockito.when(clienteService.getAll()).thenReturn(clientes);

        mockMvc.perform(MockMvcRequestBuilders.get("/clientes/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
    }



    @Test
    public void testCreate() throws Exception {
        Cliente clienteParam = new Cliente(/* datos de prueba */);
        Cliente clienteGuardado = new Cliente(/* datos de prueba */);

        Mockito.when(personaService.savePersona(Mockito.any())).thenReturn(clienteParam);
        Mockito.when(clienteService.saveCliente(Mockito.any())).thenReturn(clienteGuardado);

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clienteParam)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.perNombre", Matchers.is(clienteGuardado.getPerNombre())));
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = 1L;
        Cliente cliente = new Cliente(/* datos de prueba */);
        Optional<Cliente> clienteActual = Optional.of(new Cliente(/* datos de prueba */));

        Mockito.when(clienteService.findById(id)).thenReturn(clienteActual);
        Mockito.when(clienteService.updateCliente(Mockito.any())).thenReturn(cliente);

        mockMvc.perform(MockMvcRequestBuilders.put("/clientes/update/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(cliente)))
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andExpect(MockMvcResultMatchers.jsonPath("$.perNombre", Matchers.is(cliente.getPerNombre())));
    }

    @Test
    public void testDelete() throws Exception {
        Long perId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/del/{perId}", perId))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(clienteService, Mockito.times(1)).deleteByPerId(perId);
    }

    // Método de utilidad para convertir un objeto a una cadena JSON
    private static String asJsonString(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}