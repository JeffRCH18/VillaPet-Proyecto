
--Packages Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--Encabezado del paquete de crud cliente 
CREATE OR REPLACE PACKAGE CRUD_cliente_PKG AS
    --Insertar cliente 
    PROCEDURE Inserta_Cliente_SP(
    nombre_cliente IN VARCHAR2,
    apellido IN VARCHAR2,
    direccion_cliente IN VARCHAR2,
    correo_cliente IN VARCHAR2,
    telefono_cliente IN NUMBER
    );
    --Eliminar cliente
    PROCEDURE Eliminar_Cliente_SP(p_IDCLI IN NUMBER);
    --Actualizar cliente
    PROCEDURE Actualizar_Cliente_SP(
    p_ID_CLIENTE IN NUMBER,
    p_NOMBRE IN VARCHAR2,
    p_APELLIDO IN VARCHAR2,
    p_DIRECCION IN VARCHAR2,
    p_TELEFONO IN VARCHAR2,
    p_CORREO IN VARCHAR2
    );
    --Listar cliente
    PROCEDURE Listar_Cliente_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_cliente_PKG;

--Cuerpo del paquete de insertar paquete
CREATE OR REPLACE PACKAGE BODY CRUD_cliente_PKG AS
--PS de insertar cliente
    PROCEDURE Inserta_Cliente_SP(
    nombre_cliente IN VARCHAR2,
    apellido IN VARCHAR2,
    direccion_cliente IN VARCHAR2,
    correo_cliente IN VARCHAR2,
    telefono_cliente IN NUMBER
    )
    AS
    BEGIN
        INSERT INTO Tab_Cliente(Nombre_Cliente, Apellido, Direccion_Cliente, Correo_Cliente, Telefono_Cliente)
        VALUES (nombre_cliente, apellido, direccion_cliente, correo_cliente, telefono_cliente);
        COMMIT;
    END Inserta_Cliente_SP;
--PS de eliminar cliente 
    PROCEDURE Eliminar_Cliente_SP(p_IDCLI IN NUMBER)
    IS 
    BEGIN 
        DELETE FROM TAB_CLIENTE
        WHERE ID_CLIENTE = p_IDCLI;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el cliente seleccionado');
    END delete_cliente_PKG;
--PS de listar cliente 
    PROCEDURE Listar_Cliente_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
        OPEN p_cursor FOR
        SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
        FROM Clientes_VIEW;
    END Listar_Cliente_SP;
