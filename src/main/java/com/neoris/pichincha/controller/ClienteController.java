package com.neoris.pichincha.controller;

import com.neoris.pichincha.exception.ResourceNotFoundException;
import com.neoris.pichincha.model.Cliente;
import com.neoris.pichincha.model.Persona;
import com.neoris.pichincha.service.ClienteService;
import com.neoris.pichincha.service.PersonaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private PersonaService personaService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/all")
    public List<Cliente> getAll(){

        return clienteService.getAll();
    }

    @GetMapping("/id/{perId}")
    public Cliente getById(@PathVariable Long perId){

        Cliente clienteactual = clienteService.findById(perId).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con ID: " + perId));

        return clienteactual;
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create (@RequestBody Cliente clienteParam){


        Cliente cliente = new Cliente();
        cliente.setPerNombre(clienteParam.getPerNombre());
        cliente.setPerDireccion(clienteParam.getPerDireccion());
        cliente.setPerEdad(clienteParam.getPerEdad());
        cliente.setPerGenero(clienteParam.getPerGenero());
        cliente.setPerIdentificacion(clienteParam.getPerIdentificacion());
        cliente.setPerTelefono(clienteParam.getPerTelefono());
        cliente.setCliContrasena(clienteParam.getCliContrasena());
        cliente.setCliEstado(clienteParam.getCliEstado());

        personaService.savePersona(cliente);

        return clienteService.saveCliente(cliente);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id){

        Optional<Cliente> clienteActual = Optional.ofNullable(clienteService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado para actualizar con ID: " + id)));

        clienteActual.orElse(null).setPerNombre(cliente.getPerNombre());
        clienteActual.orElse(null).setPerGenero(cliente.getPerGenero());
        clienteActual.orElse(null).setPerDireccion(cliente.getPerDireccion());
        clienteActual.orElse(null).setPerEdad(cliente.getPerEdad());
        clienteActual.orElse(null).setPerIdentificacion(cliente.getPerIdentificacion());
        clienteActual.orElse(null).setPerTelefono(cliente.getPerTelefono());
        clienteActual.orElse(null).setCliContrasena(cliente.getCliContrasena());
        clienteActual.orElse(null).setCliEstado(cliente.getCliEstado());

        return clienteService.updateCliente(clienteActual);

    }

    @DeleteMapping("/del/{perId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public Long delete (@PathVariable long perId){

        Cliente clienteactual = clienteService.findById(perId).orElse(null);

        if (clienteactual == null) {
            throw new ResourceNotFoundException("Cliente no encontrado para eliminar con ID: " + perId);
        }

        clienteService.deleteByPerId(perId);
        return perId;
    }

}
