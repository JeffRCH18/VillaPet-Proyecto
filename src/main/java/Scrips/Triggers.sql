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

--Trigger de reduccion de Stock
CREATE OR REPLACE TRIGGER REDUCCION_STOCK_TRG
AFTER INSERT ON TAB_DETALLE
FOR EACH ROW
DECLARE
    v_tipo_elemento VARCHAR2(20);
    v_id_elemento NUMBER;
    v_cantidad NUMBER;
BEGIN
    v_tipo_elemento := :NEW.TIPO_ELEMENTO;
    v_id_elemento := :NEW.ID_ELEMENTO;
    v_cantidad := :NEW.CANTIDAD;

    IF v_tipo_elemento = 'Producto' THEN
        UPDATE TAB_PRODUCTO
        SET STOCK = STOCK - v_cantidad
        WHERE ID_PRODUCTO = v_id_elemento;
    END IF;
END REDUCCION_STOCK_TRG;

