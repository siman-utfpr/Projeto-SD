package controladores;

import java.io.IOException;
import modelo.ServidorTCP;
import visao.TelaConexao;
import visao.util.FabricaVisoes;

public class ControllerServidor {
    
    private ServidorTCP servidor;
    private FabricaVisoes fabricaVisoes;
    //private TelaConexao tela;

    public ControllerServidor(ServidorTCP servidor, FabricaVisoes fabricaVisoes) {
        this.servidor = servidor;
        this.fabricaVisoes = fabricaVisoes;
        //this.tela = tela;
    }
    
    public void setServidor(ServidorTCP servidor) {
        this.servidor = servidor;
    }
    
    public void inicializarServidor(int porta) throws IOException {
        //FabricaVisoes.esconderTelaConexao();
        this.servidor.inicializar(porta);
        ControllerLog controllerLog = (ControllerLog)this.fabricaVisoes.buscarControlador("ControllerLog");
        controllerLog.escreverMensagem("Servidor inicializado na porta " + porta);
        this.fabricaVisoes.removerTela("TelaConexao");
    }
}
