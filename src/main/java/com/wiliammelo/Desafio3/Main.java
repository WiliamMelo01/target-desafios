package com.wiliammelo.Desafio3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.function.Predicate;

/*
 3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
 • O menor valor de faturamento ocorrido em um dia do mês;
 • O maior valor de faturamento ocorrido em um dia do mês;
 • Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.
*/

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        FileReader jsonFile = new FileReader("src/main/java/com/wiliammelo/Desafio3/dados.json");

        TypeToken<List<FaturamentoDiario>> listType = new TypeToken<List<FaturamentoDiario>>(){};

        List<FaturamentoDiario> faturamentos = new Gson().fromJson(jsonFile, listType);

        double mediaMensal = faturamentos.stream()
                .filter(faturamentoMaiorQueZero)
                .mapToDouble(FaturamentoDiario::getValor)
                .average()
                .getAsDouble();

        List<FaturamentoDiario> faturamentosAcimaMediaMensal = faturamentos.stream()
                .filter(f -> f.getValor() > mediaMensal)
                .toList();

        FaturamentoDiario menorFaturamento = faturamentos.stream()
                .filter(faturamentoMaiorQueZero)
                .min(FaturamentoDiario::compareTo)
                .get();

        FaturamentoDiario maiorFaturamento = faturamentos.stream()
                .max(FaturamentoDiario::compareTo)
                .get();

        System.out.printf("Média mensal: %.2f%n", mediaMensal);
        System.out.println("Faturamentos acima da média mensal: " + faturamentosAcimaMediaMensal);
        System.out.printf("Menor faturamento: Dia %d, Valor %.2f%n", menorFaturamento.getDia(), menorFaturamento.getValor());
        System.out.printf("Maior faturamento: Dia %d, Valor %.2f%n", maiorFaturamento.getDia(), maiorFaturamento.getValor());


    }

    static Predicate<FaturamentoDiario> faturamentoMaiorQueZero = f -> f.getValor() > 0;

}
