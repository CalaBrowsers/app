package br.com.app.views.NewPost;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

@Route("NewPost")
public class NewPostView extends VerticalLayout {

    private TextArea postField;
    private Button sendButton;
    private HorizontalLayout layout;
    private VerticalLayout footer;

    public NewPostView() {

        setSizeFull();
        setPadding(true);
        setSpacing(true);

        layout = new HorizontalLayout();
        layout.setWidthFull();

        postField = new TextArea("O que você está sentindo?");
        postField.setWidthFull();
        postField.setHeight("150px");
        postField.setClassName("post");

        layout.add(postField);

        sendButton = new Button("Enviar");
        sendButton.setWidth("300px");
        sendButton.setClassName("send");

        footer = new VerticalLayout(sendButton);
        footer.setPadding(false);
        footer.setSpacing(false);
        footer.setWidthFull();

        footer.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(layout);
        expand(layout); 
        add(footer);
    }
}
