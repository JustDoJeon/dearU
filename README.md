# 회원 MVC 구현 

[깃주소] (https://github.com/JustDoJeon/dearU)

## <h2> 요구 사항 내용 </h2>

<br>
<br>

A.	기본 요구사항

<br>

i.	Java 1.8 이상 
-> JAVA 11 사용 

<br>

ii.	Spring or Spring boot Framework
-> Spirng boot framework 사용했습니다.

<br>

iii.Restful 기반(get, post, put, delete)
목록조회 -> get
회원가입 -> post 
회원수정 - > put
회원탈퇴 - > delete


- postman 을 통해 동작 확인

<전체 조회>

![전체조회](https://user-images.githubusercontent.com/52389219/155704089-52565b07-b219-4436-9264-9f55b53b5f49.PNG)

<br>

<상세 조회>

![상세조회](https://user-images.githubusercontent.com/52389219/155704082-ea157ea3-2ce9-48bf-8221-3d879b22d533.PNG)

<br>

<회원 삭제> 

![삭제요청](https://user-images.githubusercontent.com/52389219/155704064-38e64660-f0bd-4645-a052-190e25609c5c.PNG)

<Br>

<회원 수정>

![업데이트](https://user-images.githubusercontent.com/52389219/155704079-b1fe0214-7b57-470c-9db4-ff27f0d1f796.PNG)


<br>

iv.	JPA or mybatis
-> 

<br>

v.	비즈니스에 맞게 DB 설계
- sql 문 
CREATE TABLE MEMBER(
EMAIL VARCHAR(100) NOT NULL,
NICKNAME VARCHAR(30) NOT NULL,
GENDER VARCHAR(1) NOT NULL,
BIRTHDATE VARCHAR(100) NOT NULL,
PRIMARY KEY(EMAIL)
);

INSERT INTO MEMBER VALUES('wjsehgus@naver.com' , '전도현', 'M' ,  '1994-10-14');

작은양의 데이터 테스트를 위해 sequence나 index를 두지 않았습니다.

<br>

vi.	DB는 innodb 사용
->  MySQL 사용 

<br>

vii.	mvc 패턴 활용 
-> controller service dao(mapper) + mybaits xml 설정 파일 사용

<br>

viii.	logback 을 이용한 logging 처리
ix.	테스트 코드
x.	비지니스에 맞게 crud 생성
B.	비즈니스 요구사항
i.	회원 관련 기능


<br>


C.	공통 처리사항
i.	결과(Response) 처리
1.	정상 결과(프로세스상 정상, http 200 ok)
2.	실패 결과(프로세스상 정상, http 200 ok)

-> ResponseEntity<> 리턴을 통해 해결

<br>

ii.	로깅 처리
1.	시간별 파일 생성

-> logback 의 설정을 통해 시간별로 로그파일 생성

<br>

iii.	로그 내용
1.	request parameter 
2.	response parameter 

-> 컨트롤러 단에서 로그 사용

<br>

iv.	에러 처리(별도처리 요망)
1.	없는 url : 404 에러
2.	메소드를 지원하지 않는 에러 : 405 에러

-> Exception 디렉토리에 
ControllerAdvice와 Exception 클래스 상속을 통해 오버라이딩해서 처리 
두 에러에 대한 처리 구현

<br>
<br>

-------

- 현재 JPA를 학습중에 있지만 완벽하지않기 때문에 Mybatis 를 통한 DB접근기술을 적용했습니다.

- 테스트코드에서의 에러가 발생하는데 Mybatis를 통해 실사용 데이터베이스 테스트코드에 설정 문제가 있었지만

- 해당 테스트코드의 로직은 맞다고 판단하여 작성하였습니다. 

- 시퀀스나 인덱스를 디비설계시 사용하지않은점은 데이터의 양이 적기때문에 따로 추가하지않았습니다.

그래서 이메일을 primary key로 설정하고 로직을 구현했습니다.

- LocalDateTime 형으로 생일의 타입을 맞췄었지만 지속적인 오류 발생을 해결하지 못하면서 시간지연상 String으로 처리했습니다. 