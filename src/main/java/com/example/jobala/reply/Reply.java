package com.example.jobala.reply;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "reply_tb")

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer boardId;//외래키.
    private String comment;
    private String username;
    private LocalDateTime createdAt;
}