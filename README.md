# MyBaits代码实例

## 1.Sql
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
## 2.sql
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
## 3.sql
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