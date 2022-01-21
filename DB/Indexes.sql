-- CREATE INDEX keyname ON Tablename(attribute_name);

-- Location
CREATE INDEX Name_index_Loc ON location (name);
CREATE INDEX ID_Area_Index_Loc ON location (id_area);

-- Building
CREATE INDEX Name_index_Building ON building (name);
CREATE INDEX ID_Loc_index_Building ON building (id_loc);
CREATE INDEX Work_index_Building ON building (working_time);
CREATE INDEX End_index_Building ON building (end_time);

-- Training Place
CREATE INDEX Name_index_Training_Place ON training_place (name);
CREATE INDEX Sport_index_Training_Place ON training_place (sport);
CREATE INDEX ID_Building_Training_Place ON training_place (id_building);

-- Dormitory
CREATE INDEX Name_index_Dormitory ON dormitory (name);
CREATE INDEX ID_Building_index_Dormitory ON dormitory (id_building);

-- Church
-- Because some of church have no prayer time limit, and they are null.
-- So we don't need index here
CREATE INDEX Name_index_Church ON church (name);
CREATE INDEX Believe_index_Church ON church (believe);
CREATE INDEX ID_Building_index_Church ON church (id_building);

-- Canteen
-- Evaluation will likely change frequently.
-- So don't set index.
CREATE INDEX Name_Index_Canteen ON canteen (name);
CREATE INDEX Food_Kind_Index_Canteen ON canteen (food_kind);
CREATE INDEX is_Halal_Index_Canteen ON canteen (is_halal);
CREATE INDEX ID_Building_Index_Canteen ON canteen (id_building);

-- Location_Person
CREATE INDEX ID_Loc_index_LP ON location_person (id_loc);
CREATE INDEX ID_Building_index_LP ON location_person (id_building);

-- Workplace_staff
CREATE INDEX ID_Loc_index_WS ON workplace_staff (id_loc);
CREATE INDEX ID_Building_index_WS ON workplace_staff (id_building);

-- Staff_Volunteers
-- Relationship is 1 to 1. So we
CREATE UNIQUE INDEX ID_WS_Person_index_SV ON staff_volunteers (id_ws, id_person);

-- Person
CREATE INDEX Name_index_Person ON person (name);
CREATE INDEX ID_LP_index_Person ON person (id_lp);

-- Athlete
CREATE INDEX Height_index_Athlete ON athlete ("height(cm)");
CREATE INDEX Weight_index_Athlete ON athlete ("weight(kg)");
CREATE INDEX ID_LP_index_Athlete ON athlete (id_person);

--- Event
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