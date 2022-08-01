create table if not exists events(
  id INT not null,
  file_id INT not null,
  primary key(id),
  foreign key(file_id) references files(id)
);