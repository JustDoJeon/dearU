package com.dearU.homework.mapper;

import com.dearU.homework.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    //전체 조회
    List<MemberDTO> listAll();

    //회원 가입
    MemberDTO insertMember(MemberDTO memberDTO);

    //회원 상세조회
    MemberDTO findByEmail(String email) ;

    //회원 삭제
    void deleteByEmail(String email);

    //회원 수정
    void updateMember(MemberDTO memberDTO);
}
