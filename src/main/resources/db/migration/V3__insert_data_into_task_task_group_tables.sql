
INSERT INTO task_groups (id,task_group_name) values (1, 'Administration');
INSERT INTO task_groups (id,task_group_name) values (2, 'Conferences');
INSERT INTO task_groups (id,task_group_name) values (3, 'Maintenance');
INSERT INTO task_groups (id,task_group_name) values (4, 'Programming');
INSERT INTO task_groups (id,task_group_name) values (5, 'Testing');


INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (1, 'Creating models', 'developing models of data','2023-01-18 18:00:00', 4, 'true');
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (2, 'Creating controllers', 'developing controllers, methods','2022-12-27 18:00:00', 4, 1);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (3, 'Creating services', 'developing services methods','2023-01-18 18:00:00', 4, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (4, 'Update meeting', 'developing models of data','2022-12-28 11:23:00', 4, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (5, 'Update meeting 2', 'update meeting','2022-12-29 16:38:00', 2, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (6, 'Integration tests', 'integration tests of application','2022-12-29 13:30:00', 5, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (7, 'Application administration', 'creating admin user of application','2022-12-25 11:40:00', 1, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, done) values (8, 'Support customer consultation', 'Maintenance task 1','2022-12-26 14:23:00', 3, 0);





