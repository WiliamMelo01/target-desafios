package com.wiliammelo.Desafio2;

import java.util.ArrayList;
import java.util.List;

/*
 2) Dado a sequência de Fibonacci, onde se inicia por 0 e 1 e o próximo valor sempre será a soma dos 2 valores anteriores
 (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...), escreva um programa na linguagem que desejar onde, informado um número,
  ele calcule a sequência de Fibonacci e retorne uma mensagem avisando se o número informado pertence ou não a sequência.
*/
public class Main {

    public static void main(String[] args) {

        long target = 1836311903L;

        List<Long> fibonacci = new ArrayList<>(List.of(0L, 1L));

       while(fibonacci.get(fibonacci.size()-1) < target ){

           fibonacci.add(fibonacci.get(fibonacci.size()-1) + fibonacci.get(fibonacci.size()-2));
           // System.out.println(fibonacci.get(fibonacci.size()-1));
       }

        if(fibonacci.get(fibonacci.size()-1) == target){
            System.out.println("O número " + target + " pertence a sequência de Fibonacci");
            return;
        }

        System.out.println("O número " + target + " não pertence a sequência de Fibonacci");

    }


}
