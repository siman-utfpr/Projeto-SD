/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao.util;

import java.util.ArrayList;
import modelo.FlagSP;
import modelo.FlagStatus;
import modelo.FlagVDT;
import modelo.ServicoProduto;
import modelo.SPCategoria;
import modelo.Usuario;

/**
 *
 * @author florentino-ariza
 */
public class GerenciadorServicoProduto {

    // Executa para as viões coisas relacionadas aos produtos,
    // exemplo: busque todos os produtos disponíveis para venda, etc
    public static ArrayList<ServicoProduto> getProdutos() {
        ArrayList<ServicoProduto> produtosServicos = new ArrayList<>();

        Usuario u1 = new Usuario("012f", "Cacá", "cacazinho99", "dbz123");
        Usuario u2 = new Usuario("012fg", "Luan Santana", "ls@ig.com", "corinthians123");

        produtosServicos.add(new ServicoProduto("Cachorro de plástico", 40.0f, "00", SPCategoria.LAZER, FlagSP.P, FlagVDT.V, FlagStatus.A, u1));
        produtosServicos.add(new ServicoProduto("Palhaço de aniversário", 399.99f, "01", SPCategoria.LAZER, FlagSP.S, FlagVDT.V, FlagStatus.A, u1));
        produtosServicos.add(new ServicoProduto("Luis Siman", null, "02", SPCategoria.LAZER, FlagSP.S, FlagVDT.D, FlagStatus.A, u2));
        produtosServicos.add(new ServicoProduto("Cachorro de plástico", 40.0f, "00", SPCategoria.LAZER, FlagSP.P, FlagVDT.V, FlagStatus.A, u1));

        return produtosServicos;
    }

    public static void excluirServicoProduto(ServicoProduto servicoProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void abrirFecharServicoProduto(ServicoProduto servicoProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
