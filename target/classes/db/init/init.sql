drop table if exists PhysicianPrivilege;
drop table if exists Privilege;
drop table if exists OrgainisationPhysician;
drop table if exists Physician;
drop table if exists ProviderGroup;
drop table if exists Orgainisation;
drop table if exists Client;

create table Client(
  Id          bigint       primary key auto_increment,
  Name        varchar(256) not null
);

create table Orgainisation(
  Id          bigint        primary key auto_increment,
  Name        varchar(256)  not null,
  Active      bit           default 1 not null,
  ClientId    bigint,
  constraint fkOrgainisation_Client foreign key (ClientId) references Client(Id)
);

create table ProviderGroup (
  Id          bigint        primary key auto_increment,
  Name        varchar(256)  not null,
  Active      bit           default 1 not null,
  OrganizationId bigint,
  constraint fkProviderGroup_Orgainisation foreign key (OrganizationId) references Orgainisation(Id)
);

create table Physician(
  Id          bigint        primary key auto_increment,
  FirstName   varchar(256)  not null,
  MiddleName  varchar(256),
  LastName    varchar(256)  not null,
  DoB         date          not null,
  Email       varchar(256)  not null,
  Active      bit           default 1 not null,
  GroupId     bigint        not null,

  constraint fkPhysician_Group foreign key (GroupId) references ProviderGroup (Id),
  constraint Physician_Email UNIQUE (Email),
);
create index Physician_Email ON Physician (Email);

create table OrgainisationPhysician(
  PhysicianId     bigint,
  OrganizationId  bigint,
  primary key (PhysicianId, OrganizationId),
  constraint fkOrgainisationPhysician_Physician foreign key (PhysicianId) references Physician(Id),
  constraint fkOrgainisationPhysician_Organization foreign key (OrganizationId) references Orgainisation(Id)
);

create table Privilege(
  Id          bigint        primary key auto_increment,
  Name        varchar(256)  not null
);

create table PhysicianPrivilege(
  PhysicianId   bigint,
  PrivilegeId   bigint,
  primary key (PhysicianId, PrivilegeId),
  constraint fkPhysicianPrivilege_Physician foreign key (PhysicianId) references Physician(Id),
  constraint fkPhysicianPrivilege_Privilege foreign key (PrivilegeId) references Privilege(Id)
);