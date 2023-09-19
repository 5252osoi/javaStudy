select*from test1;
show tables;

create table test1(
	idx int not null auto_increment primary key,
	name varchar(20) not null
);

desc test1;
select * from test1;

insert into test1 values (default, '홍길동');
insert into test1 values (default, '김말숙',20,'파주','여자');
insert into test1 values (default, '이기자');
insert into test1 values (default, '대나무');
insert into test1 values (default, '소나무',19,'상주','여자');
insert into test1 values (default, '감나무',35);
insert into test1 values (default, '대추나',40,'경주','남자');
insert into test1 values (default, '박박박',17,'상주');
insert into test1 values (default, '최최최',20,'충주');
insert into test1 values (default, '김김김',23,'인천','남자');
insert into test1 values (default, '대대대',27,'파주','남자');
insert into test1 values (default, '중중중',33,'양주','남자');
insert into test1 values (default, '하하하',31,'나주');
insert into test1 values (default, '소소소',30,'광주','남자');
insert into test1 values (default, '소소소',40,'나주');

drop table test1;  --테이블의 데이터와 구조까지 완전히 삭제

/*   alter table ==> 테이블의 구조를 바꿈 */
-- test1테이블에 age 컬럼을 추가(int, default 15)
alter table test1 add column age int default 15;

--test1테이블에 addr컬럼을 추가(add column) (varchar(50))
alter table test1 add column addr varchar(50);

--test1테이블의 addr컬럼을 address로 변경 하려면.. (change/modify column)
alter table test1 change column addr address varchar(50);

--test1테이블의 address컬럼의 varchar(50)을 30byte로 변경(change/modify)
alter table test1 modify column address varchar(30);

--test1테이블의 address컬럼 삭제(drop column)
alter table test1 drop column address;

--address컬럼을 다시 추가(varchar(30) default'청주')
alter table test1 add column address varchar(30) default '청주';

--성별(gender) 필드 추가하기 (add column)
alter table test1 add column gender char(2) default '여자';

--test1테이블을 exam 으로 이름 변경하기(rename)
alter table test1 rename exam;
alter table exam rename test1;

--exam 테이블을 삭제하시오 (구조 완전삭제)
drop table exam;

----------------------------------------------------------------------------
--DML(데이터 조작어)

--test1 테이블의 내용 보기
select*from test1;

insert into test1 values (default,'가나나',55,'제주');

--test1테이블의 '성명/나이'정보의 모든 레코드를 보여주시오.
select name,age from test1;

--홍길동의 나이를 25세로 변경하기 (update 테이블명 set 필드명 ='변경내용' where_조건_;)
update test1 set age=25 where name='홍길동';

--홍길동의 성별을 남자로 변경하기 (update)
update test1 set gender='남자' where name='홍길동';

--이기자의 성별을 남자로 변경하기
update test1 set gender='남자' where name='이기자';

--'소나무/대나무/감나무/가나나/박박박/대대대'의 성별을 남자로 변경하기
update test1 set gender='남자' where name='소나무'or name='대나무'or name='감나무'or name='가나나'or name='박박박'or name='대대대';

--중중중 하하하 김김김 성별 남자로 변경
update test1 set gender='남자' where name in ('중중중','하하하','김김김')

--정렬 : order by 필드명 __옵션__ : 옵션 생략시엔 오름차순(asc),내림차순(desc)
--성명 오름차순으로 출력하기 
select*from test1 order by name;
select*from test1 order by name desc;

--나이 내림차순으로 출력
select*from test1 order by age desc;

--성별 오름차순 . . .
select*from test1 order by gender;

--성별 오름차순으로 정렬하되 성별이 같으면 두번째 키는 성명 내림차순으로 출력하기
select*from test1 order by gender, name desc;

--성별 내림차순으로 정렬하고 성별이 같은경우 나이가 적은사람을 우선으로 출력 
select*from test1 order by gender desc, age;

--1차 성별 내림차순, 2차 주소 오름차순, 3차 나이 내림차순, 4차 색인번호(idx)내림차순으로 출력
select*from test1 order by gender desc, address,age desc,idx desc;
--나이 30대만 출력하기 (30~39) : 필드명 between __and __
select*from test1 where age>=30 and age<40;
select*from test1 where age between 30 and 39;


--30대인 남자만 출력하기(30~39)
select*from test1 where age>=30 and age<40 and gender='남자';

--30대인 남자만 이름 내림차순으로 출력하기(30~39)
select*from test1 where age>=30 and age<40 and gender='남자' order by name desc;

--나이가 20대이거나 40대인 자료만 출력하기
select*from test1 where (age>=20 and age<30) or (age>=40 and age<50);

--청주에 살거나 인천에 사는 사람이 있으면 출력하시오.
select*from test1 where address='청주'or address='인천';
select*from test1 where address in('청주','인천');

--청주에 살거나 경주에 사는 사람중에서 나이가 20대 이하인 사람만 출력
select*from test1 where (address='청주'or address='경주')and age<30;
select*from test1 where address in('청주','경주')and age<30;

-- 청주에 살거나 나이가 20대 인 남자만 출력
select*from test1 where address='청주' or (age>=20 and age<30)and gender='남자';

--성이 '김'씨만 출력 (like 연산자 : %(복수개), _(단수개))
select*from test1 where name like '김%';

--주소의 마지막 글자가 '~주' 로 끝나는 자료 출력
select*from test1 where address like '%주'; 

--이름 중에서 '나'를 포함하고있는 모든 자료 출력
select*from test1 where name like '%나%';
--이름 두번째 글자가 '나'인 자료만 출력
select*from test1 where name like '_나%'

--이름중에서 두번째 글자가 '나'자를 포함한 자료의 '성명/주소'만 출력하기
select name,address from test1 where name like '_나%';

--자료를 10개만 출력하시오 (제한 : limit)
select*from test1 limit 10;

--인덱스번호 4에서부터 5개 출력하기 **(인덱스는 0번부터 시작)**
select*from test1 limit 4,5;

--주소의 마지막 글자가 '~주' 로 끝나는 자료의 나이를 1살 씩 추가하시오
update test1 set age=age+1 where address like '%주'; 

--청주에 사는 남자
select*from test1 where address='상주' and gender='남자'
delete from test1 where address='상주' and gender='남자'


--나이가 많은순서로 5명만 출력하기
select*from test1 order by age desc limit 5; 