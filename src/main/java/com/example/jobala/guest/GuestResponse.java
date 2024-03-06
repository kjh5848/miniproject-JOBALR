package com.example.jobala.guest;

import lombok.AllArgsConstructor;
import lombok.Data;

public class GuestResponse {
    @AllArgsConstructor
    @Data
    public static class DetailDTO {

        private Integer id;
        private Boolean isScrap;
    }

}
