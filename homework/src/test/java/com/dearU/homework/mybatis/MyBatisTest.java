package com.dearU.homework.mybatis;

import com.dearU.homework.dto.MemberDTO;
import com.dearU.homework.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class MyBatisTest {

    Logger log = (Logger) LoggerFactory.getLogger(MyBatisTest.class);


    @Autowired
    MockMvc mockMvc;

    // MySQL 연동 테스트
    @Test
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234")) {
            log.info("mysql 연결 : " + conn);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
