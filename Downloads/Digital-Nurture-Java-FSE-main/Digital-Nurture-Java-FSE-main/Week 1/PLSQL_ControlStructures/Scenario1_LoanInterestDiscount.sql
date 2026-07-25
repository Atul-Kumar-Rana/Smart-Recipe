DECLARE
    CURSOR c_students IS
        SELECT student_id, name, TRUNC(MONTHS_BETWEEN(SYSDATE, enrollment_date) / 12) AS enrollment_years
        FROM Students;
BEGIN
    FOR rec IN c_students LOOP
        IF rec.enrollment_years > 2 THEN
            UPDATE Courses
            SET credit_units = credit_units - 1
            WHERE student_id = rec.student_id;
            DBMS_OUTPUT.PUT_LINE('Credit reduction applied for student: ' || rec.name || ' (Enrollment Years: ' || rec.enrollment_years || ')');
        END IF;
    END LOOP;
    COMMIT;
END;
/
