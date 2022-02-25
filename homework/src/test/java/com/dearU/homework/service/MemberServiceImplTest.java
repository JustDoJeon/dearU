package com.dearU.homework.service;

import com.dearU.homework.dto.MemberDTO;
import com.dearU.homework.mapper.MemberMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@Transactional
//@MybatisTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class MemberServiceImplTest {
    //    @Autowired
    MemberService memberService;

    @Mock
    MemberMapper memberMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        memberService = new MemberServiceImpl(memberMapper);
    }


    @Test
    void listAll() throws Exception {

        MemberDTO mockMember1 = new MemberDTO("aaa@naver.com", "도1", "M", "1994-10-14");
        MemberDTO mockMember2 = new MemberDTO("bbb@naver.com", "도2", "F", "1995-10-14");
        MemberDTO mockMember3 = new MemberDTO("ccc@naver.com", "도3", "M", "1996-10-14");

        memberService.insertMember(mockMember1);
        memberService.insertMember(mockMember2);
        memberService.insertMember(mockMember3);

        List<MemberDTO> result = memberService.listAll();

        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result).contains(mockMember1, mockMember2, mockMember3);

    }

    @Test
    void findByEmail() {

        String memberEmail = "wjsehgus1014@naver.com";
        String memberName = "도현";

        MemberDTO mockMember = new MemberDTO("wjsehgus1014@naver.com", "도현", "M", "1994-10-14");

        MemberDTO responseMember = memberService.findByEmail(memberEmail);

        assertThat(responseMember.getNickname()).isEqualTo(memberName);
    }

    @Test
    void insertMember() throws Exception {

        //다른경우 오류가 발생해야함 인서트된게 다르니깐
        MemberDTO mockMember = new MemberDTO("bbb@naver.com", "도2", "F", "1995-10-14");

        MemberDTO InsertMember = memberService.insertMember(mockMember);

        MemberDTO findMember = memberService.findByEmail(mockMember.getEmail());

        assertThat(findMember.getNickname()).isEqualTo(mockMember.getNickname());

        //인서트동작확인
        //memberService.insertMember(mockMember);
        //verify(memberMapper).insertMember(mockMember);

    }

    @Test
    void deleteByEmail() {
        MemberDTO mockMember = new MemberDTO("wjsehgus1014@naver.com", "도현", "M", "1994-10-14");
        memberService.deleteByEmail(mockMember.getEmail());
        verify(memberMapper).deleteByEmail(mockMember.getEmail());

    }

    @Test
    void updateMember() {
        MemberDTO mockMember = new MemberDTO("wjsehgus1014@naver.com", "도현", "M", "1994-10-14");
        memberService.updateMember(mockMember);
        mockMember.setGender("F");
        verify(memberMapper).updateMember(mockMember);
        Assertions.assertThat("F").isEqualTo(mockMember.getGender());
    }
}