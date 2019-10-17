/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.util.Pair;
import pr1meta.CargarDatos;
import pr1meta.Menu;

/**
 *
 * @author carol
 */
public class PR1META {
//
//    public static boolean poblacionConverge(ArrayList<ArrayList<Integer>> p) {
//        boolean converge = false;
//        converge = p.stream().distinct().limit(2).count() <= (long) (p.size() * 0.8);
//        //Recorrer la poblacion , vector auxiliar relleno de 0
//        //Cada vez que recorro un individuo 
//
//        return converge;
//    }

    public static void main(String[] args) throws FileNotFoundException {
                Menu menu = new Menu();
                menu.mainMenu();
//            ArrayList<ArrayList<Integer> > p = new ArrayList<>();
//            ArrayList<Integer> f = new ArrayList<>();
//            ArrayList<Integer> f2 = new ArrayList<>();
//            for(int i = 0; i < 5; ++i){
//                f.add(2);
//            }
//            p.add(f);
//            
//            for(int i = 0; i < 5; ++i){
//                f2.add(i);
//            }
//            p.add(f2);
//            p.add(f2);
//            p.add(f2);
//            boolean converge = poblacionConverge(p);
//            System.out.println("converge "+ converge + " "+p.toString())ArrayList<ArrayList<Integer> > p = new ArrayList<>();
//            ArrayList<Integer> f = new ArrayList<>();
//            ArrayList<Integer> f2 = new ArrayList<>();
//            for(int i = 0; i < 5; ++i){
//                f.add(2);
//            }
//            p.add(f);
//            
//            for(int i = 0; i < 5; ++i){
//                f2.add(i);
//            }
//            p.add(f2);
//            p.add(f2);
//            p.add(f2);
//            boolean converge = poblacionConverge(p);
//            System.out.pri;
//          //PROBANDO MATRIZ FRECUENCIAS
//           CargarDatos carga = new CargarDatos();
//           ArrayList<ArrayList<Integer>> matrizVAR;
//           ArrayList<ArrayList<Integer>> matrizDOM;
//           
//          MatrizFrecuencias m = new MatrizFrecuencias(20);
//          //PROBANDO LISTA TABU
//          int tam=40;
//          ListaTabu l= new ListaTabu(tam);
//          for(int i = 0; i < 22;++i){
//              l.insertar(i, i+1);
//          }
//          l.mostrar();
//          
//        //PROBANDO RANDOM
//        Random r = new Random(12345678); 
//        for (int i = 0; i < 20; ++i) {
//            System.out.println(r.nextInt(2)); //genera numeros de 0 a tam-1
//        } 
//        CargarDatos carga = new CargarDatos();
//        MostrarDatos mostrar = new MostrarDatos();
//        ArrayList<ArrayList<Integer>> var;
//        var = carga.cargarVAR("src/archivos/graph05/var.txt");
//        mostrar.mostrarM(var);
//        System.out.println("probando");
//        System.out.println(var.get(0).get(0));
//        System.out.println(var.get(0).get(1));
//        AlgGreedy greedy = new AlgGreedy();
//        AlgBL bl= new AlgBL();
//        Utils util = new Utils();
//        ArrayList<ArrayList<Pair>> matrizCTR;
//        ArrayList<ArrayList<Integer>> matrizDOM;
//        ArrayList<Integer> vectorVAR;
//        ArrayList<Integer> solucion;
//        matrizCTR = carga.cargarCTRnuevo("src/archivos/Ejemplo/ctr.txt");
//        mostrar.mostrarM(matrizCTR);
//        matrizDOM = carga.cargarDOM("src/archivos/graph05/dom.txt");
//        vectorVAR = carga.cargarVAR("src/archivos/graph05/var.txt");
//
//        solucion = greedy.greedy(matrizDOM, vectorVAR,matrizCTR);
//        mostrar.MostrarSolucion(solucion);
//        System.out.println(util.calcularCoste(solucion, matrizCTR));
//        solucion = bl.busquedaLocal(matrizCTR, matrizDOM, vectorVAR, solucion);
//        mostrar.MostrarSolucion(solucion);
//        System.out.println(util.calcularCoste(solucion, matrizCTR));
        //leerArrayList(solucion);
        //leerArrayListMatriz(matrizCTR);
        //int coste=calcularCoste(solucion,matrizCTR);
        //leerArrayList(generarVecino(matrizDOM, vectorVAR, solucion));
        //leerSolucion(solucion);
        //leerSolucion(generarVecino(matrizDOM, vectorVAR, solucion));
    }
}
