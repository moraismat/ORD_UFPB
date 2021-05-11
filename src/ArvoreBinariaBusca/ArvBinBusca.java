package ArvoreBinariaBusca;

public class ArvBinBusca {
    private No root;

    public ArvBinBusca(){
        this.root = null;
    }

    /*
        Verifica se a arvore esta vazia
     */
    public Boolean isEmpty(){
        return (this.root == null);
    }

    public No getRoot(){
        return this.root;
    }

    /*
        Metodo para verificar se o valor esta no Nó
     */
    private No busca(No T, int valor) {
        if(T == null)
            return null;

        if(T.getValor() == valor)
            return T;

        if(valor < T.getValor())
            return busca(T.getEsq(), valor);
        else
            return busca(T.getDir(), valor);
    }

    /*
        Realiza a busca pelo valor a partir do nó
     */
    private No busca(int valor){
        if(isEmpty())
            return null;

        return busca(this.root, valor);
    }

    public boolean insere(int valor) {

        No newNo = new No();
        newNo.setValor(valor);
        newNo.setEsq(null);
        newNo.setDir(null);

        // Quando a arvore estiver vazia, o novoNó será a raiz da arv
        if (this.root == null){
            this.root = newNo;
            return true;
        }

        // Procura a posicao correta pra inserir o novo no
        No aux = this.root;
        No p = null;
        while (aux != null) {
            p = aux;
            if (valor < aux.getValor())
                aux = aux.getEsq();
            else
                aux = aux.getDir();
        }

        // Encontrou um nó folha para inserir
        if (valor < p.getValor())
            p.setEsq(newNo);
        else
            p.setDir(newNo);
        return true;
    }



    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    private void exibePreOrdem(No T) {
        if (T == null)
            return;

        // Imprime a raiz
        System.out.print(" " + T.getValor());

        // Caminha recursivamente na sub-arv da esq (pre-ordem)
        if (T.getEsq() != null)
            exibePreOrdem(T.getEsq());

        // Caminha recursivamente na sub-arv da dir (pre-ordem)
        if (T.getDir() != null)
            exibePreOrdem(T.getDir());
    }

    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    public void exibePreOrdem() {
        if (this.root == null)
            System.out.println("Arvore vazia");
        else
            exibePreOrdem(this.root);
    }


    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    private void exibeInOrdem(No T) {
        if (T == null)
            return ;

        if (T.getEsq() != null)
            exibeInOrdem(T.getEsq());

        System.out.print(" " + T.getValor());

        if (T.getDir() != null)
            exibeInOrdem(T.getDir());
    }


    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    public void exibeInOrdem() {
        if (this.root == null)
            System.out.println("Arvore vazia");
        else
            exibeInOrdem(this.root);
    }

    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    private void exibePosOrdem(No T) {
        if (T == null)
            return ;

        if (T.getEsq() != null)
            exibePosOrdem(T.getEsq());

        if (T.getDir() != null)
            exibePosOrdem(T.getDir());

        System.out.print(" " + T.getValor());
    }

    /** Exibe o conteúdo de uma árvore em pré-ordem*/
    public void exibePosOrdem() {
        if (this.root == null)
            System.out.println("Arvore vazia");
        else
            exibePosOrdem(this.root);
    }

}
