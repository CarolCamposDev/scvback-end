package com.scv.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String marca;

    private String modelo;

    private int ano;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFabricacao;

    public Date getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(Date dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Date dataHoraCadastro;

    public Veiculo(String marca, String modelo, int ano, Date dataFabricacao) {
    }

    public Veiculo() {

    }


    public long getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {

        this.marca = marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }

    public int getAno() {

        return ano;
    }

    public void setAno(int ano) {

        this.ano = ano;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {

        this.dataFabricacao = dataFabricacao;
    }

}