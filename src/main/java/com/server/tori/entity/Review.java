package com.server.tori.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.server.tori.entity.Landmark.Landmark;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "landmark_id")
    @JsonBackReference
    private Landmark landmark;

    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<Comment> commentList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dotori_id")
    @JsonBackReference
    private Dotori dotori;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    public void patchContent(String content) {
        this.content = content;
    }

    public void patchModifyDate(){
        this.modifyDate = LocalDateTime.now();
    }

    public Review(User user, Landmark landmark, Dotori dotori, String content, LocalDateTime createDate) {
        this.user = user;
        this.landmark = landmark;
        this.dotori = dotori;
        this.content = content;
        this.createDate = createDate;
    }
}
