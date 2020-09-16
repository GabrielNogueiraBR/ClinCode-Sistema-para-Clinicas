public class FeedBack {
    public class Feedback extends Pessoa {

        protected String feedbackT;
        protected String feedbackM;
        protected String celular;
    
        public Feedback(String nome, String dataNascimento, String rg, String cpf, 
        String email, String rua, String bairro, int num, String cidade, String estado)
        {
            super(nome, dataNascimento, rg, cpf, email, rua, bairro, num, cidade, estado);
            this.feedbackT = feedbackT;
            this.feedbackM = feedbackM;
            this.celular = celular;
        }
    
        public String getFeedbackT() {
            return feedbackT;
        }
    
        public void setFeedbackT(String feedbackT) {
            this.feedbackT = feedbackT;
        }
    
        public String getFeedbackM() {
            return feedbackM;
        }
    
        public void setFeedbackM(String feedbackM) {
            this.feedbackM = feedbackM;
        }
    
        public String getCelular() {
            return celular;
        }
    
        public void setCelular(String celular) {
            this.celular = celular;
        }
    }
}
