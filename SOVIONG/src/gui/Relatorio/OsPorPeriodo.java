/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Relatorio;


import beans.Usuario;

import com.toedter.calendar.JDateChooser;

import facade.Facade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.text.ParseException;

import javax.swing.JProgressBar;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author celio
 */
public class OsPorPeriodo extends JPanel {

    JLabel dataIni, dataFim, total, tTotal;
    JButton consultar, imprimir, limpar;
    JDateChooser tDataIni, tDataFim;
    MaskFormatter mascaraData;
    JTable pedidos;
    JScrollPane scroller;
    Facade fa;
    JProgressBar progressImpressao;
    
    public OsPorPeriodo(final Usuario usu) throws ParseException {

        JLabel tela = new JLabel("... :::   O.S. Por Período   ::: ...");
        tela.setBounds(400, 10, 500, 20);
        add(tela);

        dataIni = new JLabel("Início: ");
        dataFim = new JLabel("Fim: ");
        total = new JLabel("Total: ");
        tTotal = new JLabel(" ");
        consultar = new JButton("Consultar");
        imprimir = new JButton("Imprimir");
        limpar = new JButton("Limpar");

        mascaraData = new MaskFormatter("##/##/####");
        
        progressImpressao = new JProgressBar();
        progressImpressao.setStringPainted(true);   
        progressImpressao.setMinimum(0);   
        progressImpressao.setMaximum(100);
        progressImpressao.setStringPainted(true);

        tDataIni = new JDateChooser();
        tDataFim = new JDateChooser();

        dataIni.setBounds(10, 50, 100, 20);
        tDataIni.setBounds(60, 50, 100, 20);
        dataFim.setBounds(180, 50, 100, 20);
        tDataFim.setBounds(220, 50, 100, 20);
        total.setBounds(650, 400, 100, 20);
        tTotal.setBounds(700, 400, 100, 20);

        consultar.setBounds(350, 50, 100, 20);
        imprimir.setBounds(450, 50, 100, 20);
        limpar.setBounds(550, 50, 100, 20);
        
        progressImpressao.setBounds(new Rectangle(575,10,400,20));
        progressImpressao.setVisible(false);

        add(dataIni);
        add(dataFim);
        add(tDataIni);
        add(tDataFim);
        add(total);
        add(tTotal);
        add(consultar);
        add(imprimir);
        add(limpar);
        add(progressImpressao);
        

        consultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    remove(scroller);

                } catch (NullPointerException e1) {
                }
                fa = new Facade();
               // pedidos = fa.listarFechadosPorData_OS(tDataIni.getDate().toLocaleString().substring(0, 10),tDataFim.getDate().toLocaleString().substring(0, 10),usu);
                pedidos.setFont(new Font("Times New Roman", Font.BOLD, 14));
                scroller = new JScrollPane(pedidos, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scroller.setBounds(50, 80, 800, 300);
                add(scroller);

               // tTotal.setText(Funcoes.funcoes.paraFormatoDinheiro(fa.somarPedidos_OS(tDataIni.getDate().toLocaleString().substring(0, 10),tDataFim.getDate().toLocaleString().substring(0, 10),usu)));
            }
        });

        imprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                progressImpressao.setVisible(true);
                Runnable runImpressao = new Runnable() {

                    @Override
                    public void run() {
                        fa = new Facade();
                       // fa.OsPorPeriodo_Relatorio(tDataIni.getDate().toLocaleString().substring(0, 10), tDataFim.getDate().toLocaleString().substring(0, 10),usu);
                        progressImpressao.setIndeterminate(false);
                        progressImpressao.setValue(100);}
                };
                
                Runnable runBarra = new Runnable() {
                    @Override
                    public void run() {
                        progressImpressao.setIndeterminate(true);
                    }
                };
                
                Thread threadRelatorio = new Thread(runImpressao);
                Thread threadBarra = new Thread(runBarra);
                
                 try {  
            
                        threadBarra.start();  
                        threadRelatorio.join();  
                        threadRelatorio.start(); 
                        
                        } catch (InterruptedException ex) {  
            
                            System.out.println(ex.getLocalizedMessage());  
        
                        } 
                
            }
        });

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.DARK_GRAY));
        setSize(800, 800);
        setVisible(true);
        revalidate();
        repaint();
    }

}
