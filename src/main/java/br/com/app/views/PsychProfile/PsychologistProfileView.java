package br.com.app.views.PsychProfile;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

import br.com.app.UTILs.NotificationUtil;
import com.vaadin.flow.router.Route;

@PageTitle("Perfil do Psicólogo")
@Route("PsychologistProfile")
public class PsychologistProfileView extends VerticalLayout {

    private Avatar avatar;
    private H2 name;
    private Span specialty;
    private VerticalLayout profile, buttonLayout;
    private Button button;

    public PsychologistProfileView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        profile = new VerticalLayout();
        profile.setWidth("420px");
        profile.setHeight("700px");
        profile.setPadding(true);
        profile.setSpacing(true);
        profile.setAlignItems(Alignment.CENTER);
        profile.getStyle()
            .set("border-radius", "16px")
            .set("box-shadow", "0 4px 16px rgba(0, 0, 0, 0.1)")
            .set("background-color", "white")
            .set("padding", "32px");

        avatar = new Avatar();
        avatar.setImage("https://s3.glbimg.com/v1/AUTH_35862ca5c6ab48b992baf1f1b4f7062e/m-extra-globo-com/incoming/24653235-260-9ac/w367h550-PROP/whatsapp-image-2020-09-10-at-22.02.04.jpeg.jpg");
        avatar.setWidth("200px");
        avatar.setHeight("200px");
        avatar.getStyle().set("border-radius", "50%");

        name = new H2("Andréia Lima");
        name.getStyle().set("margin", "0");

        specialty = new Span("Psicopedagoga especializada em atendimento à adolescentes.");
        specialty.getStyle()
            .set("color", "gray")
            .set("text-align", "center");

        buttonLayout = new VerticalLayout();
        buttonLayout.setSizeFull();
        buttonLayout.setPadding(false);
        buttonLayout.setSpacing(false);
        buttonLayout.setMargin(false);
        buttonLayout.setHeightFull();
        buttonLayout.setJustifyContentMode(JustifyContentMode.END);
        buttonLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        button = new Button("Entrar em contato");
        button.setWidth("60%");
        button.addClickListener(e -> {
            UI.getCurrent().navigate("https://wa.me/" + "//");
            NotificationUtil.showInfo("Você será redirecionado a um bate-papo com o psicólogo.");
        });

        buttonLayout.add(button);

      profile.add(avatar, name, specialty, buttonLayout);
        add(profile);
    }
}
