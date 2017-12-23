create database zenficar;

use zenficar;

create table Empleado(
cedula char(10) primary key,
nombre varchar(20),
direccion varchar(100),
sueldo double,
cargo varchar(10)
);

create table Cliente(
ruc char(13) primary key,
razonsocial varchar(20),
direccion varchar(100),
contacto varchar(20),
ciudad varchar(10)
);

create table Vendedor(
idVendedor char(10) primary key,
nombre_v varchar(20),
direccion varchar(100),
ciudad varchar(10),
comision double
);

create table Proveedor(
ruc char(13) primary key,
n_proveedor varchar(20),
direccion varchar(100),
cuenta_no varchar(10)
);

create table Telefono(
fono_id int primary key auto_increment,
no_fono int(10),
empleado char(10) null,
cliente char(13) null,
vendedor char(10) null,
proveedor char(13) null,
foreign key (empleado) references Empleado(cedula),
foreign key (cliente) references Cliente(ruc),
foreign key (vendedor) references Vendedor(idVendedor),
foreign key (proveedor) references Proveedor(ruc)
);

create table Categoria(
cod_categ char(10) primary key,
nombretipo varchar(20)
);

create table Bodega(
cod_bod char(10) primary key,
nombrebod varchar(20),
direccion varchar(100),
ciudad varchar(20)
);

create table Pedido(
pedido_no char(10) primary key,
valor_total double,
saldo double,
detalles varchar(200),
proveedor char(13),
bodega char(10),
foreign key (proveedor) references Proveedor(ruc),
foreign key (bodega) references Bodega(cod_bod)
);

create table cuentas_x_pagar(
codigo_cp int primary key auto_increment,
valor_total double,
saldo double,
fecha_pago date,
cheque_no varchar(10),
banco varchar(15),
pedido_no char(10),
foreign key (pedido_no) references Pedido(pedido_no)
);

create table Producto(
cod_p char(10) primary key,
nombre varchar(20),
descripcion varchar(50),
precio_compra double,
precio_venta double,
cantidad int,
venta_x enum('Unidad','Par','Docena','Caja','Empaque'),
categoria char(10),
bodegaNo char(10),
proveedor char(13),
foreign key (categoria) references Categoria(cod_categ),
foreign key (bodegaNo) references Bodega(cod_bod),
foreign key (proveedor) references Proveedor(ruc)
);

create table Factura(
fact_no char(10) primary key,
cliente char(13),
vendedor char(10),
ciudad varchar(10),
fecha_emison date,
fecha_entrega date,
subtotal double,
descuento double,
iva double,
total double,
foreign key (cliente) references Cliente(ruc),
foreign key (vendedor) references Vendedor(idVendedor)
);

create table Detalle_factura(
detalle_id int primary key auto_increment,
producto char(10),
descripcion varchar(50),
precioUnidad double,
cantidad int,
descuento double,
total double,
fact_no char(10),
foreign key (producto) references Producto(cod_p),
foreign key (fact_no) references Factura(fact_no)
);

create table Cuentas_x_cobrar(
codigo_cc int primary key auto_increment,
valor double,
saldo double,
cliente_no char(13),
fact_no char(10),
foreign key (cliente_no) references Cliente(ruc),
foreign key (fact_no) references Factura(fact_no)
);

create table Abono(
abono_id int primary key auto_increment,
valor double,
cuenta_id integer,
fecha_abono date,
foreign key (cuenta_id) references Cuentas_x_cobrar(codigo_cc)
);


/*
drop database zenficar;
*/














