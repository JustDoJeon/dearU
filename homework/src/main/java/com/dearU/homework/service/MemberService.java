package com.dearU.homework.service;

import com.dearU.homework.dto.MemberDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    //회원 전체 출력
    List<MemberDTO> listAll() throws Exception;

    //회원 상세보기
    MemberDTO findByEmail(String email);

    //회원 가입
    MemberDTO insertMember(MemberDTO memberDTO) throws Exception;

    //회원 삭제
    void deleteByEmail(String email);

    //회원 수정
    void updateMember(MemberDTO memberDTO);
}
