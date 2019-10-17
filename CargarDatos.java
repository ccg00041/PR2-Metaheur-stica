/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author carol
 */
public class CargarDatos {
    ArrayList<ArrayList<Integer>> var;
    ArrayList<ArrayList<Integer>> dom;
    ArrayList<ArrayList<Integer>> ctr;
    
    public CargarDatos(){
        
    }
    /**
     * Introduce los datos del fichero en la matriz var que contiene:
     *  
     * TRX [1,n] y rangoFrec estan en el array fila
     *     var   fila
     *      0 -> TRX | rangoFrec
     *      1 -> TRX | rangoFrec
     * @param fichero
     * @exception FileNotFoundException
     * @return vector
     */
    public ArrayList<ArrayList<Integer>> cargarVAR(String fichero) throws FileNotFoundException {
        Scanner leer = new Scanner(new FileReader(fichero));
        var = new ArrayList<>();
        ArrayList<Integer> fila;
        int trx, rangoFrec;
        do {
            fila = new ArrayList<>();
            trx = leer.nextInt();
            rangoFrec = leer.nextInt();
            leer.nextLine();
            //System.out.println(elem);
            fila.add(trx);
            fila.add(rangoFrec);
            var.add(fila);
        } while (leer.hasNext());
        
        return var;
    }
    /**
     * Introduce los datos de la matrizVAR en la tabla hash para evitar excepcion de fuera de rango en los ficheros scen
     * key = TRX y value = rango es [1,size] 
     * @param var
     * @exception FileNotFoundException
     * @return vector
     */
    public HashMap<Integer,Integer> cargarVARHash(ArrayList<ArrayList<Integer>> var) throws FileNotFoundException {
        HashMap<Integer,Integer> var_hash = new HashMap<>();
//        System.out.println("HashMap clave,valor  ");
        for(int i = 0; i < var.size(); ++i){
            var_hash.put(var.get(i).get(0), i+1);
//            System.out.print("( "+var_hash.get(var.get(i).get(0))+", "+i+") ");
        }
//        System.out.println("tam HashMap "+var_hash.size());
        
        return var_hash;
    }
    /**
     * Introduce los datos del fichero dom.txt en la matrizDOM
     * El rango de frecuencia se introduce de 0 a numeroMAXRango
     *  dom(RangoFrec) listado Frecuencias
     *   0 (RF=1) ->   frecuencias
     *   1 (RF=2) ->   frecuencias
     *   2 (RF=3) ->   frecuencias
     * @param fichero
     * @exception FileNotFoundException
     * @return matriz
     */
    public ArrayList<ArrayList<Integer>> cargarDOM(String fichero) throws FileNotFoundException {
        Scanner leer = new Scanner(new FileReader(fichero));
        dom = new ArrayList<>();
        ArrayList<Integer> listadoFrec;
        Integer num;
        String lineaActual;
        do {
            leer.nextInt();
            lineaActual = leer.nextLine();
            Scanner leerLinea = new Scanner(lineaActual);
            listadoFrec = new ArrayList<>();
            do {
                num = leerLinea.nextInt();
                listadoFrec.add(num);
            } while (leerLinea.hasNext());
            dom.add(listadoFrec);
        } while (leer.hasNext());
        return dom;
    }

    /**
     * 
     * Introduce los datos del fichero ctr.txt en la matrizCTR
     *  ctr      fila (TRX1, TRX2, dif-frec, interf)
     *  0   ->      1,3,300,3 
     *  1   ->      1,4,157,2
     *  2   ->      2,3,100,1
     *  
     * @param fichero
     * @exception FileNotFoundException
     * @return matriz
     */
    public ArrayList<ArrayList<Integer>> cargarCTR(String fichero) throws FileNotFoundException {
        //Conversion a string
        Scanner leer = new Scanner(new FileReader(fichero));
        ArrayList<String> ctrString;
        ctrString = new ArrayList<>();
        do {
            String elem = leer.next();
            ctrString.add(elem);
        } while (leer.hasNext());
        
        //Carga de datos en ctr
//        System.out.println("El tam de ctrstring es "+ ctrString.size());
        ArrayList<Integer> fila;
        ctr = new ArrayList<>();
        int num;
        
        for (int i = 0; i < ctrString.size(); i += 6) {
            fila = new ArrayList<>();
//            System.out.println("la ultima posicion es trx "+ctrString.get(i)+" letra " + ctrString.get(i+2));
            if (!ctrString.get(i + 2).equals("D")) {
                num = Integer.parseInt(ctrString.get(i));
                fila.add(num);
                num = Integer.parseInt(ctrString.get(i + 1));
                fila.add(num);
                num = Integer.parseInt(ctrString.get(i + 4));
                fila.add(num);
                num = Integer.parseInt(ctrString.get(i + 5));
                fila.add(num);
                ctr.add(fila);
            }
        }

        return ctr;
    }
    
    /**PARA FACTORIZACION
     * Introduce los datos del fichero ctr.txt en la matrizCTR
     *  ctr      fila (TRX1, TRX2, dif-frec, interf)
     *          0   1   2   3
     *  0   ->  0   0 (300,3) 0 
     *  1   ->  0   0   0 (157,2)
     *  2   ->  0   0   0 (100,1)
     *  3   ->  0   0   0   0
     * @param fichero
     * @exception FileNotFoundException
     * @return matriz
     */
//    public ArrayList<ArrayList<Pair>> cargarCTRNuevo(String fichero) throws FileNotFoundException {
//        //Conversion a string
//        Scanner leer = new Scanner(new FileReader(fichero));
//        ArrayList<String> ctrString;
//        ctrString = new ArrayList<>();
//        do {
//            String elem = leer.next();
//            ctrString.add(elem);
//        } while (leer.hasNext());
//        
//        //Carga de datos en ctr
////        System.out.println("El tam de ctrstring es "+ ctrString.size());
//        ArrayList<Pair> fila;
//        ctr = new ArrayList<>(Collections.nCopies(ctrString.size()/6, null));
//        fila = new ArrayList<>(Collections.nCopies(ctrString.size()/6, null));
//        int trx1,trx2,dif,inter;
//        
//        for (int i = 0; i < ctrString.size(); i += 6) {
//            
////            System.out.println("la ultima posicion es trx "+ctrString.get(i)+" letra " + ctrString.get(i+2));
//            if (!ctrString.get(i + 2).equals("D")) {
//                
//                trx1 = Integer.parseInt(ctrString.get(i))-1; //para que empiece desde 0 hasta tam-1
//                trx2 = Integer.parseInt(ctrString.get(i + 1))-1;//para que empiece desde 0 hasta tam-1
//                dif = Integer.parseInt(ctrString.get(i + 4));
//                inter = Integer.parseInt(ctrString.get(i + 5));
//                Pair<Integer,Integer> p = new Pair(dif,inter);
//                System.out.println("trx2 "+trx2);
//                fila.add(trx2, p);
//                System.out.println("fila "+fila.get(trx2));
//                ctr.add(trx1,fila);
////                fila = new ArrayList<>(Collections.nCopies(ctrString.size()/6, null));
//                System.out.println("ctr "+ctr.get(trx1));
//            }
//        }
//
//        return ctr;
//    }
}
