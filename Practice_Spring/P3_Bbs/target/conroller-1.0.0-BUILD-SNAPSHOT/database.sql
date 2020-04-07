-----Spring Web Project ------------------------------------------------



DROP USER spring_db CASCADE;

CREATE USER spring_db 
IDENTIFIED BY spring_db 
DEFAULT TABLESPACE users 
TEMPORARY TABLESPACE temp 
PROFILE DEFAULT;



GRANT CONNECT, RESOURCE TO spring_db;
GRANT CREATE VIEW, CREATE SYNONYM TO spring_db;
 
ALTER USER spring_db ACCOUNT UNLOCK;
GRANT CONNECT, RESOURCE TO spring_db;


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

insert into tbl_board(bno,title,content,writer) values(seq_board.nextval,'테스트','테스트 내용','user00');

commit;


--p271: 
insert into tbl_board(bno, title, content, writer) (select seq_board.nextval, title,content,writer from tbl_board);
commit;


