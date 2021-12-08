package visao.util;

import java.io.IOException;
import java.util.logging.Level;
import modelo.ClienteTCP;
import org.json.JSONException;
import org.json.JSONObject;

public class GerenciadorChat extends Thread {
    
    private ClienteTCP clienteTCP;
    
    @Override
    public void run() {
        clienteTCP = GerenciadorUsuario.clienteTCP;
        while (true) {
            try {
                char[] cbuf = new char[2048];
                clienteTCP.entrada.mark(2047);
                clienteTCP.entrada.read(cbuf);
                JSONObject res = new JSONObject(String.valueOf(cbuf));
                int op = res.getInt("operacao");
                if (op == 19) {
                    System.out.println("Mensagem recebida: " + res);
                    Logger.escreverMensagem("Mensagem recebida: " + res);
                } else {
                    clienteTCP.entrada.reset();
                    Thread.sleep(300);
                }
            } catch (JSONException ex) {
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GerenciadorChat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                java.util.logging.Logger.getLogger(GerenciadorChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void enviarMensagemBroadcast(String mensagem) throws JSONException, IOException {
        JSONObject msg = new JSONObject("{operacao: 18}");
        JSONObject data = new JSONObject();
        data.put("mensagem", mensagem);
        msg.put("data", data);
        GerenciadorUsuario.clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        
    }
    
}
