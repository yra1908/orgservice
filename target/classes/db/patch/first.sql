-- liquibase formatted sql
-- changeSet BDR-3352:1 failOnError:true logicalFilePath:2018102912_BDR-3352_saved-search-as-dimension.sql
insert into Client (name) values ('Client1');
insert into Client (name) values ('Client2');


insert into Privilege(name) values ('read_patient');
insert into Privilege(name) values ('edit_patient');