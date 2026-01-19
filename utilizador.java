package TRABALHOMDS2.BackendMDS;

public class utilizador {
    private String nome;
    private String email;
    private String password;

    public utilizador(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public boolean autenticar() {
        // Implementação simplificada para o exemplo
        return true;
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

    public String getPassword() {
        return password;
    }
}
