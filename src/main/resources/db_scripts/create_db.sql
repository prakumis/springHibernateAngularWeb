DROP DATABASE IF EXISTS bazaardb;
CREATE DATABASE bazaardb;

CREATE USER 'bazaaruser'@'localhost' IDENTIFIED BY 'bazaarpassword';
GRANT USAGE ON bazaardb.* TO 'bazaaruser'@'localhost';
GRANT ALL PRIVILEGES ON bazaar.* TO 'dbuser'@'%';


CREATE USER 'dbadmin'@'*' IDENTIFIED BY 'dbadmin';
GRANT USAGE ON bazzar.* TO 'dbadmin'@'%';
GRANT ALL PRIVILEGES ON bazaar.* TO 'dbadmin'@'%';
