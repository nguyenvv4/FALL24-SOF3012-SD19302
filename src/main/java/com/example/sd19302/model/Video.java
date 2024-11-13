package com.example.sd19302.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Poster")
    private String poster;
    @Column(name = "Description")
    private String description;
    @Column(name = "Active")
    private Boolean active;
    @Column(name = "Views")
    private Integer view;

}