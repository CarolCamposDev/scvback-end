package com.scv.controller;

import com.scv.dominio.Veiculo;

import java.util.Date;

public class VeiculoController {

    //verifica se o objeto veiculo é válido com base em validações individuais dos atributos
    public boolean isVeiculoValido(Veiculo veiculo) {
        return !isMarcaValido(veiculo) || !isModeloValido(veiculo) || !isPlacaValida(veiculo) || !isAnoValido(veiculo) || !isCorValida(veiculo);
    }


    // verifica se a valor do atributo Marca não está vazio e se tamanho da String é maior ou igual a 2
    private boolean isMarcaValido(Veiculo veiculo) {
        return (!veiculo.getMarca().isEmpty()) && veiculo.getMarca().length() >= 2;
    }

    // verifica se o valor do atributo Modelo não está vazio
    public boolean isModeloValido(Veiculo veiculo) {

        return (!veiculo.getModelo().isEmpty());

    }
    // O atributo "cor" na classe Veiculo não pode ser vazio
    private boolean isCorValida(Veiculo veiculo) {
        String cor = veiculo.getCor();
        return !cor.isEmpty();
    }

    //verifica se a placa não está vazia e se possui exatamente sete caracteres
    private boolean isPlacaValida(Veiculo veiculo) {
        String placa = veiculo.getPlaca();
        return !placa.isEmpty() && placa.matches("[a-zA-Z0-9]{7}");
    }

    // A Classe Veiculo não pode ser cadastrada se o ano for anterior a 1900
    private boolean isAnoValido(Veiculo veiculo) {
        int ano = veiculo.getAno();
        return ano >= 1900;
    }

}
