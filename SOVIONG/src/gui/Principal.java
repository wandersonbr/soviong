/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import beans.Usuario;
import beans.ValoresFixos;
import enums.NomedasTelas;
import facade.Facade;
import funcoes.funcoes;
import gui.Cadastro.CadastroCrianca;
import gui.Cadastro.CadastroUsuarios;


public class Principal extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final Container tela;
    JLabel usuarioRodape, statusLicenca;
    JMenuBar menu;
    JMenu cadastro, relatorio, menuRelGerencial;
    JMenuItem relEstoque, estoqueGeral, porItem;
    JToolBar acessoRapido, rodape;
    JButton usuarios,criancas,adulto,painel_controle, sair, sairTodos;
    Calendar data;
    Facade fa;
    CadastroUsuarios cu;
    CadastroCrianca cc;
    PainelControle pc;
    	
    public Principal(final Usuario usu) {

        super("..::  Sistema único de adoção  ::..");
        tela = getContentPane();
        getContentPane().setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        revalidate();
        repaint();
        data = Calendar.getInstance();

        criaMenu();
        verificarPermissoes(usu);
        funcoes.geraLog(" ", "Usuário: " + usu.getNome() + " | Fez o Login na tela "+enums.NomedasTelas.principal.telaPrincipal.getCod()+" - "+enums.NomedasTelas.principal.telaPrincipal.getNome()+" às ");

        menu = new JMenuBar();
        cadastro = new JMenu("Cadastro");
        relatorio = new JMenu("Relatório");

        relEstoque = new JMenu("Estoque");
        estoqueGeral = new JMenuItem("Estoque Geral");
        porItem = new JMenuItem("Por Item");
        porItem.setEnabled(false);

        relEstoque.add(estoqueGeral);
        relEstoque.add(porItem);
        
        menuRelGerencial = new JMenu("Relatório Gerencial");
        relatorio.add(relEstoque);
        relatorio.add(menuRelGerencial);

        menu.add(cadastro);
        menu.add(relatorio);
        setJMenuBar(menu);

        
        
        
        sairTodos = new JButton("Início");
        
        sairTodos.setBounds(1000, 60, 150, 20);

        tela.add(sairTodos);

        acessoRapido.setBounds(1, 1, tela.getWidth(), 80);
        rodape.setBounds(1, 80, tela.getWidth(), 20);
        tela.add(acessoRapido);
        tela.add(rodape);

        usuarioRodape = new JLabel("Usuário: " + usu.getNome() + " ===== || ===== Data: " + data.getTime().toLocaleString().substring(0, 10));
        
        
        statusLicenca = new JLabel("");
        statusLicenca.setBounds(250, 200, 700, 20);
        statusLicenca.setForeground(Color.red);
        getContentPane().add(statusLicenca);
        verificarLicenca(usu);
        
            
        rodape.add(usuarioRodape);

        Runnable runnable = new Runnable() {
            public void run() {
               try {
            
                    funcoes.enviardEmailSimpes("celiobj@gmail.com", "Celio",usu.getNome()+" - Sistema de adoção único - Acesso", "Usuario: "+usu.getNome()+" acessou o sistema Mergead as: "+data.getTime().toLocaleString().substring(10)+" do dia: "+data.getTime().toLocaleString().substring(0,10));
                } catch (Exception ex) {}
        
            }
        };
        
        Thread tarefa = new Thread(runnable);
        tarefa.start();
				
         

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
                if (resposta == 0) {
                    funcoes.geraLog(" ", "Usuario: " + usu.getNome() + " | Fez o Logoff na tela "+enums.NomedasTelas.principal.telaPrincipal.getCod()+" - "+enums.NomedasTelas.principal.telaPrincipal.getNome()+" as ");
                    //bemajava.Bematech.CancelaCupom();
                    System.exit(0);
                }
            }
        });

        usuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeTudo();
                funcoes.geraLog(" ", "Usuario: " + usu.getNome() + " | Fez o Login na tela "+enums.NomedasTelas.acessoRapido.botaoUsuarios.getCod()+" - "+enums.NomedasTelas.acessoRapido.botaoUsuarios.getNome()+" as ");

                cu = new CadastroUsuarios(usu);
                JToolBar ferramentas = new JToolBar("Ferramentas");
                ferramentas.setBounds(2, 584, 1095, 64);
                cu.setBounds(50, 100, 1100, 500);
                cu.add(ferramentas);

                verificarPermissoes(usu);
                usuarios.setEnabled(false);

                tela.add(cu);
                tela.revalidate();
                tela.repaint();

            }
        });
        
        criancas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeTudo();
                funcoes.geraLog(" ", "Usuario: " + usu.getNome() + " | Fez o Login na tela "+enums.NomedasTelas.acessoRapido.botaoCrianca.getCod()+" - "+enums.NomedasTelas.acessoRapido.botaoCrianca.getNome()+" as ");

                cc = new CadastroCrianca(usu);
                JToolBar ferramentas = new JToolBar("Ferramentas");
                ferramentas.setBounds(2, 584, 1095, 64);
                cc.setBounds(50, 100, 1100, 500);
                cc.add(ferramentas);

                verificarPermissoes(usu);
                criancas.setEnabled(false);

                tela.add(cc);
                tela.revalidate();
                tela.repaint();

            }
        });


       
        painel_controle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeTudo();
                funcoes.geraLog(" ", "Usuario: " + usu.getNome() + " | Fez o Login na tela "+NomedasTelas.acessoRapido.botaoPainelControle.getCod()+" - "+NomedasTelas.acessoRapido.botaoPainelControle.getNome()+" as ");

                pc = new PainelControle(usu);
                JToolBar ferramentas = new JToolBar("Ferramentas");
                ferramentas.setBounds(2, 584, 1095, 64);
                pc.setBounds(50, 100, 1100, 500);
                pc.add(ferramentas);

                verificarPermissoes(usu);
                painel_controle.setEnabled(false);

                tela.add(pc);
                tela.revalidate();
                tela.repaint();

            }
        });

                
        sairTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                removeTudo();
                verificarPermissoes(usu);
                tela.revalidate();
                tela.repaint();

                //bemaECF.programaAliquota("1200", 1);
            }
        });
        
        
        setExtendedState(MAXIMIZED_BOTH);
        //setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }

    private void verificarLicenca(Usuario usu) {
        String dataVencimento;
        String dataHoje;
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        dataVencimento = funcoes.paraInserirData("01/01/2015");
        dataHoje = funcoes.paraInserirData(data.getTime().toLocaleString().substring(0, 10));
        try {
            Date dataVencimentoF = df.parse(dataVencimento);
            Date dataHojeF = df.parse(dataHoje);

            fa = new Facade();
            int licenca = fa.pegarCodLicenca_Licenca(usu);

            if (licenca == ValoresFixos.SituacaoLicenca.ativo.getSituacao()) {
                fa.inserir_Licenca(usu);
            } else {
                int statusIntLicenca = fa.pegarStatusLicenca_Licenca(Integer.toString(licenca),usu);
                if (statusIntLicenca == ValoresFixos.SituacaoLicenca.expirado.getSituacao()) {

                    statusLicenca.setText("Licença do sistema está¡ expirada!!! - Entre em contato com o administrador do sistema para obter a versão atualizada.");
                    desabilitabotoes();
                    sair.setEnabled(true);
                    sairTodos.setEnabled(false);
                    cadastro.setEnabled(false);
                    relatorio.setEnabled(false);

                } else {
                    if (dataHojeF.after(dataVencimentoF)) {

                        statusLicenca.setText("Licença do sistema está¡ expirada!!! - Entre em contato com o administrador do sistema para obter a versão atualizada.");
                        desabilitabotoes();
                        sair.setEnabled(true);
                        sairTodos.setEnabled(false);
                        cadastro.setEnabled(false);
                        relatorio.setEnabled(false);
                        fa.bloquear_Licenca(Integer.toString(licenca),usu);

                    }

                }

            }
        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void criaMenu() {

        acessoRapido = new JToolBar("Barra de Ferramentas");
        acessoRapido.setBackground(Color.white);
        rodape = new JToolBar("Barra de Rodapé");
        rodape.setBackground(Color.gray);

        usuarios = new JButton();
        usuarios.setIcon(new ImageIcon(Principal.class.getResource("/apoio/Icones/usuarios.jpg")));
        usuarios.setToolTipText("Cadastro de Usuários");
        usuarios.setBounds(10, 10, 100, 100);
        acessoRapido.add(usuarios);

        criancas = new JButton();
        criancas.setIcon(new ImageIcon(Principal.class.getResource("/apoio/Icones/crianca.jpg")));
        criancas.setToolTipText("Cadastro de Crianças");
        criancas.setBounds(10, 10, 100, 100);
        acessoRapido.add(criancas);

        adulto = new JButton();
        adulto.setIcon(new ImageIcon(Principal.class.getResource("/apoio/Icones/adulto.jpg")));
        adulto.setToolTipText("Cadastro de Adultos");
        adulto.setBounds(10, 10, 100, 100);
        acessoRapido.add(adulto);
       
        painel_controle = new JButton();
        painel_controle.setIcon(new ImageIcon(Principal.class.getResource("/apoio/Icones/painel_controle.jpg")));
        painel_controle.setToolTipText("Painel de Controle");
        painel_controle.setBounds(10, 10, 100, 100);
        acessoRapido.add(painel_controle);

        sair = new JButton();
        sair.setIcon(new ImageIcon(Principal.class.getResource("/apoio/Icones/botao_sair.png")));
        sair.setToolTipText("Sair");
        sair.setBounds(10, 10, 100, 100);
        acessoRapido.add(sair);
    }

    private void removeTudo() {

        try {

            tela.remove(cu);
        } catch (NullPointerException npe) {
        };
        
        try {

            tela.remove(cc);
        } catch (NullPointerException npe) {
        };


       try {

            tela.remove(pc);
        } catch (NullPointerException npe) {
        };

    }

    private void habilitabotoes() {

        try {
            usuarios.setEnabled(true);
            criancas.setEnabled(true);
            adulto.setEnabled(true);
            painel_controle.setEnabled(true);
            sair.setEnabled(true);

        } catch (NullPointerException npe) {
        };

    }

    private void desabilitabotoes() {

        try {

            usuarios.setEnabled(false);
            criancas.setEnabled(false);
            adulto.setEnabled(false);
            painel_controle.setEnabled(false);
            sair.setEnabled(false);

        } catch (NullPointerException npe) {
        };

    }

    private void verificarPermissoes(Usuario usu) {

        if (usu.getTipo()==(enums.ValoresFixos.TipoUsuario.ADM.getTipo())) {
            habilitabotoes();
        } else {
            habilitabotoes();
            usuarios.setEnabled(false);
            painel_controle.setEnabled(false);
        }
    }

    

}
