# 스프링부트 블로그 V2

## 기획 끝

## 화면설계 끝

## 화면코드 끝

## 테이블설계

## 1단계 기능

- (특징 : 자바스크립트, 예외처리)
- 회원가입 (A)
- 로그인 (A)
- 회원정보 보기 (A)
- 회원정보 수정하기 (A)
- 게시글 작성하기 (B)
- 게시글 목록보기 (B)
- 게시글 상세보기 (C)
- 게시글 삭제하기 (C)
- 게시글 수정하기 (C)
- 댓글 작성하기 (C)
- 댓글 삭제하기 (C)
- 예외처리

## 2단계 기능

- 유저네임 중복체크 (AJAX) (A) (22일)
- 검색하기 (B) (22일)
- 회원가입시 사진등록 (파일등록 23일)

## 3단계 기능 (24일)
- 섬머노트
- 필터(Filter)
- 유효성검사 자동화

## 테이블 쿼리

```sql
create database blogdb;

use blogdb;

create table user_tb (
    id integer auto_increment,
    created_at timestamp,
    email varchar(20) not null,
    password varchar(60) not null,
    username varchar(20) not null unique,
    primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table board_tb (
    id integer auto_increment,
    content varchar(10000),
    created_at timestamp,
    title varchar(100) not null,
    user_id integer,
    primary key (id),
    constraint fk_board_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

create table reply_tb (
    id integer auto_increment,
    comment varchar(100) not null,
    created_at timestamp,
    board_id integer,
    user_id integer,
    primary key (id),
    constraint fk_reply_board_id foreign key (board_id) references board_tb (id),
    constraint fk_reply_user_id foreign key (user_id) references user_tb (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

```

### 08/14

1. 영속화 컨텍스트 테스트

   - persist
   - clear
   - flush

2. 회원가입

3. 로그인

   - 자바스크립트 활용
   - 히스토리백과 하이퍼링크 이동

4. 회원수정

   - 세션과 DB의 동기화필요성

### 08/16

1. 더티체킹

2. 게시글 목록보기

   - fetch
   - ORM, Hibernate와 JPA

3. Lazy로딩

   - LAZY와 EAGER
   - fail on empty beans오류와 해결

4. 페이징

5. 로그아웃

6. 로그인 화면 수정

### 08/17

1. 게시글 상세보기

2. 게시글 삭제하기

3. 게시글 수정하기

4. 예외처리

### 08/21

1. 양방향 맵핑

2. 댓글 삭제

3. 댓글 쓰기

### 08/22

1. 댓글쓰기

2. 댓글삭제

3. cascade 옵션, fk null
