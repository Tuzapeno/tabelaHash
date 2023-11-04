import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Criação de parametros

        int SEED = 5102;
        int[] FUNCAO_HASH = {Tabela.HASH_RESTO_DIVISAO, Tabela.HASH_MULTIPLICACAO, Tabela.HASH_BITSHIFT};
        int NUM_ELEMENTOS = 5_000_000;
        int[] RANGE_TABELAS = {10_000, 50_000, 100_000, 500_000, 1_000_000};
        int round = 1;

        for(int tamanho : RANGE_TABELAS) {
            System.out.println("##################### (" + round + ") #####################");
            round++;
            for(int funcao : FUNCAO_HASH) {

                Random random = new Random(SEED);
                Tabela tabela = new Tabela(tamanho);
        
                long startTempoInsercao = System.nanoTime();
            
                for (int i = 0; i < NUM_ELEMENTOS; i++) {
                    tabela.inserirTabela(random.nextInt(100_000_000, 999_999_999), funcao);
                }
        
                long finalTempoInsercao = System.nanoTime();
        
        
                long startTempoBusca = System.nanoTime();
        
                for (int i = 0; i < NUM_ELEMENTOS; i++) {
                    tabela.buscarTabela(random.nextInt(100_000_000, 999_999_999), funcao);
                }
        
                long finalTempoBusca = System.nanoTime();
        
                // Preparando saída
        
                String f;
                switch (funcao) {
                    case Tabela.HASH_RESTO_DIVISAO:
                        f = "RESTO DIVISAO"; break;
                    case Tabela.HASH_MULTIPLICACAO:
                        f = "MULTIPLICACAO"; break;
                    default:
                        f = "BITSHIFT"; break;
                }
                System.out.println("\nFunção Hash: " + f + " Tamanho: " + tabela.tamanho + " Numeros inseridos: " + NUM_ELEMENTOS);
                System.out.println("Tempo de inserção: " + (finalTempoInsercao - startTempoInsercao) / 1_000_000 + "ms");
                System.out.println("Tempo de busca: " + (finalTempoBusca - startTempoBusca) / 1_000_000 + "ms");
                tabela.imprimirDados();

            }
        }
    }
}