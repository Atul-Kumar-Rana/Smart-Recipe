CREATE OR REPLACE PROCEDURE ProcessMonthlyPayroll IS
BEGIN
    UPDATE Salaries
    SET amount = amount + (amount * 0.01)
    WHERE salary_type = 'Monthly';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly payroll processed for all monthly salaries.');
END;
/
