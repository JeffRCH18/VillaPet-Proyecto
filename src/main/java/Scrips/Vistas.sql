
--Vistas Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Vista para lista los clientes
CREATE OR REPLACE VIEW Clientes_VIEW AS
SELECT ID_CLIENTE, NOMBRE_CLIENTE, APELLIDO, DIRECCION_CLIENTE, TELEFONO_CLIENTE, CORREO_CLIENTE
FROM TAB_CLIENTE;

--SELECT * FROM VISTA_CLIENTE;
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--Vista para listar los empledos con su puesto y rol
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