create index name_index_loc
    on location (name);

create index id_area_index_loc
    on location (id_area);

create table building
(
    id serial not null
        constraint building_pkey
            primary key,
    "size(ppl)" integer,
    working_time time,
    end_time time,
    id_loc integer not null
        constraint fk_building_id_loc
            references location,
    name varchar(32) not null
);

-- alter table building owner to s273720;

create index name_index_building
    on building (name);

create index id_loc_index_building
    on building (id_loc);

create index work_index_building
    on building (working_time);

create index end_index_building
    on building (end_time);

create table training_place
(
    id serial not null
        constraint training_place_pkey
            primary key,
    name varchar(32) not null,
    sport text,
    id_building integer not null
        constraint fk_training_place_id_building
            references building
);

-- alter table training_place owner to s273720;

create index name_index_training_place
    on training_place (name);

create index sport_index_training_place
    on training_place (sport);

create index id_building_training_place
    on training_place (id_building);

create table dormitory
(
    id serial not null
        constraint dormitory_pkey
            primary key,
    name varchar(32) not null,
    dor_area text,
    id_building integer not null
        constraint fk_dormitory_id_building
            references building
);

-- alter table dormitory owner to s273720;

create index name_index_dormitory
    on dormitory (name);

create index id_building_index_dormitory
    on dormitory (id_building);

create table church
(
    id serial not null
        constraint church_pkey
            primary key,
    name varchar(32) not null,
    believe varchar(32) not null,
    prayer_time time,
    end_time time,
    id_building integer not null
        constraint fk_church_id_building
            references building
);

-- alter table church owner to s273720;

create index name_index_church
    on church (name);

create index believe_index_church
    on church (believe);

create index id_building_index_church
    on church (id_building);

create table canteen
(
    id serial not null
        constraint canteen_pkey
            primary key,
    name varchar(32) not null,
    food_kind varchar(32),
    is_halal boolean not null,
    evaluation integer,
    id_building integer not null
        constraint fk_canteen_id_building
            references building
);

-- alter table canteen owner to s273720;

create index name_index_canteen
    on canteen (name);

create index food_kind_index_canteen
    on canteen (food_kind);

create index is_halal_index_canteen
    on canteen (is_halal);

create index id_building_index_canteen
    on canteen (id_building);

create table location_person
(
    id serial not null
        constraint location_person_pkey
            primary key,
    id_loc integer not null
        constraint fk_location_person_id_loc
            references location,
    id_building integer
        constraint fk_location_person_id_building
            references building,
    details text
);

-- alter table location_person owner to s273720;

create index id_loc_index_lp
    on location_person (id_loc);

create index id_building_index_lp
    on location_person (id_building);

create table person
(
    id serial not null
        constraint person_pkey
            primary key,
    name varchar(32) not null,
    id_lp integer not null
        constraint fk_person_id_lp
            references location_person,
    "ID_Manager" integer
);

-- alter table person owner to s273720;

create index name_index_person
    on person (name);

create index id_lp_index_person
    on person (id_lp);

create table workplace_staff
(
    id serial not null
        constraint workplace_staff_pkey
            primary key,
    id_loc integer
        constraint fk_workplace_staff_id_loc
            references location,
    id_building integer
        constraint fk_workplace_staff_id_building
            references building,
    details text
);

-- alter table workplace_staff owner to s273720;

create index id_loc_index_ws
    on workplace_staff (id_loc);

create index id_building_index_ws
    on workplace_staff (id_building);

create table staff_volunteers
(
    id_ws integer not null
        constraint fk_staff_volunteers_id_ws
            references workplace_staff,
    id_person integer not null
        constraint fk_staff_volunteers_id_person
            references person,
    id serial not null
        constraint staff_volunteers_pk
            primary key
);

-- alter table staff_volunteers owner to s273720;

create unique index id_ws_person_index_sv
    on staff_volunteers (id_ws, id_person);

create trigger staff_cant_be_athlete_check
    before insert or update
    on staff_volunteers
    for each row
execute procedure staff_cant_be_athlete_check();

create table athlete
(
    id serial not null,
    "height(cm)" numeric
        constraint heightlimit
            check ("height(cm)" > (0)::numeric),
    "weight(kg)" numeric
        constraint weightlimit
            check ("weight(kg)" > (0)::numeric),
    nationality varchar(32),
    sport varchar(32),
    record text,
    id_person integer not null
        constraint fk_athlete_id_person
            references person
);

-- alter table athlete owner to s273720;

create unique index athlete_id_person_uindex
    on athlete (id_person);

create index country_index
    on athlete (nationality);

create index sport_index
    on athlete (sport);

create index height_index_athlete
    on athlete ("height(cm)");

create index weight_index_athlete
    on athlete ("weight(kg)");

create index id_lp_index_athlete
    on athlete (id_person);

create trigger athlete_cant_be_staff_check
    before insert or update
    on athlete
    for each row
execute procedure athlete_cant_be_staff_check();

create table event
(
    id serial not null
        constraint event_pkey
            primary key,
    name varchar(32),
    type varchar(32),
    begin_time timestamp,
    end_time timestamp,
    id_person integer not null
        constraint fk_event_id_person
            references person,
    id_loc integer not null
        constraint fk_event_id_loc
            references location
);

-- alter table event owner to s273720;

create index event_begin_time_index
    on event (begin_time);

create index event_end_time_index
    on event (end_time);

create index event_id_loc_index
    on event (id_loc);

create index event_id_person_index
    on event (id_person);

create index event_name_index
    on event (name);

create index event_type_index
    on event (type);

create trigger staff_cant_visit_training
    before insert
    on event
    for each row
execute procedure staff_cant_visit_training();

create table manager
(
    id serial not null
        constraint manager_pk
            primary key,
    name varchar(32),
    type varchar(32),
    id_person integer
        constraint manager_id_person_fkey
            references person
);

-- alter table manager owner to s273720;

alter table person
    add constraint "person_ID_Manager_fkey"
        foreign key (id_manager) references manager;

create table "Users"
(
    id serial not null
        constraint users_pk
            primary key,
    login varchar(16) not null,
    role integer not null,
    password varchar(32) default 123456 not null,
    id_person integer
        constraint "Users_id_person_fkey"
            references person
);

comment on table "Users" is 'Users table is for the users of web';

-- alter table "Users" owner to s273720;

create unique index users_login_index
    on "Users" (login);