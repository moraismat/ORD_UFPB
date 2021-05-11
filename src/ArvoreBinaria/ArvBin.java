package ArvoreBinaria;

public class ArvBin {
    private No root;

    public ArvBin(){
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

        No aux = busca(T.getEsq(), valor);
        if(aux == null)
            aux = busca(T.getDir(), valor);

        return aux;
    }

    /*
        Realiza a busca pelo valor a partir do nó
     */
    private No busca(int valor){
        if(isEmpty())
            return null;

        return busca(this.root, valor);
    }

    public boolean insereRaiz(int valor){
        if(this.root != null)
            return false;

        No newNo = new No(valor);
        newNo.setValor(valor);
        newNo.setEsq(null);
        newNo.setDir(null);

        this.root = newNo;
        return true;
    }

    /*
        Metodo para inserir a Direita
     */
    public boolean insereDir(int vPai, int vFilho){
        No filho = busca(vFilho);
        if(filho != null)
            return false;

        No pai = busca(vPai);
        if(pai == null)
            return false;

        if(pai.getDir() != null)
            return false;

        No novoNo = new No();
        novoNo.setValor(vFilho);
        novoNo.setEsq(null);
        novoNo.setDir(null);

        pai.setDir(novoNo);

        return true;
    }

    /*
           Metodo para inserir a esquerda
        */
    public boolean insereEsq(int vPai, int vFilho){
        No filho = busca(vFilho);
        if(filho != null)
            return false;

        No pai = busca(vPai);
        if(pai == null)
            return false;

        if(pai.getEsq() != null)
            return false;

        No novoNo = new No();
        novoNo.setValor(vFilho);
        novoNo.setEsq(null);
        novoNo.setDir(null);

        pai.setEsq(novoNo);

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
