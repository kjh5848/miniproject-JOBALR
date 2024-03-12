package com.example.jobala.jobopen;

import com.example.jobala.skill.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JobopenRequest {

    @AllArgsConstructor
    @Data
    public static class DeleteDTO {
        private int id;
    }


    @AllArgsConstructor
    @Data
    public static class UpdateDTO {
        //compname = ? ,jobopenTitle=? , career=?, edu=?, jobType=?,salary=?,compLocation=?,content=? ,skills =?
        private String compname; //대표명
        private String jobopenTitle; //공고제목
        private String career;// 경력
        private String edu; // 학력
        private String jobType; // 고용형태
        private String salary; //연봉
        private String compLocation; //근무지역
        private String content; //내용
        private String endTime; //내용
        private List<String> skills = new ArrayList<>();
    }


    @AllArgsConstructor
    @Data
    public static class SaveDTO {
        private String compname; // 회사명
        private String jobopenTitle; // 공고제목
        private String content; // 내용
        private String career; // 경력
        private String edu; // 학력
        private String hopeJob; // 희망직종
        private String compLocation; // 근무지역
        private String jobType; // 고용형태
        private String salary; // 연봉
        private Date endTime; // 마감일
        private List<String> skills; // 스킬 목록

        public Jobopen toEntity() {
            Jobopen jobopen = new Jobopen(compname, jobopenTitle, content, career, edu, hopeJob, jobType, compLocation, salary, endTime);
            // 스킬 추가
            if (skills != null) {
                for (String skill : skills) {
                    jobopen.addSkill(new Skill(skill));
                }
            }

            return jobopen;
        }
    }


}


