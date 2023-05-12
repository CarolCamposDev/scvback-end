package com.scv.controller;

import com.scv.dominio.Veiculo;

public class VeiculoController {

    public boolean isVeiculoValido(Veiculo veiculo) {
        return !isMarcaValido(veiculo) || !isModeloValido(veiculo);
    }

    private boolean isMarcaValido(Veiculo veiculo) {
        return (!veiculo.getMarca().isEmpty()) && veiculo.getMarca().length() >= 2;
    }

    public boolean isModeloValido(Veiculo veiculo) {
        if (veiculo.getModelo().isEmpty()) return false;
        if (veiculo.getModelo().length() < 2) return false;
        return veiculo.getModelo().matches("(?=.*[a-zA-Z])(?=.*[0-9]).+");
    }
}
