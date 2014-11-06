/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Cadastro;

import facade.Facade;
import funcoes.funcoes;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import beans.Usuario;

/**
 *
 * @author celio
 */
public final class CadastroUsuarios extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel nome, senha, confSenha, tipo;
    JTextField tNome;
    JPasswordField tSenha, tConfSenha;
    JButton cadastrar, alterar, limpar;
    JComboBox<String> tTipo;
    Vector<String> tipos = new Vector<String>();
    JTable usuarios;
    JScrollPane scroller;
    funcoes fu;
    Facade fa;

    public CadastroUsuarios(final Usuario usu) {

        JLabel tela = new JLabel("... :::   Cadastro de Usuarios  ::: ...");
        tela.setBounds(400, 10, 500, 20);
        add(tela);
        fu = new funcoes();

        nome = new JLabel("Login: ");
        tNome = new JTextField(10);

        senha = new JLabel("Senha: ");
        tSenha = new JPasswordField(45);

        confSenha = new JLabel("Confirme a senha: ");
        tConfSenha = new JPasswordField(45);

        tipos.addElement("");
        tipos.addElement("ADM");
        tipos.addElement("Comum");
        tipo = new JLabel("Tipo: ");
        tTipo = new JComboBox<String>(tipos);

        cadastrar = new JButton("Cadastrar");
        alterar = new JButton("Alterar");
        limpar = new JButton("Limpar");

        nome.setBounds(10, 20, 180, 20);
        tNome.setBounds(120, 20, 200, 20);

        senha.setBounds(10, 50, 100, 20);
        tSenha.setBounds(120, 50, 200, 20);

        confSenha.setBounds(10, 80, 110, 20);
        tConfSenha.setBounds(120, 80, 200, 20);

        tipo.setBounds(10, 110, 110, 20);
        tTipo.setBounds(120, 110, 200, 20);

        cadastrar.setBounds(20, 230, 100, 20);
        alterar.setBounds(350, 450, 100, 20);
        limpar.setBounds(120, 230, 100, 20);

        add(nome);
        add(tNome);

        add(senha);
        add(tSenha);

        add(confSenha);
        add(tConfSenha);

        add(tipo);
        add(tTipo);

        add(cadastrar);
        add(alterar);
        add(limpar);

        alterar.setEnabled(false);
        atualizaTabela();

        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (tNome.getText().equals("") || tSenha.getText().equals("") || tTipo.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!!!");
                } else {
                    fa = new Facade();
                    String retorno = fa.validar_Usuario(tNome.getText(), tSenha.getText());
                    if (retorno.equals("0")) {
                        if (tSenha.getText().equals(tConfSenha.getText())) {

                            Usuario add = new Usuario();
                            add.setNome(tNome.getText());
                            add.setSenha(tSenha.getText());
                            add.setTipo(tTipo.getSelectedIndex());
                            fa.adcionar_Usuario(add);
                            funcoes.geraLog(" ", "Usuário: " + usu.getNome() + " | Inseriu o usuario " + add.getNome());
                            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!!!");
                            tNome.setText("");
                            tSenha.setText("");
                            tConfSenha.setText("");
                            tTipo.setSelectedIndex(0);

                        } else {
                            JOptionPane.showMessageDialog(null, "Senhas nao conferem!!!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ja cadastrado");

                    }
                }

                atualizaTabela();

            }
        });

        alterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                tNome.setText("");
                tSenha.setText("");
                tConfSenha.setText("");
                tTipo.setSelectedIndex(0);

            }
        });

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
        setSize(800, 600);
        setVisible(true);
        revalidate();
        repaint();
    }

    public void atualizaTabela() {

        try {
            remove(scroller);

        } catch (NullPointerException e) {
        }
        fa = new Facade();
        usuarios = fa.consultarTodos_Usuario();
        usuarios.setFont(new Font("Times New Roman", Font.BOLD, 14));
        scroller = new JScrollPane(usuarios, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setBounds(350, 50, 720, 400);
        add(scroller);
    }

}
