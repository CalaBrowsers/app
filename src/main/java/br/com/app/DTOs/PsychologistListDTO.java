package br.com.app.DTOs;

public class PsychologistListDTO {
    private String name;
    private String profession;

    public PsychologistListDTO(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
