/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcoes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author celiobj
 */
public class funcoes {

    public static String paraFormatoDinheiro(Double valor) {

        NumberFormat formato2 = NumberFormat.getInstance();
                //JOptionPane.showMessageDialog(null, valor);
        //JOptionPane.showMessageDialog(null, formato2);
        return formato2.format(valor);

    }

    public static String formatoParaInserir(String valor) throws ParseException {

        NumberFormat formato2 = NumberFormat.getNumberInstance();
        return formato2.parse(valor).toString();

    }

    public static String paraFormatoDinheiroRelatorio(Double valor) {

        NumberFormat formato2 = NumberFormat.getCurrencyInstance();
                //JOptionPane.showMessageDialog(null, valor);
        //JOptionPane.showMessageDialog(null, formato2);
        return formato2.format(valor);

    }

    public static String ajustarDinheiroDigitado(Double valor) {

        NumberFormat formato2 = NumberFormat.getCurrencyInstance();

        String retorno = formato2.format(valor);
        return retorno.substring(3, retorno.length());

    }

    public static String ajustarDinheiroTabela(Double valor) {

        NumberFormat formato2 = NumberFormat.getCurrencyInstance();
        String ValorTexto = valor.toString();
        String retorno;
        if (ValorTexto.charAt(0) == '-') {

            String aux = formato2.format(valor);
            retorno = "-" + aux.substring(4);

        } else {
            retorno = formato2.format(valor).substring(3);
        }

        return retorno;

    }

    public static String paraInserirData(String data) {

        String retorno, dia, mes, ano;
        dia = data.substring(0, 2);
        mes = data.substring(3, 5);
        ano = data.substring(6, 10);
        retorno = ano + mes + dia;
        return retorno;

    }

    public static String paraRecuperarData(String data) {

        String retorno, dia, mes, ano;
        dia = data.substring(8, 10);
        mes = data.substring(5, 7);
        ano = data.substring(0, 4);
        retorno = dia + "/" + mes + "/" + ano;
        return retorno;

    }

    public static String pegarNumeroMes(String mes) {

        String numeroMes;
        numeroMes = null;

        switch (mes) {

            case "Janeiro": {
                numeroMes = "01";
                break;
            }
            case "Fevereiro": {
                numeroMes = "02";
                break;
            }
            case "Março": {
                numeroMes = "03";
                break;
            }
            case "Abril": {
                numeroMes = "04";
                break;
            }
            case "Maio": {
                numeroMes = "05";
                break;
            }
            case "Junho": {
                numeroMes = "06";
                break;
            }
            case "Julho": {
                numeroMes = "07";
                break;
            }
            case "Agosto": {
                numeroMes = "08";
                break;
            }
            case "Setembro": {
                numeroMes = "09";
                break;
            }
            case "Outubro": {
                numeroMes = "10";
                break;
            }
            case "Novembro": {
                numeroMes = "11";
                break;
            }
            case "Dezembro": {
                numeroMes = "12";
                break;
            }
        }

        return numeroMes;

    }
    
    public static String diasNoMes(String mes) {

        String diasNoMes;
        diasNoMes = null;

        switch (mes) {

            case "Janeiro": {
                diasNoMes = "31";
                break;
            }
            case "Fevereiro": {
                diasNoMes = "28";
                break;
            }
            case "Março": {
                diasNoMes = "31";
                break;
            }
            case "Abril": {
                diasNoMes = "30";
                break;
            }
            case "Maio": {
                diasNoMes = "31";
                break;
            }
            case "Junho": {
                diasNoMes = "30";
                break;
            }
            case "Julho": {
                diasNoMes = "31";
                break;
            }
            case "Agosto": {
                diasNoMes = "31";
                break;
            }
            case "Setembro": {
                diasNoMes = "30";
                break;
            }
            case "Outubro": {
                diasNoMes = "31";
                break;
            }
            case "Novembro": {
                diasNoMes = "30";
                break;
            }
            case "Dezembro": {
                diasNoMes = "31";
                break;
            }
        }

        return diasNoMes;

    }

