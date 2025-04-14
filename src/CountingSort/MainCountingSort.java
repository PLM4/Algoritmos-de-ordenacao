package CountingSort;

public class MainCountingSort {
    public static void main(String[] args) {
        int[] lista = { 32, 54, 13, 12, 4443, 546, 7534, 65, 34, 24, 67, 74, 34, };

        lista = coutingSort(lista);

        printarLista(lista);
    }

    public static void printarLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf(lista[i] + " ");
        }
    }

    public static int[] coutingSort(int[] lista) {
        int max = 0;
        for (int num : lista) {
            if (num > max) {
                max = num;
            }
        }

        int[] listaFrequencia = new int[max + 1];

        for (int i = 0; i < lista.length; i++) {
            listaFrequencia[lista[i]] += 1;
        }

        for (int i = 1; i < listaFrequencia.length; i++) {
            listaFrequencia[i] += listaFrequencia[i - 1];
        }

        int[] listaOrdenada = new int[lista.length];

        for (int i = lista.length - 1; i >= 0; i--) {
            listaOrdenada[listaFrequencia[lista[i] - 1]] = lista[i];
            listaFrequencia[lista[i] - 1] -= 1;
        }

        return listaOrdenada;
    }
}