package modelo;

import controladores.ControllerLog;
import dao.UsuarioDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreadServidorTCP extends Thread {

    private PrintWriter saida;
    private BufferedReader entrada;

    private ServidorTCP servidor;

    private Socket clienteSocket;
    ControllerLog controllerLog;

    public ThreadServidorTCP(Socket clienteSocket, ServidorTCP servidor) {
        this.clienteSocket = clienteSocket;
        this.servidor = servidor;
        controllerLog = (ControllerLog) this.servidor.fabricaVisoes.buscarControlador("ControllerLog");
    }

    @Override
    public void run() {

        try {
            saida = null;
            entrada = null;
            saida = new PrintWriter(this.clienteSocket.getOutputStream(), true);
            entrada = new BufferedReader(new InputStreamReader(this.clienteSocket.getInputStream()));

            System.out.println("NOVO CLIENTE CONECTADO: " + this.clienteSocket.getInetAddress().getHostAddress());
            controllerLog.escreverMensagem("NOVO CLIENTE CONECTADO: " + this.clienteSocket.getInetAddress().getHostAddress());
            char[] cbuf = new char[2048];
            while (true) {
                int resultadoRead = entrada.read(cbuf);
                if (resultadoRead == -1 || clienteSocket.isClosed()) {
                    System.out.println("Cliente " + this.clienteSocket.getInetAddress().getHostAddress() + " desconectado.");
                    controllerLog.escreverMensagem("Cliente " + this.clienteSocket.getInetAddress().getHostAddress() + " desconectado.");
                    break;
                } else {
                    String msg = String.valueOf(cbuf);
                    controllerLog.escreverMensagem("MENSAGEM RECEBIDA -> " + msg);
                    cbuf = new char[2048];
                    JSONObject jsonMsg = new JSONObject(msg);
                    System.out.println("MENSAGEM RECEBIDA -> " + jsonMsg);
                    JSONObject respostaJSON = tratarMensagem(jsonMsg);

                    saida.print(respostaJSON);
                    saida.flush();
                    controllerLog.escreverMensagem("MENSAGEM ENVIADA -> " + respostaJSON);
                    System.out.println("MENSAGEM ENVIADA -> " + respostaJSON);
                }
                //  this.servidor.imprimirListaUsuarios();

            }

        } catch (IOException ex) {
            if (ex.getMessage().equals("Connection reset")) {
                controllerLog.escreverMensagem("CLIENTE " + this.clienteSocket.getInetAddress().getHostAddress() + " DESCONECTADO INESPERADAMENTE");
                System.out.println("CLIENTE " + this.clienteSocket.getInetAddress().getHostAddress() + " DESCONECTADO INESPERADAMENTE");
                this.servidor.removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
                this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
            } else {
               // ex.printStackTrace();
            }

        } catch (JSONException ex) {
            //ex.printStackTrace();
            controllerLog.escreverMensagem("Ocorreu um problema na conversão para JSON.");
            System.out.println("Ocorreu um problema na conversão para JSON.");
        }
    }

    private JSONObject tratarMensagem(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject();
        switch (msg.getInt("operacao")) {
            case 1:
                respostaJSON = tratarLogin(msg);
                break;
            case 5:
                respostaJSON = tratarCadastroUsuario(msg);
                break;
            case 7:
                respostaJSON = tratarRecuperacaoSenha(msg);
                break;
            case 8:
                respostaJSON = tratarLogout(msg);
                break;
            case 10:
                respostaJSON = tratarAtualizacaoUsuario(msg);
                break;
            case 13:
                respostaJSON = tratarExclusaoUsuario(msg);
                break;
        }

        // Logger.logMsgEnviada(respostaJSON.toString());
        return respostaJSON;
    }

    private JSONObject tratarLogin(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 1}");
        String email = msg.getJSONObject("data").getString("email");
        String senha = msg.getJSONObject("data").getString("senha");

        Usuario usuario = Usuario.validar(email, senha);
        if (usuario != null) {
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "Login efetuado com sucesso");
            JSONObject data = new JSONObject();
            data.put("nome_usuario", usuario.getNomeUsuario());
            data.put("uuid", usuario.getUuid());
            data.put("email", usuario.getEmail()); 
            respostaJSON.put("data", data);
            ClienteLogado clienteLogado
                    = new ClienteLogado(this.clienteSocket.getInetAddress().getHostAddress(),
                            this.clienteSocket.getLocalPort(), usuario);
            this.servidor.adicionarClienteLogado(clienteLogado);
            this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
        } else {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "Credenciais inválidas");
        }

        return respostaJSON;
    }

    private JSONObject tratarRecuperacaoSenha(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 7}");
        String email = msg.getJSONObject("data").getString("email");
        if (Usuario.buscarUsuarioPorEmail(email) != null) {
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "retorno.sucesso");
            respostaJSON.append("mensagem", "email.enviado");
        } else {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
        }
        return respostaJSON;
    }

    private JSONObject tratarLogout(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 8}");
        respostaJSON.put("erro", false);
        respostaJSON.append("mensagem", "Logout realizado");

        this.servidor.removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
        this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
        return respostaJSON;
    }

    private JSONObject tratarAtualizacaoUsuario(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 10}");
        JSONObject data = msg.getJSONObject("data");
        String email = data.getString("email");
        String nomeUsuario = data.getString("nome_usuario");
        String senha = data.getString("senha");

        Usuario usuarioLogado = this.servidor.getUsuarioLogado(this.clienteSocket.getInetAddress().getHostAddress());
        for (Usuario u : Usuario.buscarUsuarios()) {
            //System.out.println(u.getEmail() + " - " + (u.getNomeUsuario() == null));
            if ((u.getEmail().equals(email))
                    && !u.getUuid().equals(usuarioLogado.getUuid())) {
                respostaJSON.put("erro", true);
                respostaJSON.append("mensagem", "erro.generico");
                return respostaJSON;
            }
        }

        usuarioLogado.setEmail(email);
        usuarioLogado.setNomeUsuario(nomeUsuario);
        usuarioLogado.setSenha(senha);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.alterar(usuarioLogado);
            this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "sucesso.retorno");
        } catch (IOException ex) {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
        }

        return respostaJSON;
    }

    private JSONObject tratarCadastroUsuario(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 5}");
        JSONObject data = msg.getJSONObject("data");
        String email = data.getString("email");
        String nomeUsuario = data.getString("nome_usuario");
        String senha = data.getString("senha");
        String uuid = UUID.randomUUID().toString();

        if (Usuario.buscarUsuarioPorEmail(email) != null) {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "email duplicado");
        } else {
            Usuario usuario = new Usuario(uuid, nomeUsuario, email, senha);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            try {
                usuarioDAO.salvar(usuario);
                respostaJSON.put("erro", false);
                respostaJSON.append("mensagem", "retorno.sucesso");
            } catch (IOException ex) {
                respostaJSON.put("erro", true);
                respostaJSON.append("mensagem", "erro.generico");
            }
        }

        return respostaJSON;
    }

    private JSONObject tratarExclusaoUsuario(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 13}");
        Usuario usuario = this.servidor.
                removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try {
            usuarioDAO.excluir(usuario);
            this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "retorno.sucesso");
        } catch (IOException ex) {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
        }
        return respostaJSON;
    }

}
