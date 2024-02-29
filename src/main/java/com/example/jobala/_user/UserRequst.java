package com.example.jobala._user;

import lombok.Data;

public class UserRequst {

   @Data
    public static class guestJoinDTO{
       private String name;
       private String username;
       private String password;
       private String address;
       private String phone;
       private Boolean role;
   }
}
