drop table writer;
create table if not exists writer
(
    id        int generated by default as identity primary key,
    firstName varchar(25),
    lastName  varchar(20)
);

insert into writer(firstName, lastName)
VALUES ('Alexander', 'Levchenko');
insert into writer(firstName, lastName)
VALUES ('Benjamin', 'Grahman');
insert into writer(firstName, lastName)
VALUES ('Robert', 'Kiyosaki');
insert into writer(firstName, lastName)
VALUES ('George', 'Clayson');

drop table post;
create table if not exists post
(
    id      int generated by default as identity primary key,
    content varchar(255),
    created timestamp   not null,
    updated timestamp   not null,
    status  varchar(25) not null
);

insert into post(content, created, updated, status)
values ('History of survival', current_timestamp, current_timestamp, 'ACTIVE');
insert into post(content, created, updated, status)
values ('Investment in shares', current_timestamp, current_timestamp, 'ACTIVE');
insert into post(content, created, updated, status)
values ('Ability to see', current_timestamp, current_timestamp, 'ACTIVE');
insert into post(content, created, updated, status)
values ('Financial management', current_timestamp, current_timestamp, 'ACTIVE');


drop table label;
create table if not exists label
(
    id   int generated by default as identity primary key,
    name varchar(50) not null
);

insert into label(name) VALUES ('Blackout');
insert into label(name) VALUES ('Reasonable investor');
insert into label(name) VALUES ('Rich dad, poor dad');
insert into label(name) VALUES ('The richest man in Babylon');


drop table label_post;
create table if not exists label_post
(
    post_id  int,
    foreign key (post_id) references post (id),
    label_id int,
    foreign key (label_id) references label (id) on delete set null
);

insert into label_post(post_id, label_id) VALUES (1, 1);
insert into label_post(post_id, label_id) VALUES (2, 2);
insert into label_post(post_id, label_id) VALUES (3, 3);
insert into label_post(post_id, label_id) VALUES (4, 4);

create table if not exists writer_post
(
    writer_id int,
    foreign key (writer_id) references writer (id),
    posts_id  int,
    foreign key (posts_id) references post (id)
);

insert into writer_post(writer_id, posts_id) VALUES (1, 1);
insert into writer_post(writer_id, posts_id) VALUES (2, 2);
insert into writer_post(writer_id, posts_id) VALUES (3, 3);
insert into writer_post(writer_id, posts_id) VALUES (4, 4);

