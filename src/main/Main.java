/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 27/02/20
 *   Time: 8:34 AM
 */

package main;

import definition.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            int randomNmber =(int)(Math.random()*100);
            binaryTree.add(randomNmber);
            System.out.print(randomNmber+" ");
        }
        System.out.println();
        binaryTree.print();

    }
}
