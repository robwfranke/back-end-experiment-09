
-- ************************** users ****************************************

INSERT INTO users (username, password, enabled) VALUES ('customer', '$2y$12$OTdFbEe9EqmvLJIVQrEf6OWO8AUagdfitwfVXVBefWv7C9hWAX9oG', TRUE);/*password: customer */
INSERT INTO users (username, password, enabled) VALUES ('user', '$2y$12$ib7HLC5a/du7UNFgRggGteXvr0SyclZiMSwdMXXZ1uwYyzFfBTkV.', TRUE);/*password: user */
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2y$12$STmgp8r1FxIQpmOlD9osTuAnYZQ4s8qahccMT.vgatkEE6I8ev8s.', TRUE);/*password: admin */
-- ******************************************************************************

-- ************************** authorities ****************************************
INSERT INTO authorities (username, authority_role) VALUES ('customer', 'CUSTOMER');

INSERT INTO authorities (username, authority_role) VALUES ('user', 'CUSTOMER');
INSERT INTO authorities (username, authority_role) VALUES ('user', 'COMPANY_USER');

INSERT INTO authorities (username, authority_role) VALUES ('admin', 'CUSTOMER');
INSERT INTO authorities (username, authority_role) VALUES ('admin', 'COMPANY_USER');
INSERT INTO authorities (username, authority_role) VALUES ('admin', 'ADMIN');
-- ******************************************************************************





INSERT INTO orders (ordername, status, user_username) VALUES ('order_1', 'open','customer');
INSERT INTO orders (ordername, status, user_username) VALUES ('order_2', 'open','customer');
INSERT INTO orders (ordername, status, user_username) VALUES ('order_3', 'pending','customer');
INSERT INTO orders (ordername, status, user_username) VALUES ('order_4', 'closed','customer');


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