    public static String dataInicioMes(String mes) {

        String dataInicioMes;
        dataInicioMes = null;

        switch (mes) {

            case "Janeiro": {
                dataInicioMes = "01/01";
                break;
            }
            case "Fevereiro": {
                dataInicioMes = "01/02";
                break;
            }
            case "Março": {
                dataInicioMes = "01/03";
                break;
            }
            case "Abril": {
                dataInicioMes = "01/04";
                break;
            }
            case "Maio": {
                dataInicioMes = "01/05";
                break;
            }
            case "Junho": {
                dataInicioMes = "01/06";
                break;
            }
            case "Julho": {
                dataInicioMes = "01/07";
                break;
            }
            case "Agosto": {
                dataInicioMes = "01/08";
                break;
            }
            case "Setembro": {
                dataInicioMes = "01/09";
                break;
            }
            case "Outubro": {
                dataInicioMes = "01/10";
                break;
            }
            case "Novembro": {
                dataInicioMes = "01/11";
                break;
            }
            case "Dezembro": {
                dataInicioMes = "01/12";
                break;
            }
        }

        return dataInicioMes;

    }

    public static String dataFimMes(String mes) {

        String dataFimMes;
        dataFimMes = null;

        switch (mes) {

            case "Janeiro": {
                dataFimMes = "31/01";
                break;
            }
            case "Fevereiro": {
                dataFimMes = "28/02";
                break;
            }
            case "Março": {
                dataFimMes = "31/03";
                break;
            }
            case "Abril": {
                dataFimMes = "30/04";
                break;
            }
            case "Maio": {
                dataFimMes = "31/05";
                break;
            }
            case "Junho": {
                dataFimMes = "30/06";
                break;
            }
            case "Julho": {
                dataFimMes = "31/07";
                break;
            }
            case "Agosto": {
                dataFimMes = "31/08";
                break;
            }
            case "Setembro": {
                dataFimMes = "30/09";
                break;
            }
            case "Outubro": {
                dataFimMes = "31/10";
                break;
            }
            case "Novembro": {
                dataFimMes = "30/11";
                break;
            }
            case "Dezembro": {
                dataFimMes = "31/12";
                break;
            }
        }

        return dataFimMes;

    }
    
     public static void enviardEmailSimpes(String emailPara, String nomePara, String assunto, String mensagem) throws EmailException {
                
         
                SimpleEmail email = new SimpleEmail();
                //Utilize o hostname do seu provedor de email
                //System.out.println("alterando hostname...");
               
                email.setHostName("smtp.gmail.com");
                //Quando a porta utilizada não é a padrão (gmail = 465)
                email.setSmtpPort(465);
                //Adicione os destinatários
                email.addTo(emailPara, nomePara);
                //Configure o seu email do qual enviará
                email.setFrom("cbjsolutions@gmail.com", "CBJ Solutions");
                //Adicione um assunto
                email.setSubject(assunto);
                //Adicione a mensagem do email
                email.setMsg(mensagem);
                //Para autenticar no servidor é necessário chamar os dois métodos abaixo
                //System.out.println("autenticando...");
                email.setSSL(true);
                email.setAuthentication("cbjsolutions", "slipclown");
                //System.out.println("enviando...");
                email.send();
                //System.out.println("Email enviado!");

        }

  public static String pesquisarDiaSemana(int _diaSemana) {

        String diaSemana = null;

        switch (_diaSemana) {

            case 1: {
                diaSemana = "Domingo";
                break;
            }
            case 2: {
                diaSemana = "Segunda";
                break;
            }
            case 3: {
                diaSemana = "Terça";
                break;
            }
            case 4: {
                diaSemana = "Quarta";
                break;
            }
            case 5: {
                diaSemana = "Quinta";
                break;
            }
            case 6: {
                diaSemana = "Sexta";
                break;
            }
            case 7: {
                diaSemana = "Sábado";
                break;
            }

        }
        return diaSemana;

    }

