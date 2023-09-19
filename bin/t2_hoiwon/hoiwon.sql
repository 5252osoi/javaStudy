show tables;

create table hoiwon(
	idx int not null auto_increment primary key,
	name varchar (20) not null,
	age int default 20,
	address varchar(50),
	gender char(2) default'여자'
);

desc hoiwon;
select *from hoiwon;

insert into hoiwon values (default, '홍길동',30,'여주','남자');
insert into hoiwon values (default, '김말숙',20,'파주','여자');
insert into hoiwon values (default, '이기자',55,'서울','여자');
insert into hoiwon values (default, '대나무',59,'충주','여자');
insert into hoiwon values (default, '소나무',19,'상주','여자');
insert into hoiwon values (default, '감나무',35,'충주','남자');
insert into hoiwon values (default, '대추나',40,'경주','남자');
insert into hoiwon values (default, '박박박',17,'상주',default);
insert into hoiwon values (default, '최최최',20,'충주','남자');
insert into hoiwon values (default, '김김김',23,'인천','남자');
insert into hoiwon values (default, '대대대',27,'파주','남자');
insert into hoiwon values (default, '중중중',33,'양주','남자');
insert into hoiwon values (default, '하하하',31,'나주','여자');
insert into hoiwon values (default, '소소소',30,'광주','남자');
insert into hoiwon values (default, '소소소',40,'나주','남자');