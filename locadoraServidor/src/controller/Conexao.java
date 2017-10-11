/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rafael
 */
public class Conexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/lojavendas";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
            
        }catch (ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    public static void closeConnenction(Connection con){
        try{
            if (con != null){
                con.close();
            }
            
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnenction(con);
        try{
            if(stmt != null){
                stmt.close();
            }
        }catch (SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        
        try{
            if(rs != null){
                rs.close();
            }
        }catch (SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    }

//    public Connection con;
//    public Conexao() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String url= "jdbc:mysql://localhost:3306/locadorafilme";
//            String usuario = "root";
//            String senha = "root";
//            con = DriverManager.getConnection(url, usuario, senha);
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }