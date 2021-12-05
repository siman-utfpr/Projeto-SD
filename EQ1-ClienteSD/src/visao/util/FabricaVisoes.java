package visao.util;

import java.util.HashMap;
import javax.swing.JFrame;
import modelo.ServicoProduto;
import modelo.Usuario;
import visao.TelaAtualizacaoUsuario;
import visao.TelaBroadcast;
import visao.TelaCadastro;
import visao.TelaChat;
import visao.TelaExcluirConta;
import visao.TelaHomePage;
import visao.TelaListarServicosEProdutos;
import visao.TelaLog;
import visao.TelaLogin;
import visao.TelaSalvarServicoProduto;
import visao.TelaRecuperarSenha;

public class FabricaVisoes {

    static HashMap<String, JFrame> telas = new HashMap<String, JFrame>();

    public static void mostrarTelaLogin() {
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);

        telas.put("TelaLogin", tela);
    }

    public static void mostrarTelaHomePage() {
        TelaHomePage tela = new TelaHomePage();
        tela.setVisible(true);

        telas.put("TelaHomePage", tela);
    }

    public static void mostrarTelaCadastro() {
        TelaCadastro tela = new TelaCadastro();
        tela.setVisible(true);

        telas.put("TelaCadastro", tela);
    }

    public static void mostrarTelaAtualizacaoUsuario() {
        TelaAtualizacaoUsuario tela = new TelaAtualizacaoUsuario();
        tela.setVisible(true);

        telas.put("TelaAtualizacaoUsuario", tela);
    }

    public static void esconderTela(String nome) {
        JFrame tela = telas.get(nome);
        tela.dispose();

        telas.remove(nome);
    }

    public static void mostrarTelaLog() {
        TelaLog tela = new TelaLog();
        tela.setVisible(true);
        // tela.setResizable(false);

        Logger.setTelaLog(tela);

        telas.put("TelaLog", tela);
    }

    public static void mostrarTelaExcluirConta() {
        TelaExcluirConta tela = new TelaExcluirConta();
        tela.setVisible(true);

        telas.put("TelaExcluirConta", tela);
    }

    public static void mostrarTelaRecuperarSenha() {
        TelaRecuperarSenha tela = new TelaRecuperarSenha();
        tela.setVisible(true);

        telas.put("TelaRecuperarSenha", tela);
    }

    public static void mostrarTelaNovoServicoProduto() {
        TelaSalvarServicoProduto tela = new TelaSalvarServicoProduto(null);
        tela.setVisible(true);

        telas.put("TelaNovoServicoProduto", tela);
    }

    public static void mostrarTelaBroadcast() {
        TelaBroadcast tela = new TelaBroadcast();
        tela.setVisible(true);

        telas.put("TelaBroadcast", tela);
    }

    public static void mostrarTelaEditarServicosEProdutos(ServicoProduto sp) {
        TelaSalvarServicoProduto tela = new TelaSalvarServicoProduto(sp);
        tela.setVisible(true);

        telas.put("TelaEditarServicosEProdutos", tela);
    }

    public static void mostrarTelaListarServicosEProdutos(boolean listarApenasDoUsuarioLogado) {
        TelaListarServicosEProdutos tela = new TelaListarServicosEProdutos(listarApenasDoUsuarioLogado);
        tela.setVisible(true);

        telas.put("TelaListarServicosEProdutos", tela);
    }
    
    public static void mostrarTelaChat(Usuario usuario) {
        TelaChat tela = new TelaChat(usuario);
        tela.setVisible(true);

        telas.put("TelaChat", tela);
    }

}
