package ArvoreAVL;

public class ArvoreAVL {
    private Elemento elemento;
    private ArvoreAVL dir;
    private ArvoreAVL esq;
    private int balanceamento;

    public ArvoreAVL() {
        this.elemento = null;
        this.esq = null;
        this.dir = null;
        this.balanceamento = 0;
    }

    public ArvoreAVL(Elemento elemento) {
        this.elemento = elemento;
        this.esq = null;
        this.dir = null;
        this.balanceamento = 0;
    }

    public int calcularAltura(){
        if (this.esq == null  && this.dir == null){
            return 1;
        }
        else if (this.esq != null && this.dir == null){
            return 1 + this.esq.calcularAltura();
        }
        else if (this.esq == null && this.dir != null){
            return 1 + this.dir.calcularAltura();
        }
        else {
            return 1 + Math.max(this.esq.calcularAltura(), this.dir.calcularAltura());
        }
    }

    public void calcularBalanceamento() {
        if (this.dir == null && this.esq == null){
            this.balanceamento=0;
        }
        else if (this.esq == null && this.dir != null) {
            this.balanceamento = this.dir.calcularAltura() - 0;
        }
        else if (this.esq != null && this.dir == null){
            this.balanceamento = this.esq.calcularAltura() - 0;
        }
        else {
            this.balanceamento = this.dir.calcularAltura() - this.esq.calcularAltura();
        }
        if (this.dir != null) this.dir.calcularBalanceamento();
        if (this.esq != null) this.esq.calcularBalanceamento();
    }

    public ArvoreAVL verificarBalanceamento(){
        if (this.balanceamento >= 2 || this.balanceamento <= -2){
            if (this.balanceamento >= 2){
                if (this.balanceamento * this.dir.getBalanceamento() > 0){
                    System.out.println("Rotação Simples a direita\n");
                    return rotacaoSimplesDireita();
                }
                else {
                    System.out.println("Rotação Dupla a direita\n");
                    return rotacaoDuplaDireita();
                }
            }
            else {
                if (this.balanceamento * this.dir.getBalanceamento() > 0) {
                    System.out.println("Rotação Simples a Esquerda\n");
                    return rotacaoSimplesEsquerda();
                } else {
                    System.out.println("Rotação Dupla a Esquerda\n");
                    return rotacaoDuplaEsquerda();
                }
            }
        }
        this.calcularBalanceamento();
        if (this.esq != null ) this.esq = this.esq.verificarBalanceamento();
        if (this.dir != null) this.dir = this.dir.verificarBalanceamento();
        return this;
    }

    public ArvoreAVL rotacaoSimplesDireita(){
        ArvoreAVL filhoDir;
        ArvoreAVL filhoDoFilho = null;

        filhoDir = this.getDir();
        if (this.dir != null ){
            if (this.dir.getEsq() != null) {
                filhoDoFilho = filhoDir.getEsq();
            }
        }
        filhoDoFilho.setEsq(this);
        this.setDir(filhoDoFilho);

        return filhoDir;
    }

    public ArvoreAVL rotacaoSimplesEsquerda(){
        ArvoreAVL filhoEsq;
        ArvoreAVL filhoDoFilho = null;

        filhoEsq = this.getEsq();
        if (this.esq != null ){
            if (this.esq.getDir() != null) {
                filhoDoFilho = filhoEsq.getDir();
            }
        }
        filhoDoFilho.setDir(this);
        this.setEsq(filhoDoFilho);

        return filhoEsq;
    }

    public ArvoreAVL rotacaoDuplaDireita(){
        ArvoreAVL arvore = this;
        ArvoreAVL filhoDir = this.getDir();
        ArvoreAVL filhoDoFilho = filhoDir.getEsq();
        ArvoreAVL noInserido = filhoDoFilho.getDir();

        filhoDir.setEsq(noInserido);
        filhoDoFilho.setDir(filhoDir);
        this.setDir(filhoDoFilho);

        ArvoreAVL novoFilhoDireita = this.getDir();
        arvore.setDir(null);
        novoFilhoDireita.setEsq(arvore);

        return novoFilhoDireita;
    }

