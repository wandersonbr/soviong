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
public class ValoresFixos {
    
        
    public enum TipoUsuario{
        
        ADM(1),
        Comum(2);
        
        
        private int tipo;

        private TipoUsuario(int tipo) {
          
            this.tipo=tipo;
        }

        public int getTipo() {
            return tipo;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }
        
       
    }
    
    public enum StatusCrianca{
        
        adotada(1),
        livre(0);
        
        private int tipo;
        private StatusCrianca(int tipo){
            this.tipo=tipo;
        }

        public int getTipo() {
            return tipo;
        }

        public void setTipo(int tipo) {
            this.tipo = tipo;
        }
        
        
    }
        public enum SituacaoLicenca{
        
        ativo(0),
        expirado(1);
        
        private int situacao;
        
        SituacaoLicenca(int situacao){
            
            this.situacao=situacao;
        
        }

       
        public int getSituacao() {
            return situacao;
        }

        
        public void setSituacao(int situacao) {
            this.situacao = situacao;
        }
    }
    
        
}
