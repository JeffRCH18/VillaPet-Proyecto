
--Tablas Villa Pet
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE Tab_Puesto (
    ID_Puesto NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Descripcion_Puesto VARCHAR2(100) NOT NULL
);

CREATE TABLE Tab_Rol (
    ID_Rol NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Descripcion_Rol VARCHAR2(100) NOT NULL
);

CREATE TABLE Tab_Sucursal (
    ID_Sucursal NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Correo_sucursal VARCHAR2(100) NOT NULL,
    Telefono_Sucursal VARCHAR2(20) NOT NULL,
    Nombre_Sucursal VARCHAR2(100) NOT NULL,
    Direccion_Sucursal VARCHAR2(200) NOT NULL
);


CREATE TABLE Tab_Empleado (
    ID_Empleado NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Puesto NUMBER,
    ID_Rol NUMBER,
    ID_Sucursal NUMBER,
    Nombre_Empleado VARCHAR2(100) NOT NULL,
    Apellido VARCHAR2(100) NOT NULL,
    Correo VARCHAR2(100) NOT NULL,
    Contrasena VARCHAR2(100) NOT NULL,
    Salario NUMBER NOT NULL,
    CONSTRAINT fk_puesto_emp FOREIGN KEY (ID_Puesto) REFERENCES Tab_Puesto(ID_Puesto),
    CONSTRAINT fk_rol_emp FOREIGN KEY (ID_Rol) REFERENCES Tab_Rol(ID_Rol),
    CONSTRAINT fk_sucursal_emp FOREIGN KEY (ID_Sucursal) REFERENCES Tab_Sucursal(ID_Sucursal) 
);

CREATE TABLE Tab_Proveedor (
    ID_Proveedor NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nombre_Proveedor VARCHAR2(100) NOT NULL,
    Telefono_Proveedor VARCHAR2(20) NOT NULL,
    Direccion_Proveedor VARCHAR2(200) NOT NULL
);

CREATE TABLE Tab_Cliente (
    ID_Cliente NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nombre_Cliente VARCHAR2(100),
    Apellido VARCHAR2(100),
    Direccion_Cliente VARCHAR2(200),
    Telefono_Cliente VARCHAR2(20),
    Correo_Cliente VARCHAR2(100)
);

CREATE TABLE Tab_Venta (
    Num_Factura NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Cliente NUMBER,
    ID_Sucursal NUMBER,
    Monto_Venta NUMBER NOT NULL,
    Fecha DATE NOT NULL,
    CONSTRAINT fk_cliente_venta FOREIGN KEY (ID_Cliente) REFERENCES Tab_Cliente(ID_Cliente),
    CONSTRAINT fk_sucursal_venta FOREIGN KEY (ID_Sucursal) REFERENCES Tab_Sucursal(ID_Sucursal)
);

CREATE TABLE Tab_Categoria (
    ID_Categoria NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Descripcion_Categoria VARCHAR2(100) NOT NULL
);

CREATE TABLE Tab_Servicio (
    ID_Servicio NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Empleado NUMBER,
    Nombre_Servicios VARCHAR2(100) NOT NULL,
    Descripcion_Servicio VARCHAR2(200) NOT NULL,
    CONSTRAINT fk_empleado_servicio FOREIGN KEY (ID_Empleado) REFERENCES Tab_Empleado(ID_Empleado)
);

CREATE TABLE Tab_Pago (
    Cod_Pago NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Proveedor NUMBER,
    Monto NUMBER  NOT NULL,
    Fecha DATE  NOT NULL,
    CONSTRAINT fk_proveedor_pago FOREIGN KEY (ID_Proveedor) REFERENCES Tab_Proveedor(ID_Proveedor)
);

CREATE TABLE Tab_Producto (
    ID_Producto NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Categoria NUMBER,
    ID_Proveedor NUMBER,
    ID_Sucursal NUMBER,
    Descripcion VARCHAR2(200) NOT NULL,
    Precio NUMBER NOT NULL,
    Stock NUMBER NOT NULL,
    CONSTRAINT fk_categoria_producto FOREIGN KEY (ID_Categoria) REFERENCES Tab_Categoria(ID_Categoria),
    CONSTRAINT fk_proveedor_producto FOREIGN KEY (ID_Proveedor) REFERENCES Tab_Proveedor(ID_Proveedor)
);

CREATE TABLE Tab_Detalle (
    ID_Detalle NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Tipo_Elemento VARCHAR(20),  
    ID_Elemento NUMBER,         
    Cantidad NUMBER,
    Precio NUMBER,
    ID_Venta NUMBER,
    CONSTRAINT fk_detalle_venta FOREIGN KEY (ID_Venta) REFERENCES Tab_Venta(Num_Factura)
);

-- Inserciones en Tab_Rol
INSERT INTO Tab_Rol (ID_Rol, Descripcion_Rol) VALUES (01, 'ADMIND');
INSERT INTO Tab_Rol (ID_Rol, Descripcion_Rol) VALUES (02, 'USER');


