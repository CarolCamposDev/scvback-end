package com.scv.repository;

import com.scv.dominio.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository  extends JpaRepository<Veiculo, Integer> {

    boolean existsByPlaca(String placa); //verifica se a placa já está cadastrada
}
