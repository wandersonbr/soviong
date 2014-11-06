/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import gui.Principal;
import beans.Usuario;
import facade.Facade;
import javax.swing.ImageIcon;

/**
 *
 * @author celio
 */
@SuppressWarnings("serial")
public class VerificarUsuario extends JFrame {

    JButton ok, cancelar;
    JLabel usuario, senha;
    JTextField tUsuario;
    JPasswordField tSenha;
    Facade fa;
    static Principal pri;

    public VerificarUsuario() {
        super("Verificar Usuário");
        Container tela = getContentPane();
        tela.setLayout(null);

        ok = new JButton("Ok");
        cancelar = new JButton("Cancelar");
        usuario = new JLabel("Usuário: ");
        senha = new JLabel("Senha: ");
        tUsuario = new JTextField(10);
        tSenha = new JPasswordField(10);

        usuario.setBounds(20, 20, 50, 20);
        tUsuario.setBounds(100, 20, 100, 20);
        senha.setBounds(20, 50, 50, 20);
        tSenha.setBounds(100, 50, 100, 20);
        ok.setBounds(40, 80, 50, 30);
        cancelar.setBounds(100, 80, 100, 30);

        tela.add(ok);
        tela.add(cancelar);
        tela.add(usuario);
        tela.add(senha);
        tela.add(tUsuario);
        tela.add(tSenha);

        tUsuario.setFont(new Font("Times New Roman", Font.BOLD, 14));

        ok.addActionListener(new ActionListener() {
            
			@Override
            public void actionPerformed(ActionEvent e) {

                if (tUsuario.getText().equals("") || tSenha.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Preencha Usuário e Senha!!!");
                } else {
                    fa = new Facade();
                    String retorno = fa.validar_Usuario(tUsuario.getText(), tSenha.getText());
                    if (retorno.equals("0")) {
                        JOptionPane.showMessageDialog(null, "Usuário inválido");

                    } else {
                        if (retorno.equals("1")) {

                            Usuario usu = fa.procurar_Usuario(tUsuario.getText());
                           
                                pri = new Principal(usu);
                                pri.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                                setVisible(false);

                        } else {
                            JOptionPane.showMessageDialog(null, "Senha inválida");
                        }
                    }
                }
            }
        });

        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        setSize(250, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

   
}
