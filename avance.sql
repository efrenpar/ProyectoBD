use zenficar;

insert into Empleado(cedula,nombre,direccion,sueldo,cargo)
values
('0910086370','Irina Miroslava','Duran - El Recreo',850.0,'Gerente'),
('0915423190','Edison Leon','Sauces 9 - mz15 v12',850.0,'Presidente'),
('0984684093','jean Piere Rodriguez','Hector Cobos Hubilla',450.0,'Bodega'),
('0945987613','Stefania Vargas','Mucho Lote 1',600.0,'Secretaria'),
('0816849164','Michelle Avila','Cdla Huancavilca',600.0,'Secretaria'),
('0948035018','Carlos Pacheco','Cdla Montebello Mz 570 V 25',450.0,'Bodega'),
('0978523611','Andres Rivera','Las Acacias b12 v15',650.0,'Contador'),
('0910890331','Fernando Espinoza','Las Orquideas',450.0,'Repartidor');


insert into Cliente(ruc,razonsocial,direccion,contacto,ciudad) 
values
('0911563541001','IVICAR','Ayacucho - Lizardo Garcia','Juan Veliz','Guayaquil'),
('4181989316001','AUTO RADIADOR','Los Rios y Esmeraldas','Jannet Ochoa','Guayaquil'),
('0498032162001','GAVIKCAR','Duran - Maldonado 6518 2do piso','Gabriela Espinoza','Duran'),
('9870681602001','EL COLORADO','Los Rios y 10 de Agosto','Leonel Castro','Guayaquil'),
('3549721511001','RJ DECORACIONES','Av Machala y Padre Solano','Fabian Alarcon','Guayaquil'),
('0865468926001','CAR AUDIO','Puntilla - Plaza Madeira','Edgar Loor','Daule'),
('0780118863001','AUTO DECORATIVO','Pedro Pablo Gomez y Tungurahua','Jaime Espinoza','Guayaquil'),
('0522318844001','CAR CUENCA','Calle Larga y Escobedo','Jenny Valverde','Cuenca'),
('0781941651001','RACING TUNING CAR','Av Las Aguas frente a Maruri','Lenny Loor','Guayaquil'),
('0332161354001','MONKEY WRENCH','Urdesa Central 2560 y AV Amazonas','Michael Omar','Guayaquil'),
('8948125313001','WORLD EXPO AUTO','Av de las Americas entre España y Lima','Ivan Dominguez','Quito'),
('0861831086001','FANTASY CAR','Panecillo y franco segura','Leopoldo Lopez','Quito'),
('0831183820001','CAR SONGA','quitumbe 255 y santo domingo','Maryorie Benavides ','Quito'),
('4513512399001','CAR VITALITY','Quitumbre 317 y Machalilla','Vicoria Tomsich','Quito'),
('0156846548001','OMEGA CAR','España y Pancho Jacome','Carmen Vaca','Cuenca'),
('1356465551001','AUTO FEST','Esferas del Mañana y Dragon','Alajandra Fernandez','Cuenca'),
('0871063123001','IMPORT CAR SEC','Calle Q15-3 frente a Pepsi','Silfide Gutierrez','Milagro'),
('1323255186001','COMERCIAL OSWALDO','Calle Q15-7 junto a Primax','Nefertari Icaza','Milagro'),
('7555818139001','CARTING GTR','Calle Q15-9 esquinero','Joseline Alarcon','Milagro');


insert into Vendedor(idVendedor,nombre_v,direccion,ciudad,comision)
values 
('VENDE-0001','FAVIAN LUZURIAGA','AV 5TA Y 7MA','Milagro',0.15),
('VENDE-0002','CARLOS MALDONADO','Calle siempre viva y Alamos','Quito',0.13),
('VENDE-0003','JOSE VARGAS PAZO','AV 5TA Y 7MA','Cuenca',0.13),
('VENDE-0004','Fernando Moran','Duran - cdla Arbolito M 2b v 15','Guayaquil',0.10);

insert into  Proveedor(ruc,n_proveedor,direccion,cuenta_no) values
('0902338098001','IMPALSA','QUITO - cdla la Mana','042356889'),
('0980168606001','BLASTI SA','Prto Maritimo','08963281'),
('0498461630001','WUKON SA','China distrito Shinwong','4236658900'),
('0988970983001','SHINEE','Korea - Seul distrito Gamnam','9980156088');

insert into Telefono(no_fono,empleado)
values 
(0980807426,'0910086370'),
(0984631388,'0915423190'),
(0986215371,'0984684093'),
(0981297213,'0945987613'),
(0912345879,'0816849164'),
(0945613798,'0948035018'),
(0932158497,'0978523611'),
(0986402197,'0910890331');


