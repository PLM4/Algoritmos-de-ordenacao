package BubbleSort;

public class MainBubbleSort {

    public static void clearScreen() throws Exception, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static void main(String[] args) throws Exception {
        clearScreen();

        int[] lista = { 42, 65, 12, 89, 1, 4, 2, 67, 90, 6, 34, 23, 64, 55 };

        printarLista(ordenarLista(lista));
    }

    public static void printarLista(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
    }

    public static int[] ordenarLista(int[] lista) {
        int tamanhoLista = lista.length;
        for (int i = 0; i < tamanhoLista - 1; i++) {
            for (int j = 0; j < tamanhoLista - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int aux = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = aux;
                }
            }
        }
        return lista;
    }
}
