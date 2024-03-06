package com.example.jobala.scrap;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

public class ScrapRequest {

    @AllArgsConstructor
    @Data
    public static class SaveDTO {
        private Integer role; // 0 -> guest, 1 -> comp
        private Integer jobopenId;
        private Integer resumeId;
        private Integer userId;
        private Timestamp createdAt;


    }
}
