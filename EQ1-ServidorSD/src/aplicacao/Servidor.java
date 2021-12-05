package aplicacao;

import modelo.ServidorTCP;
import visao.util.FabricaVisoes;

public class Servidor {
    
    public static void main(String[] args) {    
        FabricaVisoes fabricaVisoes = new FabricaVisoes();
        ServidorTCP servidor = new ServidorTCP(fabricaVisoes);
        

        fabricaVisoes.mostrarTelaLog();
        fabricaVisoes.mostrarTelaConexao(servidor);
    }

}
