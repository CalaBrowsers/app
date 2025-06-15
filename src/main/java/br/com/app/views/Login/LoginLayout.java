package br.com.app.views.Login;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLayout;

@CssImport("./styles/login.css")
public class LoginLayout extends VerticalLayout implements RouterLayout {

    public LoginLayout() {
        setSizeFull(); 
        setJustifyContentMode(JustifyContentMode.CENTER); 
        setAlignItems(Alignment.CENTER);
    }
}

