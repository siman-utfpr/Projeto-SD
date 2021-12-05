package modelo;

public class ClienteLogado {
    
    private String ip;
    private int porta;
    private Usuario usuario;

    public ClienteLogado(String ip, int porta, Usuario usuario) {
        this.ip = ip;
        this.porta = porta;
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    

}
