
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

--Calcular la cantidad total de productos en stock
CREATE OR REPLACE FUNCTION ProductosEnStock_FN(sucursal NUMBER)
RETURN VARCHAR2 
IS
    detalles_stock VARCHAR2(4000);
    nombre_producto Tab_Producto.Descripcion%TYPE;
    cantidad_stock Tab_Producto.Stock%TYPE;
BEGIN
    detalles_stock := 'Detalles de productos en stock para la sucursal ' || sucursal || ':' || CHR(10);
    
    FOR producto IN (SELECT Descripcion, Stock FROM Tab_Producto WHERE ID_Sucursal = sucursal) 
    LOOP
        nombre_producto := producto.Descripcion;
        cantidad_stock := producto.Stock;
        detalles_stock := detalles_stock || ' Producto: ' || nombre_producto || ' --> Stock: ' || cantidad_stock || CHR(10);
    END LOOP;

    RETURN detalles_stock;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron detalles de productos en stock para la sucursal ' || sucursal;
END ProductosEnStock_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar productos agotados
CREATE OR REPLACE FUNCTION ListarProductosAgotados_FN
RETURN VARCHAR2 
IS
    lista_productos_agotados VARCHAR2(4000); 
    nombre_producto Tab_Producto.Descripcion%TYPE;
    sucursal_producto Tab_Sucursal.Nombre_Sucursal%TYPE;
    CURSOR c_productos_agotados IS
        SELECT p.Descripcion, s.Nombre_Sucursal
        FROM Tab_Producto p
        INNER JOIN Tab_Sucursal s ON p.ID_Sucursal = s.ID_Sucursal
        WHERE p.Stock = 0
        ORDER BY p.ID_Sucursal;
BEGIN
    lista_productos_agotados := '';
    FOR producto IN c_productos_agotados 
    LOOP
        nombre_producto := producto.Descripcion;
        sucursal_producto := producto.Nombre_Sucursal;
        lista_productos_agotados := lista_productos_agotados || 'Sucursal: ' || sucursal_producto || ' --> Producto: ' || nombre_producto || CHR(10);
    END LOOP;
    RETURN lista_productos_agotados;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No hay productos agotados';
END ListarProductosAgotados_FN;
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

--Calcular el total de ventas por empleado en cada sucursal
CREATE OR REPLACE FUNCTION ListarVentasPorClienteSucursal_FN
RETURN VARCHAR2 
IS
    lista_ventas VARCHAR2(4000); 
    nombre_cliente Tab_Cliente.Nombre_Cliente%TYPE;
    apellido_cliente Tab_Cliente.Apellido%TYPE;
    sucursal_venta Tab_Sucursal.Nombre_Sucursal%TYPE;
    total_venta NUMBER;
    CURSOR c_ventas IS
        SELECT c.Nombre_Cliente, c.Apellido, s.Nombre_Sucursal, SUM(v.Monto_Venta) AS Total_Venta
        FROM Tab_Venta v
        INNER JOIN Tab_Cliente c ON v.ID_Cliente = c.ID_Cliente
        INNER JOIN Tab_Sucursal s ON v.ID_Sucursal = s.ID_Sucursal
        GROUP BY c.Nombre_Cliente, c.Apellido, s.Nombre_Sucursal
        ORDER BY s.Nombre_Sucursal, Total_Venta DESC;
BEGIN
    lista_ventas := '';
    FOR venta IN c_ventas 
    LOOP
        nombre_cliente := venta.Nombre_Cliente;
        apellido_cliente := venta.Apellido;
        sucursal_venta := venta.Nombre_Sucursal;
        total_venta := venta.Total_Venta;
        lista_ventas := lista_ventas || 'Cliente: ' || nombre_cliente || ' ' || apellido_cliente || CHR(10) ||
                                         'Sucursal: ' || sucursal_venta || CHR(10) ||
                                         'Total de Ventas: ' || total_venta || CHR(10) || '-----------------------------------' || CHR(10);
    END LOOP;
    RETURN lista_ventas;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron ventas';
