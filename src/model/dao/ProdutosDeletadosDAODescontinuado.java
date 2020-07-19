package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.ProdutosDeletados;

public class ProdutosDeletadosDAODescontinuado {
    
    //<editor-fold defaultstate="collapsed" desc="Cria um item na tabela Produtos Deletados">
    public void create(ProdutosDeletados p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produtos_deletados (responsavel, descricao_del, quantidade_del, preco_del) VALUES(?,?,?,?)");
            stmt.setString(1, p.getResponsavel());
            stmt.setString(2, p.getDescricao_del());
            stmt.setInt(3, p.getQuantidade_del());
            stmt.setDouble(4, p.getPreco_del());
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao deletar!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Le os itens da tabela de Produtos Deletados">
    public ArrayList<ProdutosDeletados> readDel(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<ProdutosDeletados> deletados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos_deletados");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutosDeletados pdel1 = new ProdutosDeletados();
                
                pdel1.setResponsavel(rs.getString("Responsavel"));
                pdel1.setId_produto_del(rs.getInt("ID_Produto_Del"));
                pdel1.setDescricao_del(rs.getString("Descricao_Del"));
                pdel1.setQuantidade_del(rs.getInt("Quantidade_Del"));
                pdel1.setPreco_del(rs.getDouble("Preco_Del"));
                
                deletados.add(pdel1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return deletados;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Deleta um produto dos deletados (e restaura na base de dados)">
    public void delete(ProdutosDeletados p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM produtos_deletados WHERE id_produto_del = ?");
            stmt.setInt(1, p.getId_produto_del());
            
            stmt.executeUpdate();
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao restaurar!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Pesquisa se uma string consta no nome de algum Produto Deletados">
    public ArrayList<ProdutosDeletados> searchDel(String desc){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<ProdutosDeletados> deletados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produtos_deletados WHERE descricao_del LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ProdutosDeletados pdel = new ProdutosDeletados();
                pdel.setId_produto_del(rs.getInt("ID_Produto_del"));
                pdel.setDescricao_del(rs.getString("Descricao_del"));
                pdel.setQuantidade_del(rs.getInt("Quantidade_del"));
                pdel.setPreco_del(rs.getDouble("Preco_del"));
                
                deletados.add(pdel);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return deletados;
    }
//</editor-fold>

}
