/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author florentino-ariza
 */
public class ServicoProduto {
      
    private String nome;
    
    private Float preco;
    
    private String uuid;
    
    private SPCategoria categoria;
    
    private FlagSP flagSP;
    
    private FlagVDT flagVDT;
    
    private FlagStatus flagStatus;
    
    private Usuario usuario;
    
    public ServicoProduto() {
        nome = null;
        preco = null;
        uuid = null;
        categoria = null;
        flagSP = null;
        flagVDT = null;
        flagStatus = null;
        usuario = null;
    }
    
    public ServicoProduto(String nome, Float preco, String uuid, SPCategoria categoria, FlagSP flagSP, FlagVDT flagVDT, 
            FlagStatus flagStatus, Usuario usuario) {
        this.nome = nome;
        this.preco = preco;
        this.uuid = uuid;
        this.categoria = categoria;
        this.flagSP = flagSP;
        this.flagVDT = flagVDT;
        this.flagStatus = flagStatus;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public SPCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(SPCategoria categoria) {
        this.categoria = categoria;
    }

    public FlagSP getFlagSP() {
        return flagSP;
    }

    public void setFlagSP(FlagSP flagSP) {
        this.flagSP = flagSP;
    }

    public FlagVDT getFlagVDT() {
        return flagVDT;
    }

    public void setFlagVDT(FlagVDT flagVDT) {
        this.flagVDT = flagVDT;
    }

    public FlagStatus getFlagStatus() {
        return flagStatus;
    }

    public void setFlagStatus(FlagStatus flagStatus) {
        this.flagStatus = flagStatus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
       
}
