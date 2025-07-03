create table tags
(
    id   bigint auto_increment primary key,
    name varchar(255) not null
);


create table user_tags(

    user_id bigint not null,
    tag_id bigint not null,
    constraint user_tags_users_id__fk foreign key (user_id) references users (id) on delete cascade ,
    constraint user_tags_tags_id__fk foreign key (tag_id) references tags (id) on delete cascade
)