    public ArvoreAVL rotacaoDuplaEsquerda(){
        ArvoreAVL arvore = this;
        ArvoreAVL filhoEsq = this.getEsq();
        ArvoreAVL filhoDoFilho = filhoEsq.getDir();
        ArvoreAVL noInserido = filhoDoFilho.getEsq();

        filhoEsq.setDir(noInserido);
        filhoDoFilho.setEsq(filhoEsq);
        this.setEsq(filhoDoFilho);

        ArvoreAVL novoFilhoEsquerda = this.getEsq();
        arvore.setEsq(null);
        novoFilhoEsquerda.setDir(arvore);

        return novoFilhoEsquerda;
    }

    public boolean isEmpty(){
        return (this.elemento == null);
    }

    public void imprimirPreOrdem(){
        if (!isEmpty()){
            System.out.println(this.elemento.getValor() + " ");
            if (this.esq != null)
                this.esq.imprimirPreOrdem();
            if (this.dir != null)
                this.dir.imprimirPreOrdem();
        }
    }
    public void imprimirInOrdem(){
        if (!isEmpty()){
            if (this.esq != null)
                this.esq.imprimirInOrdem();
            if (this.dir != null)
                this.dir.imprimirInOrdem();
            System.out.println(this.elemento.getValor() + " ");
        }
    }
    public void imprimirPosOrdem(){
        if (!isEmpty()){
            if (this.esq != null)
                this.esq.imprimirPosOrdem();
            if (this.dir != null)
                this.dir.imprimirPosOrdem();
            System.out.println(this.elemento.getValor() + " ");
        }
    }

    public void inserir(Elemento novo){
        if (isEmpty()){
            this.elemento = novo;
        }
        else {
            ArvoreAVL novaArvore = new ArvoreAVL(novo);
            if (novo.getValor() < this.elemento.getValor()) {
                if (this.esq == null){
                    this.esq = novaArvore;
                }
                else{
                    this.esq.inserir(novo);
                }
            }
            else if (novo.getValor() > this.elemento.getValor()) {
                if (this.dir == null){
                    this.dir = novaArvore;
                }
                else{
                    this.dir.inserir(novo);
                }
            }
        }
    }

    public boolean busca(int valor) {
        if (isEmpty()) {
            return false;
        }
        if (this.elemento.getValor() == valor) {
            return true;
        } else {
            if (valor < this.elemento.getValor()) {
                if (this.esq == null)
                    return false;
                else {
                    return this.esq.busca(valor);
                }
            }
            else if (valor > this.elemento.getValor()) {
                if (this.dir == null)
                    return false;
                else{
                    this.dir.busca(valor);
                }
            }
            return false;
        }
    }

    public ArvoreAVL remover(int elemento){
        if (this.elemento.getValor() == elemento){
            if ( this.esq == null && this.dir == null)
                return null;
            else {
                if (this.esq != null && this.dir == null){
                    return this.esq;
                }
                else if (this.esq == null && this.dir != null) {
                    return this.dir;
                }
                else {
                    ArvoreAVL aux = this.dir;
                    while (aux.esq != null){
                        aux = aux.esq;
                    }
                    this.setElemento(aux.getElemento());
                    aux.getElemento().setValor(elemento);
                    this.dir = dir.remover(elemento);
                }
            }
        }
        else {
            if ( elemento < this.elemento.getValor()){
                if (this.esq != null){
                    this.esq = this.esq.remover(elemento);
                }
            }
            else if (elemento > this.elemento.getValor()){
                if (this.dir != null) {
                    this.dir = this.dir.remover(elemento);
                }
            }
        }
        return this;
    }

    public String toString(){
        return "["+this.elemento.getValor()+"]"+"("+this.balanceamento+")";
    }

    // Getters and Setters

    public Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }

    public ArvoreAVL getDir() {
        return dir;
    }

    public void setDir(ArvoreAVL dir) {
        this.dir = dir;
    }

    public ArvoreAVL getEsq() {
        return esq;
    }

    public void setEsq(ArvoreAVL esq) {
        this.esq = esq;
    }

    public int getBalanceamento() {
        return this.balanceamento;
    }

    public void setBalanceamento(int valor){
        this.balanceamento = valor;
    }

}
