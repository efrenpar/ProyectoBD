use zenficar;

create table Cuenta(
idcuenta int(5) auto_increment primary key,
usuario varchar(20) not null,
pass varchar(20) not null,
pertenece char(10),
foreign key (pertenece) references empleado(cedula)
);

insert into Cuenta values
(0,"Admin","administrador",null),
(0,"Contador","contador",'0978523611'),
(0,"IRIS1995","cesarigaby",'0910086370'),
(0,"EDSONVV01","valeandvane",'0915423190'),
(0,"STEFITAVB","vargas_vb1989",'0945987613'),
(0,"MATCHKAT","bestcosplayer",'0816849164');

