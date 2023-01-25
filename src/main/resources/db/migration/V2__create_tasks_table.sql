CREATE TABLE tasks (
    id int PRIMARY KEY auto_increment NOT NULL,
    task_name varchar(200),
    description varchar(2000),
    task_date Timestamp,
    done boolean,
    task_group_id int,
    foreign key(task_group_id) references task_groups(id)
);

