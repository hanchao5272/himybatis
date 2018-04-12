# MyBaits代码实例

CSDN专栏：[MyBatis学习实例](https://blog.csdn.net/column/details/20009.html)

----------

[SSM框架超级详细整合记录：Spring+Spring MVC+MyBatis+Maven+Git+MySQL+IDEA](http://blog.csdn.net/hanchao5272/article/details/79305666)

最近抽空将Mybatis涉及到的一些技术进行了复习，并写了一些代码实例，将源代码整理到这里，作为以后翻阅的记录。

说明： 

- 因为时间有限，文章内容可能存在错别字等现象，敬请谅解。 
- 为了展示各知识点，有些命名方式很不规范（尤其是包名、类名），敬请谅解。 
- 因为水平有限，有些内容可能存在错误，敬请指教。

## 目录

[MyBatis代码实例系列-01：MyBatis简单搭建与入门实例：纯XML方式、IDAO+XML方式](http://blog.csdn.net/hanchao5272/article/details/79184403)
[MyBatis代码实例系列-02：MyBatis用log4j打印SQL以及MyBatis的事务控制](http://blog.csdn.net/hanchao5272/article/details/79200426)
[MyBatis代码实例系列-03：MyBatis单张表简单实现增删改查 + log4j + 手动事务控制](http://blog.csdn.net/hanchao5272/article/details/79244310)
[MyBatis代码实例系列-04：MyBatis多表映射实例（一对多、多对一和多对多）](http://blog.csdn.net/hanchao5272/article/details/79244359)
[MyBatis代码实例系列-05：Mybatis初步整合Spring + Spring MVC框架，实现Web请求实例](http://blog.csdn.net/hanchao5272/article/details/79247396)
[MyBatis代码实例系列-06：Mybatis动态SQL标签（一）---if、where、set、trim、choose](http://blog.csdn.net/hanchao5272/article/details/79248416)
[ MyBatis代码实例系列-07：Mybatis动态SQL标签（二）---bind、foreach和多数据库厂商支持_databaseId](http://blog.csdn.net/hanchao5272/article/details/79250556)
[MyBatis代码实例系列-08：MyBatisGenerator插件及扩展(中文注释和Mapper重命名为Dao)](http://blog.csdn.net/hanchao5272/article/details/79251828)
[MyBatis代码实例系列-09：初步整合Spring + Spring MVC框架之后，如何打印MyBatis的SQL语句](http://blog.csdn.net/hanchao5272/article/details/79253645)
[MyBatis代码实例系列-10：MyBatis通过PageHelper插件实现分页查询](http://blog.csdn.net/hanchao5272/article/details/79254394)

## 实例SQL记录
### 1.MyBatis的入门实例：通过纯XML配置
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
### 2.MyBatis通过XML+IDAO的配置方式
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
### 3.MyBatis对单表的增删改查
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
### 4.MyBatis的一对多关联处理
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
### 5.MyBatis的多对一关联处理
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
### 6.MyBatis的多对多映射处理
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