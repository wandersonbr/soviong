/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import beans.Usuario;

/**
 *
 * @author celio
 */
public final class Base extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Calendar data;

    public Base(final Usuario usu) {

        JLabel tela = new JLabel("... :::   Base de telas   ::: ...");
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
