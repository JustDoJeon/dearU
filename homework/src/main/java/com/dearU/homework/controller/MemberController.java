package com.dearU.homework.controller;


import com.dearU.homework.dto.MemberDTO;
import com.dearU.homework.exception.ExceptionResponse;
import com.dearU.homework.exception.NotSupportedException;
import com.dearU.homework.exception.UserNotFoundException;
import com.dearU.homework.service.MemberService;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //전체 조회
    @GetMapping("/lists")
    public ResponseEntity<List<MemberDTO>> listAll () throws Exception {

        List<MemberDTO> list = memberService.listAll();
        System.out.println(list);

        if (list.size() == 0) {
            throw new UserNotFoundException(String.format("User not found "));
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //이메일로 상세조회
    @GetMapping("/{email}")
    public ResponseEntity<MemberDTO> detail( @PathVariable String email) {
        MemberDTO memberDTO = memberService.findByEmail(email);
        log.info("ReqeustParameter : " + email);
        log.info("ResponseParmeter: " + memberDTO);

        if (memberDTO == null) {
            throw new UserNotFoundException(String.format("email[%s] not found", email));
        }

        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    //회원가입
    @PostMapping("/register")
    public ResponseEntity<MemberDTO> insert(@RequestBody MemberDTO memberDTO) throws Exception {

        log.info("ReqeustParameter : " + memberDTO);

        memberService.insertMember(memberDTO);


        log.info("ResponseParmeter: " + memberDTO);

        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }

    // 특정회원 삭제 (email을 아이디처럼 기본키로 설정해놔서 이걸로 판별했음)
    @DeleteMapping("/delete/{email}")
    public ResponseEntity<MemberDTO> delete( @PathVariable String email) {
        MemberDTO memberDTO = memberService.findByEmail(email);
        log.info("ReqeustParameter : " + email);
        log.info("ResponseParmeter: " + memberDTO);

        if (memberDTO == null) {
            throw new UserNotFoundException(String.format("email[%s] not found", email));
        }
        memberService.deleteByEmail(memberDTO.getEmail());


        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }


    //회원 수정
    @PutMapping("/update/{email}")
    public ResponseEntity<MemberDTO> update(@PathVariable String email, @RequestBody MemberDTO memberDTO) {

        log.info("ReqeustParameter : " + email);

        if (memberDTO == null) {
            throw new UserNotFoundException(String.format("email[%s] not found", email));
        }
        memberService.updateMember(memberDTO);


        log.info("ResponseParmeter: " + memberDTO);

        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }


}
