package br.com.app.views.Login;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("login")
public class Login extends Div {

    private LoginForm form;

    public Login() {
        form = new LoginForm();
        form.getElement().setAttribute("no-autofocus", "");

        form.addLoginListener(e -> {
            String username = e.getUsername();
            if (isValidEmail(username)) {
                UI.getCurrent().navigate("Feed");
            } else {
                form.setError(true);
                Notification.show("Por favor, insira um e-mail válido.", 3000, Notification.Position.MIDDLE);
            }
        });

        add(form);
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
