
--Funciones Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Contar la cantidad de ventas realizadas por una sucursal
CREATE OR REPLACE FUNCTION VentasporSucursal_FN(IDSucursal IN NUMBER) 
RETURN NUMBER 
IS
    conteo NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO conteo
    FROM Tab_Venta
    WHERE ID_Sucursal = IDSucursal;

    RETURN conteo;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END VentasporSucursal_FN;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el total de ventas realizadas en un día específico
CREATE OR REPLACE FUNCTION VentasporDia_FN(fecha IN DATE) 
RETURN NUMBER 
IS
    total NUMBER;
BEGIN
    SELECT SUM(Monto_Venta)
    INTO total
    FROM Tab_Venta
    WHERE Fecha = fecha;
    
    RETURN total;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END VentasporDia_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular la cantidad total de productos en stock
CREATE OR REPLACE FUNCTION ProductosenStock_FN(sucursal NUMBER)
RETURN NUMBER 
IS
    total_stock NUMBER;
BEGIN
    SELECT SUM(Stock)
    INTO total_stock
    FROM Tab_Producto
    WHERE ID_Sucursal = sucursal;
    
    RETURN total_stock;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END ProductosenStock_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar productos agotados
CREATE OR REPLACE FUNCTION ProductosAgotados_FN 
RETURN VARCHAR2 
IS
    lista_agotados VARCHAR2(4000); 
BEGIN
    lista_agotados := '';
    
    FOR producto IN (SELECT Descripcion, ID_Sucursal FROM Tab_Producto WHERE Stock = 0) 
    LOOP
        lista_agotados := lista_agotados || producto.Descripcion || '--> Sucursal: ' || producto.ID_Sucursal || '. ';
    END LOOP;

    RETURN lista_agotados;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No hay productos agotados';
END ProductosAgotados_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Contar la cantidad de empleados por sucursal
CREATE OR REPLACE FUNCTION EmpleadosporSucursal_FN(IDSucursal IN NUMBER) 
RETURN NUMBER 
IS
    conteo NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO conteo
    FROM Tab_Empleado
    WHERE ID_Sucursal = IDSucursal;
    
    RETURN conteo;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END EmpleadosporSucursal_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular pagos realizados a un proovedor
CREATE OR REPLACE FUNCTION PagosaProveedor_FN(IDProveedor NUMBER) 
RETURN NUMBER 
IS
    total NUMBER;
BEGIN
    SELECT SUM(Monto) INTO total
    FROM Tab_Pago
    WHERE ID_Proveedor = IDProveedor;
    
    RETURN total;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END PagosaProveedor_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el total de pagos en un periodo de tiempo
CREATE OR REPLACE FUNCTION PagosporPeriodo_FN(FechaInicio DATE, FechaFin DATE) 
RETURN NUMBER 
IS
    total NUMBER;
BEGIN
    SELECT SUM(Monto) INTO total
    FROM Tab_Pago
    WHERE Fecha BETWEEN FechaInicio AND FechaFin;
    
    RETURN total;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END PagosporPeriodo_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Pruebas

-- Contar la cantidad de ventas realizadas por una sucursal
SELECT VentasporSucursal_FN(01) AS Ventas_Sucursal_01 FROM DUAL;

-- Calcular el total de ventas realizadas en un d�a espec�fico
SELECT VentasporDia_FN(TO_DATE('2024-04-07', 'YYYY-MM-DD')) AS Total_Ventas_Hoy FROM DUAL;

-- Calcular la cantidad total de productos en stock
SELECT ProductosenStock_FN(1) AS Total_Productos_Stock FROM DUAL;

-- Listar productos agotados
SELECT ProductosAgotados_FN() AS Productos_Agotados FROM DUAL;

-- Contar la cantidad de empleados por sucursal
SELECT EmpleadosporSucursal_FN(01) AS Empleados_Sucursal_01 FROM DUAL;

-- Calcular pagos realizados a un proveedor
SELECT PagosaProveedor_FN(03) AS Pagos_a_Proveedor_01 FROM DUAL;

-- Calcular el total de pagos en un periodo de tiempo
SELECT PagosporPeriodo_FN(TO_DATE('2024-04-01', 'YYYY-MM-DD'), TO_DATE('2024-04-08', 'YYYY-MM-DD')) AS Total_Pagos_Periodo FROM DUAL;

