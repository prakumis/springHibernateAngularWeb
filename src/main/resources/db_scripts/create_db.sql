DROP DATABASE IF EXISTS bazaardb;
CREATE DATABASE yashdb;

CREATE USER 'yash'@'localhost' IDENTIFIED BY 'mishra';
GRANT USAGE ON yashdb.* TO 'yash'@'localhost';
GRANT ALL PRIVILEGES ON bazaar.* TO 'dbuser'@'%';


/*CREATE USER 'dbadmin'@'*' IDENTIFIED BY 'dbadmin';
GRANT USAGE ON bazzar.* TO 'dbadmin'@'%';
GRANT ALL PRIVILEGES ON bazaar.* TO 'dbadmin'@'%';
*/
