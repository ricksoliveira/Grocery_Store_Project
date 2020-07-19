package model.bean;

public class Usuario {
    
    private String login_usuario;
    private String senha;
    private int admin;
    
    
    public String getLogin_usuario(){
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario){
        this.login_usuario = login_usuario;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public int getAdmin(){
        return admin;
    }

    public void setAdmin(int admin){
        this.admin = admin;
    }
    
}
