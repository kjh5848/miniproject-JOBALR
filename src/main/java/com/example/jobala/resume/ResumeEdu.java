package com.example.jobala.resume;

import com.example.jobala.photo.Photo;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "resume_edu_tb")
public class ResumeEdu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int resumeId;
    private String school;
    private String edu;
    private String graduate;
}
