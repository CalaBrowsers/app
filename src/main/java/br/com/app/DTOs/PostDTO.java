package br.com.app.DTOs;

import java.util.HashMap;
import java.util.Map;

public class PostDTO {
    private String image;
    private String name;
    private String date;
    private String post;
    private Map<String, Integer> reactions = new HashMap<>();

    public PostDTO(String image, String name, String date, String post) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.post = post;

        reactions.put("Você não está sozinho!", 0);
        reactions.put("Tamo junto!", 0);
        reactions.put("Fique bem!", 0);
    }

    public String image() { return image; }
    public String name() { return name; }
    public String date() { return date; }
    public String post() { return post; }
    public Map<String, Integer> getReactions() { return reactions; }

    public void react(String reaction) {
        reactions.put(reaction, reactions.getOrDefault(reaction, 0) + 1);
    }
}
