
-- ************************** users ****************************************

INSERT INTO users (username, password, enabled) VALUES ('customer', '$2y$12$OTdFbEe9EqmvLJIVQrEf6OWO8AUagdfitwfVXVBefWv7C9hWAX9oG', TRUE);/*password: customer */
INSERT INTO users (username, password, enabled) VALUES ('user', '$2y$12$ib7HLC5a/du7UNFgRggGteXvr0SyclZiMSwdMXXZ1uwYyzFfBTkV.', TRUE);/*password: user */
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2y$12$STmgp8r1FxIQpmOlD9osTuAnYZQ4s8qahccMT.vgatkEE6I8ev8s.', TRUE);/*password: admin */
-- ******************************************************************************

-- ************************** authorities ****************************************
INSERT INTO authorities (username, authority) VALUES ('customer', 'ROLE_CUSTOMER');

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_CUSTOMER');
INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_COMPANY-USER');

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_CUSTOMER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_COMPANY-USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');
-- ******************************************************************************


INSERT INTO customers (customername, street,city, postal_code,email, tel_number,password, enabled) VALUES ('klant_1', 'hazenpad 1','Rotterdam', '1234AN', 'klant1@klant','0612345','$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO customers (customername, street,city, postal_code,email, tel_number,password, enabled) VALUES ('klant_2', 'konijn 1','Amsterdam', '5378AN', 'klant2@klant','0636545','$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO customers (customername, street,city, postal_code,email, tel_number,password, enabled) VALUES ('klant_3', 'paard 1','Rotterdam', '1357AN', 'klant3@klant','069684345','$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);
INSERT INTO customers (customername, street,city, postal_code,email, tel_number,password, enabled) VALUES ('klant_4', 'koe 1','Amsterdam', '7913AN', 'klant4@klant','089745','$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE);




INSERT INTO orders (ordername, status, customer_id) VALUES ('order_1', 'open','2');
INSERT INTO orders (ordername, status, customer_id) VALUES ('order_2', 'open','2');
INSERT INTO orders (ordername, status, customer_id) VALUES ('order_3', 'pending','2');
INSERT INTO orders (ordername, status, customer_id) VALUES ('order_4', 'closed','1');


INSERT INTO order_lines (itemname, quantity, order_id) VALUES ('1001',13,2);
INSERT INTO order_lines (itemname, quantity, order_id) VALUES ('2001', 1,2);
INSERT INTO order_lines (itemname, quantity, order_id) VALUES ('3001', 3,2);
INSERT INTO order_lines (itemname, quantity, order_id) VALUES ('4001', 6,1);
--
--
-- INSERT INTO jobs (job_name, department) VALUES ('voordraaien', 'draai afdeling');
-- INSERT INTO jobs (job_name, department) VALUES ('nadraaien', 'draai afdeling');
-- INSERT INTO jobs (job_name, department) VALUES ('voorfrezen', 'frees afdeling');
-- INSERT INTO jobs (job_name, department) VALUES ('nafrezen', 'frees afdeling');
-- INSERT INTO jobs (job_name, department) VALUES ('slijpen', 'slijp afdeling');


-- INSERT INTO couple_orderline_jobs (order_line_id, jobs_id) VALUES ('1', '1');
-- INSERT INTO couple_orderline_jobs (order_line_id, jobs_id) VALUES ('1', '2');
-- INSERT INTO couple_orderline_jobs (order_line_id, jobs_id) VALUES ('1', '3');
-- INSERT INTO couple_orderline_jobs (order_line_id, jobs_id) VALUES ('1', '4');