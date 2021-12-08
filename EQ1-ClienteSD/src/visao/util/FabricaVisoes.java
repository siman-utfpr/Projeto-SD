package visao.util;

import java.util.HashMap;
import javax.swing.JFrame;
import modelo.Produto;
import modelo.Usuario;
import visao.TelaAtualizacaoProduto;
import visao.TelaAtualizacaoUsuario;
import visao.TelaBroadcast;
import visao.TelaCadastro;
import visao.TelaCadastroProduto;
import visao.TelaChat;
import visao.TelaExcluirConta;
import visao.TelaHomePage;
import visao.TelaListarServicosEProdutos;
import visao.TelaLog;
import visao.TelaLogin;
import visao.TelaProduto;
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
    
    public static void mostrarTelaEdicaoProduto(Produto p){
        TelaAtualizacaoProduto tela = new TelaAtualizacaoProduto(p);
        tela.setVisible(true);
        
        telas.put("TelaEdicaoProduto", tela);
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
    
    public static void mostrarTelaBroadcast(){
        TelaBroadcast telaBroadcast = new TelaBroadcast();
        telaBroadcast.setVisible(true);
        
        telas.put("TelaBroadcast", telaBroadcast);
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

    public static void mostrarTelaCadastroProduto() {
        TelaCadastroProduto tela = new TelaCadastroProduto();
        tela.setVisible(true);

        telas.put("TelaCadastroProduto", tela);
    }

    public static void mostrarTelaListarServicosEProdutos() {
        TelaListarServicosEProdutos tela = new TelaListarServicosEProdutos();
        tela.setVisible(true);

        telas.put("TelaListarServicosEProdutos", tela);
    }
    
    public static void mostrarTelaProduto(Produto p){
        TelaProduto telaProduto = new TelaProduto(p);
        telaProduto.setVisible(true);
        
        telas.put("TelaProduto", telaProduto);
    }
    
    public static void mostrarTelaChat(Usuario usuario) {
        TelaChat tela = new TelaChat(usuario);
        tela.setVisible(true);

        telas.put("TelaChat", tela);
    }
    
    public static void atualizarChatBroadcast(String msg){
        TelaBroadcast tela = (TelaBroadcast) telas.get("TelaBroadcast");
        tela.atualizarChat(msg);
    }

}