END ListarVentasPorClienteSucursal_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar proveedores con sus productos suministrados
CREATE OR REPLACE FUNCTION ListarProveedoresConProductos_FN
RETURN VARCHAR2 
IS
    lista_proveedores VARCHAR2(4000); 
    nombre_proveedor Tab_Proveedor.Nombre_Proveedor%TYPE;
    producto_suministrado Tab_Producto.Descripcion%TYPE;
    CURSOR c_proveedores IS
        SELECT p.Nombre_Proveedor, LISTAGG(pr.Descripcion, ', ') WITHIN GROUP (ORDER BY pr.Descripcion) AS Productos
        FROM Tab_Proveedor p
        INNER JOIN Tab_Producto pr ON p.ID_Proveedor = pr.ID_Proveedor
        GROUP BY p.Nombre_Proveedor
        ORDER BY p.Nombre_Proveedor;
BEGIN
    lista_proveedores := '';
    FOR proveedor IN c_proveedores 
    LOOP
        nombre_proveedor := proveedor.Nombre_Proveedor;
        producto_suministrado := proveedor.Productos;
        lista_proveedores := lista_proveedores || nombre_proveedor || ': ' || producto_suministrado || CHR(10);
    END LOOP;
    RETURN lista_proveedores;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron proveedores';
END ListarProveedoresConProductos_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar clientes con sus compras realizadas
CREATE OR REPLACE FUNCTION ListarClientesConCompras_FN
RETURN VARCHAR2 
IS
    lista_clientes VARCHAR2(4000); 
    lista_vacia VARCHAR2(4000); 
    nombre_cliente Tab_Cliente.Nombre_Cliente%TYPE;
    apellido_cliente Tab_Cliente.Apellido%TYPE;
    producto_comprado Tab_Producto.Descripcion%TYPE;
    CURSOR c_clientes IS
        SELECT c.Nombre_Cliente, c.Apellido, p.Descripcion
        FROM Tab_Cliente c
        INNER JOIN Tab_Venta v ON c.ID_Cliente = v.ID_Cliente
        INNER JOIN Tab_Producto p ON v.ID_Sucursal = p.ID_Sucursal
        WHERE TRUNC(v.Fecha) = TRUNC(SYSDATE)
        ORDER BY c.Nombre_Cliente; 
BEGIN
    lista_clientes := '';
    FOR cliente IN c_clientes 
    LOOP
        nombre_cliente := cliente.Nombre_Cliente;
        apellido_cliente := cliente.Apellido;
        producto_comprado := cliente.Descripcion;
        lista_clientes := lista_clientes || nombre_cliente || ' ' || apellido_cliente || ': Producto --> ' || producto_comprado || CHR(10);
    END LOOP;
    
    IF lista_clientes = '' THEN
        lista_vacia := 'No se encontraron clientes con compras el día de hoy';
        RETURN lista_vacia;
    ELSE
        RETURN lista_clientes;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        lista_vacia := 'No se encontraron clientes con compras el día de hoy';
        RETURN lista_vacia;
END ListarClientesConCompras_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar proveedores con el total de pagos realizados
CREATE OR REPLACE FUNCTION ListarProveedoresConTotalPagos_FN
RETURN VARCHAR2 
IS
    lista_proveedores VARCHAR2(4000); 
    nombre_proveedor Tab_Proveedor.Nombre_Proveedor%TYPE;
    total_pagos NUMBER;
    CURSOR c_proveedores IS
        SELECT p.Nombre_Proveedor, SUM(pa.Monto) AS TotalPagos
        FROM Tab_Proveedor p
        LEFT JOIN Tab_Pago pa ON p.ID_Proveedor = pa.ID_Proveedor
        GROUP BY p.Nombre_Proveedor
        HAVING SUM(pa.Monto) IS NOT NULL
        ORDER BY TotalPagos DESC; 
