
INSERT INTO task_groups (id,task_group_name) values (1, 'Administration');
INSERT INTO task_groups (id,task_group_name) values (2, 'Conferences');
INSERT INTO task_groups (id,task_group_name) values (3, 'Maintenance');
INSERT INTO task_groups (id,task_group_name) values (4, 'Programming');
INSERT INTO task_groups (id,task_group_name) values (5, 'Testing');


INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (1, 'Creating models', 'developing models of data','2022-12-17 11:00:00', 4, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (2, 'Creating controllers', 'developing controllers, methods','2022-12-16 18:00:00', 4, 1);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (3, 'Creating services', 'developing services methods','2022-12-17 12:30:00', 4, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (4, 'Update meeting', 'developing models of data','2022-12-17 11:23:00', 4, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (5, 'Update meeting 2', 'update meeting','2022-12-17 16:38:00', 2, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (6, 'Integration tests', 'integration tests of application','2022-12-17 13:30:00', 5, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (7, 'Application administration', 'creating admin user of application','2022-12-17 11:40:00', 1, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (8, 'Support customer consultation', 'Maintenance task 1','2022-12-17 14:23:00', 3, 0);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id, is_done) values (9, 'Error analyze', 'Creating patch','2022-12-17 15:30:00', 3, 0);




