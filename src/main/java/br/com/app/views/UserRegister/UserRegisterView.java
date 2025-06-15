package br.com.app.views.UserRegister;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Cadastro")
@Route("Register")
public class UserRegisterView extends VerticalLayout {

    private final FormLayout formLayout;
    private final TextField nameField;
    private final TextField emailField;
    private final TextField cpfField;
    private final DatePicker birthField;
    private final Button sendButton;
    private final VerticalLayout footer;

    public UserRegisterView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        nameField = new TextField();
        nameField.setWidthFull();
        nameField.setClassName("name");
        nameField.setPlaceholder("Digite seu nome");

        emailField = new TextField();
        emailField.setWidthFull();
        emailField.setClassName("email");
        emailField.setPlaceholder("Digite seu email");

        cpfField = new TextField();
        cpfField.setWidthFull();
        cpfField.setClassName("cpf");
        cpfField.setPlaceholder("Digite seu CPF");

        birthField = new DatePicker();
        birthField.setWidthFull();
        birthField.setClassName("birth");
        birthField.setPlaceholder("Selecione sua data de nascimento");

        formLayout = new FormLayout();
        formLayout.addClassName("form-layout");
        formLayout.setWidthFull();
        formLayout.add(nameField, emailField, cpfField, birthField);

        sendButton = new Button("Salvar");
        sendButton.setWidthFull();
        sendButton.setClassName("send");

        footer = new VerticalLayout(sendButton);
        footer.setPadding(false);
        footer.setSpacing(false);
        footer.setWidth("50%");
        footer.setAlignItems(Alignment.STRETCH);

        add(formLayout);
        expand(formLayout);
        add(footer);
    }
}
