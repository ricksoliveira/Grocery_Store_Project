package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Produto;

public class ProdutoDAO {
    
    //<editor-fold defaultstate="collapsed" desc="create() - Cria um item na tabela Produto">
    public void create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO produto (criacao, descricao, quantidade, preco, status) VALUES(?,?,?,?,?)");
            stmt.setString(1, p.getCriacao());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getPreco());
            stmt.setString(5, "ativo");
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto adicionado à Base de Dados.");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao adicionar!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
        
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="read() - Lê os produtos com status ATIVO">
    public ArrayList<Produto> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE status = ?");
            stmt.setString(1, "ativo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p1 = new Produto();
                
                p1.setStatus(rs.getString("Status"));
                p1.setAlteracao(rs.getString("Alteracao"));
                p1.setCriacao(rs.getString("Criacao"));
                p1.setId(rs.getInt("ID_Produto"));
                p1.setDescricao(rs.getString("Descricao"));
                p1.setQuantidade(rs.getInt("Quantidade"));
                p1.setPreco(rs.getDouble("Preco"));
                
                produtos.add(p1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return produtos;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="update() - Atualiza um item na tabela Produto">
    public void update(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE produto SET alteracao = ?, descricao = ?, quantidade = ?, preco = ? WHERE id_produto = ?");
            stmt.setString(1, p.getAlteracao());
            stmt.setString(2, p.getDescricao());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="delete() - Modifica o status de ATIVO para INATIVO">
    public void delete(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE produto SET status = ? WHERE id_produto = ?");
            stmt.setString(1, "inativo");
            stmt.setInt(2, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="deleteAll() - Exclui todos os itens da tabela Produto">
    public void deleteAll(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM produto");
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Todos os produtos foram excluídos!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold> // descontinuado
    
    //<editor-fold defaultstate="collapsed" desc="search() - Pesquisa se uma string consta no nome de algum Produto com status ATIVO">
    public ArrayList<Produto> search(String desc){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ? and status = ?");
            stmt.setString(1, "%" + desc + "%");
            stmt.setString(2, "ativo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p1 = new Produto();
                p1.setId(rs.getInt("ID_Produto"));
                p1.setDescricao(rs.getString("Descricao"));
                p1.setQuantidade(rs.getInt("Quantidade"));
                p1.setPreco(rs.getDouble("Preco"));
                
                produtos.add(p1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return produtos;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="readAcabando() - Lê os produtos com quantidade <= 20 da tabela Produtos com status ATIVO">
    public ArrayList<Produto> readAcabando(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT id_produto, descricao, quantidade FROM produto WHERE quantidade <= 20 and status = ?");
            stmt.setString(1, "ativo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p1 = new Produto();
                
                p1.setId(rs.getInt("ID_Produto"));
                p1.setDescricao(rs.getString("Descricao"));
                p1.setQuantidade(rs.getInt("Quantidade"));
                
                produtos.add(p1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return produtos;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="quantidadeTotal() - Soma todas as quantidades de todos os produtos com status ATIVO na tabela Produtos">
    public int quantidadeTotal(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            stmt = con.prepareStatement("SELECT SUM(quantidade) FROM produto WHERE status = ?");
            stmt.setString(1, "ativo");
            rs = stmt.executeQuery();
            rs.next();
            
            String sum = rs.getString(1);
            total = Integer.parseInt(sum);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!\n" + ex);
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Não há itens cadatrados ou ativos!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return total;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="quantidadeTipos() - Conta quantos produtos com status ATIVO estão na tabela Produtos">
    public int quantidadeTipos(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int total = 0;
        try{
            stmt = con.prepareStatement("SELECT COUNT(*) FROM produto WHERE status = ?");
            stmt.setString(1, "ativo");
            rs = stmt.executeQuery();
            rs.next();
            
            String sum = rs.getString(1);
            total = Integer.parseInt(sum);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        
        return total;
    }
//</editor-fold>
    
    // Métodos específicos dos produtos deletados //
    
    //<editor-fold defaultstate="collapsed" desc="readDel() - Le os Produtos INATIVOS da tabela produtos">
    public ArrayList<Produto> readDel(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE status = ?");
            stmt.setString(1, "inativo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p1 = new Produto();
                
                p1.setStatus(rs.getString("Status"));
                p1.setAlteracao(rs.getString("Alteracao"));
                p1.setCriacao(rs.getString("Criacao"));
                p1.setId(rs.getInt("ID_Produto"));
                p1.setDescricao(rs.getString("Descricao"));
                p1.setQuantidade(rs.getInt("Quantidade"));
                p1.setPreco(rs.getDouble("Preco"));
                
                produtos.add(p1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return produtos;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="restaura() - Seta o status INATIVO para ATIVO na tabela produtos">
    public void restaura(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE produto SET status = ?, criacao = ? WHERE id_produto = ?");
            stmt.setString(1, "ativo");
            stmt.setString(2, p.getCriacao());
            stmt.setInt(3, p.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir!\n" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="searchDel() - Checa uma string específica na descrição dos INATIVOS">
    public ArrayList<Produto> searchDel(String desc){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ? and status = ?");
            stmt.setString(1, "%" + desc + "%");
            stmt.setString(2, "inativo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Produto p1 = new Produto();
                p1.setId(rs.getInt("ID_Produto"));
                p1.setDescricao(rs.getString("Descricao"));
                p1.setQuantidade(rs.getInt("Quantidade"));
                p1.setPreco(rs.getDouble("Preco"));
                
                produtos.add(p1);
                
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro!" + ex);
        }
        finally{
            ConnectionFactory.closeConnection((com.mysql.jdbc.Connection) con, stmt, rs);
        }
        return produtos;
    }
//</editor-fold>
    
}
