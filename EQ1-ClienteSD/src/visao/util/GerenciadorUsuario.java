package visao.util;

import java.io.IOException;
import modelo.ClienteTCP;
import modelo.Usuario;
import org.json.JSONException;
import org.json.JSONObject;
import util.Digest;

public class GerenciadorUsuario {

    public static ClienteTCP clienteTCP = null;

    private static Usuario usuarioLogado = null;

    private static String ipConexao = null;

    private static Integer portaConexao = null;

    public static void setIpConexao(String ipConexao) {
        GerenciadorUsuario.ipConexao = ipConexao;
    }

    public static String getIpConexao() {
        return ipConexao;
    }

    public static void setPortaConexao(Integer portaConexao) {
        GerenciadorUsuario.portaConexao = portaConexao;
    }

    public static int getPortaConexao() {
        return portaConexao;
    }

    public static boolean conectarUsuario() throws IOException, NullPointerException {
        GerenciadorUsuario.clienteTCP = new ClienteTCP();
        clienteTCP.conectar(ipConexao, portaConexao);
        if (clienteTCP.estaConectado()) {
            System.out.println("Conectado ao servidor " + GerenciadorUsuario.ipConexao + " na porta " + GerenciadorUsuario.portaConexao);
            Logger.escreverMensagem("Conectado ao servidor " + GerenciadorUsuario.ipConexao + " na porta " + GerenciadorUsuario.portaConexao);
        }
        return clienteTCP.estaConectado();
    }

    public static void desconectar() {
        try {
            clienteTCP.desconectar();
            Logger.escreverMensagem("Desconectado do servidor");
            System.out.println("Desconectado do servidor");
        } catch (Exception e) {
            Logger.escreverMensagem("Erro desconectando do servidor");
        }
    }

    public static boolean recuperarSenha(String email) throws JSONException, IOException {
        JSONObject msg = new JSONObject();
        JSONObject data = new JSONObject();
        data.put("email", email);
        msg.put("operacao", 7);
        msg.put("data", data);

        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg.toString());
        System.out.println("MENSAGEM ENVIADA: " + msg.toString());
        JSONObject resposta = clienteTCP.enviarMensagem(msg);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        return !resposta.getBoolean("erro");
    }

    public static boolean fazerLoginUsuario(String email, String senha) {
        JSONObject msg = new JSONObject();
        JSONObject data = new JSONObject();
        boolean erroNoLogin = true;

        try {
            data.put("email", email);
            data.put("senha", Digest.hashString(senha, "SHA-256"));
            msg.put("operacao", 1);
            msg.put("data", data);

            Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg.toString());
            System.out.println("MENSAGEM ENVIADA: " + msg.toString());
            JSONObject resposta = clienteTCP.enviarMensagem(msg);

            Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
            System.out.println("MENSAGEM RECEBIDA: " + resposta);

            erroNoLogin = resposta.getBoolean("erro");
            if (!erroNoLogin) {
                data = resposta.getJSONObject("data");
                usuarioLogado = new Usuario(data.getString("uuid"), data.getString("nome_usuario"),
                        data.getString("email"), "");
            }
            return erroNoLogin;
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return erroNoLogin;
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    public static boolean fazerLogoutUsuario() {
        boolean erroNoLogout = true;
        try {
            JSONObject msg = new JSONObject();
            msg.put("operacao", 8);

            JSONObject resposta = clienteTCP.enviarMensagem(msg);
            System.out.println("MENSAGEM ENVIADA: " + msg);
            Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
            System.out.println("MENSAGEM RECEBIDA: " + resposta);
            Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
            usuarioLogado = null;
            erroNoLogout = resposta.getBoolean("erro");
        } catch (IOException e) {
        } catch (JSONException e) {
        }

        return erroNoLogout;
    }

    public static boolean fazerCadastroUsuario(String email, String nomeUsuario, String senha) throws JSONException, IOException {
        JSONObject msg = new JSONObject();
        msg.put("operacao", 5);

        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("nome_usuario", nomeUsuario);
        data.put("senha", senha);

        msg.put("data", data);

        JSONObject resposta = clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);

        return !resposta.getBoolean("erro");
    }

    public static boolean fazerAtualizacaoUsuario(String email, String nomeUsuario, String senha) throws JSONException, IOException {
        JSONObject msg = new JSONObject();
        msg.put("operacao", 10);

        JSONObject data = new JSONObject();
        data.put("email", email);
        data.put("nome_usuario", nomeUsuario);
        data.put("senha", senha);

        msg.put("data", data);

        JSONObject resposta = clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);

        return !resposta.getBoolean("erro");
    }

    public static boolean excluirUsuario() throws JSONException, IOException {
        JSONObject msg = new JSONObject();
        msg.put("operacao", 13);

        JSONObject resposta = clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);

        return !resposta.getBoolean("erro");
    }

}
