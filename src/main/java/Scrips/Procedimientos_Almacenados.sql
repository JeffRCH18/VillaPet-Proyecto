CREATE OR REPLACE PROCEDURE insertar_cliente(
    nombre_cliente IN VARCHAR2,
    apellido IN VARCHAR2,
    direccion_cliente IN VARCHAR2,
    correo_cliente IN VARCHAR2,
    telefono_cliente IN NUMBER
)
AS
BEGIN
    INSERT INTO Tab_Cliente (Nombre_Cliente, Apellido, Direccion_Cliente, Correo_Cliente, Telefono_Cliente)
    VALUES (nombre_cliente, apellido, direccion_cliente, correo_cliente, telefono_cliente);
    COMMIT;
END;

CREATE OR REPLACE PROCEDURE LISTAR_CLIENTE(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
    FROM VISTA_CLIENTE;
END;
