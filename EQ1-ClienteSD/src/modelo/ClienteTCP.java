package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class ClienteTCP {

    public Socket clienteSocket;
    public PrintWriter saida;
    public BufferedReader entrada;

    public ClienteTCP() {
    }

    public void conectar(String ip, int porta) throws IOException {
        clienteSocket = new Socket(ip, porta);
        saida = new PrintWriter(clienteSocket.getOutputStream(), true);
        entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
    }

    public boolean estaConectado() {
        return clienteSocket.isConnected();
    }

    public void desconectar() throws IOException {
        saida.close();
        entrada.close();
        clienteSocket.close();
    }

    public JSONObject enviarMensagem(JSONObject mensagem) throws IOException, JSONException {
        saida.print(mensagem.toString());
        saida.flush();
        char[] cbuf = new char[2048];
        entrada.read(cbuf);
        JSONObject res = new JSONObject(String.valueOf(cbuf));
        return res;
    }

}
