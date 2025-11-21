INSERT INTO t_category(t_name) VALUES ('fisrt');
INSERT INTO t_category(t_name) VALUES ('second');
INSERT INTO t_category(t_name) VALUES ('third');

INSERT INTO t_program(t_name, t_description, category_id) VALUES ('fisrt','aaaaaaaa',1);
INSERT INTO t_program(t_name, t_description, category_id) VALUES ('second','bbbbbbbbb',2);
INSERT INTO t_program(t_name, t_description, category_id) VALUES ('third','cccccccc',1);

INSERT INTO t_gym(t_name, t_city) VALUES ('gym1','ddddddd');
INSERT INTO t_gym(t_name, t_city ) VALUES ('gym2','fffffffff');
INSERT INTO t_gym(t_name, t_city) VALUES ('gym3','gggggggggg');

INSERT INTO program_gym(program_id, gym_id) VALUES (1, 1);
INSERT INTO program_gym(program_id, gym_id) VALUES (1, 2);
INSERT INTO program_gym(program_id, gym_id) VALUES (2, 1);
INSERT INTO program_gym(program_id, gym_id) VALUES (3, 3);
