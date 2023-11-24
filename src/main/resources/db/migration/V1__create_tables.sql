
create table roles (
    id bigint not null auto_increment,
    name varchar(100) not null,
    primary key (id)
);

create table user_details (
    age integer,
    birth_day datetime(6),
    id bigint not null auto_increment,
    user_id bigint,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    primary key (id)
);

create table user_roles (
    active bit not null,
    created_at datetime(6) not null,
    id bigint not null auto_increment,
    role_id bigint, user_id bigint,
    primary key (id)
)

create table users (
    created_at datetime(6),
    id bigint not null auto_increment,
    email varchar(150) not null,
    password varchar(150) not null,
    user_name varchar(150) not null,
    primary key (id)
);

alter table user_details add constraint UK_user_details_ref_user_id unique (user_id);
alter table user_details add constraint FK_user_details_ref_user foreign key (user_id) references users (id);
alter table user_roles add constraint FK_user_roles_ref_role foreign key (role_id) references roles (id);
alter table user_roles add constraint FK_user_roles_ref_user foreign key (user_id) references users (id);