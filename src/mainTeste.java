import ArvoreAVL.ArvoreAVL;
import ArvoreAVL.Elemento;
import ArvoreBinaria.ArvBin;
import ArvoreBinariaBusca.ArvBinBusca;

public class mainTeste {

    public static void main(String args[]) {

        ArvBin arv = new ArvBin();

        arv.insereRaiz(1);
        arv.insereEsq(1, 2);
        arv.insereDir(1, 3);

        arv.insereEsq(2, 4);
        arv.insereDir(2, 5);
        arv.insereEsq(3, 6);
        arv.insereDir(3, 7);

        System.out.println("################################\nTeste na Arvore Binaria\n################################\nImprimir a árvore:\nInOrdem: ");
        arv.exibeInOrdem();
        System.out.println("\nPreOrdem: ");
        arv.exibePreOrdem();
        System.out.println("\nPosOrdem: ");
        arv.exibePosOrdem();

        ArvBinBusca arvBB = new ArvBinBusca();

        arvBB.insere(20);
        arvBB.insere(10);
        arvBB.insere(5);
        arvBB.insere(15);
        arvBB.insere(30);
        arvBB.insere(25);
        arvBB.insere(35);
        System.out.println("\n################################\nTeste na Arvore Binaria de Busca\n################################\nImprimir a árvore:\nInOrdem: ");
        arvBB.exibeInOrdem();
        System.out.println("\nPreOrdem: ");
        arvBB.exibePreOrdem();
        System.out.println("\nPosOrdem: ");
        arvBB.exibePosOrdem();

        ArvoreAVL avl = new ArvoreAVL();

        Elemento el1 = new Elemento(20);
        Elemento el2 = new Elemento(10);
        Elemento el3 = new Elemento(5);
        Elemento el4 = new Elemento(15);
        Elemento el5 = new Elemento(30);
        Elemento el6 = new Elemento(25);
        Elemento el7 = new Elemento(35);

        avl.inserir(el1);
        avl.inserir(el2);
        avl.inserir(el3);
        avl.inserir(el4);
        avl.inserir(el5);
        avl.inserir(el6);
        avl.inserir(el7);
        System.out.println("\n################################\nTeste na Arvore AVL\n################################\nImprimir a árvore:\nInOrdem: ");
        avl.imprimirInOrdem();
        System.out.println("\nPreOrdem: ");
        avl.imprimirPreOrdem();
        System.out.println("\nPosOrdem: ");
        avl.imprimirPosOrdem();

    }
}
