package com.example.jobala.reply;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reply_tb")

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String content;
    private int userId;
    private int boardId;
}