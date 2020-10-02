package com.api.clincode.model;

public class FeedBack {

        protected String Nome;
        protected String Email;
        protected String Celular;
        protected String Sugest_Opini; //Sugestão / Opinião
    
        public String getNome() {
            return Nome;
        }
    
        public void setNome(String Nome) {
            this.Nome = Nome;
        }
    
        public String getEmail() {
            return Email;
        }
    
        public void setEmail(String Email) {
            this.Email = Email;
        }
    
        public String getCelular() {
            return Celular;
        }
    
        public void setCelular(String Celular) {
            this.Celular = Celular;
        }

        public String getSugest_Opini(){
            return Sugest_Opini;
        }

        public void setSugest_Opini(String Sugest_Opini){
            this.Sugest_Opini = Sugest_Opini;
        }
    
}
