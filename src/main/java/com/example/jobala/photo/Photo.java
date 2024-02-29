package com.example.jobala.photo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "photo_tb")
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String imgFilename; // 파일 패스
}