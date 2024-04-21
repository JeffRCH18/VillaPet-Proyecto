--Procedimientos Almacenados Villa Pet--


--Clientes CRUD--
--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_CLIENTE_SP(
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
END INSERTAR_CLIENTE_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_CLIENTE_SP(p_IDCLI IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_CLIENTE
    WHERE ID_CLIENTE = p_IDCLI;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el cliente seleccionado');
END ELIMINAR_CLIENTE_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_CLIENTE_SP(
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
END ACTUALIZAR_CLIENTE_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_CLIENTE_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
    FROM Clientes_VIEW;
END LISTAR_CLIENTE_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE BUSCAR_CLIENTE_SP (
    p_id_cliente IN NUMBER,
    p_cursor OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN p_cursor FOR
        SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
        FROM TAB_CLIENTE
        WHERE ID_CLIENTE = p_id_cliente;
END  BUSCAR_CLIENTE_SP;

--------------------------------------------------------------------------------

--Empleados CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_EMPLEADO_SP(
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2,
    p_SALARIO IN NUMBER,
    p_SUCURSAL)
IS 
BEGIN
    INSERT INTO TAB_EMPLEADO(
    ID_PUESTO,
    ID_ROL, 
    NOMBRE_EMPLEADO, 
    APELLIDO,
    CORREO, 
    CONTRASENA, 
    SALARIO,
    ID_SUCURSAL)
    VALUES (p_IDPUESTO, p_IDROL, p_NOMBRE_EMP, p_APELLIDO_EMP, p_CORREO, p_CONTRASENA, p_SALARIO, p_SUCURSAL);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el empleado, intente de nuevo');
END INSERTAR_EMPLEADO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_EMPLEADO_SP(p_IDEMP IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_EMPLEADO 
    WHERE ID_EMPLEADO = p_IDEMP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el empleado seleccionado');
END ELIMINAR_EMPLEADO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_EMPLEADO_SP(
    p_IDEMP IN NUMBER,
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2, 
    p_SALARIO IN NUMBER,
    p_IDSUCURSAL IN NUMBER)
IS 
BEGIN
    UPDATE TAB_EMPLEADO 
    SET ID_PUESTO = p_IDPUESTO,
        ID_ROL = p_IDROL,
        NOMBRE_EMPLEADO = p_NOMBRE_EMP,
        APELLIDO = p_APELLIDO_EMP,
        CORREO = p_CORREO,
        CONTRASENA = p_CONTRASENA,
        SALARIO = p_SALARIO,
        ID_SUCURSAL = p_IDSUCURSAL
    WHERE ID_EMPLEADO = p_IDEMP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END ACTUALIZAR_EMPLEADO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_EMPLEADO_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_EMPLEADO, ID_PUESTO, ID_ROL, ID_SUCURSAL, NOMBRE_EMPLEADO, APELLIDO, CORREO, SALARIO
    FROM Empleados_VIEW;
END LISTAR_EMPLEADO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE Sesion_Empleado_SP(
    p_Correo IN VARCHAR2,
    p_Contrasena IN VARCHAR2,
    p_ID_Empleado OUT NUMBER
)
AS
    v_Empleado_ID NUMBER;
BEGIN
    -- Buscar el empleado por correo y contrase 
    SELECT ID_Empleado
    INTO v_Empleado_ID
    FROM TAB_EMPLEADO
    WHERE Correo = p_Correo
      AND Contrasena = p_Contrasena;

    -- Asignar el ID del empleado encontrado a la variable de salida
    p_ID_Empleado := v_Empleado_ID;
    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        p_ID_Empleado := NULL;
    WHEN OTHERS THEN
        p_ID_Empleado := -1;
END Sesion_Empleado_SP;

--------------------------------------------------------------------------------

--Sucursales CRUD

---------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_SUCURSAL_SP(
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
END INSERTAR_SUCURSAL_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_SUCURSAL_SP(p_IDSU IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_SUCURSAL 
    WHERE ID_SUCURSAL = p_IDSU;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar la sucursal seleccionada');
END ELIMINAR_SUCURSAL_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_SUCURSAL_SP(
    p_IDSUCURSAL IN NUMBER,
    p_CORREO IN VARCHAR2, 
    p_TELEFONO IN VARCHAR2, 
    p_NOMBRE IN VARCHAR2, 
    p_DIRECCION IN VARCHAR2)
IS 
BEGIN
    UPDATE TAB_SUCURSAL 
    SET CORREO_SUCURSAL = p_CORREO,
        TELEFONO_SUCURSAL = p_TELEFONO,
        NOMBRE_SUCURSAL = p_NOMBRE,
        DIRECCION_SUCURSAL = p_DIRECCION
    WHERE ID_SUCURSAL = p_IDSUCURSAL;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END ACTUALIZAR_SUCURSAL_SP;

---------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_SUCURSAL_SP(s_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN s_cursor FOR
    SELECT ID_SUCURSAL, CORREO_SUCURSAL, TELEFONO_SUCURSAL, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL
    FROM SUCURSAL_VIEW;
END LISTAR_SUCURSAL_SP;

--------------------------------------------------------------------------------

--Proveedores CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_PROVEEDOR_SP(
    p_NOMBRE_PRO IN VARCHAR2,
    p_TELEFONO_PRO IN VARCHAR2, 
    p_DIRECCION_PRO IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_PROVEEDOR(
    NOMBRE_PROVEEDOR, 
    TELEFONO_PROVEEDOR, 
    DIRECCION_PROVEEDOR)
    VALUES (p_NOMBRE_PRO, p_TELEFONO_PRO, p_DIRECCION_PRO);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el proveedor, intente de nuevo');
END INSERTAR_PROVEEDOR_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_PROVEEDOR_SP(p_IDPRO IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PROVEEDOR 
    WHERE ID_PROVEEDOR = p_IDPRO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el proveedor seleccionado');
END ELIMINAR_PROVEEDOR_SP;

---------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_PROVEEDOR_SP(
    p_ID_PROVEEDOR IN NUMBER, 
    p_NOMBRE_PROVEEDOR IN VARCHAR2,
    p_TELEFONO IN NUMBER,
    p_DIRECCION IN VARCHAR2)
IS 
BEGIN
    UPDATE TAB_PROVEEDOR
    SET ID_PROVEEDOR = p_ID_EMPLEADO,
        NOMBRE_PROVEEDOR = p_NOMBRE_PROVEEDOR,
        TELEFONO_PROVEEDOR = p_TELEFONO,
        DIRECCION_PROVEEDOR = p_DIRECCION
    WHERE ID_SERVICIO = p_ID_SERVICIO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END ACTUALIZAR_PROVEEDOR_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_PROVEEDOR_SP(s_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN s_cursor FOR
    SELECT ID_PROVEEDRO, NOMBRE_PROVEEDOR, TELEFONO_SUCURSAL, DIRECCION_PROVEEDOR
    FROM PROVEEDOR_VIEW;
END LISTAR_PROVEEDOR_SP;

--------------------------------------------------------------------------------

--Productos CRUD

---------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_PRODUCTO_SP(
    p_ID_CATEGORIA IN NUMBER, 
    p_ID_PROV IN NUMBER, 
    p_DESCRIPCION IN VARCHAR2, 
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER)
IS 
BEGIN
    INSERT INTO TAB_PRODUCTO(
    ID_CATEGORIA, 
    ID_PROVEEDOR,
    DESCRIPCION, 
    PRECIO,
    STOCK)
    VALUES (
    p_ID_CATEGORIA, 
    p_ID_PROV,
    p_DESCRIPCION, 
    p_PRECIO,
    p_STOCK);
EXCEPTION 
    WHEN OTHERS THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el producto, intente de nuevo');
END INSERTAR_PRODUCTO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_PRODUCTO_SP(p_IDPRODUCTO IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PRODUCTO
    WHERE ID_PRODUCTO = p_IDPRODUCTO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el producto seleccionado');
END ELIMINAR_PRODUCTO_SP;

---------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_PRODUCTO_SP(
    p_ID_PRODUCTO IN NUMBER,
    p_ID_CATEGORIA IN NUMBER,
    p_ID_PROVEEDOR IN NUMBER,
    p_NOMBRE IN VARCHAR2,
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER
)
IS 
BEGIN 
    UPDATE TAB_PRODUCTO
    SET 
        ID_CATEGORIA = p_ID_CATEGORIA,
        ID_PROVEEDOR = p_ID_PROVEEDOR,
        DESCRIPCION = p_NOMBRE,
        PRECIO = p_PRECIO,
        STOCK = p_STOCK
    WHERE 
        ID_PRODUCTO = p_ID_PRODUCTO;
END ACTUALIZAR_PRODUCTO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_PRODUCTO_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_PRODUCTO, ID_CATEGORIA, ID_PROVEEDOR, DESCRIPCION, PRECIO, STOCK
    FROM PRODUCTO_VIEW;
END;

--------------------------------------------------------------------------------

--Servicios CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_SERVICIO_SP(
    p_ID IN NUMBER,
    p_ID_EMP IN NUMBER, 
    p_NOMBRE_SERV IN VARCHAR2,
    p_DESCRIPCION_SERV IN VARCHAR2,
    p_PRECIO IN NUMBER)
IS 
BEGIN
    INSERT INTO TAB_SERVICIO(
    ID_SERVICIO, 
    ID_EMPLEADO, 
    NOMBRE_SERVICIOS, 
    DESCRIPCION_SERVICIO,
    PRECIO)
    VALUES (p_ID, p_ID_EMP, p_NOMBRE_SERV, p_DESCRIPCION_SERV, p_PRECIO);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el servicio, intente de nuevo');
END INSERTAR_SERVICIO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_SERVICIO_SP(p_IDSERV IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_SERVICIO
    WHERE ID_SERVICIO = p_IDSERV;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el servicio seleccionado');
END ELIMINAR_Servicio_SP

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_SERVICIO_SP(
    p_ID_SERVICIO IN NUMBER,
    p_ID_EMPLEADO IN NUMBER, 
    p_NOMBRE_SERVICIO IN VARCHAR2,
    p_DESCRIPCION IN VARCHAR2,
    p_PRECIO IN NUMBER)
IS 
BEGIN
    UPDATE TAB_SERVICIO
    SET ID_EMPLEADO = p_ID_EMPLEADO,
        NOMBRE_SERVICIOS = p_NOMBRE_SERVICIO,
        DESCRIPCION_SERVICIO = p_DESCRIPCION,
        PRECIO = p_PRECIO
    WHERE ID_SERVICIO = p_ID_SERVICIO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END ACTUALIZAR_SERVICIO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_SERVICIO_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_SERVICIO, ID_EMPLEADO, NOMBRE_SERVICIOS, DESCRIPCION_SERVICIO, PRECIO
    FROM SERVICIO_VIEW;
END;

--------------------------------------------------------------------------------

--Puestos CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_PUESTO_SP(
    p_ID IN NUMBER,
    p_DESCRIPCION_P IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_PUESTO(ID_PUESTO, DESCRIPCION_PUESTO)
    VALUES (p_ID, p_DESCRIPCION_P);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el puesto, intente de nuevo');
END INSERTAR_Puesto_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_PUESTO_SP(p_IDP IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PUESTO
    WHERE ID_PUESTO = p_IDP;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el puesto seleccionado');
END ELIMINAR_Puesto_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_PUESTO_SP(
    p_IDPUESTO IN NUMBER,
    p_DESCRIPCION IN VARCHAR2)
IS 
BEGIN
    UPDATE TAB_PUESTO
    SET DESCRIPCION_PUESTO = p_DESCRIPCION
    WHERE ID_PUESTO = p_IDPUESTO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('Error al actualizar tabla');
END Actualizar_Puesto_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_PUESTO_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_Puesto,Descripcion_Puesto
    FROM Puestos_VIEW;
END Listar_Puesto_SP;

--------------------------------------------------------------------------------

--Roles CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_ROL_SP(
    DESCRIPCION_ROL IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_ROL(Descripcion_Rol)
    VALUES (DESCRIPCION_ROL);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el rol, intente de nuevo');
END INSERTAR_ROL_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_ROL_SP(p_IDRol IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_ROL
    WHERE ID_ROL = p_IDRol;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el rol seleccionado');
END ELIMINAR_ROL_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_ROL_SP(
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

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_ROL_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_Rol,Descripcion_Rol
    FROM ROL_VIEW;
END LISTAR_ROL_SP;

--------------------------------------------------------------------------------

--Categorias CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_CATEGORIA_SP(
    p_ID IN NUMBER,
    p_DESCRIPCION_CAT IN VARCHAR2)
IS 
BEGIN
    INSERT INTO TAB_CATEGORIA(
    ID_CATEGORIA,  
    DESCRIPCION_CATEGORIA)
    VALUES (p_ID, DESCRIPCION_CATEGORIA);
EXCEPTION 
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('No se pudo ingresar la categoria, intente de nuevo');
END INSERTAR_CATEGORIA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_CATEGORIA_SP(p_IDCATEGORIA IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_CATEGORIA
    WHERE ID_CATEGORIA = p_IDCATEGORIA;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar la categoria seleccionada');
END ELIMINAR_CATEGORIA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_CATEGORIA_SP(
    p_ID_CATEGORIA IN NUMBER,
    p_NOMBRE IN VARCHAR2
)
IS 
BEGIN 
    UPDATE TAB_CATEGORIA
    SET 
        DESCRIPCION_CATEGORIA = p_NOMBRE
    WHERE 
        ID_CATEGORIA = p_ID_CATEGORIA;
END ACTUALIZAR_CATEGORIA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_CATEGORIA_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT ID_Categoria,Descripcion_Categoria
    FROM CATEGORIA_VIEW;
END LISTAR_CATEGORIA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_PAGO_SP(
    p_id_proveedor IN NUMBER,
    p_monto IN NUMBER,
    p_fecha IN DATE
)
AS
BEGIN
    INSERT INTO TAB_PAGO(ID_PROVEEDOR, MONTO, FECHA)
    VALUES (p_id_proveedor, p_monto, p_fecha);
    COMMIT;
END INSERTAR_PAGO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ELIMINAR_PAGO_SP(p_CODPAGO IN NUMBER)
IS 
BEGIN 
    DELETE FROM TAB_PAGO
    WHERE COD_PAGO = p_CODPAGO;
EXCEPTION 
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar la categoria seleccionada');
END ELIMINAR_PAGO_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE ACTUALIZAR_PAGO_SP(
    p_CODPAGO IN NUMBER,
    p_IDPROVEEDOR IN NUMBER,
    p_MONTO IN NUMBER
)
IS 
BEGIN 
    UPDATE TAB_PAGO
    SET 
        ID_PROVEEDOR = p_IDPROVEEDOR,
        MONTO = p_MONTO
    WHERE 
        COD_PAGO = p_CODPAGO;
END ACTUALIZAR_PAGO_SP;

--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE LISTAR_PAGO_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT COD_PAGO, ID_PROVEEDOR, MONTO, FECHA
    FROM PAGO_VIEW;
END LISTAR_PAGO_SP;

--------------------------------------------------------------------------------

--Venta CRUD

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERTAR_VENTA_SP(
    p_id_cliente IN NUMBER,
    p_id_sucursal IN NUMBER,
    p_monto_venta IN NUMBER,
    p_fecha IN DATE
)
AS
BEGIN
    INSERT INTO TAB_VENTA (ID_CLIENTE, ID_SUCURSAL, MONTO_VENTA, FECHA)
    VALUES (p_id_cliente, p_id_sucursal, p_monto_venta, p_fecha);
    COMMIT;
END INSERTAR_VENTA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE LISTAR_VENTA_SP(p_cursor OUT SYS_REFCURSOR)
IS
BEGIN
  OPEN p_cursor FOR
    SELECT NUM_FACTURA, ID_CLIENTE, ID_SUCURSAL, MONTO_VENTA, FECHA
    FROM VENTA_VIEW;
END LISTAR_VENTA_SP;

--------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE VENTA_ID_SP (
    p_venta_id OUT NUMBER
)
AS
BEGIN
    SELECT MAX(num_factura) INTO p_venta_id FROM TAB_VENTA;
END VENTA_ID_SP ;

--------------------------------------------------------------------------------

--Detalla CRUD

--------------------------------------------------------------------------------
CREATE OR REPLACE PROCEDURE INSERTAR_DETALLE_SP (
    p_tipo_elemento IN VARCHAR2,
    p_id_elemento IN NUMBER,
    p_cantidad IN NUMBER,
    p_precio IN NUMBER,
    p_id_venta IN NUMBER
)
AS
BEGIN
    IF p_tipo_elemento = 'Producto' THEN
        INSERT INTO TAB_DETALLE (TIPO_ELEMENTO, ID_ELEMENTO, CANTIDAD, PRECIO, ID_VENTA)
        VALUES (p_tipo_elemento, p_id_elemento, p_cantidad, p_precio, p_id_venta);
    ELSIF p_tipo_elemento = 'Servicio' THEN
        INSERT INTO TAB_DETALLE (TIPO_ELEMENTO, ID_ELEMENTO, CANTIDAD, PRECIO, ID_VENTA)
        VALUES (p_tipo_elemento, p_id_elemento, p_cantidad, p_precio, p_id_venta);
    END IF;
    COMMIT; 
END INSERTAR_DETALLE_SP;


--------------------------------------------------------------------------------
