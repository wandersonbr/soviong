/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import beans.Usuario;
import javax.swing.JTable;

/**
 *
 * @author celio
 */
public interface RepositorioUsuarioInterface {

    public void adcionar(Usuario usu);

    public void alterar(Usuario usu);

    public Usuario procurar(String nome);

    public String validar(String nome, String senha);

    public void remover(Usuario usu);

    public JTable consultarTodos();

}
