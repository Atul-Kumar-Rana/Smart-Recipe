DECLARE
    CURSOR c_members IS
        SELECT member_id, name, accumulated_points
        FROM Members;
BEGIN
    FOR rec IN c_members LOOP
        IF rec.accumulated_points > 5000 THEN
            UPDATE Members
            SET IsPremium = 'TRUE'
            WHERE member_id = rec.member_id;
            DBMS_OUTPUT.PUT_LINE('Member ' || rec.name || ' promoted to Premium (Points: ' || rec.accumulated_points || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/
