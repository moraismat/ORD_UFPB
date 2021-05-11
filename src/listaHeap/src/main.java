public class main {
    public static void main(String args[]) {

        // Criando a lista de tamanho 10
        Heap heap = new Heap(10);

       // Inserindo na lista os valores: 8, 10, 5, 7, 9, 12, 6
        heap.add(8);
        heap.add(10);
        heap.add(5);
        heap.add(7);
        heap.add(9);
        heap.add(12);
        heap.add(6);

        heap.imprimirLista();
       
    }
}
