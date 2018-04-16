/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

/**
 *
 * @author Aluno
 */
public class CampoVazioException extends Exception{
    private final String msg;
    public CampoVazioException(String msg, String cause) {
        super(msg, new Exception(cause));
        this.msg = msg;
    }
 
    public String getMsg() {
        return msg;

    }
}
