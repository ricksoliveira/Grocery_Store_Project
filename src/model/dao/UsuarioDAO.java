package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Usuario;

public class UsuarioDAO {
    
    //<editor-fold defaultstate="collapsed" desc="createUser() - Cria um Usuario novo na tabela Usuario">
    public void createUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO usuario (login_usuario, senha, admin) VALUES(?,?,?)");
            stmt.setString(1, u.getLogin_usuario());
            stmt.setString(2, u.getSenha());
            stmt.setInt(3, u.getAdmin());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="readUser() - Le todos os usuários do BD para a tabela da interface">
    public ArrayList<Usuario> readUser(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u1 = new Usuario();
                
                u1.setLogin_usuario(rs.getString("Login_Usuario"));
                u1.setSenha(rs.getString("Senha"));
                u1.setAdmin(rs.getInt("Admin"));
                
                usuarios.add(u1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return usuarios;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="updateUser() - Altera os dados do usuario na tabela Usuario">
    public void updateUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE usuario SET login_usuario = ?, senha = ?");
            stmt.setString(1, u.getLogin_usuario());
            stmt.setString(2, u.getSenha());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="deleteUser() - Deleta um usuario da tabela Usuario">
    public void deleteUser(Usuario u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM usuario WHERE login_usuario = ?");
            stmt.setString(1, u.getLogin_usuario());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuário!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="search() - Procura se uma string está contida em algum Login na tabela Usuario">
    public ArrayList<Usuario> search(String desc){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login_usuario LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario u1 = new Usuario();
                u1.setLogin_usuario(rs.getString("Login_Usuario"));
                u1.setSenha(rs.getString("Senha"));
                
                usuarios.add(u1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return usuarios;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="authUser() - Autentica na tabela Usuario para login">
    public boolean authUser(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean auth = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login_usuario = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                auth = true;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return auth;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="authAdmins() - Autentica na tabela Usuario apenas os Admins">
    public boolean authAdmins(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean auth = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login_usuario = ? and senha = ? and admin = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setInt(3, 0);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                auth = true;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Este usuário não possui privilégios de administrador!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return auth;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="authCaixa() - Autentica na tabela Usuario apenas os Caixas">
    public boolean authCaixa(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean auth = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE login_usuario = ? and senha = ? and admin = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.setInt(3, 2);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                auth = true;
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Este usuário não possui privilégios de administrador!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return auth;
    }
//</editor-fold>
    
}
