package com.neoris.pichincha.service;

import com.neoris.pichincha.model.Persona;
import com.neoris.pichincha.repository.PersonaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {


    private final PersonaRepository personaRepository;


    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Transactional
    public Persona savePersona (Persona persona){
        return personaRepository.save(persona);
    }

    public Persona getPersonaByPerId (Long perId){
        return personaRepository.findByPerId(perId).orElse(null);
    }


}
