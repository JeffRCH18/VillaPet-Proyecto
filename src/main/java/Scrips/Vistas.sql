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

--Vista para lista las ventas
CREATE OR REPLACE VIEW PAGO_VIEW AS
SELECT COD_PAGO, ID_PROVEEDOR, MONTO, FECHA
FROM TAB_PAGO;

--------------------------------------------------------------------------------