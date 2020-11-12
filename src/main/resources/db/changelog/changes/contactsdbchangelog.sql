--liquibase formatted sql

-- changeset seanchen:1 runOnChange:true
create table contact (
    id UUID not null primary key,
    firstName varchar(100) not null,
    lastName varchar(100) not null,
    email varchar(100) not null,
    phone varchar(100)
);
-- rollback drop table contact;

-- changeset seanchen:2 runOnChange:true
insert into contact (id, firstname, lastname, email, phone)
values (uuid_generate_v4(), 'Test', 'User', 'test@test.com', '555-555-5555');
-- rollback delete from contact where firstname = 'Test';

-- changeset seanchen:3 runOnChange:true
alter table contact alter column id set default uuid_generate_v4();
-- rollback alter table contact alter column id drop default;