BEGIN
    lista_proveedores := '';
    FOR proveedor IN c_proveedores 
    LOOP
        nombre_proveedor := proveedor.Nombre_Proveedor;
        total_pagos := proveedor.TotalPagos;
        lista_proveedores := lista_proveedores || nombre_proveedor || ': Total de Pagos - ' || total_pagos || CHR(10);
        lista_proveedores := lista_proveedores || '---------------------------------------------------------' || CHR(10);
    END LOOP;
    RETURN lista_proveedores;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron proveedores';
END ListarProveedoresConTotalPagos_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar clientes con el total de compras realizadas
CREATE OR REPLACE FUNCTION ListarClientesConTotalCompras_FN
RETURN VARCHAR2 
IS
    lista_clientes VARCHAR2(4000); 
    nombre_cliente Tab_Cliente.Nombre_Cliente%TYPE;
    apellido_cliente Tab_Cliente.Apellido%TYPE;
    total_compras NUMBER;
    CURSOR c_clientes IS
        SELECT c.Nombre_Cliente, c.Apellido, SUM(v.Monto_Venta) AS TotalCompras
        FROM Tab_Cliente c
        LEFT JOIN Tab_Venta v ON c.ID_Cliente = v.ID_Cliente
        GROUP BY c.Nombre_Cliente, c.Apellido
        ORDER BY TotalCompras DESC;
BEGIN
    lista_clientes := '';
    FOR cliente IN c_clientes 
    LOOP
        nombre_cliente := cliente.Nombre_Cliente;
        apellido_cliente := cliente.Apellido;
        total_compras := cliente.TotalCompras;
        lista_clientes := lista_clientes || nombre_cliente || ' ' || apellido_cliente || ': Total de Compras - ' || total_compras || CHR(10);
    END LOOP;
    RETURN lista_clientes;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron clientes';
END ListarClientesConTotalCompras_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el total de empleados en cada sucursal
CREATE OR REPLACE FUNCTION TotalEmpleadosPorSucursal_FN
RETURN VARCHAR2 
IS
    lista_empleados_por_sucursal VARCHAR2(4000); 
BEGIN
    lista_empleados_por_sucursal := '';
    FOR sucursal IN (
        SELECT s.Nombre_Sucursal, COUNT(e.ID_Empleado) AS CantidadEmpleados
        FROM Tab_Sucursal s
        LEFT JOIN Tab_Empleado e ON s.ID_Sucursal = e.ID_Sucursal
        GROUP BY s.Nombre_Sucursal
        ORDER BY s.Nombre_Sucursal
    )
    LOOP
        lista_empleados_por_sucursal := lista_empleados_por_sucursal || 'Sucursal: ' || sucursal.Nombre_Sucursal || CHR(10) ||
                                         'Empleados: ' || sucursal.CantidadEmpleados || CHR(10) ||
                                         '-----------------------------------------------------' || CHR(10);
    END LOOP;
    
    IF lista_empleados_por_sucursal = '' THEN
        RETURN 'No se encontraron sucursales con empleados';
    ELSE
        lista_empleados_por_sucursal := 'Total de Empleados por Sucursal:' || CHR(10) || '-----------------------------------------------------' || CHR(10) || lista_empleados_por_sucursal;
        RETURN lista_empleados_por_sucursal;
    END IF;
END TotalEmpleadosPorSucursal_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar empleados con el total de ventas realizadas
CREATE OR REPLACE FUNCTION ListarEmpleadosPorRangoSalario_FN(salario_minimo NUMBER, salario_maximo NUMBER) 
RETURN VARCHAR2 
IS
    lista_empleados VARCHAR2(4000); 
    nombre_empleado Tab_Empleado.Nombre_Empleado%TYPE;
    salario_empleado Tab_Empleado.Salario%TYPE;
    CURSOR c_empleados IS
        SELECT Nombre_Empleado, Salario
        FROM Tab_Empleado
        WHERE Salario BETWEEN salario_minimo AND salario_maximo;
