/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.Cliente;

/**
 *
 * @author Rafael
 */
public class Implementacao extends UnicastRemoteObject implements Interface{
    
    public Implementacao()throws RemoteException{}
    
    
    @Override
    public String inserirCliente(Cliente cliente){
        try {
            Conexao conexao = new Conexao();
            String sql = "INSERT INTO Pessoa (nomeCliente,cpfCliente,telefoneCliente,e-mailCliente"
                    + "enderecoCliente) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conexao.con.prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getCpf());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4,cliente.getEmail());
            ps.setString(5,cliente.getEndereco());            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return "Inserido Com sucesso!";
    }
    
    public String removerCliente(Cliente cliente){
        try {
         Conexao conexao = new Conexao();
         String sql = "delete from produto where idProduto = ?";
         PreparedStatement ps = conexao.con.prepareStatement(sql);
         ps.setInt(1,cliente.getCodigo());
         
          JOptionPane.showMessageDialog(null," Exclusão realizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null," Erro ao excluir!"+ ex);
        }        
        return null;
        
    
    }
}