insert into Telefono(no_fono,cliente)
values 
(0984084963,'0911563541001'),
(0986317913,'4181989316001'),
(0975019038,'0498032162001'),
(0981781354,'9870681602001'),
(0975216193,'3549721511001'),
(0954191787,'0865468926001'),
(0633176744,'0780118863001'),
(0816318010,'0522318844001'),
(0898168733,'0781941651001'),
(0988138859,'0332161354001'),
(0986219842,'8948125313001'),
(0497903181,'0861831086001'),
(0425680318,'0831183820001'),
(0982108461,'4513512399001'),
(0985160876,'0156846548001'),
(0943384096,'1356465551001'),
(0998874080,'0871063123001'),
(0984974094,'1323255186001'),
(0909486303,'7555818139001');

insert into Telefono(no_fono,vendedor)
values 
(0483201830,'VENDE-0001'),
(0988713109,'VENDE-0002'),
(0485409301,'VENDE-0003'),
(0998131809,'VENDE-0004'),
(0895180964,'VENDE-0001'),
(0468919084,'VENDE-0002'),
(0982007105,'VENDE-0003'),
(0428637012,'VENDE-0004');


insert into Telefono(no_fono,proveedor)
values 
(0653389216,'0902338098001'),
(0283568193,'0980168606001'),
(0434526048,'0498461630001'),
(0428637150,'0988970983001'),
(0866709136,'0902338098001'),
(0998191369,'0980168606001'),
(0998487106,'0498461630001'),
(0915384900,'0988970983001');


insert into Categoria(cod_categ,nombretipo)
values
('GUARDLSSTR','Guardalluvias'),
('SAASCI0150','Sobre Asientos'),
('ALERONGTR5','Alerones'),
('ESTRWONGLS','Estribos'),
('PLUMGTMAXC','Plumas'),
('GLASSINNER','Espejos Interior'),
('GLASSEXTER','Espejo Exterior'),
('ALOGEFAROS','Focos Alogenos'),
('LLANTASMIC','LLantas'),
('AROSRTWXPL','Aros'),
('CUBREAROS1','Tapa Cubos'),
('BLACKCOVER','Cobertores'),
('LUZPISONEO','Neon'),
('PEGATINAST','Stickers'),
('AMBIENTTP1','Ambientales'),
('PINTAUTO12','Pintura'),
('FOCOSFRONT','Faros Delanteros'),
('FOCOSPOSTR','Guias Posteriores'),
('MEDICALCEN','Kits Medicos'),
('EXTPULGREV','Extintores'),
('PITOSHIGHC','Vocinas'),
('PERNSEG453','Pernos de Seguridad'),
('TORQSEG456','Tuercas de Seguridad'),
('AUDIORAD24','Radios'),
('AUDIOSOUND','Parlantes');


insert into Bodega(cod_bod,nombrebod,direccion,ciudad)
values
('BODPRIN001','Bodega Principal','Cdla Hector Cobos hubilla','Duran'),
('BODALTER02','Bodega Almacen','Ayacucho y Leonidas Plaza local','Guayaquil'),
('BODALTER03','Bodega Cuenca','Redondel Chola Cuencana','Cuenca'),
('BODALTER04','Bodega Quito','Parque Comercial el Panecillo','Quito');


insert into Producto(cod_p,nombre,descripcion,precio_compra,precio_venta,cantidad,venta_x,categoria,bodegaNo,proveedor)
values 
('forzals099','zusuki forza 1 fino','Guardalluvia suzuki forza 1 delgado año 1999',12.5,19.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('sentrals94','Nissan Sentra fino','Guardalluvia Nissan Sentra  delgado año 94',12.5,19.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('cheluvls15','chevrolet luv fino','Guardalluvia Chevrolet Luv D-max fino 2015',12.5,19.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('forzamd099','zusuki forza 1 med','Guardalluvia suzuki forza 1 mediano año 1999',15.5,23.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('sentramd94','Nissan Sentra med','Guardalluvia Nissan Sentra  mediano año 94',15.5,23.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('cheluvmd15','chevrolet luv med','Guardalluvia Chevrolet Luv D-max mediano 2015',15.5,23.5,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('forzabo099','zusuki forza 1 grand','Guardalluvia suzuki forza 1 Ancho año 1999',17.5,25.0,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('sentrabo94','Nissan Sentra grand','Guardalluvia Nissan Sentra  Ancho año 94',17.5,25.0,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001'),
('cheluvbo15','chevrolet luv grand','Guardalluvia Chevrolet Luv D-max Ancho 2015',17.5,25.0,20,'Par','GUARDLSSTR','BODPRIN001','0902338098001');




