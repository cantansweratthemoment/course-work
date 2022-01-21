CREATE
OR REPLACE FUNCTION staff_cant_be_athlete_check() RETURNS trigger AS
$staff_cant_be_athlete_check$
    DECLARE
person_staff_id integer := (NEW.ID_Person);
person_athlete_id integer := (SELECT ID FROM Athlete WHERE ID_Person = person_staff_id);
BEGIN
        IF
(person_athlete_id IS NOT NULL) THEN
            RAISE EXCEPTION 'staff cant be athlete';
END IF;
RETURN NEW;
END;
$staff_cant_be_athlete_check$
LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS staff_cant_be_athlete_check ON Athlete;

CREATE TRIGGER staff_cant_be_athlete_check
    BEFORE INSERT OR
UPDATE ON Staff_Volunteers
    FOR EACH ROW
    EXECUTE PROCEDURE staff_cant_be_athlete_check();