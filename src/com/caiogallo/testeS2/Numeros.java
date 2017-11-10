package com.caiogallo.testeS2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Numeros {
    public static void main(String... args) {
        int a = 9, b = 5736;
        Numeros numeros = new Numeros();
        Queue qA = numeros.integerToQueue(a);
        Queue qB = numeros.integerToQueue(b);

        StringBuilder strC = preencheC(qA, qB);
        Integer c = Integer.parseInt(strC.toString());

        System.out.println("Resultado: " + c);

    }

    private static StringBuilder preencheC(Queue qA, Queue qB) {
        StringBuilder c = new StringBuilder();
        int maiorFila = qA.size() > qB.size()? qA.size(): qB.size();
        for(int i = 0; i < maiorFila; i++) {
            if (!qA.isEmpty()) {
                c.append(qA.poll());
            }
            if (!qB.isEmpty()) {
                c.append(qB.poll());
            }
        }
        return c;
    }

    public Queue integerToQueue(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        Queue<Integer> queue = new ArrayDeque<>();
        for (char c : numStr) {
            queue.add(Character.getNumericValue(c));
        }
        return queue;
    }

}
