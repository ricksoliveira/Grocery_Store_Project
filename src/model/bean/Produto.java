package model.bean;

public class Produto {
    
    private int id;
    private String criacao;
    private String alteracao;
    private String descricao;
    private int quantidade;
    private double preco;
    private String status;
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }

    public String getCriacao(){
        return criacao;
    }

    public void setCriacao(String criacao){
        this.criacao = criacao;
    }

    public String getAlteracao(){
        return alteracao;
    }

    public void setAlteracao(String alteracao){
        this.alteracao = alteracao;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    
    
}
