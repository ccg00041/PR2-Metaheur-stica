/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr1meta;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import static pr1meta.Menu.Algoritmo.BL;
import static pr1meta.Menu.Algoritmo.BT;
import static pr1meta.Menu.Algoritmo.GRASP;

/**
 *
 * @author carol
 */
public class Menu {

    public Random rand;

    public enum Algoritmo {
        GT, BL, BT, GRASP, GSG, AGG2P, AGGBLX, AGE2P, AGEBLX, AM1, AM2, AM3 //Añadir los que faltan
    }

    String ctr, dom, var;
    Integer semilla;
    Algoritmo algoritmo;
    ArrayList<Integer> solucion;
//    ArrayList<ArrayList<Pair>> m_ctr;
    ArrayList<ArrayList<Integer>> m_ctr;
    ArrayList<ArrayList<Integer>> m_dom;
    ArrayList<ArrayList<Integer>> v_var;
    HashMap<Integer, Integer> hashScen;
    Long tiempo;

    public Menu() {
        rand = new Random();
        solucion = new ArrayList<>();
        m_ctr = new ArrayList<>();
        m_dom = new ArrayList<>();
        v_var = new ArrayList<>();
    }

    public void mainMenu() throws FileNotFoundException {
        while (true) {

            int option;
            System.out.println("MENU PRINCIPAL");
            System.out.print("\n");
            System.out.println("0. Seleccion de semilla");
            System.out.println("1.  Seleccion del archivo ");
            System.out.println("2.  Seleccion del algoritmo ");
            //System.out.println("3.  Seleccion del numero de iteraciones ");
            System.out.println("3.  Resolver el problema");
            System.out.println("4.  Resolver problema con todos los archivos");
            System.out.print("\n");
            System.out.print("Introduzca un numero (-1 para salir): ");
            option = getEntradaDatos();

            try {
                limpiarConsola();
            } catch (InterruptedException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

            switch (option) {
                case 0:
                    seleccionSemilla();
                    break;
                case 1:
                    seleccionarArchivo();
                    break;
                case 2:
                    seleccionAlgoritmo();
                    break;
                case 3:
                    resolucionProblema();
                    break;
                case 4:
                    resolucionProblemaTodosArchivos();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public void seleccionSemilla() {
        int opcion;
        System.out.println("SELECCION DE ARCHIVO");
        System.out.print("\n");
        System.out.println("1.  77376004");
        System.out.println("2.  37600477");
        System.out.println("3.  40037776");
        System.out.println("4.  76407370");
        System.out.println("5.  60047737");
        System.out.println("6.  77370064");
        System.out.println("7.  30476077");
        System.out.println("8.  47600377");
        System.out.println("9.  37764070");
        System.out.println("10.  64773700");
        System.out.print("\n");
        System.out.print("Introduzca un numero (-1 para cancelar): ");
        opcion = getEntradaDatos();
        switch (opcion) {
            case 1:
                semilla = 77376004;
                break;
            case 2:
                semilla = 37600477;
                break;
            case 3:
                semilla = 40037776;
                break;
            case 4:
                semilla = 76407370;
                break;
            case 5:
                semilla = 60047737;
                break;
            case 6:
                semilla = 77370064;
                break;
            case 7:
                semilla = 30476077;
                break;
            case 8:
                semilla = 47600377;
                break;
            case 9:
                semilla = 37764070;
                break;
            case 10:
                semilla = 64773700;
                break;
            default:
                semilla = 77376004;
        }
    }

    public void seleccionarArchivo() {
        int opcion;
        System.out.println("SELECCION DE ARCHIVO");
        System.out.print("\n");
        System.out.println("0. Ejemplo");
        System.out.println("1.  graph05");
        System.out.println("2.  graph06");
        System.out.println("3.  graph07");
        System.out.println("4.  graph11");
        System.out.println("5.  graph12");
        System.out.println("6.  graph13");
        System.out.println("7.  scen06");
        System.out.println("8.  scen07");
        System.out.println("9.  scen08");
        System.out.println("10. scen09");
        System.out.println("11. scen10");
        System.out.print("\n");
        System.out.print("Introduzca un numero (-1 para cancelar): ");
        opcion = getEntradaDatos();
        switch (opcion) {
            case 0:
                ctr = "src/archivos/Ejemplo/ctr.txt";
                dom = "src/archivos/Ejemplo/dom.txt";
                var = "src/archivos/Ejemplo/var.txt";
                System.err.println("asigna a cada string su fichero " + ctr);
                break;
            case 1:
                ctr = "src/archivos/graph05/ctr.txt";
                dom = "src/archivos/graph05/dom.txt";
                var = "src/archivos/graph05/var.txt";
                System.err.println("asigna a cada string su fichero " + ctr);
                break;
            case 2:
                ctr = "src/archivos/graph06/ctr.txt";
                dom = "src/archivos/graph06/dom.txt";
                var = "src/archivos/graph06/var.txt";
                break;
            case 3:
                ctr = "src/archivos/graph07/ctr.txt";
                dom = "src/archivos/graph07/dom.txt";
                var = "src/archivos/graph07/var.txt";
                break;
            case 4:
                ctr = "src/archivos/graph11/ctr.txt";
                dom = "src/archivos/graph11/dom.txt";
                var = "src/archivos/graph11/var.txt";
                break;
            case 5:
                ctr = "src/archivos/graph12/ctr.txt";
                dom = "src/archivos/graph12/dom.txt";
                var = "src/archivos/graph12/var.txt";
                break;
            case 6:
                ctr = "src/archivos/graph13/ctr.txt";
                dom = "src/archivos/graph13/dom.txt";
                var = "src/archivos/graph13/var.txt";
                break;
            case 7:
                ctr = "src/archivos/scen06/ctr.txt";
                dom = "src/archivos/scen06/dom.txt";
                var = "src/archivos/scen06/var.txt";
                break;
            case 8:
                ctr = "src/archivos/scen07/ctr.txt";
                dom = "src/archivos/scen07/dom.txt";
                var = "src/archivos/scen07/var.txt";
                break;
            case 9:
                ctr = "src/archivos/scen08/ctr.txt";
                dom = "src/archivos/scen08/dom.txt";
                var = "src/archivos/scen08/var.txt";
                break;
            case 10:
                ctr = "src/archivos/scen09/ctr.txt";
                dom = "src/archivos/scen09/dom.txt";
                var = "src/archivos/scen09/var.txt";
                break;
            case 11:
                ctr = "src/archivos/scen10/ctr.txt";
                dom = "src/archivos/scen10/dom.txt";
                var = "src/archivos/scen10/var.txt";
                break;
            default:
                return;
        }
    }

    public void seleccionAlgoritmo() {
        int opcion;
        System.out.println("SELECCION DE ALGORITMO");
        System.out.print("\n");
//        System.out.println("1.  Greedy");
//        System.out.println("2.  Busqueda Local");
//        System.out.println("3.  BT");
//        System.out.println("4.  GRASP");
//        System.out.println("5.  GreedySimple (geneticos)");
//        System.out.println("6.  AGG + cruce 2 puntos");
//        System.out.println("7.  AGG + cruce BLX");
//        System.out.println("8.  AGE + cruce 2 puntos");
//        System.out.println("9.  AGE + cruce BLX");
        System.out.println("10. AM1");
        System.out.println("11. AM2");
        System.out.println("12. AM3");
        System.out.print("Introduzca un numero (-1 para cancelar): ");
        opcion = getEntradaDatos();

        try {
            limpiarConsola();
        } catch (InterruptedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (opcion) {
            case 1:
//                algoritmo = Algoritmo.GT;
//                System.out.println("Asigna el greedy");
//                break;
//            case 2:
//                algoritmo = Algoritmo.BL;
//                break;
//            case 3:
//                algoritmo = Algoritmo.BT;
//                break;
//            case 4:
//                algoritmo = Algoritmo.GRASP;
//                break;
//            case 5:
//                algoritmo = Algoritmo.GSG;
//                break;
//            case 6:
//                algoritmo = Algoritmo.AGG2P;
//                break;
//            case 7:
//                algoritmo = Algoritmo.AGGBLX;
//                break;
//            case 8:
//                algoritmo = Algoritmo.AGE2P;
//                break;
//            case 9:
//                algoritmo = Algoritmo.AGEBLX;
//                break;
            case 10:
                algoritmo = Algoritmo.AM1;
                break;
            case 11:
                algoritmo = Algoritmo.AM2;
                break;
            case 12:
                algoritmo = Algoritmo.AM3;
                break;
            default:
                return;
        }
    }

    public static void limpiarConsola() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print("\n");
        }
    }

    public static int getEntradaDatos() {
        Scanner reader = new Scanner(System.in);
        if (reader.hasNextInt()) {
            return reader.nextInt();
        }
        return -1;
    }

    public void resolucionProblema() throws FileNotFoundException {
//        System.out.println("Entra en resolucion problema");
        ArrayList<Integer> sol_actual = new ArrayList<>();
        CargarDatos cargarD = new CargarDatos();

        m_ctr = cargarD.cargarCTR(ctr);
        m_dom = cargarD.cargarDOM(dom);
        v_var = cargarD.cargarVAR(var);
        hashScen = cargarD.cargarVARHash(v_var);

        long tiempoInicial = System.currentTimeMillis();
        switch (algoritmo) {
            case GT:
                AlgGreedy alggreedy = new AlgGreedy();
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
//                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla);
                break;
            case BL:
                AlgBL algbl = new AlgBL();
                AlgGreedy greedy = new AlgGreedy();
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
//                System.out.println("La solución de greedy es: ");
//                for(int i = 0; i < solucion.size();++i){
//                    System.out.print(solucion.get(i)+" ");
//                }
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                break;
            case BT:
                AlgBT algbt = new AlgBT();
                AlgGreedy greedyBT = new AlgGreedy();
                solucion = greedyBT.greedy(m_dom, v_var, m_ctr, semilla, hashScen); //Solucion inicial greedy
                sol_actual = algbt.busquedaTabu(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                break;
            case GRASP:
                break;
            case GSG:
                AlgGreedySimple greedyS = new AlgGreedySimple(semilla);
                solucion = greedyS.greedy(m_dom, v_var, m_ctr, hashScen);
                break;
            case AGG2P:
                AlgAGG2Pts agg = new AlgAGG2Pts(semilla);
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                break;
            case AGGBLX:
                AlgAGGBLX aggb = new AlgAGGBLX(semilla);
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                break;
            case AGE2P:
                AlgAGE2Pts age = new AlgAGE2Pts(semilla);
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                break;
            case AGEBLX:
                AlgAGEBLX ageb = new AlgAGEBLX(semilla);
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                break;
            case AM1:
                AlgMemetico agam1 = new AlgMemetico(semilla);
                solucion = agam1.AM1(m_dom, v_var, m_ctr, hashScen);
                break;
            case AM2:
                AlgMemetico agam2 = new AlgMemetico(semilla);
                solucion = agam2.AM2(m_dom, v_var, m_ctr, hashScen);
                break;
            case AM3:
                AlgMemetico agam3 = new AlgMemetico(semilla);
                solucion = agam3.AM3(m_dom, v_var, m_ctr, hashScen);
                break;
            default:
                break;
        }
//        System.out.println("Termina de ejecutar eleccion de algoritmo");
        long tiempoFinal = System.currentTimeMillis();
        MostrarDatos mostrar = new MostrarDatos();
//        mostrar.MostrarSolucion(sol_actual);
        tiempo = tiempoFinal - tiempoInicial;
        mostrar.mostrarTiempo(tiempo);
    }

    public void resolucionProblemaTodosArchivos() throws FileNotFoundException {
//        System.out.println("Entra en resolucion problema");
        ArrayList<Integer> sol_actual = new ArrayList<>();
        MostrarDatos mostrar = new MostrarDatos();
        long tiempoInicial;
        long tiempoFinal;
        switch (algoritmo) {
            case GT:
                AlgGreedy alggreedy = new AlgGreedy();
                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen06");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen06");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen07");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen07");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen08");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen08");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen09");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen09");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen10");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen10");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph11");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
//                sol_actual = alggreedy.greedy(m_dom, v_var, m_ctr, semilla);
                break;
            case BL:
                tiempoInicial = System.currentTimeMillis();
                AlgBL algbl = new AlgBL();
                AlgGreedy greedy = new AlgGreedy();

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen06");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen07");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen08");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen08");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen09");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen09");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("scen10");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "scen10");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph11");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = greedy.greedy(m_dom, v_var, m_ctr, semilla, hashScen);
                sol_actual = algbl.busquedaLocal(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");
                break;
            case BT:
                AlgBT algbt = new AlgBT();
                AlgGreedy greedyBT = new AlgGreedy();
                solucion = greedyBT.greedy(m_dom, v_var, m_ctr, semilla, hashScen); //Solucion inicial greedy
                sol_actual = algbt.busquedaTabu(m_ctr, m_dom, v_var, hashScen, solucion, semilla);
                break;
            case GRASP:
                break;
            case GSG:
                AlgGreedySimple greedyS = new AlgGreedySimple(semilla);
                solucion = greedyS.greedy(m_dom, v_var, m_ctr, hashScen);
                break;
            case AGG2P:
                AlgAGG2Pts agg = new AlgAGG2Pts(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph011");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = agg.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");

                break;
            case AGGBLX:
                AlgAGGBLX aggb = new AlgAGGBLX(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph011");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = aggb.AGG(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");

                break;
            case AGE2P:
                AlgAGE2Pts age = new AlgAGE2Pts(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph011");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = age.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");

                break;
            case AGEBLX:
                AlgAGEBLX ageb = new AlgAGEBLX(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph011");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = ageb.AGE(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");

                break;
            case AM1:
                AlgMemetico aggm = new AlgMemetico(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph11");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = aggm.AM1(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");
                break;
            case AM2:
                AlgMemetico aggm2 = new AlgMemetico(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph11");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = aggm2.AM2(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");
                break;
            case AM3:
                AlgMemetico aggm3 = new AlgMemetico(semilla);

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph05");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph05");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph06");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph06");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph07");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph07");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph11");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph11");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph12");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph12");
                System.out.println("");

                tiempoInicial = System.currentTimeMillis();
                EjecutarFichero("graph13");
                solucion = aggm3.AM3(m_dom, v_var, m_ctr, hashScen);
                tiempoFinal = System.currentTimeMillis();
                tiempo = tiempoFinal - tiempoInicial;
                mostrar.mostrarTiempoFichero(tiempo, "graph13");
                System.out.println("");
                break;
            default:
                break;
        }
