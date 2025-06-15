package br.com.app.views.Login;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.router.Route;

@Route(value = "login", layout = LoginLayout.class)
public class Login extends Div {

    private LoginForm form;
    private LoginI18n i18n;

    public Login() {
        setClassName("login");

        form = new LoginForm();
        form.setI18n(createPortugueseI18n());

        form.getElement().setAttribute("no-autofocus", "");
        add(form);
    }

    private LoginI18n createPortugueseI18n() {
        i18n = LoginI18n.createDefault();

        i18n.setForm(new LoginI18n.Form());
        i18n.getForm().setUsername("Usuário");
        i18n.getForm().setTitle("Login");
        i18n.getForm().setPassword("Senha");
        i18n.getForm().setSubmit("Entrar");
        i18n.getForm().setForgotPassword("Esqueceu a senha?");

        i18n.setErrorMessage(new LoginI18n.ErrorMessage());
        i18n.getErrorMessage().setTitle("Credenciais inválidas");
        i18n.getErrorMessage().setMessage("Verifique seu usuário e senha e tente novamente.");

        return i18n;
    }

}
