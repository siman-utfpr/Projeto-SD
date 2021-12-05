package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class BancoDados implements Serializable {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private static BancoDados bancoDados = null;

    private BancoDados() {
    }

    public static BancoDados getInstance() {
        if (bancoDados == null) {
            bancoDados = carregarEstadoSalvo();
            return bancoDados;
        } else {
            return bancoDados;
        }
    }

    private static BancoDados carregarEstadoSalvo() {
        BancoDados bd;
        ObjectInputStream objectIn = null;
        try {
            objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("bancodados.dat"))));
            bd = (BancoDados) objectIn.readObject();
            objectIn.close();
            return bd;
        } catch (IOException | ClassNotFoundException ex) {
            //ex.printStackTrace();
            return new BancoDados();
        }
    }

    public void salvarEstadoAtual() throws IOException {
        ObjectOutputStream objectOut = null;
        objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("bancodados.dat")));
        objectOut.writeObject(bancoDados);
        objectOut.close();
    }
}
