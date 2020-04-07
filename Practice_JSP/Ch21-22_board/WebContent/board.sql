create database board default character set utf8;

create table board.member(
	memberid varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate datetime not null
)engine=InnoDb default character set=utf8;


create table board.article(
	article_no int auto_increment primary key,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
	title varchar(255) not null,
	regdate dateTime not null,
	moddate datetime not null,
	read_cnt int
)engine=InnoDb default character set=utf8;

create table board.article_content(
	article_no int primary key,
	content text
)engine=InnoDb default character set=utf8;


--oracle--
create table member(
	memberid varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate TIMESTAMP not null
)
drop table member;
drop table article;
create table article(
	article_no int primary key,
	writer_id varchar(50) not null,
	writer_name varchar(50) not null,
	title varchar(255) not null,
	regdate TIMESTAMP not null,
	moddate TIMESTAMP not null,
	read_cnt int
)
create SEQUENCE article_no_seq INCREMENT BY 1 START WITH 1;

create table article_content(
	article_no int primary key,
	content Long
)