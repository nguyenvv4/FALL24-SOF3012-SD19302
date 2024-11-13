package com.example.sd19302.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FavoriteDto {

    @Id
    private String fullName;

    private String email;

    private String poster;

    private String description;

    private Integer views;

    private Date likeDate;
}
