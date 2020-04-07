drop table tbl_board;
drop SEQUENCE seq_board;

create SEQUENCE seq_board;

create table tbl_board(
    bno number(10, 0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT sysdate,
    updatedate DATE DEFAULT sysdate
);

alter table tbl_board add CONSTRAINT pk_board primary key (bno);
/* primart key 이름설정에 따라 아래의 코드가 모두 달라진다 */
/* 코드의 재사용을 위해 가능한 제약조건의 이름을 설정해야한다. */

INSERT INTO tbl_board(bno, title, content, writer)
VALUES (seq_board.nextval, 'test name', 'test content', 'user00');

select * from tbl_board where bno > 0;

COMMIT;

insert into tbl_board(bno, title, content, writer)
(select seq_board.nextval, title, content, writer from tbl_board);

/* oracle hint (/*+ Hint name (param...) */) */
select count(*) from tbl_board;
select count(*) from tbl_board order by bno desc;

/* pk_board는 Primary key를 별도로 이름을 만들었을때 사용 */
select /*+ INDEX_DESC(tbl_board pk_board */ * from tbl_board where bno > 0;

select * from tbl_board order by bno desc;
select /*+ INDEX_DESC (tbl_board pk_board) */* from tbl_board;

select /*+ INDEX_ASC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board;
select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where bno > 0;
select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <= 10;

/* rownum은 반드시 1을 포함해야 한다. */
/* select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum > 10 and rownum <= 20; */
select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <= 20;

/* 최종 목차 검색 Query */
select bno, title, content from (select /*+ INDEX_DESC(tbl_board pk_board) */ rownum rn, bno, title, content from tbl_board where rownum <= 20) where rn > 10;

/* title, content검색 Query */
select bno, title, content
from (
	select /*+ INDEX_DESC(tbl_board pk_board) */
		rownum rn, bno, title, content
	from tbl_board
	where 
		(titla like '%Test' or content like '%Test') and rownum <= 20
	)
where rn > 10;