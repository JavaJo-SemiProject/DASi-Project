![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/824ff431-06d8-4b3d-9573-4f4dc63019cf)
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
- 이메일: dididi121515@gmail.com
- GitHub 프로필: [[팀원 1 GitHub 프로필 링크]](https://github.com/gahyonii)
- 역할: FAQ / 1:1문의게시판
  
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

#### 디자인
[[Project-DASi 디자인 Figma]](https://www.figma.com/file/ePACHwHqrs8LUguTKrV7r0/dasi-temp-(Copy)?type=design&node-id=45%3A376&mode=design&t=KA5qM1Q0KrA3TcCE-1)

#### 개발 환경
<img width="3400" alt="개발 환경" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/3f26aaf4-d6f2-44e3-941e-d0262f707440">



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

   - 마이페이지 내 '문의 내역'버튼을 클릭하여 1:1문의 등록, 수정, 삭제가 가능합니다.
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/206db88e-f751-42ee-8969-5a0d49a8d1b1)
   - <img src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/4dfc714f-87df-4747-ad81-cb32226f141b">

   <img alt="스크린샷 2023-10-03 오후 8 02 30" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/80c8e41b-570b-4651-ba3b-9ba00b4ffc65">
   

   - 마이페이지를 들어가고 싶다면 우측 상단에 사람 이모티콘을 누릅니다.
     
   - 회원정보의 아이디와 비밀번호를 입력하고 로그인을 합니다.
     
     <img alt="스크린샷 2023-10-03 오후 8 02 56" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/5b29c35f-9760-4d06-833c-c727a21e74c6">
     
   - 로그인을 하면 우측 상단에 회원의 닉네임이 뜨고 닉네임을 클릭을 하면 마이페이지로 이동을 합니다.

<img alt="스크린샷 2023-10-03 오후 7 09 05" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/6b356ed6-e93b-4b07-a7b1-6c173f6887a1">

   - 마이페이지에 들어가면 회원가입을 할 때 작성한 회원정보를 확인할 수 있습니다.
   
<img alt="스크린샷 2023-10-03 오후 8 08 45" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/593ccf3c-bbfa-4d2a-97a2-85593819dfde">

   - 마이페이지에서는 나의 주문 내역을 확인할 수 있습니다
   
<img alt="스크린샷 2023-10-03 오후 8 08 59" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/7942f0f2-d1f6-434b-9e2c-261990f2d228">

   - 마이페이지에서는 나의 문의 내역도 확인이 가능합니다.
 
 <img alt="스크린샷 2023-10-03 오후 8 02 30" src="https://github.com/JavaJo-SemiProject/DASi-Project/assets/90394571/81d9150b-fb8d-41d5-8930-4f8d97315d95">
 
   - 하단에 로그아웃 버튼을 누르면 로그아웃이 되며 Index 페이지로 넘어갑니다.


3. **주문 제작**

   - 내가 원하는 제품을 요청할 수 있는 기능을 제공하고 있습니다.
   - "주문제작 견적문의"를 통해서 주문 등록할 수 있습니다.
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/0295df57-33f2-4d26-b0ed-711e9d7245e4)
     
   - "마이페이지"의 "주문 내역"을 통해서 나의 주문 리스트와 주문 상세 내역을 확인할 수 있습니다.
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/5916f305-7722-450d-b93c-7f8ac162d0f9)

   - 주문 상세 내역에서는 주문 상태 여부 및 견적 결정 시 결제 기능/배송지 등록 기능을 제공하고 있습니다.
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/e6ea4624-3b9f-42cc-9769-b7d16d2ccf3b)
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/00b364cc-5ddf-4d49-931e-89e97dc16eb3)

   - 주문 취소할 수 있습니다.

