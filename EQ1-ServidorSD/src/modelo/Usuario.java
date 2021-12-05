package modelo;

import dao.UsuarioDAO;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import util.Digest;
import util.HashGenerationException;

public class Usuario implements Serializable {

    private static final long serialVersionUID = -1267316262872583373L;

    private String uuid;
    private String nomeUsuario;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String uuid, String nomeUsuario, String email, String senha) {
        this.uuid = uuid;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }

    public JSONObject getLoginJSON() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("email", this.email);
        obj.put("senha", this.senha);
        return obj;
    }

    public static ArrayList<Usuario> buscarUsuarios() {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return new ArrayList<>(usuarioDAO.buscarUsuarios());
    }

    public static Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario u : Usuario.buscarUsuarios()) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    public static Usuario validar(String email, String senha) {
        Usuario usuario = Usuario.buscarUsuarioPorEmail(email);
        if (usuario == null) {
            return null;
        }
        if(usuario.getSenha().equals(senha)){
            return usuario;
        }
        return null;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

}
