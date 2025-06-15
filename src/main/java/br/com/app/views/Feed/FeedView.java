package br.com.app.views.Feed;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import br.com.app.DTOs.PostDTO;

import java.util.Arrays;
import java.util.List;

@PageTitle("Desabafo")
@Route("Feed")
@Menu(order = 2, icon = LineAwesomeIconUrl.LIST_SOLID)
public class FeedView extends Div implements AfterNavigationObserver {

    private Grid<PostDTO> grid = new Grid<>();

    public FeedView() {
        addClassName("feed-view");
        setSizeFull();

        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);

        grid.addComponentColumn(this::createCard);

        add(grid);
    }

    private HorizontalLayout createCard(PostDTO dto) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");
        card.setAlignItems(Alignment.CENTER);
        card.setPadding(true);
        card.setWidth("100%");

        card.getStyle()
            .set("border", "1px solid #ccc")
            .set("border-radius", "12px")
            .set("box-shadow", "0 2px 4px rgba(0, 0, 0, 0.1)")
            .set("padding", "12px")
            .set("margin", "8px 0")
            .set("background-color", "#fff");

        Image image = new Image(dto.image(), "Foto de " + dto.name());
        image.setWidth("64px");
        image.setHeight("64px");
        image.getStyle().set("border-radius", "50%");

        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);
        description.setWidthFull();

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        Span name = new Span(dto.name());
        name.addClassName("name");

        Span date = new Span(dto.date());
        date.addClassName("date");

        header.add(name, date);

        Span post = new Span(dto.post());
        post.addClassName("post");
        post.getStyle()
            .set("white-space", "normal")
            .set("word-break", "break-word")
            .set("width", "100%");

        HorizontalLayout reactionsLayout = new HorizontalLayout();
        reactionsLayout.setSpacing(true);
        reactionsLayout.setPadding(true);
        for (String reactionText : dto.getReactions().keySet()) {
            Button reactionButton = new Button(reactionText + " (" + dto.getReactions().get(reactionText) + ")");
            reactionButton.getStyle().set("font-size", "12px");
            reactionButton.addClickListener(e -> {
                dto.react(reactionText);
                reactionButton.setText(reactionText + " (" + dto.getReactions().get(reactionText) + ")");
            });

            reactionsLayout.add(reactionButton);
        }

        description.add(header, post, reactionsLayout);
        card.add(image, description);

        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        List<PostDTO> posts = Arrays.asList(
            createPost("https://randomuser.me/api/portraits/men/42.jpg", "Sprinklers_waffle", "May 8",
                    "Exemplo de post sem ícones."),
            createPost("https://randomuser.me/api/portraits/women/42.jpg", "Sibbidi-capuccino", "May 3",
                    "Outro exemplo de conteúdo de post."),
            createPost("https://randomuser.me/api/portraits/men/24.jpg", "Pink_pie", "May 3",
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.")
        );

        grid.setItems(posts);
    }

    private PostDTO createPost(String image, String name, String date, String post) {
        return new PostDTO(image, name, date, post);
    }
}

