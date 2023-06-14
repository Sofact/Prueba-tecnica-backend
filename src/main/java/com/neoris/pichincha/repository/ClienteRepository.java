package com.neoris.pichincha.repository;

import com.neoris.pichincha.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAll();
    @Override
    Optional<Cliente> findById(Long perId);

    void deleteByPerId(Long perId);
}
