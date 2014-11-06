/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import beans.Usuario;



/**
 *
 * @author celiobj
 */
public interface RepositorioLicencaInterface {

    public void bloquear(String cod, Usuario usu);

    public void liberar(String cod, Usuario usu);

    public void inserir(Usuario usu);

    public int pegarCodLicenca(Usuario usu);

    public int pegarStatusLicenca(String cod, Usuario usu);

}