BEGIN
    lista_empleados := '';
    FOR empleado IN c_empleados 
    LOOP
        nombre_empleado := empleado.Nombre_Empleado;
        salario_empleado := empleado.Salario;
        lista_empleados := lista_empleados || 'Empleado: ' || nombre_empleado || ', Salario: ' || salario_empleado || CHR(10);
    END LOOP;
    RETURN lista_empleados;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron empleados dentro del rango de salario especificado';
END ListarEmpleadosPorRangoSalario_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Calcular el promedio de salario de todos los empleados
CREATE OR REPLACE FUNCTION PromedioSalarioPorPuesto_FN
RETURN VARCHAR2 
IS
    lista_promedios_salarios VARCHAR2(4000); 
    puesto_empleado Tab_Puesto.Descripcion_Puesto%TYPE;
    promedio_salario NUMBER;
    CURSOR c_puestos IS
        SELECT p.Descripcion_Puesto, AVG(e.Salario) AS PromedioSalario
        FROM Tab_Empleado e
        INNER JOIN Tab_Puesto p ON e.ID_Puesto = p.ID_Puesto
        GROUP BY p.Descripcion_Puesto
        ORDER BY PromedioSalario DESC; 
BEGIN
    lista_promedios_salarios := '';
    FOR puesto IN c_puestos 
    LOOP
        puesto_empleado := puesto.Descripcion_Puesto;
        promedio_salario := puesto.PromedioSalario;
        lista_promedios_salarios := lista_promedios_salarios || 'Puesto: ' || puesto_empleado || CHR(10) ||
                                     'Promedio de Salario: ' || promedio_salario || CHR(10) ||
                                     '------------------------------------------------' || CHR(10);
    END LOOP;
    IF lista_promedios_salarios = '' THEN
        RETURN 'No se encontraron datos de salarios por puesto';
    ELSE
        lista_promedios_salarios := 'Promedio de Salarios por Puesto:' || CHR(10) || '------------------------------------------------' || CHR(10) || lista_promedios_salarios;
        RETURN lista_promedios_salarios;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'No se encontraron datos de salarios por puesto';
END PromedioSalarioPorPuesto_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar los servicios y los empleados que pueden ofrecer ese servicio
CREATE OR REPLACE FUNCTION ListarEmpleadosParaServicio_FN(NombreServicio VARCHAR2) 
RETURN VARCHAR2 
IS
    lista_empleados_servicio VARCHAR2(4000); 
    nombre_servicio Tab_Servicio.Nombre_Servicios%TYPE;
    nombre_empleado Tab_Empleado.Nombre_Empleado%TYPE;
    CURSOR c_empleados_servicio IS
        SELECT e.Nombre_Empleado, s.Nombre_Servicios
        FROM Tab_Servicio s
        INNER JOIN Tab_Empleado e ON s.ID_Empleado = e.ID_Empleado
        WHERE s.Nombre_Servicios = NombreServicio;
BEGIN
    lista_empleados_servicio := '';
    OPEN c_empleados_servicio;
    FETCH c_empleados_servicio INTO nombre_empleado, nombre_servicio;
    IF c_empleados_servicio%FOUND THEN
        lista_empleados_servicio := 'Servicio: ' || nombre_servicio || CHR(10) || 'Empleados: ';
        LOOP
            lista_empleados_servicio := lista_empleados_servicio || CHR(10) || ' - ' || nombre_empleado;
            FETCH c_empleados_servicio INTO nombre_empleado, nombre_servicio;
            EXIT WHEN c_empleados_servicio%NOTFOUND;
        END LOOP;
    ELSE
        lista_empleados_servicio := 'No se encontraron empleados para el servicio especificado';
    END IF;
    CLOSE c_empleados_servicio;
    RETURN lista_empleados_servicio;
