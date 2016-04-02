create table switch (
  id bigint not null,
  name varchar(255) not null,
  value int not null,
  on_script varchar(255),
  off_script varchar(255)
);

create table rgb_led_strip (
  id bigint not null,
  name varchar(255) not null,
  red int,
  green int,
  blue int
);