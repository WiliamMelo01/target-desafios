package com.wiliammelo.Desafio5;

// 5) Escreva um programa que inverta os caracteres de um string.

public class Main {

    public static void main(String[] args) {

        String nome = "Wiliam Melo";

        StringBuilder nomeInvertido = new StringBuilder(nome);

        for(int i =0;i<nome.length();i++){

            nomeInvertido.setCharAt(i, nome.charAt(nome.length()-1-i));

        }

        System.out.println(nomeInvertido);

    }

}