END ListarEmpleadosParaServicio_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Listar servicios disponibles en cada sucursal
CREATE OR REPLACE FUNCTION ListarServiciosPorTodasSucursales_FN
RETURN VARCHAR2 
IS
    lista_servicios_sucursal VARCHAR2(4000); 
    nombre_servicio Tab_Servicio.Nombre_Servicios%TYPE;
    nombre_sucursal Tab_Sucursal.Nombre_Sucursal%TYPE;
    CURSOR c_servicios_sucursal IS
        SELECT s.Nombre_Servicios, su.Nombre_Sucursal
        FROM Tab_Servicio s
        INNER JOIN Tab_Empleado e ON s.ID_Empleado = e.ID_Empleado
        INNER JOIN Tab_Sucursal su ON e.ID_Sucursal = su.ID_Sucursal
        ORDER BY e.ID_Sucursal;
BEGIN
    lista_servicios_sucursal := '';

    FOR servicio_sucursal IN c_servicios_sucursal 
    LOOP
        nombre_servicio := servicio_sucursal.Nombre_Servicios;
        nombre_sucursal := servicio_sucursal.Nombre_Sucursal;

        lista_servicios_sucursal := lista_servicios_sucursal || 'Servicio: ' || nombre_servicio || CHR(10) || 'Sucursal: ' || nombre_sucursal || CHR(10) || CHR(10);
    END LOOP;
    
    IF lista_servicios_sucursal = '' THEN
        RETURN 'No se encontraron servicios en las sucursales';
    ELSE
        RETURN lista_servicios_sucursal;
    END IF;
END ListarServiciosPorTodasSucursales_FN;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--Pruebas

-- Prueba de VentasporSucursal_FN
SELECT VentasporSucursal_FN(1) AS Ventas_Sucursal_1 FROM dual;

-- Prueba de DetallesProductosEnStock_FN
SELECT ProductosEnStock_FN(1) AS Productos_En_Stock_Sucursal_1 FROM dual;

-- Prueba de ListarProductosAgotados_FN
SELECT ListarProductosAgotados_FN() AS Productos_Agotados FROM dual;

-- Prueba de PagosaProveedor_FN
SELECT PagosaProveedor_FN(1) AS Pagos_Pedigree FROM dual;

-- Prueba de PagosporPeriodo_FN
SELECT PagosporPeriodo_FN(TO_DATE('2024-01-01', 'YYYY-MM-DD'), TO_DATE('2024-12-31', 'YYYY-MM-DD')) AS Total_Pagos_2024 FROM dual;

-- Prueba de ListarVentasPorEmpleadoSucursal_FN
SELECT ListarVentasPorClienteSucursal_FN() AS Ventas_Por_Cliente_Y_Sucursal FROM dual;

-- Prueba de ListarProveedoresConProductos_FN
SELECT ListarProveedoresConProductos_FN() AS Proveedores_Con_Productos FROM dual;

-- Prueba de ListarClientesConCompras_FN
SELECT ListarClientesConCompras_FN() AS Clientes_Con_Compras FROM dual;

-- Prueba de ListarProveedoresConTotalPagos_FN
SELECT ListarProveedoresConTotalPagos_FN() AS Proveedores_Con_Total_Pagos FROM dual;

-- Prueba de ListarClientesConTotalCompras_FN
SELECT ListarClientesConTotalCompras_FN() AS Clientes_Con_Total_Compras FROM dual;

-- Prueba de TotalEmpleadosPorSucursal_FN
SELECT TotalEmpleadosPorSucursal_FN() AS Total_Empleados_Por_Sucursal FROM dual;

-- Prueba de ListarEmpleadosPorRangoSalario_FN
SELECT ListarEmpleadosPorRangoSalario_FN(300000, 400000) AS Empleados_Con_Salario_En_Rango FROM dual;

-- Prueba de PromedioSalarioPorPuesto_FN
SELECT PromedioSalarioPorPuesto_FN() AS Promedio_Salario_Por_Puesto FROM dual;

-- Prueba de ListarEmpleadosParaServicio_FN
SELECT ListarEmpleadosParaServicio_FN('Peluquería') AS Empleados_Para_Servicio_Peluqueria FROM dual;

-- Prueba de ListarServiciosPorTodasSucursales_FN
SELECT ListarServiciosPorTodasSucursales_FN() AS Servicios_Por_Todas_Sucursales FROM dual;

