/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author celiobj
 */
public class ValoresFixos {
    
        
    public enum TipoClienteLocadora{
        
        Locadora("1"),
        NaoLocadora("0");
        
        private String tipo;

        private TipoClienteLocadora(String tipo) {
          
            this.tipo=tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
       
    }
    
    public enum TipoConta{
        
        entrada("0"), saida("1");
        
        private String tipo;
        private TipoConta(String tipo){
            this.tipo=tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
        
    }
    
   
    
    public enum SituacaoLicenca{
        
        ativo(0),expirado(1);
        
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
    
    public enum StatusCrianca{
    	
    	livre(0),
    	Adotada(1);
    	
    	private int status;
    	
    	StatusCrianca(int status){
    		
    		this.status=status;
    	}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}
    	
    }
    
    public enum TipoUsuario{
        
        ADM("0"),comum("1");
        private String tipo;

        private TipoUsuario(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
        
    }
    
    public enum TipoProduto{
        
        inteiro("0"), fracionada("1");
        private String tipo;

        private TipoProduto(String tipo) {
            this.tipo = tipo;
        }

       public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
        
        
    }
    
}
