DECLARE
    CURSOR c_registrations IS
        SELECT r.registration_id, r.submission_deadline, s.name, s.student_id
        FROM Registrations r
        JOIN Students s ON r.student_id = s.student_id
        WHERE r.submission_deadline BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
    FOR rec IN c_registrations LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || rec.name || ', your registration (ID: ' || rec.registration_id || ') is due on ' || TO_CHAR(rec.submission_deadline, 'DD-MON-YYYY') || '. Please submit your documents.');
    END LOOP;
END;
/
