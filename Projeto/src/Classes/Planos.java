package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.List;


public class Planos {
   
    //criando getters e setters
    private int Id;
    private String Nome;
    private String Data;
    private String Valor;
    private String Gigas;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getGigas() {
        return Gigas;
    }

    public void setGigas(String Gigas) {
        this.Gigas = Gigas;
    }
    
    @Override
    public String toString(){
        return this.getNome();
    }
    

   
    
    //Conectando com a classe Conexao e buscando a conexao com o banco de dados
    private Connection conecta;
    public Planos(){
        this.conecta = new Conexao().conectaBD();
    }
    
    //metodo de listar os planos
    public List<Planos> listaPlanos(){
        
        try{
            List<Planos> lista = new ArrayList();
            
            String sql = "Select * from planos";
            
            PreparedStatement stmt = conecta.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            
            Planos obj = new Planos();
            
            obj.setId(rs.getInt("id_planos"));
            obj.setNome(rs.getString("nome_plano"));
            obj.setData(rs.getString("data_pagamento"));
            obj.setValor(rs.getString("valor"));
            obj.setGigas(rs.getString("gigas"));
            
            lista.add(obj);
        }
            
      return lista;
         
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "erro:" + erro);
        return null;
    }
  }
}

