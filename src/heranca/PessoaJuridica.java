/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heranca;

/**
 *
 * @author luiz
 */
public class PessoaJuridica extends Pessoa {
    private String IE;
    private String CNPJ;
 
    public PessoaJuridica(String nome, String telefone, String endereco, String IE, String CNPJ) {
        super (nome, telefone, endereco);
        this.IE = IE;
        this.CNPJ = CNPJ;
    }

    public String getIE() {
        return IE;
    }

    public void setIE(String IE) {
        this.IE = IE;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
    
    
    
    @Override
    public String toString(){
        return super.toString()
                + "<br><b>IE:</b> " + this.IE
                + "<br><b>CNPJ:</b> " + this.CNPJ;
    }
}

