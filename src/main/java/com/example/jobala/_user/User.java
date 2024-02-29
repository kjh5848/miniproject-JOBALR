package com.example.jobala._user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, length = 15)
    private String username; // 아아디 (이메일 주소)
    
    private String email;
    private String compNum;
    private String password;
    private String name;
    private String compname;
    private String phone;
    private String ceo;
    private String address;
    private Boolean role; // true -> guest, false -> comp
    private String photo;
    private LocalDateTime createdAt;
}
