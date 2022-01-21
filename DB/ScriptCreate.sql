CREATE TABLE Info_Olympic_Village
(
    ID_IOV      serial,
    Description text NOT NULL,
    PRIMARY KEY (ID_IOV)
);

CREATE TABLE OV_Area
(
    ID          serial,
    Name        varchar(32) NOT NULL,
    Size        decimal,
    Description text,
    ID_Village  integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_OV_Area_ID_Village
        FOREIGN KEY (ID_Village)
            REFERENCES Info_Olympic_Village (ID_IOV)
);

CREATE TABLE Location
(
    ID          serial,
    Name        varchar(32),
    Description text,
    ID_Area     integer NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Location_ID_Area
        FOREIGN KEY (ID_Area)
            REFERENCES OV_Area (ID)
);

CREATE TABLE Building
(
    ID           serial,
    Name         varchar(8),
    Size         decimal,
    Num_People   integer,
    Working_Time time,
    End_Time     time,
    ID_Loc       integer NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Building_ID_Loc
        FOREIGN KEY (ID_Loc)
            REFERENCES Location (ID)
);

CREATE TABLE Training_Place
(
    ID          serial,
    Name        varchar(32) NOT NULL,
    Sport       text,
    ID_Building integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Training_Place_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID)
);

CREATE TABLE Dormitory
(
    ID          serial,
    Name        varchar(32) NOT NULL,
    Dor_Area    varchar(32),
    ID_Building integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Dormitory_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID)
);

CREATE TABLE Church
(
    ID          serial,
    Name        varchar(32) NOT NULL,
    Believe     varchar(32) NOT NULL,
    Prayer_Time time,
    End_Time    time,
    ID_Building integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Church_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID)
);

CREATE TABLE Canteen
(
    ID          serial,
    Name        varchar(32) NOT NULL,
    Food_Kind   varchar(32),
    is_Halal    boolean     NOT NULL,
    Evaluation  integer,
    ID_Building integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Canteen_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID)
);

/*ID_Building and ID_Loc can be null because worker can work for a place or a building*/
CREATE TABLE workplace_staff
(
    ID          serial,
    ID_Loc      integer,
    ID_Building integer,
    Details     text,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Workplace_staff_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID),
    CONSTRAINT FK_Workplace_staff_ID_Loc
        FOREIGN KEY (ID_Loc)
            REFERENCES Location (ID)
);

/*ID_Building can be null because person could be outside*/
CREATE TABLE Location_Person
(
    ID          serial,
    ID_Loc      integer NOT NULL,
    ID_Building integer,
    Details     text,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Location_Person_ID_Building
        FOREIGN KEY (ID_Building)
            REFERENCES Building (ID),
    CONSTRAINT FK_Location_Person_ID_Loc
        FOREIGN KEY (ID_Loc)
            REFERENCES Location (ID)
);

CREATE TABLE Person
(
    ID    serial,
    Name  varchar(32) NOT NULL,
    ID_LP integer     NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Person_ID_LP
        FOREIGN KEY (ID_LP)
            REFERENCES Location_Person (ID)
);

CREATE TABLE Staff_Volunteers
(
    ID        serial,
    ID_WS     integer NOT NULL,
    ID_Person integer NOT NULL,
    CONSTRAINT FK_Staff_Volunteers_ID_WS
        FOREIGN KEY (ID_WS)
            REFERENCES Workplace_staff (ID),
    CONSTRAINT FK_Staff_Volunteers_ID_Person
        FOREIGN KEY (ID_Person)
            REFERENCES Person (ID)
);

CREATE TABLE Athlete
(
    ID          serial,
    Height      decimal,
    Weight      decimal,
    Nationality varchar(32),
    Sport       varchar(32),
    Record      text,
    ID_Person   integer NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Athlete_ID_Person
        FOREIGN KEY (ID_Person)
            REFERENCES Person (ID)
);

CREATE TABLE Event
(
    ID              serial,
    Name            varchar(32),
    Type            varchar(32),
    Begin_time      timestamp,
    End_time        timestamp,
    ID_Person       integer NOT NULL,
    ID_Loc          integer NOT NULL,
    PRIMARY KEY (ID),
    CONSTRAINT FK_Event_ID_Person
        FOREIGN KEY (ID_Person)
            REFERENCES Person (ID)  ,
    CONSTRAINT FK_Event_ID_Loc
        FOREIGN KEY (ID_Loc)
            REFERENCES Location (ID)
);