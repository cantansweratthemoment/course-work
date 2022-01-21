CREATE OR REPLACE FUNCTION get_workplace_of_employee(pID Integer) RETURNS varchar(32) AS
$get_workplace_of_employee$
DECLARE
    staff_id          integer := (SELECT ID
                                  FROM Staff_Volunteers
                                  WHERE ID_Person = pID);
    staff_building_id integer;
    staff_location_id integer;
    name_res          varchar(32);
    ws_staff_id       integer;
begin
    IF
        (staff_id IS NULL) THEN
        RAISE EXCEPTION 'This person is not staff';
    END IF;
    SELECT ID_WS FROM staff_volunteers where ID = staff_id into ws_staff_id;
    SELECT ID_Building FROM workplace_staff where ID = ws_staff_id into staff_building_id;
    SELECT ID_Loc FROM workplace_staff where ID = ws_staff_id into staff_location_id;
    IF (staff_building_id IS NULL) THEN
        SELECT Name from location where ID = staff_location_id into name_res;
    ELSE
        SELECT Name from building where ID = staff_building_id into name_res;
    END IF;
    Return name_res;
end;
$get_workplace_of_employee$ LANGUAGE plpgsql;