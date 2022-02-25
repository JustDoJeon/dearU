package com.dearU.homework.service;

import com.dearU.homework.dto.MemberDTO;
import com.dearU.homework.mapper.MemberMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberServiceImpl implements MemberService{

    private MemberMapper memberMapper;

    //생성자 주입
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<MemberDTO> listAll() throws Exception {
        return memberMapper.listAll();
    }

    @Override
    public MemberDTO findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    @Override
    public MemberDTO insertMember(MemberDTO memberDTO) throws Exception {
      return memberMapper.insertMember(memberDTO);
    }

    @Override
    public void deleteByEmail(String email) {
        memberMapper.deleteByEmail(email);
    }

    @Override
    public void updateMember(MemberDTO memberDTO) {
        memberMapper.updateMember(memberDTO);
    }
}
