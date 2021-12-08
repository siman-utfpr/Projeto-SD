package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.ClienteLogado;
import modelo.Produto;

public class ProdutoDAO {

    public void salvar(Produto produto) throws IOException {
        BancoDados bd = BancoDados.getInstance();
        bd.getProdutos().add(produto);
        bd.salvarEstadoAtual();
    }

    public List<Produto> buscarProdutos() {
        BancoDados bd = BancoDados.getInstance();
        return bd.getProdutos();
    }

    public List<Produto> buscarProdutosFiltrado(ArrayList<ClienteLogado> usuariosLogados){
        ArrayList<Produto> listaFiltrada = new ArrayList<>();
        for(Produto p: buscarProdutos()){
            if(p.isNegociado()) {
                continue;
            }
            for(ClienteLogado cl: usuariosLogados){
                if(cl.getUsuario().getUuid().equals(p.getUuidUsuario())){
                    listaFiltrada.add(p);
                }
            }
        }
        return listaFiltrada;
    }

    public void excluir(Produto p) throws IOException {
        BancoDados bd = BancoDados.getInstance();
        bd.getProdutos().remove(p);
        bd.salvarEstadoAtual();
    }

    public boolean alterar(Produto p) throws IOException {
        BancoDados bd = BancoDados.getInstance();
        int pos = bd.getProdutos().indexOf(p);

        if (pos == -1) {
            return false;
        }

        bd.getProdutos().set(pos, p);
        bd.salvarEstadoAtual();
        return true;

    }

}
