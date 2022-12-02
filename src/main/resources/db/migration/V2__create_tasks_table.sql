CREATE TABLE tasks (
    id int PRIMARY KEY NOT NULL,
    task_name varchar(200),
    description varchar(200),
    task_date Timestamp,
    is_done boolean,
    task_group_id int,
    foreign key(task_group_id) references task_groups(id)
);

