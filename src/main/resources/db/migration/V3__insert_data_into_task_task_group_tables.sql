INSERT INTO task_group (id, group_name) VALUES (1, 'Conferences');
INSERT INTO task_group (id, group_name) VALUES (2, 'Development');
INSERT INTO task_group (id, group_name) values (3, 'Testing');
INSERT INTO task_group (id, group_name) values (4, 'Maintenance');

INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (1, 'Creating models', 'developing models of data','2022-11-17 11:00:00', 2);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (2, 'Creating controllers', 'developing controllers, methods','2022-11-16 18:00:00', 2);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (3, 'Creating services', 'developing services methods','2022-11-17 12:30:00', 2);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (4, 'Update meeting', 'developing models of data','2022-11-17 11:23:00', 1);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (5, 'Update meeting 2', 'developing models of data','2022-11-17 16:38:00', 1);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (6, 'Integration tests', 'integration tests of application','2022-11-17 11:00:00', 3);
INSERT INTO tasks (id, task_name, description, task_date, task_group_id) values (7, 'Application administration', 'creating admin user of application','2022-11-17 11:00:00', 4);