# 또 다른 지속 가능한 혁신, 다시(DASI) 
## DOES ANOTHER SUSTAINABLE INNOVATION
- - -

## 팀 소개

### 프로그래밍 기초 언어인 JAVA 공부를 위한 팀 
## JAVA조 

- - -

### 팀원

#### [팀장] 배승수
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/5eea4b67-6152-457b-9920-07b66dde5168)
- 이메일: bnj021212@gmail.com
- GitHub 프로필: [[팀원 1 GitHub 프로필 링크]](https://github.com/costudying)
- 역할: DBA / 제작 주문

#### [팀원] 김민주
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/33229f3c-c8fa-4673-b6af-2c338eddd3cc)
- 이메일: 팀원 2 이메일 주소
- GitHub 프로필: [팀원 2 GitHub 프로필 링크]
- 역할: 디자인 / 시큐리티

#### [팀원] 이가현
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/700ff629-b655-43b9-966f-ad2fa5b9edd3)
- 이메일: 팀원 2 이메일 주소
- GitHub 프로필: [팀원 2 GitHub 프로필 링크]
- 역할: 문의 게시판 관리
  
#### [팀원] 김민범
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/aac1fa35-3eca-4de1-af79-20edc2d8dd2e)
- 이메일: 팀원 2 이메일 주소
- GitHub 프로필: [팀원 2 GitHub 프로필 링크]
- 역할: 마이 페이지

## 목차

1. [개요](#개요)
2. [시작하기](#시작하기)
   - [사전 요구 사항](#사전-요구-사항)
   - [설치 및 설정](#설치-및-설정)
3. [사용법](#사용법)
4. [기능](#기능)

## 개요

- 업사이클링 제품 판매로 환경과 소비자를 연결하고 주문제작을 통한 새로운 가치 창출
- 업사이클링과 반려견 용품을 결합한 주문제작 전문 공방 컨셉


## 시작하기

### 사전 요구 사항

프로젝트를 실행하기 전에 아래 사전 요구 사항을 확인하세요.

#### 개발 환경
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/7845b3e5-e497-411d-b9f0-605a85986b37)


#### 구조
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/de579a03-bd70-4dd9-94b8-b4d9731cf89c)

#### 소프트웨어 요구 사항

- MySQL 데이터베이스가 필요합니다.
- 하단의 gradle 디펜던시를 추가해야합니다.
```
 implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.3.1'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.mysql:mysql-connector-j'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter-test:2.3.1'

    compileOnly 'org.projectlombok:lombok:1.18.24'
    annotationProcessor 'org.projectlombok:lombok:1.18.24'

    implementation 'com.github.pagehelper:pagehelper-spring-boot-starter:1.4.6'

    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity5'
    testImplementation 'org.springframework.security:spring-security-test'
    implementation 'org.springframework.boot:spring-boot-starter-validation'

    implementation 'org.springframework.boot:spring-boot-starter-mail'

    implementation 'org.json:json:20230227'

    implementation 'com.github.iamport:iamport-rest-client-java:0.2.23'
    implementation group: 'com.google.code.gson', name: 'gson', version: '2.7'
```
#### 환경 설정

프로젝트를 실행하기 전에 아래 설정을 수행하세요.

1. MySQL 서버를 실행하고 dasi 데이터베이스를 만듭니다.

2. project-dasi-sql 파일을 실행합니다.
[project-dasi-sql.zip](https://github.com/JavaJo-SemiProject/DASi-Project/files/12789775/project-dasi-sql.zip)


### 설치 및 설정

프로젝트를 설치하고 설정하는 방법에 대한 단계를 설명합니다. 필요한 설정 파일을 어떻게 구성해야 하는지도 설명할 수 있습니다.

## 사용법

1. **로그인 및 계정 생성**

   - 웹 브라우저를 열고 `http://localhost:8000`에 접속합니다.
   - 처음 사용자라면 "로그인" 접속 후 "회원가입"을 통해서 새로운 계정을 만듭니다.
   - 이미 계정이 있는 경우 "로그인"을 선택하여 로그인합니다.

2. **마이페이지**

   - 로그인 성공 시, 마이페이지를 액세스할 수 있습니다.
   - 현재 제공하고 있는 마이페이지 기능은 나의 정보 조회/나의 주문 내역/나의 문의 내역을 제공하고 있습니다.

3. **주문 제작**

   - 내가 원하는 제품을 요청할 수 있는 기능을 제공하고 있습니다.
   - "주문제작 견적문의"를 통해서 주문 등록할 수 있습니다.
   - "마이페이지"의 ""
   - 삭제하려면 항목 목록에서 해당 항목을 선택하고 "삭제"를 클릭합니다.

4. **수정 및 삭제**

   - 나의 정보를 수정 기능과 나의 문의 내역 수정 및 삭제 기능을 제공하고 있습니다.
   - 각 항목을 클릭하여 세부 정보를 확인하고 수정할 수 있습니다.
   - 삭제하려면 항목 목록에서 해당 항목을 선택하고 "삭제"를 클릭합니다.

5. **로그아웃**

   - 사용이 끝났을 때, 로그아웃하여 보안을 유지합니다.
   - 오른쪽 상단의 "로그아웃" 버튼을 클릭합니다.



## 기능

프로젝트의 주요 기능과 강점에 대한 설명을 제공합니다. 프로젝트의 핵심 기능을 명확히 나열하고 각 기능에 대한 간단한 설명을 제공합니다.

