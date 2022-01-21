CREATE
    OR REPLACE FUNCTION athlete_cant_be_staff_check() RETURNS trigger AS
$athlete_cant_be_staff_check$
DECLARE
    person_athlete_id integer := (NEW.ID_Person);
    person_staff_id   integer := (SELECT ID
                                  FROM Staff_Volunteers
                                  WHERE ID_Person = person_athlete_id);
BEGIN
    IF
        (person_staff_id IS NOT NULL) THEN
        RAISE EXCEPTION 'athlete cant be staff worker';
    END IF;
    RETURN NEW;
END;
$athlete_cant_be_staff_check$
    LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS athlete_cant_be_staff_check ON Athlete;

CREATE TRIGGER athlete_cant_be_staff_check
    BEFORE INSERT OR
        UPDATE
    ON Athlete
    FOR EACH ROW
EXECUTE PROCEDURE athlete_cant_be_staff_check();