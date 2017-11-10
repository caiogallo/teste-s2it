package com.caiogallo.testeS2;

import java.util.*;

public class BinaryTree {
    private int value;
    private BinaryTree left;
    private BinaryTree right;

    public static void main(String... args) {
        List<Integer> nodeValues = Arrays.asList(6,9,2,8,10,1,5);
        Collections.shuffle(Arrays.asList(nodeValues));

        BinaryTree rootNode = null;
        for(int i = 0; i < nodeValues.size(); i++) {
            int nextValue = nodeValues.get(i);
            rootNode = inserir(rootNode, nextValue);
        }

        System.out.println("Soma dos nos subsequentes: " + rootNode.prefixedSum(rootNode));
    }

    static BinaryTree inserir(BinaryTree binaryTreeNode, int value) {
        BinaryTree node = binaryTreeNode;
        if (node == null) {
            node = new BinaryTree();
            node.value = value;

        }else if (value < node.value) {
            node.left = inserir(node.left, value);
        }else{
            node.right = inserir(node.right, value);
        }

        return node;
    }

    public int prefixedSum(BinaryTree node) {

        if (node != null) {
            int retorno = node.value;
            retorno += prefixedSum(node.left);
            retorno += prefixedSum(node.right);
            return retorno;
        }
        return 0;
    }

}
