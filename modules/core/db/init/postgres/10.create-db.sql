-- begin CUBAPLANER_SESSION
create table CUBAPLANER_SESSION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TOPIC varchar(255) not null,
    START_DATE timestamp not null,
    SPEAKER_ID uuid not null,
    DURATION integer not null,
    DESCRIPTION varchar(2000),
    --
    primary key (ID)
)^
-- end CUBAPLANER_SESSION
-- begin CUBAPLANER_SPEAKER
create table CUBAPLANER_SPEAKER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255),
    EMAIL varchar(1024) not null,
    --
    primary key (ID)
)^
-- end CUBAPLANER_SPEAKER
