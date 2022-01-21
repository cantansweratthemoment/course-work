CREATE
    OR REPLACE FUNCTION staff_cant_visit_training() RETURNS trigger AS
$staff_cant_visit_training$
    DECLARE
    person_id integer := (NEW.ID_Person);
    event_type varchar(32) := (new.Type);
    staff_id integer = (SELECT ID FROM Staff_Volunteers WHERE ID_Person = person_id);
BEGIN
IF (event_type = 'training' && staff_id IS NOT NULL) THEN
            RAISE EXCEPTION 'staff cant participate in training';
END IF;
RETURN NEW;
END;
$staff_cant_visit_training$
LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS staff_cant_visit_training ON Event;

CREATE TRIGGER staff_cant_visit_training
    BEFORE INSERT ON Event
    FOR EACH ROW
    EXECUTE PROCEDURE staff_cant_visit_training();