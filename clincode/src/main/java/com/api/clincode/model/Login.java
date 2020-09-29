package com.api.clincode.model;

//@autor: Gabriel Nogueira 
//Descrição: Essa classe vai conter as informações de login de cada usuário. 
//Vai buscar no BD as informaçoes DE ACORDO com os privilégio (se é medico, paciente, atendente ou admin) e construir a o objeto de acordo com essas informações.
public class Login extends Privilegios{
    protected String user_login;
    protected String user_password;

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Login(Boolean usuario_paciente, Boolean usuario_atendente, Boolean usuario_medico, Boolean usuario_admin,
            String user_login, String user_password) {
        super(usuario_paciente, usuario_atendente, usuario_medico, usuario_admin);
        this.user_login = user_login;
        this.user_password = user_password;
    }

    

    
    
    
}
