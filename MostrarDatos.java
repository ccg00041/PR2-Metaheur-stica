/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author carol
 */
public class MostrarDatos {

    public MostrarDatos() {

    }

    public void mostrarV(ArrayList<Integer> vector) {
        System.out.println("Imprimo vector");
        for (int i = 0; i < vector.size(); ++i) {
            System.out.println("pos " + i + " " + vector.get(i));
        }
    }

    public void mostrarM(ArrayList<ArrayList<Pair>> ctrMatriz) {
        System.out.println("Imprimo matriz");
        for (int i = 0; i < ctrMatriz.size(); ++i) {
            System.out.print(ctrMatriz.get(i) + " ");
//            for (int j = 0; j < ctrMatriz.get(i).size(); ++j) {
//                System.out.print(ctrMatriz.get(i).get(j) + " ");
//            }
            System.out.println();
        }
//        System.out.println(ctrMatriz.get(0).get(2));
    }

    //ANTIGUO
//    public void mostrarM(ArrayList<ArrayList<Integer>> ctrMatriz) {
//        System.out.println("Imprimo matriz");
//        for (int i = 0; i < ctrMatriz.size(); ++i) {
//            for (int j = 0; j < ctrMatriz.get(i).size(); ++j) {
//                System.out.print(ctrMatriz.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }
//    }
    public void MostrarSolucion(ArrayList<Integer> solucion) {
        System.out.println("leyendo solucion");
        for (int i = 0; i < solucion.size(); ++i) {
            System.out.print(" " + solucion.get(i));
        }
        System.out.println();
    }

    public void mostrarTiempo(long tiempo) {
        System.out.println("Ha tardado " + tiempo + " milisegundos");
    }

    public void mostrarTiempoFichero(long tiempo, String fich) {
        System.out.println("El algoritmo " + fich + " ha tardado " + tiempo + " milisegundos");
    }

    public void mostrarCoste(Integer coste) {
        System.out.println("El coste es " + coste);
    }
}
