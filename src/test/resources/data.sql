-- call next value for hibernate_sequence
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (1, 'martin','martin@aaa.aaa',now(),now());
-- call next value for hibernate_sequence
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (2, 'denis','denis@aaa.aaa',now(),now());
-- call next value for hibernate_sequence
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (3, 'sophia','sophia@bbb.bbb',now(),now());
-- call next value for hibernate_sequence
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (4, 'james','james@bbb.bbb',now(),now());
-- call next value for hibernate_sequence
insert into user(`id`,`name`,`email`,`created_at`,`updated_at`) values (5, 'martin','martin@ccc.ccc',now(),now());

insert into publisher (`id`,`name`) values (1, '패스트 캠퍼스');

insert into book (`id`,`name`,`publisher_id`,`deleted`,`status`) values (1, 'JPA 초격차 패키지' ,1,false,100);
insert into book (`id`,`name`,`publisher_id`,`deleted`,`status`) values (2, 'Spring 초격차 패키지', 1,false,200);
insert into book (`id`,`name`,`publisher_id`,`deleted`,`status`) values (3, 'Python 초격차 패키지', 1,true,100);




