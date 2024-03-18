
--Funciones Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Contar la cantidad de ventas realizadas por una sucursal
CREATE OR REPLACE FUNCTION VentasporSucursal(IDSucursal IN NUMBER) 
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

--Calcular total de ventas por categoría
CREATE OR REPLACE FUNCTION VentasporCategoria(IDCategoria IN NUMBER) 
RETURN NUMBER 
IS
    total NUMBER;
BEGIN
    SELECT SUM(v.Monto_Venta)
    INTO total
    FROM Tab_Venta v
    JOIN Tab_Producto p ON v.ID_Producto = p.ID_Producto
    WHERE p.ID_Categoria = IDCategoria;
    
    RETURN total;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN NULL;
END VentasporCategoria;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular la cantidad total de productos en stock
CREATE OR REPLACE FUNCTION ProductosenStock 
RETURN NUMBER 
IS
    total_stock NUMBER;
BEGIN
    SELECT SUM(Stock)
    INTO v_total_stock
    FROM Tab_Producto;
    
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
    
    FOR producto IN (SELECT Descripcion FROM Tab_Producto WHERE Stock = 0) 
    LOOP
        lista_agotados := lista_agotados || producto.Descripcion || ', ';
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
    SELECT SUM(Monto_Venta) INTO total
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


