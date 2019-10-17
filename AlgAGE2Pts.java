/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import javafx.util.Pair;

/**
 *
 * @author carol
 */
public class AlgAGE2Pts {

    Random rand;
    Integer semilla;
    public AlgAGE2Pts(int s) {
        rand = new Random(s);
        semilla = s;
    }

    public ArrayList<Integer> AGE(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var,
            ArrayList<ArrayList<Integer>> ctr, HashMap<Integer, Integer> hashVar) {
        //Generar P_actual greedy
        ArrayList<ArrayList<Integer>> p_actual = new ArrayList<>();
        ArrayList<Integer> cromosoma = new ArrayList<>();
        AlgGreedySimple gS = new AlgGreedySimple(semilla);
        Utils utils = new Utils();
        Pair<ArrayList<Integer>, ArrayList<Integer>> p;
        ArrayList<Integer> mejor_sol = new ArrayList<>();
        int coste_mejor_sol = 999999;
        int coste = 0, primer_coste_mejor = 0;
        HashMap<Integer, Integer> costes_p_actual = new HashMap<>();
        int evaluaciones = 0;

        for (int i = 0; i < 50; ++i) {
            cromosoma = gS.greedy(dom, var, ctr, hashVar);
            p_actual.add(i, cromosoma);
            coste = utils.calcularCosteGS(cromosoma, ctr, hashVar);
            costes_p_actual.put(i, coste);
            //COMPRUEBO SI ES LA MEJOR SOLUCION
            if (coste < coste_mejor_sol) {
                for (int x = 0; x < cromosoma.size(); ++x) {
                    mejor_sol.add(cromosoma.get(x));
                }
//                System.out.println("mejor_sol " + mejor_sol.toString());
                coste_mejor_sol = coste;
            }
        }

        int i1, i2, i3, i4;
        int c1, c2, c3, c4;
        while (evaluaciones < 50) {
            evaluaciones++;

            ArrayList<Integer> ind = new ArrayList<>();
            ArrayList<Integer> ind2 = new ArrayList<>();
            ArrayList<Integer> hijo = new ArrayList<>();
            ArrayList<Integer> hijo2 = new ArrayList<>();
            //Seleccion de los cromosomas más prometedores entre dos parejas aleatorias
            i1 = rand.nextInt(50);
            i2 = rand.nextInt(50);
            while (i1 == i2) {
                i2 = rand.nextInt(50);
            }
            i3 = rand.nextInt(50);
            while (i3 == i1 || i3 == i2) {
                i3 = rand.nextInt(50);
            }
            i4 = rand.nextInt(50);
            while (i4 == i1 || i4 == i1 || i4 == i3) {
                i4 = rand.nextInt(50);
            }
            c1 = costes_p_actual.get(i1);
            c2 = costes_p_actual.get(i2);
            c3 = costes_p_actual.get(i3);
            c4 = costes_p_actual.get(i4);
            //Selección de los dos mejores
            ind = (c1 < c2) ? p_actual.get(i1) : p_actual.get(i2);
            ind2 = (c3 < c4) ? p_actual.get(i3) : p_actual.get(i4);
//            System.out.println("Entra en cruce");
            //CRUCE 2 pts
            p = utils.cruce2Puntos(ind, ind2);
            hijo = p.getKey();
            hijo2 = p.getValue();
            //LA MUTACION IGUAL A LA ESPERANZA MATEMATICA DE MUTACION
//            System.out.println("Entra en mutacion");
            int numInd = rand.nextInt(p_actual.size() / 2);
            int numGenesMutar = (int) (p_actual.size() * 0.1);
            int pos = 0, f = 0, frec_ele = 0;
            int frec = 0, rangFrec = 0;

            for (int i = 1; i <= numGenesMutar; ++i) {
                //HIJO
//                System.out.println("i "+i+" tam p_Actual "+p_actual.size());
                pos = rand.nextInt(hashVar.size());
//                System.out.println("pos "+pos+" tam hashvar "+hashVar.size());
                rangFrec = var.get(hashVar.get(pos + 1) - 1).get(1);
                f = dom.get(rangFrec - 1).size();
                frec_ele = rand.nextInt(f);
                hijo.set(pos, frec_ele);

                //HIJO2
                pos = rand.nextInt(hashVar.size());
                rangFrec = var.get(hashVar.get(pos + 1) - 1).get(1);
                f = dom.get(rangFrec - 1).size();
                frec_ele = rand.nextInt(f);
                hijo2.set(pos, frec_ele);
            }
            //CALCULAMOS COSTE DE LOS HIJOS

            //Reemplazamiento (los dos hijos compiten por entrar en P t
//            System.out.println("Entra en reemplazamiento");
            int coste_hijo = utils.calcularCosteGS(hijo, ctr, hashVar);
            int coste_hijo2 = utils.calcularCosteGS(hijo, ctr, hashVar);
            int peor1 = Collections.max(costes_p_actual.entrySet(), Comparator.comparingInt(HashMap.Entry::getValue)).getKey();
            pos = costes_p_actual.get(peor1);
            if (peor1 > coste_hijo) {
//                System.out.println("pos "+pos+" p_actual "+p_actual.size()+" peor1 "+peor1);
                p_actual.set(pos, hijo);
            } else if (peor1 > coste_hijo2) {
                p_actual.set(pos, hijo2);
            }
            int peor = 0;
            int pos_peor = 0;
            for (int i = 0; i < costes_p_actual.size(); ++i) {
                if (costes_p_actual.get(i) > peor && costes_p_actual.get(i) != peor1) {
                    peor = costes_p_actual.get(i);
                    pos_peor = i;
                }
            }

            if (peor > coste_hijo) {
                p_actual.set(pos_peor, hijo);
            } else if (peor > coste_hijo2) {
                p_actual.set(pos_peor, hijo2);
            }
//            System.out.println("Sale de reemplazar las 2 peores soluciones");
            for (int i = 0; i < costes_p_actual.size(); ++i) {
                if (costes_p_actual.get(i) < coste_mejor_sol) {
                    coste_mejor_sol = costes_p_actual.get(i);
                    mejor_sol = p_actual.get(i);
                }
            }
            if (poblacionConverge(p_actual)) {
//                System.out.println("Entra en reinicializacion");
//                System.out.println("Entra reinicializar ");
                p_actual.set(0, mejor_sol);
                for (int i = 1; i < p_actual.size(); ++i) {
                    cromosoma = gS.greedy(dom, var, ctr, hashVar);
                    p_actual.set(i, cromosoma);
                    coste = utils.calcularCosteGS(cromosoma, ctr, hashVar);
                    costes_p_actual.put(i, coste);
                }
            }
//            System.out.println("Evaluacion numero" + evaluaciones);
        }
        System.out.println("Numero evaluaciones" + evaluaciones);
        System.out.println("Solucion " + mejor_sol.toString());
        System.out.println("Coste solucion " + coste_mejor_sol);
        return mejor_sol;
    }

    public boolean poblacionConverge(ArrayList<ArrayList<Integer>> p) {
        boolean converge = false;
        converge = p.stream().distinct().limit(2).count() <= (long) (p.size() * 0.8);
        return converge;
    }
}
