package com.example.courseProjectSpring.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private String image;

    private String Name;

    private String Band;

    public Blog() {
    }

    public Blog(Long id, String url, String image, String name, String band) {
        this.id = id;
        this.url = url;
        this.image = image;
        Name = name;
        Band = band;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String urlImage) {
        this.image = urlImage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBand() {
        return Band;
    }

    public void setBand(String band) {
        Band = band;
    }
}
