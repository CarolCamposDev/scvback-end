package com.scv.resource;

import com.scv.controller.VeiculoController;
import com.scv.dominio.Veiculo;
import com.scv.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/veiculo")
public class VeiculoResource {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping(value = "/list")
    public List<Veiculo> list() {

        return veiculoRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo) {
        VeiculoController veiculoController = new VeiculoController();
        if (veiculoController.isVeiculoValido(veiculo)) {
            return new ResponseEntity("Dados do veiculo inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        veiculo.setDataHoraCadastro(new Date());
        veiculo = veiculoRepository.save(veiculo);
        return new ResponseEntity(veiculo, HttpStatus.OK);

    }

    @GetMapping("getById/{id}")
    public Optional<Veiculo> getById(@PathVariable(value = "id") int id) {

        return veiculoRepository.findById(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<Veiculo> editar(@RequestBody Veiculo veiculo) {
        VeiculoController veiculoController = new VeiculoController();
        if (veiculoController.isVeiculoValido(veiculo)) {
            return new ResponseEntity("Dados do veículo é inválido", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        veiculo = veiculoRepository.save(veiculo);
        return new ResponseEntity(veiculo, HttpStatus.OK);
    }

    @GetMapping("/total")
    public long getTotal() {
        return veiculoRepository.count();
    }

    @DeleteMapping("/delete/{id}")
    public Veiculo remove(@PathVariable(value = "id") int id) {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(id);
        veiculoRepository.delete(optionalVeiculo.get());
        return optionalVeiculo.get();
    }

}
