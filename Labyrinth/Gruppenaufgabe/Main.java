package Gruppenaufgabe;

import Gruppenaufgabe.Generator.HuntandKill;

public class Main {
    public static void main(String[] args) {
        HuntandKill HAK = new HuntandKill();
        Labyrinth lb = HAK.generateLabyrinth(10, 10);
        System.out.println(lb.toString());
    }
}
