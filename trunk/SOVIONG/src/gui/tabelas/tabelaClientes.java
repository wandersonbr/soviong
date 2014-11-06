/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.tabelas;


import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import beans.Usuario;
import facade.Facade;

/**
 *
 * @author celiobj
 */
public class tabelaClientes extends JFrame{
   
    final Container tela;
   
    Calendar data;
    JTable tabela;
    DefaultTableModel dtm;
    JScrollPane scroller;
    Vector linhas, dados, cabecalho;
    JButton ok;
    Facade fa;
    
    public tabelaClientes(final Usuario usu) {
        
        super("..::  Clientes  ::..");
        tela = getContentPane();
        


        data = Calendar.getInstance();
        ok = new JButton("OK");
        
        cabecalho = new Vector();
        linhas = new Vector();
        
        atualizaTabela(usu);

        cabecalho.addElement("Cód");
        cabecalho.addElement("Decrição");
        cabecalho.addElement("Valor");
        cabecalho.addElement("Fornecedor");

        
        ok.setBounds(30, 10, 100, 20);
        
        
        
        tela.add(scroller);
        tela.add(ok);
        
        ok.setEnabled(false);
        
        tabela.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            
                ok.setEnabled(true);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                fa = new Facade();
                String descCliente = tabela.getValueAt(tabela.getSelectedRow(),1).toString();
                String numCadastro = tabela.getValueAt(tabela.getSelectedRow(),3).toString();
               // CadastroVeiculo.tCliente.setText(descCliente);
               // CadastroVeiculo.tCnpj.setText(numCadastro);
               // CadastroVeiculo.tCpf.setText(numCadastro);
                setVisible(false);
                
            }
        });
        
        setLayout(null);
        setResizable(false);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        revalidate();
        repaint();
    }
    
      private void atualizaTabela(Usuario usu) {

        try {
            remove(scroller);

        } catch (NullPointerException e) {
        }
        fa = new Facade();
        //tabela = fa.listarTodos_Cliente(usu);
        tabela.setFont(new Font("Times New Roman", Font.BOLD, 14));
        scroller = new JScrollPane(tabela, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setBounds(30, 30, 700, 300);
        tela.add(scroller);
    }



}
