
public class Tabela {
    public Node[] tabela;
    public int tamanho;
    public long colisoes = 0;
    public long comparacoes = 0;

    // CONSTANTES ########################
    
    public static final int HASH_RESTO_DIVISAO = 1;
    public static final int HASH_MULTIPLICACAO = 2;
    public static final int HASH_BITSHIFT= 3;
    
    //  CONSTRUTOR ##########################

    public Tabela(int x) {
        tamanho = x;
        tabela = new Node[tamanho];
    }

    // INSERIR POR PONTEIRO ############################

    public void inserirTabela(int valor, int hashCode) {
        // validar o hashCode
        if (hashCode > 3 || hashCode < 1) return;
        
        int chaveHashed;

        chaveHashed = calcularChaveHashed(valor, hashCode);
        
        // inserir caso esteja vazia
        if (tabela[chaveHashed] == null)
            tabela[chaveHashed] = new Node(valor, null);
        else {
            // senao procurar um ponteiro vazio
            colisoes++;
            Node aux = tabela[chaveHashed];
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }
            aux.setProximo(new Node(valor, null));
        }
    }
    
    // BUSCAR POR PONTEIRO ############################

    public void buscarTabela(int valor, int hashCode) {
        // validar o hashCode
        if (hashCode > 3 || hashCode < 1) return;

        int chaveHashed = calcularChaveHashed(valor, hashCode);

        comparacoes++;
        if (tabela[chaveHashed] != null && tabela[chaveHashed].getValor() == valor) return;
        
        Node aux = tabela[chaveHashed];

        if (aux == null) return;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
            comparacoes++;
            if (aux.getValor() == valor) return;
        }
    }

    // CALCULAR CHAVE HASHED ############################

    private int calcularChaveHashed(int valor, int hashCode) {
        int chaveHashed;
        if (hashCode == HASH_RESTO_DIVISAO)
            chaveHashed = Hash.hashRestoDivisao(valor, tamanho);
        else if (hashCode == HASH_MULTIPLICACAO)
            chaveHashed = Hash.hashMultiplicacao(valor, tamanho);
        else
            chaveHashed = Hash.hashBitShift(valor, tamanho);
        return chaveHashed;
    }
    
    // IMPRIMIR TABELA ############################

    public void imprimirTabela() {
        // Imprimir cada Node e seus proximos
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                System.out.print(i + " : ");
                Node aux = tabela[i];
                while (aux != null) {
                    System.out.print(aux.getValor() + " -> ");
                    aux = aux.getProximo();
                }
                System.out.print("fim\n");
            }
        }
    }

    // IMPRIMIR DADOS ############################

    public void imprimirDados() {
        System.out.println("Colisões (insercao): " + colisoes);
        System.out.println("Comparações (busca): " + comparacoes);
    }
}