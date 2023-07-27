package com.neoris.pichincha.service;


import com.neoris.pichincha.model.Movimiento;
import com.neoris.pichincha.repository.MovimientoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    public MovimientoService(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }


    public List<Movimiento> getAll(){

        return movimientoRepository.findAll();
    }

    public Optional<Movimiento> findById(Long movId){

        return movimientoRepository.findById(movId);
    }

    @Transactional
    public Movimiento saveMovimiento(Movimiento movimiento){

        return  movimientoRepository.save(movimiento);
    }

    @Transactional
    public Movimiento updateMovimiento(Optional<Movimiento> movimiento){

        if (movimiento.isPresent()) {

            return movimientoRepository.save(movimiento.get());
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }
    }
    @Transactional
    public void deleteByMovId(Long movId){
        movimientoRepository.deleteByMovId(movId);
    }
}
