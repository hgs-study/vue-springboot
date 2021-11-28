DROP TABLE IF EXISTS POST;
DROP TABLE IF EXISTS USER;

create table user (
    user_id bigint generated by default as identity,
    name varchar(255),
    primary key (user_id)
);

create table post (
    post_id bigint generated by default as identity,
    content varchar(255),
    title varchar(255),
    user_id bigint,
    primary key (post_id),
    foreign key (user_id) references user(user_id)
);



