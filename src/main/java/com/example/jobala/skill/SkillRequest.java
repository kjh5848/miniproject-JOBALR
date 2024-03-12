package com.example.jobala.skill;

import lombok.Data;

public class SkillRequest {
    @Data
    public static class saveDTO {
        private String name;

        public Skill toEntity() {
            return new Skill(name);
        }
    }
}
