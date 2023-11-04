public class Hash {

    public static int hashRestoDivisao(int chave, int tamanhoTabela) {
        return chave % tamanhoTabela;
    }

    public static int hashMultiplicacao(int chave, int tamanhoTabela) {
        double A = (2.23606 - 1) / 2;
        return (int) (tamanhoTabela * (chave * A % 1));
    }

    public static int hashBitShift(int chave, int tamanhoTabela) {
        int soma = 0;
        while (chave != 0) {
            soma += chave & 0xFFFF; // Adiciona os 16 bits inferiores de chave
            chave >>>= 16;          // Desloca chave 16 bits para a direita
        }
        return soma % tamanhoTabela;
    }
    
}    

