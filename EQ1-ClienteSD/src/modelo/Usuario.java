package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class Usuario {


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