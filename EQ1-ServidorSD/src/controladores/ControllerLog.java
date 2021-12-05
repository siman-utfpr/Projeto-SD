package controladores;

import java.util.ArrayList;
import modelo.ClienteLogado;
import visao.TelaLog;
import visao.util.FabricaVisoes;

public class ControllerLog {

    private TelaLog telaLog;

    public ControllerLog(FabricaVisoes fabricaVisoes) {
        this.telaLog = (TelaLog) fabricaVisoes.buscarTela("TelaLog");
    }
    
    public void escreverMensagem(String msg){
        telaLog.appendTextLogTextArea(msg);
        telaLog.appendTextLogTextArea("\n\n");
    }
    
    public void atualizarUsuariosLogados(ArrayList<String> s){
        telaLog.limparAreaUsuarios();
        telaLog.preencherAreaUsuarios(s);
    }

    public void logListaDeUsuarios(ArrayList<ClienteLogado> usuariosLogados) {
        telaLog.appendTextLogTextArea("USUÁRIOS LOGADOS: ");
        for (ClienteLogado cl : usuariosLogados) {
            telaLog.appendTextLogTextArea("IP: " + cl.getIp() + "\n");
            telaLog.appendTextLogTextArea("PORTA: " + cl.getPorta() + "\n");
            telaLog.appendTextLogTextArea("EMAIL: " + cl.getUsuario().getEmail() + "\n\n");
        }

        telaLog.appendTextLogTextArea("\n\n");
    }

}