    public static void geraLog(String nome, String log) {

        int dia, mes, ano;
        String data_log;
        Calendar data;
        data = Calendar.getInstance();
        dia = data.get(Calendar.DAY_OF_MONTH);
        mes = data.get(Calendar.MONTH);
        ano = data.get(Calendar.YEAR);
        data_log = +dia + "_" + (mes + 1) + "_" + ano;
        if (dia < 10 && mes < 10) {
            data_log = "0" + dia + "_0" + (mes + 1) + "_" + ano;
        } else if (dia < 10 && mes >= 10) {
            data_log = "0" + dia + "_" + (mes + 1) + "_" + ano;
        } else if (dia >= 10 && mes < 10) {
            data_log = dia + "_0" + (mes + 1) + "_" + ano;
        } else {
            data_log = dia + "_" + (mes + 1) + "_" + ano;
        }

        File arquivo = new File("C:/SOVIONG/log/log_" + data_log + ".txt");

        try {
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }

                        //caso seja um diretório, é possível listar seus arquivos e diretórios
            //File[] arquivos = arquivo.listFiles();
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(log + " " + data.getTime().toLocaleString().substring(10, data.getTime().toLocaleString().length()) + " do dia: " + data.getTime().toLocaleString().substring(0, 10));
            bw.newLine();
            bw.close();
            fw.close();
           
        } catch (IOException ex) {
        	JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public static boolean validaEmail(String email) {
        
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher m = p.matcher(email);
        return m.find();
    }

     public static double calculaTotalMedia(JTable tabela, int coluna, String tipo, int denominador) throws ParseException {
        double valorTotal = 0.0;
        double valorAdd = 0.0;
        

        for (int a = 1; a <= tabela.getRowCount(); a++) {

            try{
            valorAdd = Double.parseDouble(funcoes.formatoParaInserir(tabela.getValueAt(a - 1, coluna).toString()));
            if (valorAdd < 0.0 && tipo.equalsIgnoreCase("-")) {

                valorTotal = valorTotal + valorAdd;
                

            } else {
                if (valorAdd >= 0.0 && tipo.equalsIgnoreCase("+")) {

                    valorTotal = valorTotal + valorAdd;
                   

                } else {
                    if (tipo.equalsIgnoreCase("0")) {
                        valorTotal = valorTotal + valorAdd;
                        

                    }
                }

            }

            }catch(NullPointerException ex){}
        }
        return valorTotal/denominador;

    }
    
    public static String calculaTotal(JTable tabela, int coluna, String tipo) throws ParseException {
        double valorTotal = 0.0;
        double valorAdd = 0.0;
        String retorno = null;

        for (int a = 1; a <= tabela.getRowCount(); a++) {

            try{
            valorAdd = Double.parseDouble(funcoes.formatoParaInserir(tabela.getValueAt(a - 1, coluna).toString()));
            if (valorAdd < 0.0 && tipo.equalsIgnoreCase("-")) {

                valorTotal = valorTotal + valorAdd;
                retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

            } else {
                if (valorAdd >= 0.0 && tipo.equalsIgnoreCase("+")) {

                    valorTotal = valorTotal + valorAdd;
                    retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

                } else {
                    if (tipo.equalsIgnoreCase("0")) {
                        valorTotal = valorTotal + valorAdd;
                        retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

                    }
                }

            }

            }catch(NullPointerException ex){}
        }
        return retorno;

    }

    public static String calculaTotalFormatoDinheiro(JTable tabela, int coluna, String tipo) throws ParseException {
        double valorTotal = 0.0;
        double valorAdd = 0.0;
        String retorno = null;

        for (int a = 1; a <= tabela.getRowCount(); a++) {

            valorAdd = Double.parseDouble(funcoes.formatoParaInserir(tabela.getValueAt(a - 1, coluna).toString().substring(3, tabela.getValueAt(a - 1, coluna).toString().length())));
            if (valorAdd < 0.0 && tipo.equalsIgnoreCase("-")) {

                valorTotal = valorTotal + valorAdd;
                retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

            } else {
                if (valorAdd >= 0.0 && tipo.equalsIgnoreCase("+")) {

                    valorTotal = valorTotal + valorAdd;
                    retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

                } else {
                    if (tipo.equalsIgnoreCase("0")) {
                        valorTotal = valorTotal + valorAdd;
                        retorno = "R$ " + funcoes.paraFormatoDinheiro(valorTotal);

                    }
                }

            }

        }
        return retorno;

    }
    
    @SuppressWarnings("rawtypes")
	public static Vector<Comparable> proximaLinha(ResultSet rs, ResultSetMetaData rsmd) throws SQLException {
        Vector<Comparable> LinhaAtual = new Vector<Comparable>();

        try {
            for (int i = 1; i <= rsmd.getColumnCount(); ++i) {
                switch (rsmd.getColumnType(i)) {
                
                    case Types.VARCHAR:
                        LinhaAtual.addElement(rs.getString(i));
                        break;
                    case Types.TIMESTAMP:
                        LinhaAtual.addElement(rs.getDate(i).toLocaleString().substring(0, 10));
                        break;
                    case Types.INTEGER:
                        LinhaAtual.addElement(rs.getInt(i));
                        break;
                    case Types.DECIMAL:
                        LinhaAtual.addElement(funcoes.paraFormatoDinheiro(rs.getDouble(i)));
                        break;
                    case Types.DOUBLE:
                        LinhaAtual.addElement(funcoes.paraFormatoDinheiro(rs.getDouble(i)));
                        break;

                }
            }
        } catch (SQLException e) {
        }
        return LinhaAtual;

    }

}
