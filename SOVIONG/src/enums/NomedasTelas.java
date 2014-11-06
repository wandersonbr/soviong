/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enums;

/**
 *
 * @author celiobj
 */
public class NomedasTelas {
    
    public enum principal{
        
        telaPrincipal("001","Tela Principal");
        private String nome;
        private String cod;
        private principal(String cod,String nome){
            this.cod=cod;
            this.nome=nome;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }

        /**
         * @return the cod
         */
        public String getCod() {
            return cod;
        }

        /**
         * @param cod the cod to set
         */
        public void setCod(String cod) {
            this.cod = cod;
        }
    }
    public enum cadastro{
        
        usuario("Cad0001","Cadastro de Usu�rio"),
        adulto("Cad0002","Cadastro de Adulto"),
        crianca("Cad0003","Cadastro de Crian�a"),
        
        ;
        private String cod;
        private String nome;
        
        private cadastro(String cod, String nome){
            
            this.cod=cod;
            this.nome=nome;
        }

        /**
         * @return the cod
         */
        public String getCod() {
            return cod;
        }

        /**
         * @param cod the cod to set
         */
        public void setCod(String cod) {
            this.cod = cod;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    public enum estoque{
        
        entrada("Est0001","Entrada de Produto");
        
        private String cod;
        private String nome;
        
        private estoque(String cod, String nome){
            
            this.cod=cod;
            this.nome=nome;
            
        }

        /**
         * @return the cod
         */
        public String getCod() {
            return cod;
        }

        /**
         * @param cod the cod to set
         */
        public void setCod(String cod) {
            this.cod = cod;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    
    public enum relatorio{
        
        OS_OSPorPeriodo("Rel0001","Relatório de O.S. por período"),
        OS_OS("Rel0002","Impressão pelo número da O.S."),
        
        movimentacoes_FluxodeCaixa("Rel0003","Impressão do fluxo de caixa"),
        movimentacoes_lancamentosFuturos("Rel0004","Impressão dos lançamentos futurs"),
        
        estoque_estoqueGeral("Rel0005","Relatório de produtos"),
        
        gastos("Rel006","Relatório de gastos por O.S."),
        metas("Rel007","Relatório de metas");
        
        private String cod;
        private String nome;
                
        private relatorio(String cod, String nome){
            
            this.cod=cod;
            this.nome=nome;
            
        }

        /**
         * @return the cod
         */
        public String getCod() {
            return cod;
        }

        /**
         * @param cod the cod to set
         */
        public void setCod(String cod) {
            this.cod = cod;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }
        
    }
    
    public enum acessoRapido{
        
        botaoUsuarios("Ace0001","Cadastro de Usu�rios"),
        botaoCrianca("Ace0002","Cadastro de Crian�as"),
        botaoPainelControle("Ace0003","Painel de Controle"),
        botaoAdulto("Ace0004","Cadastro de Adulto");
        
        private String cod;
        private String nome;
        
        private acessoRapido(String cod, String nome){
            
            this.cod=cod;
            this.nome=nome;
            
        }

        /**
         * @return the cod
         */
        public String getCod() {
            return cod;
        }

        /**
         * @param cod the cod to set
         */
        public void setCod(String cod) {
            this.cod = cod;
        }

        /**
         * @return the nome
         */
        public String getNome() {
            return nome;
        }

        /**
         * @param nome the nome to set
         */
        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
