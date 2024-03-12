package com.example.jobala.jobopen;

import com.example.jobala.skill.Skill;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "jobopen_tb")
@NoArgsConstructor
public class Jobopen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String compname; //회사명
    private String jobopenTitle; //공고제목
    private String content; //내용
    private String career;// 경력
    private String edu; // 학력
    private String hopeJob; //희망직종
    private String compLocation; //근무지역
    private String jobType; // 고용형태
    private String salary; //연봉
    private Date endTime; // 마감일

    public Jobopen(String compname, String jobopenTitle, String content, String career, String edu, String hopeJob, String compLocation, String jobType, String salary, Date endTime) {
        this.compname = compname;
        this.jobopenTitle = jobopenTitle;
        this.content = content;
        this.career = career;
        this.edu = edu;
        this.hopeJob = hopeJob;
        this.compLocation = compLocation;
        this.jobType = jobType;
        this.salary = salary;
        this.endTime = endTime;
    }


    @CreationTimestamp // pc -> db(날짜주입)
    private Timestamp createdAt; //생성일

    @ColumnDefault("1")
    private Integer role; // 역할 0 -> guest, 1 -> comp


}