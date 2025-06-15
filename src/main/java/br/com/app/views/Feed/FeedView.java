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
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.vaadin.lineawesome.LineAwesomeIconUrl;
import br.com.app.DTOs.PostDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@PageTitle("Desabafo")
@Route("Feed")
@Menu(order = 2, icon = LineAwesomeIconUrl.LIST_SOLID)
public class FeedView extends VerticalLayout implements AfterNavigationObserver {

    private final Grid<PostDTO> grid = new Grid<>();
    private List<PostDTO> posts = new ArrayList<>();

    private final TextArea postField = new TextArea("O que você está sentindo?");
    private final Button sendButton = new Button("Enviar");
    private final HorizontalLayout postInputArea = new HorizontalLayout();
    private final VerticalLayout postBox = new VerticalLayout();

    public FeedView() {
        addClassName("feed-view");
        setSizeFull();
        setPadding(true);
        setSpacing(true);

        initPostInputBox();
        initGrid();

        add(postBox, grid);
        expand(grid);
    }

    private void initPostInputBox() {
        postField.setWidthFull();
        postField.setHeight("150px");

        sendButton.setWidth("200px");
        sendButton.addClickListener(e -> {
            String content = postField.getValue();
            if (content != null && !content.trim().isEmpty()) {
                PostDTO novoPost = createPost(
                        "https://randomuser.me/api/portraits/lego/2.jpg",
                        "Você",
                        LocalDate.now().format(DateTimeFormatter.ofPattern("dd MMM yyyy")),
                        content
                );
                posts.add(0, novoPost);
                grid.setItems(posts);
                postField.clear();
            }
        });

        postInputArea.setWidthFull();
        postInputArea.add(postField);

        postBox.setWidthFull();
        postBox.setAlignItems(Alignment.CENTER);
        postBox.setSpacing(true);
        postBox.add(postInputArea, sendButton);
        postBox.getStyle()
            .set("border", "1px solid #ccc")
            .set("border-radius", "12px")
            .set("box-shadow", "0 2px 4px rgba(0, 0, 0, 0.1)")
            .set("background-color", "#fff")
            .set("padding", "12px")
            .set("margin", "8px 0");
    }

    private void initGrid() {
        grid.setWidthFull();
        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(this::createCard);
    }

    private HorizontalLayout createCard(PostDTO dto) {
        HorizontalLayout card = new HorizontalLayout();
        card.setSpacing(false);
        card.setPadding(true);
        card.setWidth("100%");
        card.setAlignItems(Alignment.CENTER);
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

        Span name = new Span(dto.name());
        Span date = new Span(dto.date());
        date.getStyle().set("color", "gray").set("font-size", "12px");

        HorizontalLayout header = new HorizontalLayout(name, date);
        header.setSpacing(true);

        Span post = new Span(dto.post());
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

        VerticalLayout description = new VerticalLayout(header, post, reactionsLayout);
        description.setSpacing(false);
        description.setPadding(false);
        description.setWidthFull();

        card.add(image, description);
        return card;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        posts = new ArrayList<>(Arrays.asList(
                createPost("https://randomuser.me/api/portraits/men/42.jpg", "Sprinklers_waffle", "May 8", "Exemplo de post sem ícones."),
                createPost("https://randomuser.me/api/portraits/women/42.jpg", "Sibbidi-capuccino", "May 3", "Outro exemplo de conteúdo de post."),
                createPost("https://randomuser.me/api/portraits/men/24.jpg", "Pink_pie", "May 3", "Post bem longo...".repeat(10))
        ));
        grid.setItems(posts);
    }

    private PostDTO createPost(String image, String name, String date, String post) {
        return new PostDTO(image, name, date, post);
    }
}
