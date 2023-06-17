package Model;

import DAO.ConnectionFactory;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Local {
    
    private int id_local;
    private String nome_local;
    private String zona_local;
    private int id_zona;
    private int id_acao;
    private String endereco_local;
    private String telefone_local;

    public Local(int id_local, String nome_local, String zona_local, String endereco_local, String telefone_local) {
        this.id_local = id_local;
        this.nome_local = nome_local;
        this.zona_local = zona_local;
        this.endereco_local = endereco_local;
        this.telefone_local = telefone_local;
       
    }

    public Local() {
    }

    public int getId_zona() {
        return id_zona;
    }

    public void setId_zona(int id_zona) {
        this.id_zona = id_zona;
    }

    public int getId_acao() {
        return id_acao;
    }

    public void setId_acao(int id_acao) {
        this.id_acao = id_acao;
    }
    

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public String getNome_local() {
        return nome_local;
    }

    public void setNome_local(String nome_local) {
        this.nome_local = nome_local;
    }

    public String getZona_local() {
        return zona_local;
    }

    public void setZona_local(String zona_local) {
        this.zona_local = zona_local;
    }

    public String getEndereco_local() {
        return endereco_local;
    }

    public void setEndereco_local(String endereco_local) {
        this.endereco_local = endereco_local;
    }

    public String getTelefone_local() {
        return telefone_local;
    }

    public void setTelefone_local(String telefone_local) {
        this.telefone_local = telefone_local;
    }
    
        public List<String> listarZona () throws SQLException {
      
     String sql = "SELECT nome_zona FROM tb_zona";
                    List<String> listaZonas = new ArrayList<>();

    try
    
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
               listaZonas.add(resultSet.getString("nome_zona"));
                           
        }
    }
          return listaZonas;
}
  
        
        public void cadastrarLocal (Local cadastrar) throws SQLException {
      
     String sql = "INSERT INTO tb_local (nome_local, endereco_local, telefone_local, fk_id_acao, fk_id_zona) VALUES (?, ?, ?, ?, ?)";
        
        try
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nome_local);
            ps.setString(2, endereco_local);
            ps.setString(3, telefone_local);
            ps.setInt(4, id_acao);
            ps.setInt(5, id_zona);
           
            ps.execute();}
         
        catch (SQLException e) {
        }
  }   
        
        //retornar Local pelo ID
        public void retornaLocal (int idLocal) throws SQLException {
                    
            String sql = ("SELECT "
                    + "nome_local, "
                    + "endereco_local, " 
                    + "telefone_local "
                    + "FROM tb_local  where id_local = ?;");
            
            try(Connection conn = ConnectionFactory.obtemConexao())
            {
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setInt(1, idLocal); 
               System.out.println("id retorna sql - " + idLocal);


                ResultSet resultSet = ps.executeQuery();

                   while (resultSet.next()) {
                   nome_local = resultSet.getString("nome_local");
                   endereco_local = resultSet.getString("endereco_local");   
                   telefone_local = resultSet.getString("telefone_local"); 
                   
                   System.out.println("nome local - " + nome_local);
                   }

                
                 System.out.println(" sql - " + sql);
            }
            
        }
        
        
        public List<String> listarlocais () throws SQLException {
            List<String> listalocais = new ArrayList<>();
        
            String sql = ("SELECT"
                    + "nome_local, "
                    + "endereco_local, " 
                    + "telefone_local, "
                    + "FROM tb_local");
            try
    
            (Connection conn = ConnectionFactory.obtemConexao();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet resultSet = ps.executeQuery();

               while (resultSet.next()) {
               listalocais.add(resultSet.getString("nome_local"));
               listalocais.add(resultSet.getString("endereco_local"));   
               listalocais.add(resultSet.getString("telefone_local"));  
            }
            
            return listalocais;
            }
        }
}
            
     
   
        
        
                    
                    
                   
        
      
  
                
                
      
     
        
       
            
                 

        