//        System.out.println("Termina de ejecutar eleccion de algoritmo");
//        long tiempoFinal = System.currentTimeMillis();

//        mostrar.MostrarSolucion(sol_actual);
    }

    public void EjecutarFichero(String fichero) throws FileNotFoundException {
        CargarDatos cargarD = new CargarDatos();
        long tiempoInicial = System.currentTimeMillis();
        switch (fichero) {
            case "scen06":
                ctr = "src/archivos/scen06/ctr.txt";
                dom = "src/archivos/scen06/dom.txt";
                var = "src/archivos/scen06/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero scen06: ");
                break;
            case "scen07":
                ctr = "src/archivos/scen07/ctr.txt";
                dom = "src/archivos/scen07/dom.txt";
                var = "src/archivos/scen07/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero scen07: ");
                break;
            case "scen08":
                ctr = "src/archivos/scen08/ctr.txt";
                dom = "src/archivos/scen08/dom.txt";
                var = "src/archivos/scen08/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero scen08: ");
                break;
            case "scen09":
                ctr = "src/archivos/scen09/ctr.txt";
                dom = "src/archivos/scen09/dom.txt";
                var = "src/archivos/scen09/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero scen09: ");
                break;
            case "scen10":
                ctr = "src/archivos/scen10/ctr.txt";
                dom = "src/archivos/scen10/dom.txt";
                var = "src/archivos/scen10/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero scen10: ");
                break;
            case "graph05":
                ctr = "src/archivos/graph05/ctr.txt";
                dom = "src/archivos/graph05/dom.txt";
                var = "src/archivos/graph05/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph05: ");
                break;
            case "graph06":
                ctr = "src/archivos/graph06/ctr.txt";
                dom = "src/archivos/graph06/dom.txt";
                var = "src/archivos/graph06/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph06: ");
                break;
            case "graph07":
                ctr = "src/archivos/graph07/ctr.txt";
                dom = "src/archivos/graph07/dom.txt";
                var = "src/archivos/graph07/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph07: ");
                break;
            case "graph11":
                ctr = "src/archivos/graph11/ctr.txt";
                dom = "src/archivos/graph11/dom.txt";
                var = "src/archivos/graph11/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph11: ");
                break;
            case "graph12":
                ctr = "src/archivos/graph12/ctr.txt";
                dom = "src/archivos/graph12/dom.txt";
                var = "src/archivos/graph12/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph12: ");
                break;
            case "graph13":
                ctr = "src/archivos/graph13/ctr.txt";
                dom = "src/archivos/graph13/dom.txt";
                var = "src/archivos/graph13/var.txt";
                m_ctr = cargarD.cargarCTR(ctr);
                m_dom = cargarD.cargarDOM(dom);
                v_var = cargarD.cargarVAR(var);
                hashScen = cargarD.cargarVARHash(v_var);
                System.out.println("Fichero graph13: ");
                break;

        }
    }
}