-- Inserciones en Tab_Sucursal
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (01, 'villapetsabana@gmail.com', '89326213', 'Sucursal Principal', 'Sabana este');
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (02, 'villapetcurridabat@gmail.com', '22554488', 'Sucursal Curridabat', 'Curridabat, San Jos�');
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (03, 'villapetescazu@gmail.com', '26435566', 'Sucursal Escaz�', 'Escaz�, San Jose');
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (04, 'villapetoxigeno@gmail.com', '27778899', 'Sucursal Oxigeno', 'Oxigeno, Heredia');
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (05, 'villapetcartago@gmail.com', '21013322', 'Sucursal Cartago', 'Cartago Centro');
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal) VALUES (06, 'villapetsanpedro@gmail.com', '22001122', 'Sucursal San Pedro', 'San Pedro, San Jose');

-- Inserciones en Tab_Proveedor
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (01, 'Pedigree', '25254080', 'San Jose');
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (02, 'Royal Canin', '22223344', 'San Pedro, San Jos�');
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (03, 'Hills Pet Nutrition', '24445566', 'Curridabat, San Jos�');
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (04, 'Whiskas', '27778899', 'Heredia, Heredia');
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (05, 'Purina', '25556677', 'San Rafael, Alajuela');
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor) VALUES (06, 'Friskies', '26667788', 'Curridabat, San Jos�');

-- Inserciones en Tab_Puesto
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (01, 'Peluquero');
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (02, 'Cajero');
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (03, 'Vendedor');
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (04, 'Administrador');
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (05, 'Recepcionista');
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto) VALUES (06, 'Encargado de Almac�n');

-- Inserciones en Tab_Categoria
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (01, 'Peluqueria');
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (02, 'Alimento para perros');
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (03, 'Alimento para gatos');
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (04, 'Accesorios para mascotas');
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (05, 'Juguetes para mascotas');
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria) VALUES (06, 'Productos de higiene');

-- Inserciones en Tab_Empleado
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (01, 01,02, 01, 'Bruno','Diaz','diaz01@yahoo.com','12345', 300000);
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (02, 03, 01, 02, 'Mar�a', 'Mart�nez', 'mmartinez@example.com', '123', 320000);
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (03, 03, 01, 01, 'Juan', 'Gonz�lez', 'jgonzalez@example.com', '123', 320000);
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (04, 04, 01, 04, 'Ana', 'S�nchez', 'asanchez@example.com', '123', 350000);
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (05, 05, 02, 05, 'Carlos', 'Vargas', 'cvargas@example.com', '123', 380000);
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, ID_Sucursal, Nombre_Empleado, Apellido, Correo, Contrasena, Salario) VALUES (06, 06, 01, 05, 'Sof�a', 'L�pez', 'slopez@example.com', '123', 400000);

-- Inserciones en Tab_Cliente
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (01, 'Jeff','Ramos', 'Santa ana', '67253534', 'anad92@gmail.com');
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (02, 'Laura', 'Fern�ndez', 'San Jos�', '87123456', 'lfernandez@example.com');
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (03, 'Diego', 'G�mez', 'Heredia', '81234567', 'dgomez@example.com');
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (04, 'Valentina', 'Chac�n', 'Alajuela', '72345678', 'vchacon@example.com');
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (05, 'Mateo', 'Castro', 'Cartago', '63456789', 'mcastro@example.com');
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente, Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente) VALUES (06, 'Isabella', 'Morales', 'Liberia', '54567890', 'imorales@example.com');

-- Inserciones en Tab_Producto
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (01, 01, 01, 01, 'Pedigree adulto', 4000, 10);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (02, 02, 02, 01, 'Royal Canin Puppy', 6000, 15);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (03, 02, 03, 04, 'Hills Science Diet Adulto', 8000, 20);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (04, 03, 04, 02, 'Whiskas Carne', 3500, 30);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (05, 03, 05, 05, 'Purina Cat Chow', 4000, 25);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (06, 04, 06, 02, 'Collar para perros', 2500, 50);
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, ID_Sucursal, Descripcion, Precio, Stock) VALUES (07, 02, 03, 01, 'Collar para perros', 4500, 0);

-- Inserciones en Tab_Venta
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (01, 01, 01, 4000, SYSDATE);
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (02, 02, 02, 8000, SYSDATE);
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (03, 03, 03, 12000, SYSDATE);
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (04, 04, 04, 5000, SYSDATE);
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (05, 05, 05, 6000, SYSDATE);
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha) VALUES (06, 06, 06, 10000, SYSDATE);

-- Inserciones en Tab_Pago
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha) VALUES (01, 01, 40000, SYSDATE);
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha) VALUES (02, 02, 50000, SYSDATE);
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha) VALUES (03, 03, 60000, SYSDATE);
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha) VALUES (04, 04, 70000, SYSDATE);
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha) VALUES (05, 05, 40000, SYSDATE);

-- Inserciones en Tab_Servicio
INSERT INTO Tab_Servicio (ID_Empleado, Nombre_Servicios, Descripcion_Servicio) VALUES (01, 'Peluqueria', 'Bano y corte para mascotas');
