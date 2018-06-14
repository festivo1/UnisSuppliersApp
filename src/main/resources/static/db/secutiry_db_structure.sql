/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  utsi
 * Created: Apr 22, 2018
 */
#DROP TABLE IF EXISTS roles;

CREATE TABLE IF NOT EXISTS roles(
id serial primary key, 
role varchar(50) DEFAULT NULL 
   );


CREATE TABLE IF NOT EXISTS user_roles( user_role_id serial primary key, role_id int, user_id int);
alter table user_roles add foreign key(role_id) references roles(id);
alter table user_roles add foreign key(user_id) references user_info(id);

