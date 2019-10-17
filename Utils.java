/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author carol
 */
public class Utils {

    Random rand;

    public Utils() {
        Menu m = new Menu();
        rand = m.rand;
    }

//    public int calcularCoste(ArrayList<Integer> solucion, ArrayList<ArrayList<Integer>> matrizCTR,HashMap<Integer, Integer> hashVar) {
//        int coste = 0;
//        int trx1 = 0, trx2 = 0;
//        int diferencia_frec = 0;
//        for (int i = 0; i < matrizCTR.size(); ++i) {
////            System.out.println("i " + i);
//            trx1 = matrizCTR.get(i).get(0);
////            System.out.println("trx1 " + trx1);
//            trx2 = matrizCTR.get(i).get(1);
////            System.out.println("trx2 " + trx2);
//            diferencia_frec = matrizCTR.get(i).get(2);
//            
//            if (Math.abs(solucion.get(hashVar.get(trx1) - 1) - solucion.get(hashVar.get(trx2) - 1)) > diferencia_frec) {
////                System.out.println("frec1 "+solucion.get(trx1-1)+" frec2 "+solucion.get(trx2-1)+ " = "+Math.abs(solucion.get(trx1 - 1) - solucion.get(trx2 - 1)));
//                coste += matrizCTR.get(i).get(3);
//                // System.out.println("El coste se incrementa "+valor_coste+" total es "+coste);
////                }
//            }
//        }
//        return coste;
//    }
    /**
     * Función calcularCoste para archivos scen
     */
    public int calcularCoste(ArrayList<Integer> solucion, ArrayList<ArrayList<Integer>> matrizCTR, HashMap<Integer, Integer> hashVar) {
        int coste = 0;
        int trx1 = 0, trx2 = 0;
        int diferencia_frec = 0;
        for (int i = 0; i < matrizCTR.size(); ++i) {
//            System.out.println("i " + i);
            trx1 = hashVar.get(matrizCTR.get(i).get(0));
//            System.out.println("trx1 " + trx1);
            trx2 = hashVar.get(matrizCTR.get(i).get(1));
//            System.out.println("trx2 " + trx2);
            diferencia_frec = matrizCTR.get(i).get(2);
//            System.out.println("trx1 "+trx1 + " trx2 "+ trx2 + " i "+i+ " tam sol " + solucion.size());
            if (Math.abs(solucion.get(trx1 - 1) - solucion.get(trx2 - 1)) > diferencia_frec) {
//                System.out.println("frec1 "+solucion.get(trx1-1)+" frec2 "+solucion.get(trx2-1)+ " = "+Math.abs(solucion.get(trx1 - 1) - solucion.get(trx2 - 1)));
                coste += matrizCTR.get(i).get(3);
                // System.out.println("El coste se incrementa "+valor_coste+" total es "+coste);
//                }
            }
        }
        return coste;
    }

    /**
     * Función calcularCoste algoritmo GreedySimple Al estar inicializado con -1
     * la solución anterior solo se tienen en cuenta los archivos que tienen una
     * frecuencia positiva
     */
    public int calcularCosteGS(ArrayList<Integer> solucion, ArrayList<ArrayList<Integer>> matrizCTR, HashMap<Integer, Integer> hashVar) {
        int coste = 0;
        int trx1 = 0, trx2 = 0, pos_var1 = 0, pos_var2 = 0;
        int diferencia_frec = 0;
        int frec1 = 0, frec2 = 0;
        for (int i = 0; i < matrizCTR.size(); ++i) {
            pos_var1 = matrizCTR.get(i).get(0);
            pos_var2 = matrizCTR.get(i).get(1);
            trx1 = pos_var1;
            trx2 = pos_var2;
//            trx1 = hashVar.get(pos_var1);
//            trx2 = hashVar.get(pos_var2);

            if (trx1 > solucion.size() || trx2 > solucion.size()) {
//                trx1 = hashVar.get(pos_var1);
//                trx2 = hashVar.get(pos_var2);

            }

            diferencia_frec = matrizCTR.get(i).get(2);
            frec1=solucion.get(trx1 - 1);
            frec2 =solucion.get(trx2 - 1);
            if (frec1 != -1 && frec2 != -1) {
                if (Math.abs(frec1 - frec2) > diferencia_frec) {
//                System.out.println("frec1 "+solucion.get(trx1-1)+" frec2 "+solucion.get(trx2-1)+ " = "+Math.abs(solucion.get(trx1 - 1) - solucion.get(trx2 - 1)));
                    coste += matrizCTR.get(i).get(3);
                }
            }

        }
        return coste;
    }

