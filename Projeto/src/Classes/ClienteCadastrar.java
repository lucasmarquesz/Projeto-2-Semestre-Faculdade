package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClienteCadastrar {
    
    //Conexao com o banco
    private Connection conecta;
    public ClienteCadastrar(){
        this.conecta = new Conexao().conectaBD();
    }
    
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<Clientes> lista = new ArrayList<>();
    
    public void cadastrarCliente(Clientes objCliente){
        
        String SQL = "insert into cliente(nome, cpf_cpj, dta_nascimento, endereco, status_rede, login, senha, id_plano) values(?, ?, ?, ?, ?, ?, ?, ?)";
        
        conecta = new Conexao().conectaBD();
        
        try{
            pstm = conecta.prepareStatement(SQL);
            pstm.setString(1, objCliente.getNome_cliente());
            pstm.setString(2, objCliente.getCPF_CNPJ());
            pstm.setString(3, objCliente.getDta_nascimento());
            pstm.setString(4, objCliente.getEndereco());
            pstm.setString(5, objCliente.getStatus_rede());
            pstm.setString(6, objCliente.getLogin());
            pstm.setString(7, objCliente.getSenha());
            pstm.setInt(8, objCliente.getId_planos());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro realizado com Sucesso");
           
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, "erro:" + erro);
        }
                
  
        
    }
    
    public void Excluir_cliente(Clientes objCliente){
            
        String SQL = "delete from cliente where id_cliente = ?";
        conecta = new Conexao().conectaBD();
        
        try{
             pstm = conecta.prepareStatement(SQL);
             pstm.setInt(1, objCliente.getId_Cliente());
             
             pstm.execute();
             pstm.close();
        }
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null,"O erro é "+ erro);
            
        }
        }
    
    public ArrayList<Clientes> ListarClientes(){
        String SQL = "Select * from cliente";
        
        try{
            pstm = conecta.prepareStatement(SQL);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                Clientes ObjListar = new Clientes();
                ObjListar.setId_Cliente(rs.getInt("id_cliente"));
                ObjListar.setNome_cliente(rs.getString("nome"));
                ObjListar.setCPF_CNPJ(rs.getString("cpf_cpj"));
                ObjListar.setDta_nascimento(rs.getString("dta_nascimento"));
                ObjListar.setEndereco(rs.getString("endereco"));
                ObjListar.setStatus_rede(rs.getString("status_rede"));
                ObjListar.setLogin(rs.getString("login"));
                ObjListar.setSenha(rs.getString("senha"));
                ObjListar.setId_planos(rs.getInt("id_plano"));
                
                lista.add(ObjListar);
            }
            
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null,"O erro é" + erro);
        }
        
        return lista;
        
    }
    
    
    public void AlterarCliente(Clientes objCliente){
        String sql = "update cliente set nome = ?, endereco = ?, login = ?, cpf_cpj = ?, senha = ?, status_rede = ?, id_plano = ? where id_cliente = ?";
        
        conecta = new Conexao().conectaBD();
        
        try{
            pstm = conecta.prepareStatement(sql);
            pstm.setString(1, objCliente.getNome_cliente());
            pstm.setString(2, objCliente.getEndereco());
            pstm.setString(3, objCliente.getLogin());
            pstm.setString(4, objCliente.getCPF_CNPJ());
            pstm.setString(5, objCliente.getSenha());
            pstm.setString(6, objCliente.getStatus_rede());
            pstm.setInt(7, objCliente.getId_planos());
            pstm.setInt(8, objCliente.getId_Cliente());
            
            pstm.execute();
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "Alteração realizado com Sucesso");
           
        }
        catch(Exception erro){
            JOptionPane.showMessageDialog(null, "erro:" + erro);
        }
    }
    
    
}
