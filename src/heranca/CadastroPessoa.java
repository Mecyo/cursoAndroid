package heranca;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Emerson Santos
 */
public class CadastroPessoa {
    
    public static int cont = 0;
    javax.swing.JFrame tela;
    Pessoa[] p = new Pessoa[5];

    public CadastroPessoa(JFrame tela) {
        this.tela = tela;
    }
    
    public Boolean cadastrar(Pessoa pessoa, int posicao) {
        if(posicao != -1){
            p[posicao] = pessoa;
            return true;
        }else{
            if (pessoa == null) {
                openMessage("Cadastro com erros! Favor verificar", "Erro!");
                return false;
            } else if (cont >= 5) {
                openMessage("Limite excedido!", "Erro!");
                return false;
            } else if (validaCPFCNPJ(pessoa)) {
                p[cont] = pessoa;
                cont++;
                return true;
            }
        }
        return false;
    }
    
    public Boolean validaCPFCNPJ(Pessoa pessoa) {
        for (int i = 0; i < cont; i++) {
            if ((pessoa instanceof PessoaFisica) && (p[i] instanceof PessoaFisica)) {
                if(((PessoaFisica) p[i]).CPF.equalsIgnoreCase(((PessoaFisica) pessoa).CPF)){
                    openMessage("CPF já cadastrado!", "ERRO!");
                    return false;
                }
            }else if ((pessoa instanceof PessoaJuridica) && (p[i] instanceof PessoaJuridica)) {
                if(((PessoaJuridica) p[i]).CNPJ.equalsIgnoreCase(((PessoaJuridica) pessoa).CNPJ)){
                    openMessage("CNPJ já cadastrado!", "ERRO!");
                    return false;
                }
            }
        }
        return true;
    }
    
    private void openMessage(String msg, String tipo){
        JOptionPane.showMessageDialog(this.tela,
        msg, tipo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public DefaultListModel<Pessoa> pesquisa(String documento){
        DefaultListModel<Pessoa> model = new DefaultListModel<Pessoa>();
        
        if(documento.equalsIgnoreCase(""))
            for(int i = 0; i < cont; i++)
                model.addElement(p[i]);
        else   
            for(int i = 0; i < cont; i++){
                if ((p[i] instanceof PessoaFisica) && (((PessoaFisica) p[i]).CPF.equalsIgnoreCase(documento)))
                    model.addElement(p[i]);
                else if ((p[i] instanceof PessoaJuridica) && (((PessoaJuridica) p[i]).CNPJ.equalsIgnoreCase(documento)))
                    model.addElement(p[i]);
            }
        return model;
    }

    public int getIndex(Pessoa pessoa) {
        for(int i = 0; i < cont; i++)
            if(p[i].equals(pessoa))
                return i;
        
        return -1;
    }
}
