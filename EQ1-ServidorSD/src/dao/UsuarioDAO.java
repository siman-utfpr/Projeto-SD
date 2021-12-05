package dao;

import java.io.IOException;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {
    
    public void salvar(Usuario usuario) throws IOException{
        BancoDados bd = BancoDados.getInstance();
        bd.getUsuarios().add(usuario);
        bd.salvarEstadoAtual();
    }
    
   public List<Usuario> buscarUsuarios(){
        BancoDados bd = BancoDados.getInstance();
        return bd.getUsuarios();                        
    }
    
    public void excluir(Usuario u) throws IOException{        
        BancoDados bd = BancoDados.getInstance();
        bd.getUsuarios().remove(u);     
        bd.salvarEstadoAtual();
    }
    
    public boolean alterar(Usuario u) throws IOException{
        BancoDados bd = BancoDados.getInstance();
        int pos = bd.getUsuarios().indexOf(u);
        
        if (pos == -1){
            return false;
        }
        
        bd.getUsuarios().set(pos, u);
        bd.salvarEstadoAtual();
        return true;
        
    }
    
}
