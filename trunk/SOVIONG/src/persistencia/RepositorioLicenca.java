/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.AccessDatabase;
import beans.Usuario;
import beans.ValoresFixos;

/**
 *
 * @author celiobj
 */
public class RepositorioLicenca implements RepositorioLicencaInterface {

    @Override
    public void bloquear(String cod,Usuario usu) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE licenca SET status= '"+ValoresFixos.SituacaoLicenca.expirado.getSituacao()+"' WHERE idLicenca = '" + cod + "'");
            con.close();

        } catch (HeadlessException | SQLException t) {
            System.out.println(t.getMessage());

        }

    }

    @Override
    public void liberar(String cod,Usuario usu) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE licenca SET status= '"+ValoresFixos.SituacaoLicenca.ativo.getSituacao()+"' WHERE idLicenca = '" + cod + "'");
            con.close();

        } catch (HeadlessException | SQLException t) {
            System.out.println(t.getMessage());

        }

    }

    @Override
    public void inserir(Usuario usu) {

        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            st.execute("INSERT INTO `licenca` (`status`) VALUES ('"+ValoresFixos.SituacaoLicenca.ativo.getSituacao()+"');");

        } catch (SQLException ex) {
            Logger.getLogger(RepositorioUsuario.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public int pegarCodLicenca(Usuario usu) {

        int retorno = 0;
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(idLicenca) FROM licenca");
            rs.next();
            if (rs.getRow() == 0) {
                con.close();
                return 0;
            } else {
                retorno = Integer.parseInt(rs.getString("MAX(idLicenca)"));
                con.close();
                return retorno;
            }
        } catch (NumberFormatException | SQLException t) {
            System.out.println(t.getMessage());
            return 0;

        }

    }

    @Override
    public int pegarStatusLicenca(String cod,Usuario usu) {

        int retorno = 0;
        try {

            AccessDatabase a = new AccessDatabase();
            Connection con = a.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT status FROM licenca where idLicenca='" + cod + "'");
            rs.next();
            retorno = Integer.parseInt(rs.getString("status"));
            con.close();
            return retorno;

        } catch (NumberFormatException | SQLException t) {
            System.out.println(t.getMessage());
            return 0;

        }

    }

}
