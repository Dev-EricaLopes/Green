package Model;

import DAO.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Acao {
    
    private int id_acao;
    private String nome_acao;

    public Acao(String nome_acao) {
        this.nome_acao = nome_acao;
    }

    public int getId_acao() {
        return id_acao;
    }

    public void setId_acao(int id_acao) {
        this.id_acao = id_acao;
    }

    public String getNome_acao() {
        return nome_acao;
    }

    public void setNome_acao(String nome_acao) {
        this.nome_acao = nome_acao;
    }

    public Acao() {
    }

    public List<String> listarAcao () throws SQLException {
      
     String sql = "SELECT nome_acao FROM tb_acao";
                    List<String> listaAcoes = new ArrayList<>();

    try
    
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet resultSet = ps.executeQuery();
   
            
            
        while (resultSet.next()) {
               listaAcoes.add(resultSet.getString("nome_acao"));
                           
        }
    }
          return listaAcoes;
}

public void cadastrarAcao (Acao acao) throws SQLException {
      
     String sql = "INSERT INTO tb_acao (nome_acao) VALUES (?)";
        
        try
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nome_acao);
            ps.execute();}
         
        catch (SQLException e) {
        }
}
}
    
    
   