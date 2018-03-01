package exerciciobingo;

public class Jogador {
    private String nome;
    private Cartela[] cartelas;

    public Jogador(String nome, Cartela[] cartelas){
        this.nome = nome;
        this.cartelas = cartelas;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cartela[] getCartelas() {
        return cartelas;
    }

    public void setCartelas(Cartela[] cartelas) {
        this.cartelas = cartelas;
    }
}
