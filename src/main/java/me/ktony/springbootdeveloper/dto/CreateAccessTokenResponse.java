package me.ktony.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CreateAccessTokenResponse {

    private String refreshToken;

}
