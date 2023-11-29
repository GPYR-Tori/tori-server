package com.server.tori.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonManagedReference
    private Review review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    public void patchContent(String content) {
        this.content = content;
    }

    public void patchModifyDate(){
        this.modifyDate = LocalDateTime.now();
    }

    public Comment(User user, Review review, String content, LocalDateTime createDate) {
        this.user = user;
        this.review = review;
        this.content = content;
        this.createDate = createDate;
    }
}