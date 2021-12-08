/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Produto;
import modelo.Usuario;

/**
 *
 * @author luiss
 */
public class Teste {

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        for (Produto p : produtoDAO.buscarProdutos()) {
            System.out.println(p.getTitulo() + " - " + p.getFlagSP() + " - " + p.getUuidUsuario());
        }
        
        for (Usuario u : usuarioDAO.buscarUsuarios()) {
            System.out.println(u.getEmail()+ " - " + u.getUuid());
        }
    }

}
