package models;

public class Usuario{

  private int id;
  private String login;
  private String senha;

  public Usuario(int id, String login, String senha){
    this.id = id;
    this.login = login;
    this.senha = senha;
  }

  public void setId(int id){
    this.id = id;
  }

  public void setLogin(String login){
    this.login = login;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }

  public int getId(){
    return id;
  }

  public String getLogin(){
    return login;
  }

  public String getSenha(){
    return senha;
  }
}
