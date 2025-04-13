package MergeSort;

import java.util.Arrays;

public class MainMergeSort {

    public static void clearScreen() throws Exception, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        clearScreen();
        int[] lista = { 44, 23, 67, 122, 32, 56, 98, 12, 43, 56 };

        mergeSort(lista);

        System.out.println("Array ordenado: " + Arrays.toString(lista));
    }

    public static void mergeSort(int[] lista) {
        int tamanho = lista.length;
        if (tamanho > 1) {
            int meio = tamanho / 2;

            int[] parte1 = Arrays.copyOfRange(lista, 0, meio);
            int[] parte2 = Arrays.copyOfRange(lista, meio, tamanho);

            mergeSort(parte1);
            mergeSort(parte2);

            merge(lista, parte1, parte2);
        }
    }

    public static void merge(int[] lista, int[] parte1, int[] parte2) {
        int i = 0, k = 0, j = 0;

        int tamanhoParte1 = parte1.length;
        int tamanhoParte2 = parte2.length;

        while (i < tamanhoParte1 && j < tamanhoParte2) {
            if (parte1[i] <= parte2[j]) {
                lista[k++] = parte1[i++];
            } else {
                lista[k++] = parte2[j++];
            }

            while (i < tamanhoParte1) {
                lista[k++] = parte1[i++];
            }

            while (j < tamanhoParte2) {
                lista[k++] = parte2[j++];
            }
        }
    }
}