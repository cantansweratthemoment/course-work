CREATE
    OR REPLACE FUNCTION set_training_for_sportsman(pID integer, event_name varchar(32), event_begin_time timestamp,
                                                   event_end_time timestamp, training_loc_id integer) RETURNS void AS
$set_training_for_sportsman$
DECLARE
    athlete_ID integer := (SELECT ID
                           FROM athlete
                           WHERE id_person = pID);
    loc_ID     integer := (Select id_area
                           FROM location
                           WHERE ID = training_loc_id);
BEGIN
    IF (athlete_ID IS NULL) THEN
        RAISE EXCEPTION 'This person is not athlete';
    END IF;
    IF (loc_ID IS NULL) THEN
        RAISE EXCEPTION 'This location does not exist';
    END IF;
    INSERT INTO event(Name, Type, begin_time, end_time, id_person, id_loc)
    VALUES (event_name, 'training', event_name, event_begin_time, event_end_time, training_loc_id);
END;
$set_training_for_sportsman$
    LANGUAGE plpgsql;