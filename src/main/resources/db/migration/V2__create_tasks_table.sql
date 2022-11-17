CREATE TABLE tasks (
    id int PRIMARY KEY NOT NULL auto_increment,
    task_name varchar(200),
    description varchar(200),
    task_date Timestamp,
    task_group_id int not null, foreign key(task_group_id) references task_group(id)
);