package QuickSort;

public class MainQuickSort {

    public static void clearScreen() throws Exception, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        clearScreen();

        int[] lista = { 21, 43, 23, 53, 12, 33, 54, 321, 34, 64, 23, 45 };

        quickSort(lista, 0, lista.length - 1);

        printarLista(lista);
    }

    public static void printarLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.printf(lista[i] + " ");
        }
    }

    public static void quickSort(int[] lista, int inicio, int fim) {
        if (inicio < fim) {
            int pivoIndex = particionar(lista, inicio, fim);
            quickSort(lista, inicio, pivoIndex - 1);
            quickSort(lista, pivoIndex + 1, fim);
        }
    }

    private static int particionar(int[] lista, int inicio, int fim) {
        int meio = (inicio + fim) / 2;
        int pivo = lista[meio];
        int i = inicio - 1;
        int j = fim + 1;

        while (true) {
            do {
                i++;
            } while (lista[i] < pivo);

            do {
                j--;
            } while (lista[j] > pivo);

            if (i >= j) {
                return j;
            }

            int temp = lista[i];
            lista[i] = lista[j];
            lista[j] = temp;
        }
    }
}
