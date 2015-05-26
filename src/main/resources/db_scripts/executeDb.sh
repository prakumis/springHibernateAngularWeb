### Help for creating MySql db user:: https://dev.mysql.com/doc/refman/5.1/en/adding-users.html


# 1. Run this below script/sql to create db & schema
/usr/bin/mysql -hlocalhost -uroot -proot < create_db.sql


# 2. Start the application with <prop key="hibernate.hbm2ddl.auto">create</prop> to create tables
#/usr/bin/mysql -hlocalhost -uroot -proot < createRolesAndMenus.sql

# 3. Run this below script/sql to create menus, roles & other static data
dbHost=localhost
dbUser=yash
dbPassword=mishra
#/usr/bin/mysql -h$dbHost -u$dbUser -p$dbPassword < createRolesAndMenus.sql

