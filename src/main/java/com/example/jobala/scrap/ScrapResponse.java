package com.example.jobala.scrap;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ScrapResponse {

    @AllArgsConstructor
    @Data
    public static class DetailDTO {
        private Integer id;
        private Long scrapCount;
        private Boolean isScrap;
    }
}
