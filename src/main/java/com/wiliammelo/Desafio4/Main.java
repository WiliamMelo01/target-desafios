package com.wiliammelo.Desafio4;

import java.util.HashMap;
import java.util.Map;

/*
 4) Dado o valor de faturamento mensal de uma distribuidora, detalhado por estado:
 • SP – R$67.836,43
 • RJ – R$36.678,66
 • MG – R$29.229,88
 • ES – R$27.165,48
 • Outros – R$19.849,53

 Escreva um programa na linguagem que desejar onde calcule o percentual de representação que cada estado teve dentro do valor total mensal da distribuidora.  
 */

public class Main {

    public static void main(String[] args) {

        Map<String, Double> faturamentosMensais = new HashMap<>(Map.of("SP", 67_836.43, "RJ", 36_678.66, "MG", 29_229.88, "ES", 27_165.48, "Outros", 19_849.53));

        double faturamentoTotal = faturamentosMensais.values().stream().reduce(0.0, Double::sum);

        System.out.println("Faturamento total: " + faturamentoTotal);

        faturamentosMensais.entrySet().forEach(entry -> {
            double percentual = entry.getValue() / faturamentoTotal * 100;
            System.out.printf("%s: %.2f%%\n", entry.getKey(), percentual);
        });

    }

}

