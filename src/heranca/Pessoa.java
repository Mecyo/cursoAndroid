package heranca;

/**
 *
 * @author Emerson Santos
 */
public class Pessoa {
    String nome;
    String telefone;
    String endereco;
 
    public Pessoa() {
        nome = "";
        telefone = "";
        endereco = "";
    }
    public Pessoa(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    @Override
    public String toString(){
        return "<html><b>Nome:</b> " + this.nome
                + "<br><b>Telefone:</b> " + this.telefone
                + "<br><b>Endereco:</b> " + this.endereco;
    }
}
