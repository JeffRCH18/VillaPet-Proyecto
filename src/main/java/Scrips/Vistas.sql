--Vistas Villa Pet

--------------------------------------------------------------------------------

--Vista para lista los clientes
CREATE OR REPLACE VIEW Clientes_VIEW AS
SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
FROM TAB_CLIENTE;

--------------------------------------------------------------------------------

--Vista para lista los roles
CREATE OR REPLACE VIEW ROL_VIEW AS
SELECT ID_Rol,Descripcion_Rol
FROM TAB_ROL;

--------------------------------------------------------------------------------

--Vista para lista los servicios
CREATE OR REPLACE VIEW SERVICIO_VIEW AS
SELECT ID_Servicio, ID_Empleado, Nombre_Servicios, Descripcion_Servicio, Precio
FROM TAB_SERVICIO;

--------------------------------------------------------------------------------

--Vista para lista los puestos
CREATE OR REPLACE VIEW PUESTO_VIEW AS
SELECT ID_PUESTO,DESCRIPCION_PUESTO
FROM TAB_PUESTO;

--------------------------------------------------------------------------------

--Vista para lista las sucursales
CREATE OR REPLACE VIEW SUCURSAL_VIEW AS
SELECT ID_SUCURSAL, CORREO_SUCURSAL, TELEFONO_SUCURSAL, NOMBRE_SUCURSAL, DIRECCION_SUCURSAL
FROM TAB_SUCURSAL;

--------------------------------------------------------------------------------

--Vista para lista los proveedores
CREATE OR REPLACE VIEW PROVEEDOR_VIEW AS
SELECT ID_PROVEEDOR,  NOMBRE_PROVEEDOR, TELEFONO_PROVEEDOR, DIRECCION_PROVEEDOR
FROM TAB_PROVEEDOR;

--------------------------------------------------------------------------------

--Vista para lista los empleados
CREATE OR REPLACE VIEW EMPLEADO_VIEW AS
SELECT ID_EMPLEADO, ID_PUESTO, ID_ROL, ID_SUCURSAL, NOMBRE_EMPLEADO, APELLIDO, CORREO, CONTRASEÑA, SALARIO
FROM TAB_EMPLEADO;

--------------------------------------------------------------------------------

--Vista para lista los productos
CREATE OR REPLACE VIEW PRODUCTO_VIEW AS
SELECT ID_PRODUCTO, ID_CATEGORIA, ID_PROVEEDOR, DESCRIPCION, PRECIO, STOCK
FROM TAB_PRODUCTO;

--------------------------------------------------------------------------------

--Vista para lista las categorias
CREATE OR REPLACE VIEW CATEGORIA_VIEW AS
SELECT ID_Categoria,Descripcion_Categoria
FROM TAB_CATEGORIA;

--------------------------------------------------------------------------------

--Vista para lista las ventas
CREATE OR REPLACE VIEW VENTA_VIEW AS
SELECT NUM_FACTURA, ID_CLIENTE, ID_SUCURSAL, MONTO_VENTA, FECHA
FROM TAB_VENTA;

--------------------------------------------------------------------------------












--------------------------------------------------------------------------------
-Vista para listar los empledos con su puesto y rol
CREATE OR REPLACE VIEW Empleados_VIEW AS
SELECT
    ID_EMPLEADO,
    NOMBRE_EMPLEADO,
    APELLIDO,
    CORREO,
    DESCRIPCION_ROL AS ROL,
    DESCRIPCION_PUESTO AS PUESTO,
    SALARIO
FROM
    Tab_Empleado e
    JOIN Tab_Rol r ON e.ID_ROL = r.ID_ROL
    JOIN Tab_Puesto p ON e.ID_PUESTO = p.ID_PUESTO;

--SELECT * FROM VISTA_EMPLEADOS;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Vista que muesta el total de ventas de cada cliente y su total
CREATE OR REPLACE VIEW VentasCliente_VIEW AS
SELECT
    v.ID_CLIENTE,
    c.NOMBRE_CLIENTE,
    c.APELLIDO,
    COUNT(*) AS TOTAL_VENTAS,
    SUM(v.MONTO_VENTA) AS TOTAL_MONTO_VENTAS
FROM
    Tab_Venta v
    JOIN Tab_Cliente c ON v.ID_CLIENTE = c.ID_CLIENTE
GROUP BY
    v.ID_CLIENTE, c.NOMBRE_CLIENTE, c.APELLIDO;

--SELECT * FROM VISTA_VENTASCLIENTE;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Vista que genera el total de ventas por mes de cada sucursal
CREATE OR REPLACE VIEW VentasMensualesporSucursal_VIEW AS
SELECT
    TO_CHAR(FECHA, 'YYYY-MM') AS MES,
    ts.NOMBRE_SUCURSAL,
    SUM(MONTO_VENTA) AS TOTAL_VENTAS
FROM
    Tab_Venta tv
    JOIN Tab_SUCURSAL ts ON tv.ID_SUCURSAL = ts.ID_SUCURSAL
GROUP BY
    TO_CHAR(FECHA, 'YYYY-MM'), ts.NOMBRE_SUCURSAL
ORDER BY
    MES;

--SELECT * FROM VISTA_VENTAS_MENSUALES_POR_SUCURSAL;
---------------------------------------------------------------------------------------------------------------------------------------------------------------