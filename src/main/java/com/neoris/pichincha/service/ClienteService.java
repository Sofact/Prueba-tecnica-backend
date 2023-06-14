package com.neoris.pichincha.service;

import com.neoris.pichincha.model.Cliente;
import com.neoris.pichincha.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll(){

        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long perId){

        return clienteRepository.findById(perId);
    }

    public Cliente saveCliente(Cliente cliente){

      return  clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Optional<Cliente> cliente){

        if (cliente.isPresent()) {

            return clienteRepository.save(cliente.get());
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }

    public void deleteByPerId(Long perId){
            clienteRepository.deleteByPerId(perId);
    }

}
