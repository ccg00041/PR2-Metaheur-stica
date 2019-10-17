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
public class AlgAGGBLX {
     Random rand;
     Integer semilla;
    public AlgAGGBLX(int s) {
        rand = new Random(s);
        semilla = s;
    }

    public ArrayList<Integer> AGG(ArrayList<ArrayList<Integer>> dom, ArrayList<ArrayList<Integer>> var,
            ArrayList<ArrayList<Integer>> ctr, HashMap<Integer, Integer> hashVar) {
        ArrayList<ArrayList<Integer>> p_actual = new ArrayList<>();

        ArrayList<Integer> cromosoma = new ArrayList<>();
        ArrayList<Integer> ind = new ArrayList<>();
        ArrayList<Integer> mejor_sol = new ArrayList<>();
        ArrayList<Integer> primer_mejor_sol = new ArrayList<>();
        int coste_mejor_sol = 999999;
        int coste = 0, primer_coste_mejor = 0;
        ArrayList<Integer> ind2 = new ArrayList<>();
        AlgGreedySimple gS = new AlgGreedySimple(semilla);
        Utils utils = new Utils();
        Pair<ArrayList<Integer>, ArrayList<Integer>> p;
        HashMap<Integer, Integer> costes_p_actual = new HashMap<>();

        //GENERO POBLACION CON GREEDY
        for (int i = 0; i < 50; ++i) {
            cromosoma = gS.greedy(dom, var, ctr, hashVar);
            p_actual.add(i, cromosoma);
            //Evaluar P(t) -> calcular coste de cada individuo de la poblacion inicializada 
            coste = utils.calcularCosteGS(cromosoma, ctr, hashVar);
            costes_p_actual.put(i, coste);
            //COMPRUEBO SI ES LA MEJOR SOLUCION
            if (coste < coste_mejor_sol) {
                for (int x = 0; x < cromosoma.size(); ++x) {
                    mejor_sol.add(cromosoma.get(x));
                }
                coste_mejor_sol = coste;
            }
        }
        //Mientras (evaluaciones menor 20000)

        int evaluaciones = 0;
        int reinicializar = 0;

        while (evaluaciones < 1000) {
            evaluaciones++;
            //REVISAR DESCENDIENTES
            ArrayList<ArrayList<Integer>> descendientes = new ArrayList<>();
            HashMap<Integer, Integer> costes_descendientes = new HashMap<>();
            int num_cruces = (int) ((p_actual.size() / 2) * 0.7);
            descendientes.addAll(p_actual);
//            System.out.println("descendientes ultimo "+descendientes.get(descendientes.size()-1).size());
            //seleccionar P' desde P(t-1) -> operador de cruce BLX
            //recombinar P'
            //Coger dos cromosomas de la poblacion y cruzarlos
            for (int i = 1; i <= num_cruces; i += 2) {
//                System.out.println("pactual "+p_actual.get(2).size()+ " i "+i);
                p = utils.cruceBLX(p_actual.get(i - 1), p_actual.get(i), dom, var, hashVar);
                //Añado a la poblacion los dos cromosomas cruzados
                descendientes.set(i - 1, p.getKey());
                descendientes.set(i, p.getValue());
            }
//            System.out.println("descendientes  "+descendientes.toString());
            //mutar p' 
            int numGenesMutar = (int) (descendientes.size() * 0.1);
            ArrayList<Integer> individuo;
            int num_ind,trx,rangFrec,f,frec_ele;
            costes_descendientes = costes_p_actual;
            for (int i = 0; i < numGenesMutar; ++i) {
                num_ind = rand.nextInt(descendientes.size());
                individuo = descendientes.get(num_ind);
                trx = rand.nextInt(hashVar.size() - 1) + 1;
                rangFrec = var.get(hashVar.get(trx) - 1).get(1);
                f = dom.get(rangFrec - 1).size();
                frec_ele = rand.nextInt(f);
                individuo.set(trx, dom.get(rangFrec - 1).get(frec_ele));
                descendientes.set(num_ind, individuo);
                coste = utils.calcularCosteGS(individuo, ctr, hashVar);
                costes_descendientes.put(i, coste);
                //COMPRUEBO SI ES LA MEJOR SOLUCION
                if (coste < coste_mejor_sol) {
                    for (int x = 0; x < cromosoma.size(); ++x) {
                        mejor_sol.set(x, individuo.get(x));
                    }
                    coste_mejor_sol = coste;
                }
            }
            //reemplazar P(t) a partir de P(t-1) y P'
            //evaluar P(t)

            for (int j = 0; j < costes_descendientes.size() - 1; ++j) {
//                System.out.println(" j " + j + " coste des tam " + costes_descendientes.size() + " tam p_actual " + costes_p_actual.size());
                if (costes_descendientes.get(j) < costes_p_actual.get(j)) {
                    p_actual.set(j, descendientes.get(j));
                    evaluaciones++;
                }
            }

//            System.out.println("Sale de evaluar ");
            //REINICIALIZACION
            if (reinicializar == 20 && poblacionConverge(p_actual)) {
                reinicializar = 0;
//                System.out.println("Entra reinicializar ");
                p_actual.set(0, mejor_sol);
                for (int i = 1; i < p_actual.size(); ++i) {
                    evaluaciones++;
                    cromosoma = gS.greedy(dom, var, ctr, hashVar);
                    p_actual.set(i, cromosoma);
                    //Evaluar P(t) -> calcular coste de cada individuo de la poblacion inicializada 
                    coste = utils.calcularCosteGS(cromosoma, ctr, hashVar);
                    costes_p_actual.put(i, coste);
                    //COMPRUEBO SI ES LA MEJOR SOLUCION
                    if (coste < coste_mejor_sol) {
                        for (int x = 0; x < cromosoma.size(); ++x) {
                            mejor_sol.set(x, cromosoma.get(x));
                        }
                        coste_mejor_sol = coste;
                    }
                }
            }
            reinicializar++;
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
