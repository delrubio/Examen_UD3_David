package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Examen {
    public static void ej_examen() {
        Scanner teclado = new Scanner(System.in);
        Random random = new Random();

        boolean bucle = true;

        int carton[][] = new int[3][3];
        int convesion = 0;
        int premio = 0;
        int cont_linea = 0;
        int linea = 100;

        while (bucle) {
            System.out.println("*** Introduce los datos de tu cartón ***");

            for (int i = 0; i < carton.length; i++) {
                System.out.println("Introduce los datos de la fila " + i);
                String numeros = teclado.next();
                if (!numeros.matches("\\d{1,2}-\\d{1,2}-\\d{1,2}")){
                    continue;
                }
                String[] string_bolas = numeros.split("[-]");
                for (int j = 0; j < carton[i].length; j++) {
                    carton[i][j] = Integer.parseInt(string_bolas[convesion]);
                    convesion++;
                }
                convesion = 0;
            }
            bucle = false;
            //            for (int[] vector : carton){
//                int[] carton_rep = Arrays.stream(vector).distinct().toArray();
//                if (carton_rep.length == 8){
//                    bucle = false;
//                }else {
//                    bucle = true;
//                }
//            }
        }

        System.out.println("Datos del Cartón:");

        for (int[] vector : carton) {
            for (int vector2 : vector) {
                System.out.print(vector2 + " ");
            }
            System.out.println(" ");
        }

        int random_bolas = random.nextInt(40) + 10;
        int[] bolas_jugadas = new int[random_bolas];

        for (int i = 0; i < bolas_jugadas.length; i++) {
            bolas_jugadas[i] = random.nextInt(90) + 1;
        }

        int bolas_limpio[] = Arrays.stream(bolas_jugadas).distinct().toArray();

        System.out.println(random_bolas + " bolas jugadas hasta ahora: " + Arrays.toString(bolas_limpio));

        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                linea = Arrays.binarySearch(bolas_limpio, carton[i][j]);
                if (linea != 100){
                    cont_linea++;
                }
            }
            linea = 100;
        }

//        for (int[] vector : carton) {
//            for (int i = 0; i < bolas_limpio.length; i++) {
//                for (int j = 0; j < vector.length; j++) {
//                    if (vector[j] == bolas_limpio[i]){
//                        premio ++;
//                    }
//                }
//            }
//        }

        if (cont_linea >= 1 && cont_linea < 3){
            System.out.println("LÍNEA" + cont_linea);
        } else if (cont_linea == 3) {
            System.out.println("BINGO");
        }else{
            System.out.println("Mala suerte!");
        }
    }
}
