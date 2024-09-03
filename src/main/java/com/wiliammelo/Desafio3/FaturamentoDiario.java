package com.wiliammelo.Desafio3;

import com.google.gson.Gson;

public class FaturamentoDiario implements Comparable<FaturamentoDiario>{

    private int dia;

    private  double valor;

    public FaturamentoDiario(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public FaturamentoDiario() {
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    @Override
    public int compareTo(FaturamentoDiario f) {
        return Double.compare(this.valor, f.getValor());
    }
}
