package Classes;

public class Clientes {
    
    private int Id_Cliente;
    private String  nome_cliente;
    private String  CPF_CNPJ;
    private String  dta_nascimento;
    private String  endereco;
    private String  status_rede;
    private String  login;
    private String  senha;
    private int  id_planos;

    public int getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(int Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCPF_CNPJ() {
        return CPF_CNPJ;
    }

    public void setCPF_CNPJ(String CPF_CNPJ) {
        this.CPF_CNPJ = CPF_CNPJ;
    }

    public String getDta_nascimento() {
        return dta_nascimento;
    }

    public void setDta_nascimento(String dta_nascimento) {
        this.dta_nascimento = dta_nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus_rede() {
        return status_rede;
    }

    public void setStatus_rede(String status_rede) {
        this.status_rede = status_rede;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId_planos() {
        return id_planos;
    }

    public void setId_planos(int id_planos) {
        this.id_planos = id_planos;
    }
    
     
}
