CREATE OR REPLACE PROCEDURE UpdateDepartmentRaise(
    p_department_id IN NUMBER,
    p_raise_percentage IN NUMBER
) IS
BEGIN
    UPDATE Staff
    SET base_pay = base_pay + (base_pay * p_raise_percentage / 100)
    WHERE department_id = p_department_id;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Raise of ' || p_raise_percentage || '% applied to department ' || p_department_id);
END;
/
