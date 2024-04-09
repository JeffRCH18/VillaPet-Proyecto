
--Procedimientos Almacenados Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Clientes CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Inserta_Cliente_SP(
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
END Inserta_Cliente_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Actualizar_Cliente_SP(
    p_ID_CLIENTE IN NUMBER,
    p_NOMBRE IN VARCHAR2,
    p_APELLIDO IN VARCHAR2,
    p_DIRECCION IN VARCHAR2,
    p_TELEFONO IN VARCHAR2,
    p_CORREO IN VARCHAR2
)
IS 
BEGIN 
    UPDATE TAB_CLIENTE 
    SET 
        NOMBRE_CLIENTE = p_NOMBRE,
        APELLIDO = p_APELLIDO,
        DIRECCION_CLIENTE = p_DIRECCION,
        TELEFONO_CLIENTE = p_TELEFONO,
        CORREO_CLIENTE = p_CORREO
    WHERE 
        ID_CLIENTE = p_ID_CLIENTE;
END Actualizar_Cliente_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Cliente_SP(p_IDCLI IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_CLIENTE
    WHERE ID_CLIENTE = p_IDCLI;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el cliente seleccionado');
END Eliminar_Cliente_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Listar_Cliente_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
    FROM Clientes_VIEW;
END Listar_Cliente_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Empleados CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Empleado_SP(
    p_ID IN NUMBER,
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2,
    p_SALARIO IN NUMBER)
IS 
BEGIN
    INSERT INTO TAB_EMPLEADO(
    ID_EMPLEADO, 
    ID_PUESTO,
    ID_ROL, 
    NOMBRE_EMPLEADO, 
    APELLIDO,
    CORREO, 
    CONTRASENA, 
    SALARIO)
    VALUES (p_ID, p_IDPUESTO, p_IDROL, p_NOMBRE_EMP, p_APELLIDO_EMP, p_CORREO, p_CONTRASENA, p_SALARIO);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el empleado, intente de nuevo');
END Insertar_Empleado_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Actualizar_Empleado_SP(
    p_IDEMP IN NUMBER,
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2, 
    p_SALARIO IN NUMBER)
IS 
BEGIN
    UPDATE TAB_EMPLEADO 
    SET ID_PUESTO = p_IDPUESTO,
        ID_ROL = p_IDROL,
        NOMBRE_EMPLEADO = p_NOMBRE_EMP,
        APELLIDO = p_APELLIDO_EMP,
        CORREO = p_CORREO,
        CONTRASENA = p_CONTRASENA,
        SALARIO = p_SALARIO
    WHERE ID_EMPLEADO = p_IDEMP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END Actualizar_Empleado_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Empleado_SP(p_IDEMP IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_EMPLEADO 
    WHERE ID_EMPLEADO = p_IDEMP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el empleado seleccionado');
END Eliminar_Empleado_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Listar_Empleado_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_EMPLEADO, ID_PUESTO, ID_ROL, ID_SUCURSAL, NOMBRE_EMPLEADO, APELLIDO, CORREO, SALARIO
    FROM Empleados_VIEW;
END Listar_Empleado_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Sucursales CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Sucursal_SP(
    p_ID IN NUMBER,
    p_CORREO IN VARCHAR2, 
    p_TELEFONO IN VARCHAR2, 
    p_NOMBRE_SUCURSAL IN VARCHAR2,
    p_DIRECCION_SUCURSAL IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_SUCURSAL(
    ID_SUCURSAL, 
    CORREO_SUCURSAL, 
    TELEFONO_SUCURSAL, 
    NOMBRE_SUCURSAL, 
    DIRECCION_SUCURSAL)
    VALUES (p_ID, p_CORREO, p_TELEFONO, p_NOMBRE_SUCURSAL, p_DIRECCION_SUCURSAL);
EXCEPTION 
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar la sucursal, intente de nuevo');
END Insertar_Sucursal_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Actualizar_Sucursal_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Sucursal_SP(p_IDSU IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_SUCURSAL 
    WHERE ID_SUCURSAL = p_IDSU;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar la sucursal seleccionada');
END Eliminar_Sucursal_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Listar_Sucursal_SP(s_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN s_cursor FOR
    SELECT ID_SUCURSAL, CORREO_SUCURSAL, TELEFONO_SUCURSAL, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL
    FROM Sucursales_VIEW;
END Listar_Sucursal_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Proveedores CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Proveedor_SP(
    p_ID IN NUMBER, 
    p_NOMBRE_PRO IN VARCHAR2,
    p_TELEFONO_PRO IN VARCHAR2, 
    p_DIRECCION_PRO IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_PROVEEDOR(
    ID_PROVEEDOR,
    NOMBRE_PROVEEDOR, 
    TELEFONO_PROVEEDOR, 
    DIRECCION_PROVEEDOR)
    VALUES (p_ID, p_NOMBRE_PRO, p_TELEFONO_PRO, p_DIRECCION_PRO);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el proveedor, intente de nuevo');
END Insertar_Proveedor_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Actualizar_Proveedor_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Proveedor_SP(p_IDPRO IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PROVEEDOR 
    WHERE ID_PROVEEDOR = p_IDPRO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el proveedor seleccionado');
END Eliminar_Proveedor_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Listar_Proveedor_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Productos CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Producto_SP(
    p_ID IN NUMBER,
    p_ID_CATEGORIA IN NUMBER, 
    p_ID_PROV IN NUMBER, 
    p_DESCRIPCION IN VARCHAR2, 
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER)
IS 
BEGIN
    INSERT INTO TAB_PRODUCTO(
    ID_PRODUCTO, 
    ID_CATEGORIA, 
    ID_PROVEEDOR,
    DESCRIPCION, 
    PRECIO,
    STOCK)
    VALUES (
    p_ID,
    p_ID_CATEGORIA, 
    p_ID_PROV,
    p_DESCRIPCION, 
    p_PRECIO,
    p_STOCK);
EXCEPTION 
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el producto, intente de nuevo');
END Insertar_Producto_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Actualizar_Producto_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Elimnar_Producto_SP(p_IDPRODUCTO IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PRODUCTO
    WHERE ID_PRODUCTO = p_IDPRODUCTO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el producto seleccionado');
END Elimnar_Producto_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Listar_Producto_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Servicios CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Servicio_SP(
    p_ID IN NUMBER,
    p_ID_EMP IN NUMBER, 
    p_NOMBRE_SERV IN VARCHAR2,
    p_DESCRIPCION_SERV IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_SERVICIO(
    ID_SERVICIO, 
    ID_EMPLEADO, 
    NOMBRE_SERVICIOS, 
    DESCRIPCION_SERVICIO)
    VALUES (p_ID, p_ID_EMP, p_NOMBRE_SERV, p_DESCRIPCION_SERV);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el servicio, intente de nuevo');
END Insertar_Servicio_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Actualizar_Servicio_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Servicio_SP(p_IDSERV IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_SERVICIO
    WHERE ID_SERVICIO = p_IDSERV;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el servicio seleccionado');
END Eliminar_Servicio_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Listar_Servicio_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Puestos CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Puesto_SP(
    p_ID IN NUMBER,
    p_DESCRIPCION_P IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_PUESTO(ID_PUESTO, DESCRIPCION_PUESTO)
    VALUES (p_ID, p_DESCRIPCION_P);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el puesto, intente de nuevo');
END Insertar_Puesto_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--********************************
--Actualizar_Puesto_SP
--********************************
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Puesto_SP(p_IDP IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PUESTO
    WHERE ID_PUESTO = p_IDP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el puesto seleccionado');
END Eliminar_Puesto_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Listar_Puesto_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_Puesto,Descripcion_Puesto
    FROM Puestos_VIEW;
END Listar_Puesto_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Roles CRUD
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Insertar_Rol_SP(
    DESCRIPCION_ROL IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_ROL(Descripcion_Rol)
    VALUES (DESCRIPCION_ROL);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el rol, intente de nuevo');
END Insertar_Rol_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Actualizar_Rol_SP(
    p_ID_ROL     IN NUMBER,
    p_NOMBRE IN VARCHAR2
)
IS 
BEGIN 
    UPDATE TAB_ROL
    SET 
        DESCRIPCION_ROL = p_NOMBRE
    WHERE 
        ID_ROL = p_ID_ROL;
END Actualizar_Rol_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Eliminar_Rol_SP(p_IDRol IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_ROL
    WHERE ID_ROL = p_IDRol;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el rol seleccionado');
END Eliminar_Rol_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE Listar_Rol_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_Rol,Descripcion_Rol
    FROM Roles_VIEW;
END Listar_Rol_SP;
---------------------------------------------------------------------------------------------------------------------------------------------------------------