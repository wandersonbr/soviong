/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import beans.Usuario;
import dao.AccessDatabase;
import funcoes.funcoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;

/**
 *
 * @author celio
 */
public class RepositorioUsuario implements RepositorioUsuarioInterface {

    @Override
    public void adcionar(Usuario usu) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO `usuarios` (`login`, `senha`, `tipo`) VALUES ('" + usu.getNome() + "', '" + usu.getSenha() + "', '" + usu.getTipo() + "');");
        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String validar(String nome, String senha) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE login = '" + nome + "'");
            rs.next();
            if (rs.getRow() == 0) {
                con.close();
                return "0";
            } else {

                Usuario usu = new Usuario();
                usu.setNome(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getInt("tipo"));
                if (usu.getSenha().equals(senha)) {
                    con.close();
                    return "1";
                } else {
                    con.close();
                }
                return "2";
            }
        } catch (SQLException t) {
            System.out.println(t.getMessage());
            return null;

        }
    }

    @Override
    public void remover(Usuario usu) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Usuario procurar(String nome) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE login = '" + nome + "'");
            rs.next();
            if (rs.getRow() == 0) {
                con.close();
                return null;
            } else {

                Usuario usu = new Usuario();
                usu.setNome(rs.getString("login"));
                usu.setSenha(rs.getString("senha"));
                usu.setTipo(rs.getInt("tipo"));
                con.close();
                return usu;
            }
        } catch (SQLException t) {
            System.out.println(t.getMessage());
            return null;

        }

    }

    @Override
    public JTable consultarTodos() {

        try {
            Vector<String> cabecalho = new Vector<String>();
            @SuppressWarnings("rawtypes")
			Vector<Vector<Comparable>> linhas = new Vector<Vector<Comparable>>();
            AccessDatabase a = new AccessDatabase();
            JTable tabela;
            try (Connection con = a.conectar()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM usuarios ORDER BY idusuarios");
                rs.next();
                ResultSetMetaData rsmd = rs.getMetaData();
                cabecalho.addElement("Cód");
                cabecalho.addElement("Login");
                cabecalho.addElement("Senha");
                cabecalho.addElement("Tipo");

                do {
                    linhas.addElement(funcoes.proximaLinha(rs, rsmd));
                } while (rs.next());
                tabela = new JTable(linhas, cabecalho);
            }
            tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabela.getColumnModel().getColumn(2).setPreferredWidth(300);
            tabela.getColumnModel().getColumn(3).setPreferredWidth(300);

            return tabela;

        } catch (SQLException t) {
            System.out.println(t.getMessage());
            return null;

        }

    }

  
}
