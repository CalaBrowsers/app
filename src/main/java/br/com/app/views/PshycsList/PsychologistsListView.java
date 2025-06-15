package br.com.app.views.PshycsList;

import java.util.List;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import br.com.app.DTOs.PsychologistListDTO;

@PageTitle("Psicólogos")
@Route("Psychologists")
public class PsychologistsListView extends Composite<VerticalLayout> {

    private ListBox<PsychologistListDTO> items;

    public PsychologistsListView() {
        items = new ListBox<>();
        items.setWidthFull();
        getContent().getStyle().set("flex-grow", "1");

        setAvatarItemsSampleData(items);
        getContent().add(items);

        items.addValueChangeListener(event -> {
            UI.getCurrent().navigate("PsychologistProfile");
        });
    }

    private void setAvatarItemsSampleData(ListBox<PsychologistListDTO> listBox) {
        List<PsychologistListDTO> data = List.of(
            new PsychologistListDTO("Cristina Maria", "Psicóloga"),
            new PsychologistListDTO("Aaliyah Butler", "Psicopedagogo"),
            new PsychologistListDTO("Andressa Campos", "Ophthalmologist"),
            new PsychologistListDTO("Allison Torres", "Allergist"),
            new PsychologistListDTO("Angelina Souza", "Gastroenterologist")
        );

        listBox.setItems(data);

        listBox.setRenderer(new ComponentRenderer<>(item -> {
            Avatar avatar = new Avatar(item.getName());
            avatar.setWidth("40px");
            avatar.setHeight("40px");

            Span name = new Span(item.getName());
            Span profession = new Span(item.getProfession());
            profession.getStyle().set("font-size", "smaller").set("color", "gray");

            VerticalLayout textLayout = new VerticalLayout(name, profession);
            textLayout.setSpacing(false);
            textLayout.setPadding(false);

            Icon icon = VaadinIcon.ANGLE_RIGHT.create();

            HorizontalLayout leftSide = new HorizontalLayout(avatar, textLayout);
            leftSide.setSpacing(true);

            HorizontalLayout layout = new HorizontalLayout();
            layout.setWidthFull();
            layout.setJustifyContentMode(com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode.BETWEEN);
            layout.setAlignItems(com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment.CENTER);
            layout.add(leftSide, icon);

            return layout;
        }));
    }
}
