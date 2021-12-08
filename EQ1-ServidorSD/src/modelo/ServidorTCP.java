package modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import visao.util.FabricaVisoes;

public class ServidorTCP extends Thread {

    private ServerSocket servidorSocket;
    private Socket clienteSocket;

    public FabricaVisoes fabricaVisoes;
    
    private ArrayList<ClienteLogado> usuariosLogados;
    private ArrayList<ThreadServidorTCP> threads;

    public ServidorTCP(FabricaVisoes fabricaVisoes) {
        this.usuariosLogados = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.fabricaVisoes = fabricaVisoes;
    }

    @Override
    public void run() {
        while (true) {
            try {
                clienteSocket = servidorSocket.accept();
                ThreadServidorTCP thread = new ThreadServidorTCP(clienteSocket, this);
                this.threads.add(thread);
                thread.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
 
    public void inicializar(int porta) throws IOException {
        System.out.println("Servidor inicializado na porta " + porta);
        servidorSocket = new ServerSocket(porta);
        this.start();
    }

    public void adicionarClienteLogado(ClienteLogado clienteLogado) {
        this.usuariosLogados.add(clienteLogado);
    }
    
    public ArrayList<ClienteLogado> getClientesLogados(){
        return this.usuariosLogados;
    }
    
    public void broadcast(String mensagem) throws JSONException{
        JSONObject msg = new JSONObject("{operacao: 19}");
        JSONObject data = new JSONObject();
        data.put("mensagem", mensagem);
        msg.put("data", data);
        for(ThreadServidorTCP t: this.threads){
            if(t.usuarioLogado){
                t.saida.print(msg);
                t.saida.flush();
                
                t.controllerLog.escreverMensagem("(" + t.clienteSocket.getInetAddress()
                                .getHostAddress() + ")Mensagem enviada -> " + msg);
                System.out.println("(" + t.clienteSocket.getInetAddress()
                                .getHostAddress() + ")Mensagem enviada -> " + msg);
            }
        }
    }
    
    public Usuario getUsuarioLogado(String ip){
        for (ClienteLogado cl: this.usuariosLogados) {
            if (cl.getIp().equals(ip)) {
                return cl.getUsuario();
            }
        }
        return null;
    }

    public Usuario removerClienteLogado(String ip) {
        for (int i = this.usuariosLogados.size() - 1; i >= 0; i--) {
            ClienteLogado cl = this.usuariosLogados.get(i);
            if (cl.getIp().equals(ip)) {
                this.usuariosLogados.remove(cl);
                return cl.getUsuario();
            }
        }
        return null;
    }

    public ArrayList<String> imprimirListaUsuarios() {
        ArrayList<String> usuarios = new ArrayList<>();
        for(ClienteLogado cl: this.usuariosLogados){
            usuarios.add(cl.getIp() + ":" + cl.getPorta() + " - " + cl.getUsuario().getEmail());
        }
        return usuarios;

    }
}
