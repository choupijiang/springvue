package com.choupijiang.mango.admin.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {
    private String account;
    private String password;
    private String captcha;
}
