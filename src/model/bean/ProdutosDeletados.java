package model.bean;

public class ProdutosDeletados {
    
    private int id_produto_del;
    private String responsavel;
    private String descricao_del;
    private int quantidade_del;
    private double preco_del;
    
    
    public int getId_produto_del(){
        return id_produto_del;
    }

    public void setId_produto_del(int id_produto_del){
        this.id_produto_del = id_produto_del;
    }

    public String getResponsavel(){
        return responsavel;
    }

    public void setResponsavel(String responsavel){
        this.responsavel = responsavel;
    }

    public String getDescricao_del() {
        return descricao_del;
    }

    public void setDescricao_del(String descricao_del){
        this.descricao_del = descricao_del;
    }

    public int getQuantidade_del() {
        return quantidade_del;
    }

    public void setQuantidade_del(int quantidade_del){
        this.quantidade_del = quantidade_del;
    }

    public double getPreco_del() {
        return preco_del;
    }

    public void setPreco_del(double preco_del){
        this.preco_del = preco_del;
    }
    
}
