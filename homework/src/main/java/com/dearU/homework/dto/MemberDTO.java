package com.dearU.homework.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberDTO {

    private String email; //회원 이메일
    private String nickname; // 회원 닉네임
    private String gender; // 회원 성별
    private String birthdate; // 회원 생일

}
