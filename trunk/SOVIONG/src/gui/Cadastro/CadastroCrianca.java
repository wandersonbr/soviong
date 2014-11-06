/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import beans.Usuario;



/**
 *
 * @author celio
 */
public final class CadastroCrianca extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Calendar data;
	Calendar dataNas;
	JLabel nomeCrianca, dataNascimento, numCadastro;
	JTextField tNomeCrianca, tNumCadastro;
	JButton cadastrar, limpar;
	JDateChooser tDataNascimento;

    public CadastroCrianca(final Usuario usu) {

        JLabel tela = new JLabel("... :::   Cadastro de Crianças   ::: ...");
        tela.setBounds(400, 10, 500, 20);
        add(tela);

        data = Calendar.getInstance();
        
        nomeCrianca = new JLabel("Nome: ");
        tNomeCrianca = new JTextField();
        tNomeCrianca.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        dataNascimento = new JLabel("Data de Nascimento: ");
        tDataNascimento = new JDateChooser();
        
        numCadastro = new JLabel("Registro: ");
        tNumCadastro = new JTextField();
        tNumCadastro.setFont(new Font("Times New Roman", Font.BOLD, 14));
                
        
        cadastrar = new JButton("Cadastrar");
        
        nomeCrianca.setBounds(10, 43, 80, 20);
        tNomeCrianca.setBounds(191, 42, 200, 20);
        
        dataNascimento.setBounds(10,74,139,20);
        tDataNascimento.setBounds(191,74,100,20);
        
        numCadastro.setBounds(10,105,54,20);
        tNumCadastro.setBounds(191,105,100,20);
        
        cadastrar.setBounds(20, 401, 110, 23);
        
        add(nomeCrianca);
        add(tNomeCrianca);
        add(dataNascimento);
        add(tDataNascimento);
        add(numCadastro);
        add(tNumCadastro);
        add(cadastrar);
        
        
        cadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				boolean valNome = validation.StringValidation.validacaoTextoVazio(tNomeCrianca.getText());
				boolean valRegistro = validation.StringValidation.validacaoCampoNumericoIntegerNaoMoeda(tNumCadastro.getText());
				
				if(valNome&&valRegistro){
					JOptionPane.showMessageDialog(null,"Ok");
				}else{
					JOptionPane.showMessageDialog(null,"Corrija os valores e tente novamente");

				}
				
			}
		});

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
        setSize(800, 600);
        
        JButton limpar_1 = new JButton("Limpar");
        limpar_1.setBounds(165, 401, 89, 23);
        add(limpar_1);
        
        JButton sair = new JButton("Sair");
        sair.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        sair.setBounds(264, 401, 89, 23);
        add(sair);
        setVisible(true);
        revalidate();
        repaint();
    }
}
