--Trigger de auditoria para la tabla empleado
CREATE OR REPLACE TRIGGER audit_emp_TRG
    AFTER 
    UPDATE OR DELETE 
    ON Tab_Empleado 
    FOR EACH ROW 
DECLARE 
    transaction1 VARCHAR(10);
BEGIN 
    transactionl := CASE 
                    WHEN UPDATING THEN 'UPDATE'
                    WHEN DELETING THEN 'DELETE'
                    END;
                
    INSERT INTO Tab_Auditoria(table_name, transaction_name, by_user, transaction_date)
    VALUES('Tabla Empleado', transactionl, USER, SYSDATE);
END;

--Creacion de un trigger para evitar que se haga un insert en la tabla venta 
CREATE OR REPLACE TRIGGER no_insert_venta_TRG
    BEFORE
    INSERT 
    ON Tab_Venta
    FOR EACH ROW 
BEGIN 
    RAISE_APPLICATION_ERROR(-20105,'No se pueden hacer inserts en la tabla venta');
END;

--Trigger de auditoria para la tabla prodcuto 
CREATE OR REPLACE TRIGGER audit_prod_TRG
    AFTER 
    UPDATE OR DELETE 
    ON Tab_Producto 
    FOR EACH ROW 
DECLARE 
    transaction1 VARCHAR(10);
BEGIN 
    transactionl := CASE 
                    WHEN UPDATING THEN 'UPDATE'
                    WHEN DELETING THEN 'DELETE'
                    END;
                
    INSERT INTO Tab_Auditoria(table_name, transaction_name, by_user, transaction_date)
    VALUES('Tabla Producto', transactionl, USER, SYSDATE);
END;

--Trigger para ver cuando ingresa un usuario 
CREATE OR REPLACE TRIGGER user_login_TRG
    AFTER LOGON ON DATABASE
BEGIN 
    INSERT INTO Tab_Login_log(usario, fecha_hora, accion)
    VALUES(USER, SYSDATE, 'Login');
END;

--Trigger para ver cuando se desconecta un usuario
CREATE OR REPLACE TRIGGER user_logout_TRG
    AFTER LOGOFF ON DATABASE 
BEGIN
    INSERT INTO Tab_Login_log(usuario, fecha_hora, accion)
    VALUES(USER, SYSDATE, 'LogOut');
END;


