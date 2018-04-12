/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heranca;

/**
 *
 * @author luiz
 */
public class PessoaFisica extends Pessoa {
    String RG;
    String CPF;
 
    public PessoaFisica(String nome, String telefone, String endereco, String RG, String CPF) {
        super (nome, telefone, endereco);
        this.RG = RG;
        this.CPF = CPF;
    }
    
    @Override
    public String toString(){
        return super.toString()
                + "<br><b>RG:</b> " + this.RG
                + "<br><b>CPF:</b> " + this.CPF;
    }
}
