package com.project.to_do_app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class ToDo {
    @Id
    @GeneratedValue
    Long id;
    @NotBlank(message = "Title should not be blank")
    String title;
    @NotBlank(message = "Description should not be blank")
    // @Size(min = 5, max = 15)
    // @Pattern(regexp = "^[0 - 9]{10}$")
    String description;
    Boolean isCompleted;
    @Email
    String email;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getIsCompleted() {
        return isCompleted;
    }
    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
