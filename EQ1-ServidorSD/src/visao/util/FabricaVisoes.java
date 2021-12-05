package visao.util;

import controladores.ControllerLog;
import controladores.ControllerServidor;
import java.util.HashMap;
import javax.swing.JFrame;
import modelo.ServidorTCP;
import visao.TelaConexao;
import visao.TelaLog;

public class FabricaVisoes {
    
    private HashMap<String, JFrame> telas;
    private HashMap<String, Object> controladores;

    public FabricaVisoes() {
        this.telas = new HashMap<>();
        this.controladores = new HashMap<>();
    }
    
    public void adicionarTela(String nome, JFrame tela){
        telas.put(nome, tela);
    }
    
    public JFrame buscarTela(String nome){
        return telas.get(nome);
    }
    
    public void removerTela(String nome){
        telas.get(nome).dispose();
        telas.remove(nome);
    }
    
    public void adicionarControlador(String nome, Object controlador){
        controladores.put(nome, controlador);
    }
    
    public Object buscarControlador(String nome){
        return controladores.get(nome);
    }
    
    public void removerControlador(String nome){
        controladores.remove(nome);
    }
    
    public void mostrarTelaLog() {
        TelaLog tela = new TelaLog();
        tela.setVisible(true);
        //tela.setResizable(false);
        
        this.adicionarTela("TelaLog", tela);
        
        ControllerLog controlador = new ControllerLog(this);
        this.adicionarControlador("ControllerLog", controlador);
    }
    
    public void mostrarTelaConexao(ServidorTCP servidor) {           
        ControllerServidor controlador = new ControllerServidor(servidor, this);
        TelaConexao tela = new TelaConexao(controlador);
        tela.setVisible(true);
        
        this.adicionarTela("TelaConexao", tela);
        this.adicionarControlador("ControllerServidor", controlador);
    }
    
    public void esconderTelaConexao() {
        JFrame tela = telas.get("TelaConexao");
        tela.dispose();
        telas.remove("TelaConexao");
    }
  
}
