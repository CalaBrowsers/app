package br.com.app.views.StudentRegister;

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
public class StudentRegisterView extends VerticalLayout {

    public StudentRegisterView() {
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        FormLayout formLayout = new FormLayout();
        formLayout.addClassName("form-layout");
        formLayout.setWidthFull();

        TextField nameField = new TextField();
        nameField.setWidthFull();
        nameField.setClassName("name");
        nameField.setPlaceholder("Digite seu nome");

        TextField emailField = new TextField();
        emailField.setWidthFull();
        emailField.setClassName("email");
        emailField.setPlaceholder("Digite seu email");

        TextField cpfField = new TextField();
        cpfField.setWidthFull();
        cpfField.setClassName("cpf");
        cpfField.setPlaceholder("Digite seu CPF");

        DatePicker birthField = new DatePicker();
        birthField.setWidthFull();
        birthField.setClassName("birth");
        birthField.setPlaceholder("Selecione sua data de nascimento");

        formLayout.add(nameField, emailField, cpfField, birthField);

        Button sendButton = new Button("Salvar");
        sendButton.setWidthFull();
        sendButton.setClassName("send");

        VerticalLayout footer = new VerticalLayout(sendButton);
        footer.setPadding(false);
        footer.setSpacing(false);
        footer.setWidthFull();
        footer.setAlignItems(Alignment.STRETCH);

        add(formLayout);
        expand(formLayout);
        add(footer);
    }
}
