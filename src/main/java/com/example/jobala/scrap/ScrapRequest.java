package com.example.jobala.scrap;

import lombok.Data;

public class ScrapRequest {

    @Data
    public static class SaveDTO {
        private Integer role; // 0 -> guest, 1 -> comp
        private Integer jobopenId;
        private Integer resumeId;
        private Integer userId;

    }
}
