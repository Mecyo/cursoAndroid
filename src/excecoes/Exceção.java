package excecoes;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Emerson santos
 */
public class Exceção {
    
    public static void exemplo(String campo) throws CampoVazioException {
        if (campo.isEmpty()) {
            throw new CampoVazioException("Campo Vazio. O campo nao pode estar vazio",
                    "O campo nao pode estar vazio");
        }
    }
    
    public static void validaData(String pDia, String pMes, String pAno) throws CampoVazioException, DataInvalidaException {
        if (pDia.isEmpty()) {
            throw new CampoVazioException("O campo dia não pode estar vazio", "");
        } else if (pMes.isEmpty()) {
            throw new CampoVazioException("O campo mês não pode estar vazio", "");
        } else if (pAno.isEmpty()) {
            throw new CampoVazioException("O campo ano não pode estar vazio", "");
        }

        Integer ano, dia, mes;
        try {
            dia = Integer.parseInt(pDia);
            mes = Integer.parseInt(pMes);
            ano = Integer.parseInt(pAno);

            List<Integer> meses31Dias = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
            List<Integer> meses30Dias = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
            List<Integer> meses = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
            DataInvalidaException validaData = null;

            if (ano < 1) {
                validaData = new DataInvalidaException("O ano informado é inválido!", "");
            }
            if (!meses.contains(mes)) {
                validaData = new DataInvalidaException("O mês informado é inválido!", "");
            }
            if (dia < 1) {
                validaData = new DataInvalidaException("O dia informado é inválido!", "");
            } else if ((!meses31Dias.contains(mes) && dia > 31) || (!meses30Dias.contains(mes) && dia > 30)) {
                validaData = new DataInvalidaException("O dia informado é inválido!", "");
            } else if (mes == 2) {
                if ((!anoIsBissexto(ano) && dia > 28) || (anoIsBissexto(ano) && dia > 29)) {
                    validaData = new DataInvalidaException("O dia informado é inválido!", "");
                }
            }

            if (validaData != null) {
                throw validaData;
            }

        } catch (NumberFormatException | DataInvalidaException e) {
            throw e;
        }
    }
    
    private static Boolean anoIsBissexto(Integer ano) {
        if((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0 && ano % 100 == 0)) 
            return true;
        
        return false;
    }
}
    
    


