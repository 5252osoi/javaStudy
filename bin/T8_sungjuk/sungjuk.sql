show tables;
desc sungjuk
select*from sungjuk

create table sungjuk(
	idx int not null auto_increment primary key,	/*성적고유번호*/
	name varchar(20) not null,						/*이름*/
	kor int default 0,								/*국어점수*/
	eng int default 0,								/*영어점수*/
	mat int default 0								/*수학점수*/
);


insert into sungjuk values (default,'홍길동',100,90,80);

