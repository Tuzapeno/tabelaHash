public class Node {
    private int valor = -1;
    private Node proximo = null;

    public Node(int valor) {
        this.valor = valor;
    }

    public Node(int valor, Node proximo) {
        this.valor = valor;
        this.proximo = proximo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
