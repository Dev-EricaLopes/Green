package Model;

import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario() {
    }
    
    public boolean Entrar(Usuario usu) throws SQLException 
    {
        String sql = "SELECT * FROM tb_usuario WHERE email = ? AND senha= ?";
        try 
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, email);
            ps.setString(2, senha);
            try (ResultSet rs = ps.executeQuery())
            {
                return rs.next();
            }
                    }
        catch (Exception e){
            e.printStackTrace();
        }
            return false;
    }

  public void cadastrarUsuario (Usuario cadastrar) throws SQLException {
      
     String sql = "INSERT INTO tb_usuario (nome, email, senha) VALUES (?, ?, ?)";
        
        try
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.setString(3, senha);
            ps.execute();}
         
        catch (SQLException e) {
        }
  }
}
                
            









    