    public Pair<ArrayList<Integer>, ArrayList<Integer>> cruce2Puntos(ArrayList<Integer> in, ArrayList<Integer> ind) {
        //Generar dos posiciones aleatorias desde p1 a p2
        ArrayList<Integer> aux = new ArrayList<>(in);
        int p1 = rand.nextInt(in.size());
        int p2 = rand.nextInt(in.size());
        while (p1 == p2 || p1 > ind.size() || p2 > ind.size()) {
            p1 = rand.nextInt(in.size());
            p2 = rand.nextInt(in.size());
        }
        //Intercambiar in y ind
        if (p1 > p2) {
            for (int i = p2; i < Math.abs(p2 - p1); ++i) {
                aux.set(i, in.get(i));
                in.set(i, ind.get(i - p2));
                ind.set(i, aux.get(i));
            }
        } else {
            for (int i = p1; i < Math.abs(p2 - p1); ++i) {
                aux.set(i, in.get(i));
//                System.out.println(" i "+i+" p2 "+p2+" in_tam "+in.size()+" ind tam "+ind.size()+ " aux "+aux.size());
                int dif = Math.abs(i - p2);
                if (dif == ind.size()) {
                    dif--;
                }
                in.set(i, ind.get(dif));
                ind.set(i, aux.get(i));
            }
        }

        Pair<ArrayList<Integer>, ArrayList<Integer>> p = new Pair(in, ind);
        return p;
    }

    public Pair<ArrayList<Integer>, ArrayList<Integer>> cruceBLX(ArrayList<Integer> in, ArrayList<Integer> ind,
            ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var, HashMap<Integer, Integer> hashVar) {
//        System.out.println("Entra de cruceBLX ");
        int n_frec1 = 0, n_frec2 = 0;
        int frec1, frec2, trx1, trx2;
        int I = 0;
        Boolean enc_frec1 = false;
        Boolean enc_frec2 = false;
        ArrayList<Integer> nuevo_in = new ArrayList<>(in);
        ArrayList<Integer> nuevo_ind = new ArrayList<>(ind);
        ArrayList<Integer> listadoFrec = new ArrayList<>();
        //crear dos invididuos cambiando la frecuencia de cada trx (frecuencia mas cercana)
        for (int i = 0; i < 200; ++i) {

            frec1 = rand.nextInt(in.size());
            frec2 = rand.nextInt(ind.size());
//            System.out.println("frec1 " + frec1 + "frec1 " + frec1);
            while (frec1 == frec2) {
//                System.out.println("WHILE frec1 " + frec1 + "frec1 " + frec1);
                frec1 = rand.nextInt(in.size());
                frec2 = rand.nextInt(ind.size());
            }
            I = Math.abs(frec1 - frec2);
//            System.out.println("I" + I);
            n_frec1 = rand.nextInt(I);
            n_frec2 = rand.nextInt(I);//DUDA QUE PASA SI I = 0
            //Buscar la frecuencia mas cercana a n_freci
//            System.out.println("in tam "+in.size()+" i "+i+ "tam hashvar "+ hashVar.size()+ "tam var" + var.size());
//            System.out.println("i "+i+ "tam hashvar "+ hashVar.size()+ "tam var" + var.size()+ "tam dom " + dom.get(hashVar.get(i)-1).size());
            for (int f = 0; f < dom.get(var.get(hashVar.get(i + 1) - 1).get(1)).size() - 1; ++f) {
//                System.out.println("i "+i+"f "+f+ "tam hashvar "+ hashVar.size()+ "tam var" + var.size()+ "tam dom " + dom.size());
                int d = dom.get(var.get(hashVar.get(i + 1) - 1).get(1)).get(f);
                listadoFrec.add(d);
            }
            frec1 = frecuenciaMasCercana(listadoFrec, n_frec1);
            frec2 = frecuenciaMasCercana(listadoFrec, n_frec2);
            nuevo_in.add(frec1);
            nuevo_ind.add(frec2);
        }
//        System.out.println("ind1 " + nuevo_in.size());
//        System.out.println("ind2 " + nuevo_ind.size());
        Pair p = new Pair(nuevo_in, nuevo_ind);
//        System.out.println("Sale de cruceBLX ");
        return p;
    }

    public static int frecuenciaMasCercana(ArrayList<Integer> v, int x) {

        int low = 0;
        int high = v.size() - 1;

//        if (high < 0) {
//            throw new IllegalArgumentException("The array cannot be empty");
//        }
        while (low < high) {
            int mid = (low + high) / 2;
            assert (mid < high);
            int d1 = Math.abs(v.get(mid) - x);
            int d2 = Math.abs(v.get(mid + 1) - x);
            if (d2 <= d1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return v.get(high);
    }
}
