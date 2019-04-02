create schema notesapp;

create table note
(
  id          int auto_increment
    primary key,
  category    varchar(255) null,
  content     varchar(255) null,
  create_date datetime     null,
  description varchar(255) null,
  status      varchar(255) null,
  last_update_date   datetime         not null,
  title   varchar(255) null,
  user_id     int          null
);
create table user
(
  id       int auto_increment
    primary key,
  email    varchar(255) null,
  password varchar(255) null,
  role     int          null,
  username varchar(255) null
);

