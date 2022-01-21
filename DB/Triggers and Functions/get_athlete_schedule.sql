CREATE OR REPLACE FUNCTION get_athlete_schedule(pID Integer, event_time timestamp) RETURNS record AS
$get_athlete_schedule$
DECLARE
    athlete_id     integer := (SELECT ID
                               FROM athlete
                               WHERE ID_Person = pID);
    result         record;
    athlete_name   varchar(32);
    athlete_events record;
begin
    IF
        (athlete_id IS NULL) THEN
        RAISE EXCEPTION 'This person is not athlete';
    END IF;
    SELECT name FROM person Where ID = pID into athlete_name;
    SELECT * FROM event WHERE id_person = pID into athlete_events;
    SELECT * FROM athlete_events WHERE (event_time >= begin_time AND event_time <= end_time) into result;
    RETURN result;
end;
$get_athlete_schedule$ LANGUAGE plpgsql;