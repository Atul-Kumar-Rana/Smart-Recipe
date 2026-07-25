CREATE OR REPLACE PROCEDURE TransferBudget(
    p_source_dept_id IN NUMBER,
    p_target_dept_id IN NUMBER,
    p_amount IN NUMBER
) IS
    v_source_balance NUMBER;
BEGIN
    SELECT allocation INTO v_source_balance
    FROM Budgets
    WHERE department_id = p_source_dept_id;
    IF v_source_balance < p_amount THEN
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient budget in source department.');
    ELSE
        UPDATE Budgets
        SET allocation = allocation - p_amount
        WHERE department_id = p_source_dept_id;
        UPDATE Budgets
        SET allocation = allocation + p_amount
        WHERE department_id = p_target_dept_id;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Successfully transferred ' || p_amount || ' from department ' || p_source_dept_id || ' to department ' || p_target_dept_id);
    END IF;
END;
/
