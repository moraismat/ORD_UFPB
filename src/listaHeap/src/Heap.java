
public class Heap {
    private int[] heap;
    private int tail;

    public Heap(int tamanho){
        this.heap = new int[tamanho];
        this.tail = -1;
    }

    public Heap(int[] heap) {
        this.heap = heap;
        this.tail = this.heap.length - 1;
        this.buildHeap();
    }

    private void buildHeap() {
        for (int i = parent(this.tail); i >= 0; i--)
            heapify(i);
    }

    public Boolean isEmpty(){
        return this.tail == -1;
    }

    public int left(int index){
        return 2*index+1;
    }

    public int right(int index){
        return 2*(index+1);
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public void add(int n){
        if(this.tail >= (this.heap.length-1))
            throw new RuntimeException("Heap Cheio!");

        tail += 1;
        this.heap[tail] = n;
        int i = tail;

        while(i > 0 && this.heap[parent(i)] < this.heap[i]){
            int aux = this.heap[i];
            this.heap[i] = this.heap[parent(i)];
            this.heap[parent(i)] = aux;
            i = parent(i);
        }
    }

    public int remove(){
        if(isEmpty())
            throw new RuntimeException("Vazio!");

        int element = this.heap[0];
        this.heap[0] = this.heap[this.tail];
        this.tail = -1;

        this.heapify(0);

        return element;
    }

    public void heapify(int index){
        if (isLeaf(index) || !isValidIndex(index))
            return;

        int index_max = max_index(index, left(index), right(index));

        if (index_max != index) {
            swap(index, index_max);
            heapify(index_max);
        }
    }

    private int max_index(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)) {
                if (this.heap[index] < this.heap[right])
                    return right;
            }

            return index;

        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] < this.heap[right])
                    return right;
            }

            return left;
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private void swap(int i, int j) {
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    public void imprimirLista() {
        for(int i = 0; i <= tail; i++){
            System.out.println("Posição["+i+"]: "+this.heap[i]);
        }
    }

}

