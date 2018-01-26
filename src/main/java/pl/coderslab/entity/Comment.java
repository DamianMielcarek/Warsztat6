package pl.coderslab.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Tweet post;

    private LocalDateTime created;

    @NotBlank
    @Size(max = 60)
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getPost() {
        return post;
    }

    public void setPost(Tweet post) {
        this.post = post;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", created=" + created +
                ", text='" + text + '\'' +
                '}';
    }

}
