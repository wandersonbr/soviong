/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import beans.Usuario;

import com.lowagie.text.Meta;

import facade.Facade;

/**
 *
 * @author celio
 */
public class PainelControle extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Facade fa;
    Calendar data;
    
    
    public PainelControle(final Usuario usu) {

        JLabel tela = new JLabel("... :::   Painel de Controle   ::: ...");
        tela.setBounds(400, 10, 500, 20);
        add(tela);

        data = Calendar.getInstance();
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
        setSize(800, 800);
        setVisible(true);
        revalidate();
        repaint();
    	}

    

}
