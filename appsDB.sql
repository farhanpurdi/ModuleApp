CREATE TABLE USERS ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY NOT NULL, user_name VARCHAR(30) NOT NULL );
CREATE TABLE promo ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, user_id INT(6) NOT NULL, PRIVILEGES INT(1) NOT NULL );
CREATE TABLE category ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, user_id INT(6) NOT NULL, PRIVILEGES INT(1) NOT NULL );
CREATE TABLE FLASH_SALE ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, user_id INT(6) NOT NULL, PRIVILEGES INT(1) NOT NULL );
CREATE TABLE NEWS ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, user_id INT(6) NOT NULL, PRIVILEGES INT(1) NOT NULL );
CREATE TABLE HISTORY ( id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY not null, user_id INT(6) NOT NULL, PRIVILEGES INT(1) NOT NULL );

CREATE VIEW VIEW_MODULE AS
SELECT  ROW_NUMBER() OVER (PARTITION BY y.user_name ORDER BY  y.privileges ASC) AS row_num, y.module_name, y.privileges as module_order, y.user_name
FROM   (SELECT 'CategoryCard' AS module_name,
               c.privileges, 
               u.user_name 
        FROM   users u 
               JOIN category c 
                 ON c.user_id = u.id
        		GROUP BY u.id
        UNION 
        SELECT 'FlashSaleCard' AS module_name, 
               f.privileges, 
               u.user_name 
        FROM   users u 
               JOIN flash_sale f 
                 ON f.user_id = u.id 
        		GROUP BY u.id
        UNION 
        SELECT 'HistoryCard' AS module_name, 
               h.privileges, 
               u.user_name 
        FROM   users u 
               JOIN history h 
                 ON h.user_id = u.id
        		GROUP BY u.id
        UNION 
        SELECT 'NewsCard' AS module_name, 
               n.privileges, 
               u.user_name 
        FROM   users u 
               JOIN news n 
                 ON n.user_id = u.id 
        		GROUP BY u.id
        UNION 
        SELECT 'PromoCard' AS module_name, 
               p.privileges, 
               u.user_name 
        FROM   users u 
               JOIN promo p 
                 ON p.user_id = u.id
       			GROUP BY u.id
       ) AS y;