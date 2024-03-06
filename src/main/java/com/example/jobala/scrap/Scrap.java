package com.example.jobala.scrap;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;


@Table(name = "scrap_tb")
@Entity
@Data
public class Scrap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer jobopenId;
    private Integer resumeId;
    private Integer role; // 0 -> guest, 1 -> comp
    private Timestamp createAt;
}
