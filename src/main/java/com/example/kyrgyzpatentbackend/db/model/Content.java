package com.example.kyrgyzpatentbackend.db.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "contents")
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_gen")
    @SequenceGenerator(name = "content_gen", sequenceName = "content_seq", allocationSize = 1, initialValue = 37)
    private Long id;
    private String title;
    private String contentNumber;
    private String linkPdf;
    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "category_id")
    private Category category;
}
