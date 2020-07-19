package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AdminDAODescontinuado {
    
    //<editor-fold defaultstate="collapsed" desc="Autentica o login do admin">
    public boolean auth(String login, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean auth = false;
        
        try{
            stmt = con.prepareStatement("SELECT * FROM admin WHERE login_admin = ? and senha = ?");
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
    
}
