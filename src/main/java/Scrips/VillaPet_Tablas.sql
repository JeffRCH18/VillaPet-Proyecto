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
    Contraseña VARCHAR2(100) NOT NULL,
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

CREATE TABLE Tab_Cliente (
    ID_Cliente NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    Nombre_Cliente VARCHAR2(100),
    Apellido VARCHAR2(100),
    Direccion_Cliente VARCHAR2(200),
    Telefono_Cliente VARCHAR2(20),
    Correo_Cliente VARCHAR2(100)
);

CREATE TABLE Tab_Producto (
    ID_Producto NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ID_Categoria NUMBER,
    ID_Proveedor NUMBER,
    Descripcion VARCHAR2(200) NOT NULL,
    Precio NUMBER NOT NULL,
    Stock NUMBER NOT NULL,
    CONSTRAINT fk_categoria_producto FOREIGN KEY (ID_Categoria) REFERENCES Tab_Categoria(ID_Categoria),
    CONSTRAINT fk_proveedor_producto FOREIGN KEY (ID_Proveedor) REFERENCES Tab_Proveedor(ID_Proveedor)
);


-- Inserción en Tab_Rol
INSERT INTO Tab_Rol (ID_Rol, Descripcion_Rol)
VALUES (01, 'Administrador');

-- Inserción en Tab_Sucursal
INSERT INTO Tab_Sucursal (ID_Sucursal, Correo_sucursal, Telefono_Sucursal, Nombre_Sucursal, Direccion_Sucursal)
VALUES (01, 'villapetsabana@gmail.com', '89326213', 'Sucursal Principal', 'Sabana este');

-- Inserción en Tab_Proveedor
INSERT INTO Tab_Proveedor (ID_Proveedor, Nombre_Proveedor, Telefono_Proveedor, Direccion_Proveedor)
VALUES (01, 'Pedigree', '78765432', 'San Jose');

-- Inserción en Tab_Puesto
INSERT INTO Tab_Puesto (ID_Puesto, Descripcion_Puesto)
VALUES (01, 'Peluquero');

-- Inserción en Tab_Categoria
INSERT INTO Tab_Categoria (ID_Categoria, Descripcion_Categoria)
VALUES (01, 'Peluqueria');

-- Inserción en Tab_Empleado
INSERT INTO Tab_Empleado (ID_Empleado, ID_Puesto, ID_Rol, Nombre_Empleado, Apellido, Correo, Contraseña, Salario,ID_Sucursal)
VALUES (01, 01,01, 'Bruno','Diaz','diaz01@yahoo.com','12345', 300000,01);

-- Inserción en Tab_Servicios
INSERT INTO Tab_Servicio (ID_Servicio, ID_Empleado, Nombre_Servicios, Descripcion_Servicio)
VALUES (01, 01, 'Peluqueria canica', 'Corte de pelo');

-- Inserción en Tab_Cliente
INSERT INTO Tab_Cliente (ID_Cliente, Nombre_Cliente,Apellido, Direccion_Cliente, Telefono_Cliente, Correo_Cliente)
VALUES (01, 'Jeff','Ramos', 'Santa ana', '67253534', 'anad92@gmail.com');

-- Inserción en Tab_Producto
INSERT INTO Tab_Producto (ID_Producto, ID_Categoria, ID_Proveedor, Descripcion, Precio, Stock)
VALUES (01, 01, 01, 'Pedigree adulto', 4000, 10);

-- Inserción en Tab_Venta
INSERT INTO Tab_Venta (Num_Factura, ID_Cliente, ID_Sucursal, Monto_Venta, Fecha)
VALUES (01, 01, 01, 4000, SYSDATE);

-- Inserción en Tab_Pago
INSERT INTO Tab_Pago (Cod_Pago, ID_Proveedor, Monto, Fecha)
VALUES (01, 01, 40000, SYSDATE);



