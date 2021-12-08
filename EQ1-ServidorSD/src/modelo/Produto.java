package modelo;

import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = -1267316262872583373L;

    private String uuid;
    private String titulo;
    private String descricao;
    private String uuidUsuario;
    private float valor;
    private String categoria;
    private char flagSP;
    private char flagVDT;
    private boolean negociado;

    public Produto(String uuid, String titulo, String descricao,
            String uuidUsuario, float valor, String categoria,
            char flagSP, char flagVDT, boolean negociado) {
        this.uuid = uuid;
        this.titulo = titulo;
        this.descricao = descricao;
        this.uuidUsuario = uuidUsuario;
        this.valor = valor;
        this.categoria = categoria;
        this.flagSP = flagSP;
        this.flagVDT = flagVDT;
        this.negociado = negociado;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUuidUsuario() {
        return uuidUsuario;
    }

    public void setUuidUsuario(String uuidUsuario) {
        this.uuidUsuario = uuidUsuario;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public char getFlagSP() {
        return flagSP;
    }

    public void setFlagSP(char flagSP) {
        this.flagSP = flagSP;
    }

    public char getFlagVDT() {
        return flagVDT;
    }

    public void setFlagVDT(char flagVDT) {
        this.flagVDT = flagVDT;
    }

    public boolean isNegociado() {
        return negociado;
    }

    public void setNegociado(boolean negociado) {
        this.negociado = negociado;
    }

}
