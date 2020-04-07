-----Spring Web Project ------------------------------------------------



DROP USER spring2 CASCADE;

CREATE USER spring2 
IDENTIFIED BY spring2 
DEFAULT TABLESPACE users 
TEMPORARY TABLESPACE temp 
PROFILE DEFAULT;



GRANT CONNECT, RESOURCE TO spring2;
GRANT CREATE VIEW, CREATE SYNONYM TO spring2;
 
ALTER USER kamejsp ACCOUNT UNLOCK;
GRANT CONNECT, RESOURCE TO kamejsp;


-----------Part3------------------------------------------------
create sequence seq_board;

create table tbl_board (
  bno number(10,0),
  title varchar2(200) not null,
  content varchar2(2000) not null,
  writer varchar2(50) not null,
  regdate date default sysdate, 
  updatedate date default sysdate
);

alter table tbl_board add constraint pk_board 
primary key (bno);

insert into tbl_board(bno,title,content,writer) values(seq_board.nextval,'�׽�Ʈ ����','�׽�Ʈ ����','user00');

commit;


--p271: 
insert into tbl_board(bno, title, content, writer) (select seq_board.nextval, title,content,writer from tbl_board);
commit;


----------Part4------------------------------------------------
create table tbl_reply (
  rno number(10,0), 
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null, 
  replyDate date default sysdate, 
  updateDate date default sysdate
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key (rno);

alter table tbl_reply  add constraint fk_reply_board  
foreign key (bno)  references  tbl_board (bno); 

create table tbl_reply (
  rno number(10,0), 
  bno number(10,0) not null,
  reply varchar2(1000) not null,
  replyer varchar2(50) not null, 
  replyDate date default sysdate, 
  updateDate date default sysdate
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key (rno);

alter table tbl_reply  add constraint fk_reply_board  
foreign key (bno)  references  tbl_board (bno); 

-----------------------PART5: AOP&Transaction--------------------------

--tranaction �׽�Ʈ��
create table tbl_sample1(col1 varchar2(500));
create table tbl_sample2(col2 varchar2(50));

---19.2.4 @Transaction�� �ϱ� ���� �缳��

--�׽�Ʈ�� ���ؼ� ������ ������ tbl_sample1�� �����͸� �����ϰ�, commit�ϱ�

delete tbl_sample1;
delete tbl_sample2;
commit;


----------------------Part6: FileUpload-------------------------------------------------
create table tbl_attach ( 
  uuid varchar2(100) not null,
  uploadPath varchar2(200) not null,
  fileName varchar2(100) not null, 
  filetype char(1) default 'I',
  bno number(10,0)
);

alter table tbl_attach add constraint pk_attach primary key (uuid); 
alter table tbl_attach add constraint fk_board_attach foreign key (bno) references tbl_board(bno);