4. **관리자**

   - 회원 리스트/ 회원 주문 내역/문의 내역 기능을 제공하고 있습니다.
   - 회원 주문 내역을 조회하면서 단계별 주문 상태 변경 및 제품 가격을 입력할 수 있습니다.
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/02c7187b-d3f6-4d59-bb1b-143a309cd92a)
     ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/747458c1-290b-4203-a140-3eed8967e40e)
   - 주문 상태 변경에 따른 기능을 따로 제공하고 있습니다.
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/132265893/221ff3f7-0fa9-4dc4-b53c-eb886f627eed)

   - 삭제하려면 항목 목록에서 해당 항목을 선택하고 "삭제"를 클릭합니다.
   - 문의 관리 안에서 FAQ 등록, 수정, 삭제가 가능합니다.
    ![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/b1a95694-b4cd-44c4-8c59-f008d9fee512)


5. **수정 및 삭제**

   - 나의 정보를 수정 기능과 나의 문의 내역 수정 및 삭제 기능을 제공하고 있습니다.
   - 각 항목을 클릭하여 세부 정보를 확인하고 수정할 수 있습니다.
   - 삭제하려면 항목 목록에서 해당 항목을 선택하고 "삭제"를 클릭합니다.

6. **로그아웃**

   - 사용이 끝났을 때, 로그아웃하여 보안을 유지합니다.
   - 오른쪽 상단의 "로그아웃" 버튼을 클릭합니다.

   

     


## 기능

프로젝트는 다음과 같은 주요 기능을 제공합니다:

1. **제품 목록 표시**

   - 사용자는 업사이클링된 반려견 제품 디자인을 볼 수 있습니다.
   - 각 제품은 사진, 제품명, 설명 포함합니다.

2. **제품 제작 요청**

   - 사용자는 제품 디자인을 보고 제품을 커스텀할 수 있는 주문 제작 요청을 할 수 있습니다.
   - 주문 제작 요청에는 반려견 맞춤 사이즈, 이니셜 등의 커스텀을 제공합니다.
  
3. **제품 제작**

   - 관리자가 해당 제품 가격 견적을 결정하면 해당 제품 제작을 진행할 지 선택할 수 있습니다. 
   - 결제 과정에서 배송 정보를 입력하고 결제를 완료할 수 있습니다.
  
4. **마이페이지**

   - 사용자는 나의 정보 및 주문 내역, 문의 내역을 확인할 수 있습니다. 
   - 나의 주문 내역에서 결제, 배송지 등록, 주문 상태 여부를 확인할 수 있습니다.

5. **회원 가입 및 로그인**

   - 사용자는 회원 가입을 통해 계정을 만들고 로그인할 수 있습니다.
   - 로그인된 사용자는 제품을 구매하고 주문 내역을 확인할 수 있습니다.

6. **주문 관리**

   - 사용자는 자신의 주문 내역을 확인하고 주문 상태를 추적할 수 있습니다.
   - 주문 상태 업데이트 및 주문 취소 기능을 제공합니다.

7. **관리자 패널**

   - 관리자는 회원 및 주문, 문의 관리를 위한 관리자 패널에 액세스할 수 있습니다.
   - 회원 조회 및 주문 관리 기능, 문의 관리 기능을 제공합니다.

<admin 페이지에서의 캡쳐>
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/f4f45184-557c-4f5d-ba35-b16363d8c48e)
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/58d5e40c-1ddd-44c3-ab40-66c4c6cb8aad)
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/53898b3a-3af8-45aa-8471-77d68bc106ba)
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/ba9fac05-ae1d-461b-b7d3-b3954a28a1a3)
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/e89a1b46-9455-45f6-bd34-44480583c94a)

<사용자 페이지에서의 캡쳐>
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/02da1ca7-6ac7-40d1-b4f6-c69b399ff1d2)
![image](https://github.com/JavaJo-SemiProject/DASi-Project/assets/127739134/e7c341b0-c3d2-4bbe-8ec7-5df44d10a660)


- - -

#### 업데이트 날짜
- 2023-10-03 : 첫 작성
