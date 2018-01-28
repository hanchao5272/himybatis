# MyBaits代码实例

## 1.MyBatis的入门实例：通过纯XML配置
```sql
drop table question;
create table `question`(
	`id` int(5) unsigned not null auto_increment comment '试题id',
    `title` varchar(20) not null comment '题目',
    `score` int(3) not null comment '分数',
    `answer` varchar(100) comment '答案',
    primary key(id)
)engine=InnoDB comment='试题' auto_increment=1 default charset=utf8;
insert into question values(99999,'简答题',100,'你好吗？');
```
## 2.MyBatis通过XML+IDAO的配置方式
```sql
drop table problem;
create table `problem`(
	`id` int(5) unsigned not null auto_increment comment '难题id',
    `title` varchar(20) not null comment '题目',
    `score` int(3) not null comment '分数',
    `answer` varchar(100) comment '答案',
    primary key(id)
)engine=InnoDB comment='难题' auto_increment=1 default charset=utf8;
insert into problem values(99999,'题目1',100,'你好吗？');
```
## 3.MyBatis对单表的增删改查
```sql
drop table topic;
create table `topic`(
	`id` int(5) unsigned not null auto_increment comment '话题',
    `title` varchar(20) not null comment '题目',
    `score` int(3) not null comment '分数',
    `answer` varchar(100) comment '答案',
    primary key(id)
)engine=InnoDB comment='话题' auto_increment=1 default charset=utf8;
insert into topic values(99999,'题目1',100,'你好吗？');

```
## 4.MyBatis的一对多关联处理
```sql
drop table person;
create table `person`(
	`person_id` int(5) unsigned not null comment '人员id',
    `name` varchar(10) not null comment '姓名',
    `age` int(3) not null comment '年龄',
    primary key(person_id)
)engine=InnoDB comment='人员' auto_increment=1 default charset=utf8;
insert into person values(1,'张三',25);
insert into person values(2,'李四',16);
select * from person;

drop table experience;
create table `experience`(
	`experience_id` int(5) unsigned not null comment '工作经验id',
    `person_id` int(5)  unsigned not null comment '人员id',
    `company` varchar(32) not null comment '公司',
    `position` varchar(16) not null comment '职位',
    primary key(experience_id)
)engine=InnoDB comment='工作经验' auto_increment=1 default charset=utf8;
insert into experience values(1,1,'北京天大地大科技有限公司','开发工程师');
insert into experience values(2,1,'南通考古研究院','考古专家');
insert into experience values(3,1,'海南旅游集团','CEO');
select * from experience;
```
## 5.MyBatis的多对一关联处理
```sql
drop table person;
create table `person`(
	`person_id` int(5) unsigned not null comment '人员id',
    `name` varchar(10) not null comment '姓名',
    `age` int(3) not null comment '年龄',
    primary key(person_id)
)engine=InnoDB comment='人员' auto_increment=1 default charset=utf8;
insert into person values(1,'张三',25);
insert into person values(2,'李四',16);
select * from person;

drop table experience;
create table `experience`(
	`experience_id` int(5) unsigned not null comment '工作经验id',
    `person_id` int(5)  unsigned not null comment '人员id',
    `company` varchar(32) not null comment '公司',
    `position` varchar(16) not null comment '职位',
    primary key(experience_id)
)engine=InnoDB comment='工作经验' auto_increment=1 default charset=utf8;
insert into experience values(1,1,'北京天大地大科技有限公司','开发工程师');
insert into experience values(2,1,'南通考古研究院','考古专家');
insert into experience values(3,1,'海南旅游集团','CEO');
select * from experience;
```
## 6.MyBatis的多对多映射处理
```sql
drop table student;
create table `student`(
	`student_id` int(4) unsigned not null comment '学生id',
    `name` varchar(10) not null comment '姓名',
    `number` varchar(3) not null comment '学号',
    primary key(student_id)
)engine=InnoDB comment='学生' auto_increment=1 default charset=utf8;
insert into student values(1,'张三','003');
insert into student values(2,'李四','004');
insert into student values(3,'王五','005');
select * from student;

drop table course;
create table `course`(
	`course_id` int(5) unsigned not null comment '选修课id',
    `name` varchar(10)  not null comment '课程名',
    `score` int(1) unsigned not null comment '学分',
    primary key(course_id)
)engine=InnoDB comment='选修课' default charset=utf8;
insert into course values(1,'Java开发',2);
insert into course values(2,'国家地理',1);
insert into course values(3,'十级英语',2);
insert into course values(4,'高等数学',3);
insert into course values(5,'国语',1);
select * from course;

drop table student_course;
create table `student_course`(
	`student_id` int(4) unsigned not null comment '学生id',
    `course_id` int(4) unsigned not null comment '选修课id',
    primary key(student_id,course_id)
)engine = InnoDB comment='学生选修课中间表' charset=utf8;
insert into student_course values(1,1);
insert into student_course values(1,3);
insert into student_course values(1,5);

insert into student_course values(2,2);
insert into student_course values(2,4);

insert into student_course values(3,1);
insert into student_course values(3,2);
insert into student_course values(3,3);
insert into student_course values(3,4);
insert into student_course values(3,5);
select * from student_course;
```