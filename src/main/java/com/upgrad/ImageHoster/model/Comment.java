package com.upgrad.ImageHoster.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table (name = "comment")
public class Comment implements Serializable {
    // These annotations auto-increments the id column for us whenever
    // a new Image object is stored into the database
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Text is a Postgres specific column type that allows you to save
    // text based data that will be longer than 256 characters
    @Column(columnDefinition="TEXT")
    private String description;

    @Column
    private LocalDate uploadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Image_id")
    private Image image;

    //constructors

    public Comment() {
    }

    public Comment(String description) {
        this.description = description;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
