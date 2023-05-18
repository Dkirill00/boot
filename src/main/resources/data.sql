INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
INSERT INTO users (id, name, password) VALUES (1, 'admin', 'admin');
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);

# INSERT INTO roles (id, role) SELECT * FROM (SELECT 1, 'ROLE_ADMIN') AS tmp WHERE NOT EXISTS (SELECT id FROM roles WHERE id = 1) LIMIT 1;
# INSERT INTO roles (id, role) SELECT * FROM (SELECT 2, 'ROLE_USER') AS tmp WHERE NOT EXISTS (SELECT id FROM roles WHERE id = 2) LIMIT 1;
# INSERT INTO users (id, name, password) VALUES (1, 'admin', 'admin');
# INSERT INTO user_role (user_id, role_id) VALUES (1, 1);