package modelo;

import controladores.ControllerLog;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThreadServidorTCP extends Thread {

    public PrintWriter saida;
    public BufferedReader entrada;

    private ServidorTCP servidor;

    public Socket clienteSocket;
    public ControllerLog controllerLog;

    public boolean usuarioLogado = false;

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
                    this.usuarioLogado = false;
                    System.out.println("Cliente " + this.clienteSocket.getInetAddress().getHostAddress() + " desconectado.");
                    controllerLog.escreverMensagem("Cliente " + this.clienteSocket.getInetAddress().getHostAddress() + " desconectado.");
                    this.servidor.removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
                    this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
                    break;
                } else {
                    String msg = String.valueOf(cbuf);
                    controllerLog.escreverMensagem("(" + this.clienteSocket.getInetAddress()
                            .getHostAddress() + ")Mensagem recebida -> " + msg);
                    cbuf = new char[2048];
                    JSONObject jsonMsg = new JSONObject(msg);
                    System.out.println("(" + this.clienteSocket.getInetAddress()
                            .getHostAddress() + ")Mensagem recebida -> " + msg);
                    JSONObject respostaJSON = tratarMensagem(jsonMsg);
                    if (respostaJSON.getInt("operacao") != 19) {
                        saida.print(respostaJSON);
                        saida.flush();
                        controllerLog.escreverMensagem("(" + this.clienteSocket.getInetAddress()
                                .getHostAddress() + ")Mensagem enviada -> " + respostaJSON);
                        System.out.println("(" + this.clienteSocket.getInetAddress()
                                .getHostAddress() + ")Mensagem enviada -> " + respostaJSON);
                    }
                }
                //  this.servidor.imprimirListaUsuarios();

            }

        } catch (IOException ex) {
            if (ex.getMessage().equals("Connection reset")) {
                this.usuarioLogado = false;
                controllerLog.escreverMensagem("CLIENTE " + this.clienteSocket.getInetAddress().getHostAddress() + " DESCONECTADO INESPERADAMENTE");
                System.out.println("CLIENTE " + this.clienteSocket.getInetAddress().getHostAddress() + " DESCONECTADO INESPERADAMENTE");
                this.servidor.removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
                this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
            } else {
                // ex.printStackTrace();
            }

        } catch (JSONException ex) {
            ex.printStackTrace();
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
            case 6:
                respostaJSON = tratarCadastroProduto(msg);
                break;
            case 7:
                respostaJSON = tratarRecuperacaoSenha(msg);
                break;
            case 8:
                respostaJSON = tratarLogout(msg);
                break;
            case 9:
                respostaJSON = tratarListagemProduto(msg);
                break;
            case 10:
                respostaJSON = tratarAtualizacaoUsuario(msg);
                break;
            case 11:
                respostaJSON = tratarAtualizacaoProduto(msg);
                break;
            case 12:
                respostaJSON = tratarExclusaoProduto(msg);
                break;
            case 13:
                respostaJSON = tratarExclusaoUsuario(msg);
                break;
            case 18:
                this.servidor.broadcast(msg.getJSONObject("data").getString("mensagem"));
                respostaJSON = new JSONObject("{operacao: 19}");
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
            this.usuarioLogado = true;
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
        this.usuarioLogado = false;
        this.servidor.removerClienteLogado(this.clienteSocket.getInetAddress().getHostAddress());
        this.controllerLog.atualizarUsuariosLogados(this.servidor.imprimirListaUsuarios());
        return respostaJSON;
    }

    private JSONObject tratarListagemProduto(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 9}");
        respostaJSON.put("erro", false);
        respostaJSON.append("mensagem", "sucesso.retorno");
        JSONArray data = new JSONArray();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Produto p : produtoDAO.buscarProdutosFiltrado(this.servidor.getClientesLogados())) {
            JSONObject cliente = new JSONObject();
            cliente.put("produto_servico_id", p.getUuid());
            cliente.put("usuario_id", p.getUuidUsuario());
            cliente.put("categoria", p.getCategoria());
            cliente.put("descricao", p.getDescricao());
            cliente.put("valor", p.getValor());
            cliente.put("titulo", p.getTitulo());
            cliente.put("flag_sp", String.valueOf(p.getFlagSP()));
            cliente.put("flag_vdt", String.valueOf(p.getFlagVDT()));
            cliente.put("flag_status", "a");
            data.put(cliente);
        }
        respostaJSON.put("data", data);
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

    private JSONObject tratarExclusaoProduto(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 12}");
        JSONObject data = msg.getJSONObject("data");
        String uuid = data.getString("produto_servico_id");
        Produto p = null;
        ProdutoDAO produtoDAO = new ProdutoDAO();
        for (Produto produto : produtoDAO.buscarProdutos()) {
            if (produto.getUuid().equals(uuid)) {
                p = produto;
                break;
            }
        }
        if (p == null) {
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
        }
        try {
            produtoDAO.excluir(p);
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "sucesso.retorno");
        } catch (IOException ex) {
            ex.printStackTrace();
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
            //Logger.getLogger(ThreadServidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respostaJSON;
    }

    private JSONObject tratarCadastroProduto(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 6}");
        JSONObject data = msg.getJSONObject("data");
        String uuidUsuario = data.getString("usuario_id");
        String categoria = data.getString("categoria");
        char flagSP = data.getString("flag_sp").charAt(0);
        String descricao = data.getString("descricao");
        float valor = (float) data.getDouble("valor");
        String titulo = data.getString("titulo");
        char flagVDT = data.getString("flag_vdt").charAt(0);
        String uuid = UUID.randomUUID().toString();

        Produto produto = new Produto(uuid, titulo, descricao, uuidUsuario, valor, categoria, flagSP, flagVDT, false);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        try {
            produtoDAO.salvar(produto);
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "retorno.sucesso");
            data = new JSONObject();
            data.put("produto_servico_id", uuid);
            respostaJSON.put("data", data);
        } catch (IOException ex) {
            ex.printStackTrace();
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
        }
        return respostaJSON;
    }

    private JSONObject tratarAtualizacaoProduto(JSONObject msg) throws JSONException {
        JSONObject respostaJSON = new JSONObject("{operacao: 11}");
        JSONObject data = msg.getJSONObject("data");
        String uuid = data.getString("produto_servico_id");
        String uuidUsuario = data.getString("usuario_id");
        String categoria = data.getString("categoria");
        char flagSP = data.getString("flag_sp").charAt(0);
        String descricao = data.getString("descricao");
        float valor = (float) data.getDouble("valor");
        String titulo = data.getString("titulo");
        char flagVDT = data.getString("flag_vdt").charAt(0);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produtoAtualizado = null;
        try {
            for (Produto p : produtoDAO.buscarProdutos()) {
                if (p.getUuid().equals(uuid)) {
                    produtoAtualizado = p;
                    produtoAtualizado.setCategoria(categoria);
                    produtoAtualizado.setDescricao(descricao);
                    produtoAtualizado.setTitulo(titulo);
                    produtoAtualizado.setValor(valor);
                    produtoAtualizado.setFlagSP(flagSP);
                    produtoAtualizado.setFlagVDT(flagVDT);
                    break;
                }
            }

            produtoDAO.alterar(produtoAtualizado);
            respostaJSON.put("erro", false);
            respostaJSON.append("mensagem", "retorno.sucesso");
            data = new JSONObject();
            data.put("produto_servico_id", uuid);
            respostaJSON.put("data", data);
        } catch (IOException ex) {
            ex.printStackTrace();
            respostaJSON.put("erro", true);
            respostaJSON.append("mensagem", "erro.generico");
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
