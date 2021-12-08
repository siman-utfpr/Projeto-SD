package visao.util;

import java.io.IOException;
import java.util.ArrayList;
import modelo.Produto;
import modelo.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GerenciadorServicoProduto {

    public static boolean cadastrarProduto(String titulo, String descricao,
            String categoria, float valor, String flagSP, String flagVDT) throws JSONException, IOException {
        JSONObject msg = new JSONObject("{operacao: 6}");
        JSONObject data = new JSONObject();

        data.put("titulo", titulo);
        data.put("descricao", descricao);
        data.put("valor", valor);
        data.put("usuario_id", GerenciadorUsuario.getUsuarioLogado().getUuid());
        data.put("categoria", categoria);
        data.put("flag_sp", flagSP);
        data.put("flag_vdt", flagVDT);

        msg.put("data", data);

        JSONObject resposta = GerenciadorUsuario.clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);

        return !resposta.getBoolean("erro");
    }

    public static boolean editarProduto(Produto p) throws JSONException, IOException {
        JSONObject msg = new JSONObject("{operacao: 11}");
        JSONObject data = new JSONObject();
        msg.put("data", data);
        data.put("produto_servico_id", p.getUuid());
        data.put("titulo", p.getTitulo());
        data.put("descricao", p.getDescricao());
        data.put("valor", p.getValor());
        data.put("usuario_id", GerenciadorUsuario.getUsuarioLogado().getUuid());
        data.put("categoria", p.getCategoria());
        data.put("flag_sp", String.valueOf(p.getFlagSP()));
        data.put("flag_vdt", String.valueOf(p.getFlagVDT()));
        JSONObject resposta = GerenciadorUsuario.clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
        return !resposta.getBoolean("erro");
    }

    public static boolean excluirProduto(Produto p) throws JSONException, IOException {
        JSONObject msg = new JSONObject("{operacao: 12}");
        JSONObject data = new JSONObject();
        data.put("produto_servico_id", p.getUuid());
        msg.put("data", data);
        JSONObject resposta = GerenciadorUsuario.clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
        return !resposta.getBoolean("erro");
    }

    public static ArrayList<Produto> listarProdutos() throws JSONException, IOException {
        JSONObject msg = new JSONObject("{operacao: 9}");
        JSONObject resposta = GerenciadorUsuario.clienteTCP.enviarMensagem(msg);
        System.out.println("MENSAGEM ENVIADA: " + msg);
        Logger.escreverMensagem("MENSAGEM ENVIADA: " + msg);
        System.out.println("MENSAGEM RECEBIDA: " + resposta);
        Logger.escreverMensagem("MENSAGEM RECEBIDA: " + resposta);
        ArrayList<Produto> produtos = new ArrayList<>();
        JSONArray data = resposta.getJSONArray("data");
        for (int i = 0; i < data.length(); i++) {
            JSONObject obj = data.getJSONObject(i);
            String uuid = obj.getString("produto_servico_id");
            String titulo = obj.getString("titulo");
            String descricao = obj.getString("descricao");
            String uuidUsuario = obj.getString("usuario_id");
            float valor = (float) obj.getDouble("valor");
            String categoria = obj.getString("categoria");
            char flagSP = obj.getString("flag_sp").charAt(0);
            char flagVDT = obj.getString("flag_vdt").charAt(0);
            Produto p = new Produto(uuid, titulo, descricao, uuidUsuario, valor,
                    categoria, flagSP, flagVDT, false);
            produtos.add(p);
        }

        return produtos;
    }

}
