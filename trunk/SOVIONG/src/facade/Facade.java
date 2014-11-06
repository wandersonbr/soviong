/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facade;

import javax.swing.JTable;

import persistencia.RepositorioLicenca;
import persistencia.RepositorioUsuario;
import beans.Usuario;



/**
 *
 * @author celiobj
 */
public class Facade {
    
    
    RepositorioUsuario rusu;
    RepositorioLicenca rlic;
        
   
    
     //=================Usuario=======================
    
    public void adcionar_Usuario(Usuario usu){
        rusu = new RepositorioUsuario();
        rusu.adcionar(usu);
        
    }

    public void alterar_Usuario(Usuario usu){
        rusu = new RepositorioUsuario();
        rusu.alterar(usu);
        
    }

    public Usuario procurar_Usuario(String nome){
        rusu = new RepositorioUsuario();
        return rusu.procurar(nome);
        
    }

    public String validar_Usuario(String nome, String senha){
        rusu = new RepositorioUsuario();
        return rusu.validar(nome, senha);
        
    }

    public void remover_Usuario(Usuario usu){
        rusu = new RepositorioUsuario();
        rusu.remover(usu);
        
    }

    public JTable consultarTodos_Usuario(){
        rusu = new RepositorioUsuario();
        return rusu.consultarTodos();
        
    }
    
//=================Licenca=======================
    
    public void bloquear_Licenca(String cod, Usuario usu){
        rlic = new RepositorioLicenca();
        rlic.bloquear(cod,usu);
        
    }

    public void liberar_Licenca(String cod, Usuario usu){
        rlic = new RepositorioLicenca();
        rlic.liberar(cod,usu);
        
    }

    public void inserir_Licenca(Usuario usu){
        rlic = new RepositorioLicenca();
        rlic.inserir(usu);
        
    }

    public int pegarCodLicenca_Licenca(Usuario usu){
        rlic = new RepositorioLicenca();
        return rlic.pegarCodLicenca(usu);
        
    }

    public int pegarStatusLicenca_Licenca(String cod, Usuario usu){
        rlic = new RepositorioLicenca();
        return rlic.pegarStatusLicenca(cod,usu);
        
    }

   
}
    