--PS actualizar cliente 
    PROCEDURE Actualizar_Cliente_SP(
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
END CRUD_cliente_PKG;

CREATE OR REPLACE PACKAGE CRUD_empleados_PKG AS
--Encabezado para eliminar empleado
    PROCEDURE ELIMINAR_EMPLEADO_SP(p_IDEMP IN NUMBER);
--Encabezado para actualizar empleado
    PROCEDURE ACTUALIZAR_EMPLEADO_SP(
    p_IDEMP IN NUMBER,
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2, 
    p_SALARIO IN NUMBER,
    p_IDSUCURSAL IN NUMBER
    );
--Encabezado para listar empleado
    PROCEDURE LISTAR_EMPLEADO_SP(p_cursor OUT SYS_REFCURSOR);
--Encabezado para insertar empleado
    PROCEDURE INSERTAR_EMPLEADO_SP(
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2,
    p_SALARIO IN NUMBER,
    p_SUCURSAL IN VARCHAR2
    );
END CRUD_empleados_PKG;

--Cuerpo del paquete del crud empleados
CREATE OR REPLACE PACKAGE BODY CRUD_empleados_PKG AS
--PS para borrar empleado
    PROCEDURE ELIMINAR_EMPLEADO_SP(p_IDEMP IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_EMPLEADO 
    WHERE ID_EMPLEADO = p_IDEMP;
        EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.PUT_LINE('No se pudo borrar el empleado seleccionado');
    END ELIMINAR_EMPLEADO_SP;
--PS para actualizar empleado
    PROCEDURE ACTUALIZAR_EMPLEADO_SP(
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
--PS para listar empleado 
    PROCEDURE LISTAR_EMPLEADO_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT ID_EMPLEADO, ID_PUESTO, ID_ROL, ID_SUCURSAL, NOMBRE_EMPLEADO, APELLIDO, CORREO, SALARIO
    FROM Empleados_VIEW;
    END LISTAR_EMPLEADO_SP;
--PS para insertar empleado
    PROCEDURE INSERTAR_EMPLEADO_SP(
    p_IDPUESTO IN NUMBER, 
    p_IDROL IN NUMBER,
    p_NOMBRE_EMP IN VARCHAR2,
    p_APELLIDO_EMP IN VARCHAR2, 
    p_CORREO IN VARCHAR2, 
    p_CONTRASENA IN VARCHAR2,
    p_SALARIO IN NUMBER,
    p_SUCURSAL IN VARCHAR2)
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
END CRUD_empleados_PKG;

--Encabezado del paquete crud de sucursales 
CREATE OR REPLACE PACKAGE CRUD_sucursal_PKG AS
--Encabezado para insertar una sucursal
    PROCEDURE INSERTAR_SUCURSAL_SP(
    p_ID IN NUMBER,
    p_CORREO IN VARCHAR2, 
    p_TELEFONO IN VARCHAR2, 
    p_NOMBRE_SUCURSAL IN VARCHAR2,
    p_DIRECCION_SUCURSAL IN VARCHAR2
    );
--Encabezado para eliminar una sucursal  
    PROCEDURE ELIMINAR_SUCURSAL_SP(p_IDSU IN NUMBER);
--Encabezado par actualizar una sucursal
    PROCEDURE ACTUALIZAR_SUCURSAL_SP(
    p_IDSUCURSAL IN NUMBER,
    p_CORREO IN VARCHAR2, 
    p_TELEFONO IN VARCHAR2, 
    p_NOMBRE IN VARCHAR2, 
    p_DIRECCION IN VARCHAR2
    );
--Encabezado para listar una sucursal 
    PROCEDURE LISTAR_SUCURSAL_SP(s_cursor OUT SYS_REFCURSOR);
END CRUD_sucursal_PKG;

--Cuerpo del paquete CRUD_sucursal_PKG
CREATE OR REPLACE PACKAGE BODY CRUD_sucursal_PKG AS
--PS para insertar sucursal
    PROCEDURE INSERTAR_SUCURSAL_SP(
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
--PS para eliminar sucursal  
    PROCEDURE ELIMINAR_SUCURSAL_SP(p_IDSU IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_SUCURSAL 
    WHERE ID_SUCURSAL = p_IDSU;
        EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            DBMS_OUTPUT.PUT_LINE('No se pudo borrar la sucursal seleccionada');
    END ELIMINAR_SUCURSAL_SP;
--PS para actualizar sucursal  
    PROCEDURE ACTUALIZAR_SUCURSAL_SP(
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
--PS para listar sucursal 
    PROCEDURE LISTAR_SUCURSAL_SP(s_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN s_cursor FOR
    SELECT ID_SUCURSAL, CORREO_SUCURSAL, TELEFONO_SUCURSAL, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL
    FROM SUCURSAL_VIEW;
    END LISTAR_SUCURSAL_SP;
END CRUD_sucursal_PKG;

--Encabezado del paquete CRUD proveedor
CREATE OR REPLACE PACKAGE CRUD_proveedor_PKG AS
--Encabezado de insertar proveedor
    PROCEDURE INSERTAR_PROVEEDOR_SP(
    p_NOMBRE_PRO IN VARCHAR2,
    p_TELEFONO_PRO IN VARCHAR2, 
    p_DIRECCION_PRO IN VARCHAR2);
--Encabezado de eliminar proveedor   
    PROCEDURE ELIMINAR_PROVEEDOR_SP(p_IDPRO IN NUMBER);
--Encabezado de actualizar proveedor   
    PROCEDURE ACTUALIZAR_PROVEEDOR_SP(
    p_ID_PROVEEDOR IN NUMBER, 
    p_NOMBRE_PROVEEDOR IN VARCHAR2,
    p_TELEFONO IN NUMBER,
    p_DIRECCION IN VARCHAR2);
--Encabezado de listar proveedor    
    PROCEDURE LISTAR_PROVEEDOR_SP(s_cursor OUT SYS_REFCURSOR);
END CRUD_proveedor_PKG;

--Cuerpo del paquete de CRUD proveedor 
CREATE OR REPLACE PACKAGE BODY CRUD_proveedor_PKG AS 
--PS para insertar proveedor 
    PROCEDURE INSERTAR_PROVEEDOR_SP(
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
--PS para eliminar proveedor  
    PROCEDURE ELIMINAR_PROVEEDOR_SP(p_IDPRO IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_PROVEEDOR 
    WHERE ID_PROVEEDOR = p_IDPRO;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            DBMS_OUTPUT.PUT_LINE('No se pudo borrar el proveedor seleccionado');
    END ELIMINAR_PROVEEDOR_SP;
--PS para actualizar proveedor
    PROCEDURE ACTUALIZAR_PROVEEDOR_SP(
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
--PS para listar proveedor  
    PROCEDURE LISTAR_PROVEEDOR_SP(s_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN s_cursor FOR
    SELECT ID_PROVEEDRO, NOMBRE_PROVEEDOR, TELEFONO_SUCURSAL, DIRECCION_PROVEEDOR
    FROM PROVEEDOR_VIEW;
    END LISTAR_PROVEEDOR_SP;
END CRUD_proveedor_PKG;

--Encabezado del paquete CRUD producto
CREATE OR REPLACE PACKAGE CRUD_producto_PKG AS
--Encabezado para insertar producto
    PROCEDURE INSERTAR_PRODUCTO_SP(
    p_ID_CATEGORIA IN NUMBER, 
    p_ID_PROV IN NUMBER, 
    p_DESCRIPCION IN VARCHAR2, 
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER
    );
--Encabezado para eliminar producto
    PROCEDURE ELIMINAR_PRODUCTO_SP(p_IDPRODUCTO IN NUMBER);
--Encabezado para actualizar producto 
    PROCEDURE ACTUALIZAR_PRODUCTO_SP(
    p_ID_PRODUCTO IN NUMBER,
    p_ID_CATEGORIA IN NUMBER,
    p_ID_PROVEEDOR IN NUMBER,
    p_NOMBRE IN VARCHAR2,
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER
    );
--Encabezado para listar producto   
    PROCEDURE LISTAR_PRODUCTO_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_proveedor_PKG;

--Cuerpo del paquete CRUD productos 
CREATE OR REPLACE PACKAGE BODY CRUD_proveedor_PKG AS
--PS para insertar producto
    PROCEDURE INSERTAR_PRODUCTO_SP(
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
    VALUES(
    p_ID_CATEGORIA, 
    p_ID_PROV,
    p_DESCRIPCION, 
    p_PRECIO,
    p_STOCK);
    EXCEPTION 
        WHEN OTHERS THEN 
            DBMS_OUTPUT.PUT_LINE('No se pudo ingresar el producto, intente de nuevo');
    END INSERTAR_PRODUCTO_SP;
--PS para eliminar producto  
    PROCEDURE ELIMINAR_PRODUCTO_SP(p_IDPRODUCTO IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_PRODUCTO
    WHERE ID_PRODUCTO = p_IDPRODUCTO;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            DBMS_OUTPUT.PUT_LINE('No se pudo borrar el producto seleccionado');
    END ELIMINAR_PRODUCTO_SP;
--PS para actualizar producto 
    PROCEDURE ACTUALIZAR_PRODUCTO_SP(
    p_ID_PRODUCTO IN NUMBER,
    p_ID_CATEGORIA IN NUMBER,
    p_ID_PROVEEDOR IN NUMBER,
    p_NOMBRE IN VARCHAR2,
    p_PRECIO IN NUMBER,
    p_STOCK IN NUMBER)
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
--PS para listar producto   
    PROCEDURE LISTAR_PRODUCTO_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT ID_PRODUCTO, ID_CATEGORIA, ID_PROVEEDOR, DESCRIPCION, PRECIO, STOCK
    FROM PRODUCTO_VIEW;
    END LISTAR_PRODUCTO_SP;
END CRUD_producto_PKG;

--Encabezado del paquete CRUD servicio 
CREATE OR REPLACE PACKAGE CRUD_servicio_PKG AS 
--Encabezado para insertar servicio
    PROCEDURE INSERTAR_SERVICIO_SP(
    p_ID IN NUMBER,
    p_ID_EMP IN NUMBER, 
    p_NOMBRE_SERV IN VARCHAR2,
    p_DESCRIPCION_SERV IN VARCHAR2,
    p_PRECIO IN NUMBER);
--Encabezado para eliminar servicio 
    PROCEDURE ELIMINAR_SERVICIO_SP(p_IDSERV IN NUMBER);
--Encabezado para actualizar servicio   
    PROCEDURE ACTUALIZAR_SERVICIO_SP(
    p_ID_SERVICIO IN NUMBER,
    p_ID_EMPLEADO IN NUMBER, 
    p_NOMBRE_SERVICIO IN VARCHAR2,
    p_DESCRIPCION IN VARCHAR2,
    p_PRECIO IN NUMBER);
--Encabezado para listar servicio  
    PROCEDURE LISTAR_SERVICIO_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_servicio_PKG;

--Cuerpo del paquete CRUD servicio 
CREATE OR REPLACE PACKAGE BODY CRUD_servicio_PKG AS
--SP para insertar servicio
    PROCEDURE INSERTAR_SERVICIO_SP(
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
--PS para eliminar servicio
    PROCEDURE ELIMINAR_SERVICIO_SP(p_IDSERV IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_SERVICIO
    WHERE ID_SERVICIO = p_IDSERV;
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN 
            DBMS_OUTPUT.PUT_LINE('No se pudo borrar el servicio seleccionado');
    END ELIMINAR_Servicio_SP;
--SP para actualizar servicio   
    PROCEDURE ACTUALIZAR_SERVICIO_SP(
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
--SP para listar servicio 
    PROCEDURE LISTAR_SERVICIO_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT ID_SERVICIO, ID_EMPLEADO, NOMBRE_SERVICIOS, DESCRIPCION_SERVICIO, PRECIO
    FROM SERVICIO_VIEW;
    END LISTAR_SERVICIO_SP;
END CRUD_servicio_PKG; 

--Encabezado del paquete CRUD puestos 
CREATE OR REPLACE PACKAGE CRUD_puestos_PKG AS 
--Encabezado para insertar puesto
    PROCEDURE INSERTAR_PUESTO_SP(
    p_ID IN NUMBER,
    p_DESCRIPCION_P IN VARCHAR2);
--Encabezado para eliminar puesto
    PROCEDURE ELIMINAR_PUESTO_SP(p_IDP IN NUMBER);
--Encabezado para actualizar puesto
    PROCEDURE ACTUALIZAR_PUESTO_SP(
    p_IDPUESTO IN NUMBER,
    p_DESCRIPCION IN VARCHAR2);
--Encabezado para listar puesto
    PROCEDURE LISTAR_PUESTO_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_puestos_PKG;

--Cuerpo del package para CRUD_puesto_PKG
CREATE OR REPLACE PACKAGE BODY CRUD_puesto_PKG AS 
--PS para insertar puesto
    PROCEDURE INSERTAR_PUESTO_SP(
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
--PS para eliminar puesto
    PROCEDURE ELIMINAR_PUESTO_SP(p_IDP IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_PUESTO
    WHERE ID_PUESTO = p_IDP;
        EXCEPTION 
            WHEN NO_DATA_FOUND THEN 
                DBMS_OUTPUT.PUT_LINE('No se pudo borrar el puesto seleccionado');
    END ELIMINAR_Puesto_SP;
--PS para actualizar puesto
    PROCEDURE ACTUALIZAR_PUESTO_SP(
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
--PS para listar puesto
    PROCEDURE LISTAR_PUESTO_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT ID_Puesto,Descripcion_Puesto
    FROM Puestos_VIEW;
    END Listar_Puesto_SP;
END CRUD_puestos_PKG;
 
--Encabezado para CRUD categorias 
CREATE OR REPLACE PACKAGE CRUD_categorias_PKG AS
--Encabezado para insertar categoria 
    PROCEDURE INSERTAR_CATEGORIA_SP(
    p_ID IN NUMBER,
    p_DESCRIPCION_CAT IN VARCHAR2);
--Encabezado para eliminar categoria
    PROCEDURE ELIMINAR_CATEGORIA_SP(p_IDCATEGORIA IN NUMBER);
--Encabezado para actualizar categoria 
    PROCEDURE ACTUALIZAR_CATEGORIA_SP(
    p_ID_CATEGORIA IN NUMBER,
    p_NOMBRE IN VARCHAR2);
--Encabezado para listar categoria
    PROCEDURE LISTAR_CATEGORIA_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_categorias_PKG;
    
--Cuerpo del paquete CRUD categoria 
CREATE OR REPLACE PACKAGE BODY CRUD_categorias_PKG AS 
--PS para insertar categoria 
    PROCEDURE INSERTAR_CATEGORIA_SP(
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
--PS para elimnar categoria
    PROCEDURE ELIMINAR_CATEGORIA_SP(p_IDCATEGORIA IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_CATEGORIA
    WHERE ID_CATEGORIA = p_IDCATEGORIA;
        EXCEPTION 
            WHEN NO_DATA_FOUND THEN 
                DBMS_OUTPUT.PUT_LINE('No se pudo borrar la categoria seleccionada');
    END ELIMINAR_CATEGORIA_SP;
--PS para actualizar categoria
    PROCEDURE ACTUALIZAR_CATEGORIA_SP(
    p_ID_CATEGORIA IN NUMBER,
    p_NOMBRE IN VARCHAR2)
    IS 
    BEGIN 
    UPDATE TAB_CATEGORIA
    SET 
        DESCRIPCION_CATEGORIA = p_NOMBRE
    WHERE 
        ID_CATEGORIA = p_ID_CATEGORIA;
    END ACTUALIZAR_CATEGORIA_SP;
--PS para listar categoria 
    PROCEDURE LISTAR_CATEGORIA_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT ID_Categoria,Descripcion_Categoria
    FROM CATEGORIA_VIEW;
    END LISTAR_CATEGORIA_SP;
END CRUD_categorias_PKG;

--Encabezado del paquete CRUD venta 
CREATE OR REPLACE PACKAGE CRUD_venta_PKG AS 
    PROCEDURE INSERTAR_VENTA_SP(
    p_id_cliente IN NUMBER,
    p_id_sucursal IN NUMBER,
    p_monto_venta IN NUMBER,
    p_fecha IN DATE);
    
    PROCEDURE LISTAR_VENTA_SP(p_cursor OUT SYS_REFCURSOR);
    
    PROCEDURE VENTA_ID_SP (
    p_venta_id OUT NUMBER);
END CRUD_venta_PKG;

--Encabezado del package CRUD pago
CREATE OR REPLACE PACKAGE CRUD_pago_PKG AS 
--Encabezado para insertar pago
    PROCEDURE INSERTAR_PAGO_SP(
    p_id_proveedor IN NUMBER,
    p_monto IN NUMBER,
    p_fecha IN DATE);
--PS para eliminar pago
    PROCEDURE ELIMINAR_PAGO_SP(p_CODPAGO IN NUMBER);
--PS para actualizar pago
    PROCEDURE ACTUALIZAR_PAGO_SP(
    p_CODPAGO IN NUMBER,
    p_IDPROVEEDOR IN NUMBER,
    p_MONTO IN NUMBER);
--PS para listar pago
    PROCEDURE LISTAR_PAGO_SP(p_cursor OUT SYS_REFCURSOR);
END CRUD_pago_PKG;

--Cuerpo del package CRUD_pago_PKG
CREATE OR REPLACE PACKAGE BODY CRUD_pago_PKG AS
--PS para insertar pago
    PROCEDURE INSERTAR_PAGO_SP(
    p_id_proveedor IN NUMBER,
    p_monto IN NUMBER,
    p_fecha IN DATE)
    AS
    BEGIN
    INSERT INTO TAB_PAGO(ID_PROVEEDOR, MONTO, FECHA)
    VALUES (p_id_proveedor, p_monto, p_fecha);
    COMMIT;
    END INSERTAR_PAGO_SP;
--PS para eliminar pago
    PROCEDURE ELIMINAR_PAGO_SP(p_CODPAGO IN NUMBER)
    IS 
    BEGIN 
    DELETE FROM TAB_PAGO
    WHERE COD_PAGO = p_CODPAGO;
        EXCEPTION 
            WHEN NO_DATA_FOUND THEN 
                DBMS_OUTPUT.PUT_LINE('No se pudo borrar la categoria seleccionada');
    END ELIMINAR_PAGO_SP;
--PS para actualizar pago
    PROCEDURE ACTUALIZAR_PAGO_SP(
    p_CODPAGO IN NUMBER,
    p_IDPROVEEDOR IN NUMBER,
    p_MONTO IN NUMBER)
    IS 
    BEGIN 
    UPDATE TAB_PAGO
    SET 
        ID_PROVEEDOR = p_IDPROVEEDOR,
        MONTO = p_MONTO
    WHERE 
        COD_PAGO = p_CODPAGO;
    END ACTUALIZAR_PAGO_SP;
--PS para listar pago
    PROCEDURE LISTAR_PAGO_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT COD_PAGO, ID_PROVEEDOR, MONTO, FECHA
    FROM PAGO_VIEW;
    END LISTAR_PAGO_SP;
END CRUD_pago_PKG;

--Cuerpo del pakcage CRUD venta
CREATE OR REPLACE PACKAGE BODY CRUD_venta_PKG AS
--PS para insertar venta
    PROCEDURE INSERTAR_VENTA_SP(
    p_id_cliente IN NUMBER,
    p_id_sucursal IN NUMBER,
    p_monto_venta IN NUMBER,
    p_fecha IN DATE)
    AS
    BEGIN
    INSERT INTO TAB_VENTA (ID_CLIENTE, ID_SUCURSAL, MONTO_VENTA, FECHA)
    VALUES (p_id_cliente, p_id_sucursal, p_monto_venta, p_fecha);
    COMMIT;
    END INSERTAR_VENTA_SP;
--PS para listar venta 
    PROCEDURE LISTAR_VENTA_SP(p_cursor OUT SYS_REFCURSOR)
    IS
    BEGIN
    OPEN p_cursor FOR
    SELECT NUM_FACTURA, ID_CLIENTE, ID_SUCURSAL, MONTO_VENTA, FECHA
    FROM VENTA_VIEW;
    END LISTAR_VENTA_SP;

    PROCEDURE VENTA_ID_SP (
    p_venta_id OUT NUMBER)
    AS
    BEGIN
    SELECT MAX(num_factura) INTO p_venta_id FROM TAB_VENTA;
    END VENTA_ID_SP ;
END CRUD_venta_PKG;





