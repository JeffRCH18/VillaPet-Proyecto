
--Funciones Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Contar la cantidad de ventas realizadas por una sucursal
create or replace FUNCTION VentasporSucursal(IDSucursal IN NUMBER) 
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
END VentasporSucursal;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el total de ventas realizadas en un día específico
CREATE OR REPLACE FUNCTION VentasporDia(fecha IN DATE) 
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
END VentasporDia;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular la cantidad total de productos en stock
CREATE OR REPLACE FUNCTION ProductosenStock(sucursal NUMBER)
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
END ProductosenStock;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar productos agotados
CREATE OR REPLACE FUNCTION ProductosAgotados 
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
END ProductosAgotados;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Contar la cantidad de empleados por sucursal
CREATE OR REPLACE FUNCTION EmpleadosporSucursal(IDSucursal IN NUMBER) 
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
END EmpleadosporSucursal;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular pagos realizados a un proovedor
CREATE OR REPLACE FUNCTION PagosaProveedor(IDProveedor NUMBER) 
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
END PagosaProveedor;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el total de pagos en un periodo de tiempo
CREATE OR REPLACE FUNCTION PagosporPeriodo(FechaInicio DATE, FechaFin DATE) 
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
END PagosporPeriodo;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Pruebas

-- Contar la cantidad de ventas realizadas por una sucursal
SELECT VentasporSucursal(01) AS Ventas_Sucursal_01 FROM DUAL;

-- Calcular el total de ventas realizadas en un d�a espec�fico
SELECT VentasporDia(TO_DATE('2024-04-07', 'YYYY-MM-DD')) AS Total_Ventas_Hoy FROM DUAL;

-- Calcular la cantidad total de productos en stock
SELECT ProductosenStock(1) AS Total_Productos_Stock FROM DUAL;

-- Listar productos agotados
SELECT ProductosAgotados() AS Productos_Agotados FROM DUAL;

-- Contar la cantidad de empleados por sucursal
SELECT EmpleadosporSucursal(01) AS Empleados_Sucursal_01 FROM DUAL;

-- Calcular pagos realizados a un proveedor
SELECT PagosaProveedor(03) AS Pagos_a_Proveedor_01 FROM DUAL;

-- Calcular el total de pagos en un periodo de tiempo
SELECT PagosporPeriodo(TO_DATE('2024-04-01', 'YYYY-MM-DD'), TO_DATE('2024-04-08', 'YYYY-MM-DD')) AS Total_Pagos_Periodo FROM DUAL;

