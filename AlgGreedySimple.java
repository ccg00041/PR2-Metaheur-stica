/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import pr1meta.Menu;

/**
 * Algoritmo Greedy Simple para algoritmos genéticos
 *
 * @author carol
 */
public class AlgGreedySimple {

    Random rand;

    public AlgGreedySimple(int semilla) {
        rand = new Random(semilla);
    }

    /**
     * Algoritmo que genera una solución inicial: Escogiendo un TRX al azar y
     * una frecuencia al azar y completando el resto de la solución con una
     * frecuencia de menor coste Introduce los datos del fichero dom.txt en la
     * matrizDOM El rango de frecuencia se introduce de 0 a numeroMAXRango
     *
     * @param ctr
     * @param dom
     * @param semilla
     * @param var
     * @param hashVar
     * @return solucion
     */
    public ArrayList<Integer> greedy(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var,
            ArrayList<ArrayList<Integer>> ctr, HashMap<Integer, Integer> hashVar) {

        rand.nextInt();
//        System.out.println("hashvar GS "+hashVar.toString());
        ArrayList<Integer> solucion = new ArrayList<>(Collections.nCopies(hashVar.size(), -1));
        Utils utils = new Utils();
        MostrarDatos mostrar = new MostrarDatos();
        int tam_hashVar = hashVar.size();
        int pos_rfrec = 0;
        int cont = 1;
        int coste = 0, mejor_coste = 0;
        boolean encontrado;
        
        //Escojo un trx al azar
        int trx = rand.nextInt(tam_hashVar) + 1; // +1 para que trx [1,200] ya que en Var están introducidos asi
        pos_rfrec = hashVar.get(trx) - 1;
        //ESCOJO FRECUENCIA AL AZAR
        int rangoFrec = 0; //resto -1 para que acceda bien al rango que es de 0 a size-1
        int pos_frec = rand.nextInt(dom.get(rangoFrec).size());
        int frec = dom.get(rangoFrec).get(pos_frec);
        solucion.set(trx - 1, frec);
        

        //COMPLETO LA SOLUCION con frecuencias que añadan el mínimo coste posible a la solucion
        while (cont < tam_hashVar) { //recorro hashVar hasta que he completado solución
            trx++;
            if (trx == tam_hashVar + 1) {
                trx = 1;
            }
            rangoFrec = var.get(pos_rfrec).get(1) - 1;
            frec = dom.get(rangoFrec).get(0);
            solucion.set(trx - 1, frec);
//            System.out.println("trx " + trx + " var tam " + var.size()+ " ctr tam " + ctr.size());
            mejor_coste = utils.calcularCosteGS(solucion, ctr, hashVar);
//            System.out.println("Mejor coste "+mejor_coste);
            encontrado = false;
            for (int i = 1; i < dom.get(rangoFrec).size() && !encontrado; ++i) {
                frec = dom.get(rangoFrec).get(i);
                solucion.set(trx - 1, frec);
                coste = utils.calcularCosteGS(solucion, ctr, hashVar);
//                System.out.println("coste "+coste);
                if (mejor_coste > coste) {
                    mejor_coste = coste;
                    encontrado = true;
                }
            }
            solucion.set(trx - 1, frec);

            cont++;
        }
        return solucion;
    }

}
