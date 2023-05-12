package com.scv.controller;

import com.scv.dominio.Veiculo;

public class VeiculoController {

    public boolean isVeiculoValido(Veiculo veiculo) {
        return !isMarcaValido(veiculo) || !isModeloValido(veiculo) || !isPlacaValida(veiculo);
    }

    private boolean isMarcaValido(Veiculo veiculo) {
        return (!veiculo.getMarca().isEmpty()) && veiculo.getMarca().length() >= 2;
    }


    public boolean isModeloValido(Veiculo veiculo) {

        return (!veiculo.getModelo().isEmpty());

    }

    private boolean isPlacaValida(Veiculo veiculo) {
        String placa = veiculo.getPlaca();
        return !placa.isEmpty() && placa.matches("[a-zA-Z0-9]{7}");
    }


}
