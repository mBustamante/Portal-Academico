INSERT INTO role( id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role( id, role) VALUES (2, 'ROLE_DOCENTE');
INSERT INTO role( id, role) VALUES (3, 'ROLE_ALUMNO');

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1,'Bustamante Mora','26/03/1991','Alejandra','bma1234',987253008,'alejandra.bustmante',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (2,'Morales Muñoz','6/10/1988','Elizabeth','mm5678',959784123,'elizabeth.morales',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (3,'Aguirre Concha','24/23/1990','Karla','ack9101',998563210,'karla.aguirre',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (4,'Garcia Toledo','21/12/1989','Stephanie','gts1213',959632864,'stephanie.garcia',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (5,'Ligarda Gutierres','26/04/1990','Fabiola','lgf1415',958632475,'fabiola.ligarda',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (6,'Bustamante Cayo','3/04/1994','Miguel','bcm1617',958469632,'miguel.bustmante',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (7,'Aguirre Corrales','25/06/1990','Jeffrey','acj1819',959784236,'jeffrey.corrales',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (8,'Tejada Bejazo','29/10/1992','MariaFernanda','tb2021',958632145,'maria.tejada',1);

INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (9,'Yana Chavez','05/12/1987','Elder','yce2223',958632145,'elder.yana',1);
INSERT INTO admin(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (10,'Loayza Soto','15/04/1992','Jennifer','ls2425',958462032,'jennifer.loayza',1);

INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8001,30,'307');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8002,20,'306');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8003,30,'309');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8004,15,'210');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8005,25,'201');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8006,33,'PB-01');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8007,10,'PB-09');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8008,12,'401');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8009,25,'LAB-C');
INSERT INTO aula(
            id, maxalumnos, nombre)
    VALUES (8010,25,'LAB-E');
    
INSERT INTO carrera(
            id, nombre)
    VALUES (00198, 'Ciencia de la Computacion');
INSERT INTO carrera(
            id, nombre)
    VALUES (00299, 'Administracion');
INSERT INTO carrera(
            id, nombre)
    VALUES (003100, 'Educacion');
INSERT INTO carrera(
            id, nombre)
    VALUES (004101, 'Psicologia');
INSERT INTO carrera(
            id, nombre)
    VALUES (005102, 'Ingenieria Industrial');
INSERT INTO carrera(
            id, nombre)
    VALUES (006103, 'Ingenieria en Telecomunicaciones');
INSERT INTO carrera(
            id, nombre)
    VALUES (007105, 'Contabilidad');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1201,'permanente1');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1202,'permanente2');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1203,'parcial');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1204,'final');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1205,'parcial teoria');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1206,'parcial practica');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1207,'final teoria');
INSERT INTO categoria_nota(
            id, nombre)
    VALUES (1208,'final practica');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2001, 2, 200101,'Introduccion a la vida universitaria');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2002, 4, 200103,'Logica');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2003, 2,200102,'Formacion cristiana');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2004, 2, 200104,'Musica');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2005, 5, 200105,'Analisis Matematico');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2006, 4, 200105,'Calculo I');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2007, 2, 200102,'Teologia I');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2008,5, 200106,'Fisica I');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2009,4, 200107,'Base de Datos I');
INSERT INTO curso(
            id, creditos, idequivalencia, nombre)
    VALUES (2010, 5, 200108,'Base de Datos II');
    
    INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1101,'Vasquez','10/01/1985','Luz Marina','vql1001',952365478,'luzmarina.vasquez',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1102,'Arias','23/06/1988','Diego','apd5234',958536147,'diego.arias',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1103,'Medina','02/012/1987','Tatiana','mtt1895',958539672,'tatiana.medina',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1104,'Basurco','10/01/1985','Luis Fernando','dbl1265',93016782,'luis.basurco',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1105,'Linares','23/05/1985','Rubel','ldr5364',98236100,'rubel.linares',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1106,'Jordan','14/11/1984','Monica','jm1263',975230010,'monica.jordan',2);
INSERT INTO docente(
            id, apellido, fecha_n, nombre, password, telefono, usuario, role_id)
    VALUES (1107,'Tejada','26/09/1982','Javier','tjk4203',954910234,'javier.tejada',2);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1301,'Lunes',830, 700);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1302,'Martes',830, 700);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1303,'Lunes',1515, 1345);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1304,'Miercoles',1730, 1600);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1305,'Jueves',830,700);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1306,'Viernes',2115,1945);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1307,'Viernes',1945, 1815);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1308,'Jueves',1600,1730);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1309,'Miercoles',1515,1645);
INSERT INTO horario(
            id, dia, hora_fin, hora_inicio)
    VALUES (1310,'Martes',1815,1600);
    
    INSERT INTO malla(
           id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7001,'Introduccion a lo nuevos estudiantes a llevar un nuevo concepto de su vida universitaria','01/03/2006',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7002,'Introduccion a lo nuevos estudiantes a llevar un nuevo concepto de su vida universitaria','01/03/2006',True, 00299);
    INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7003,'Introduccion a lo nuevos estudiantes a llevar un nuevo concepto de su vida universitaria','01/03/2006',True, 005102);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7004,'Introduccion a lo nuevos estudiantes a llevar un nuevo concepto de su vida universitaria','01/03/2006',True, 003100);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7005,'Introduccion a lo nuevos estudiantes a llevar un nuevo concepto de su vida universitaria','01/03/2006',True, 004101);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7006,'Ciencia formal que estudia los principios de la demostracion e inferencia valida','01/03/2010',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7007,'Formar a la persona en la vida cristiana','01/03/2006',False, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7008,'Formar a la persona en la vida cristiana','01/03/2006',True, 005102);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7009,'Formar a la persona en la vida cristiana','01/03/2006',True, 003100);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7010,'Formar a la persona en la vida cristiana','01/03/2006',True, 006103);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (7011,'Formar a la persona en la vida cristiana','01/03/2006',True, 007105);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70012,'Desarrollar el arte de organizar sensible y logicamente una combinacion coherente de sonidos','01/03/2006',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70013,'Desarrollar el arte de organizar sensible y logicamente una combinacion coherente de sonidos','01/03/2006',True, 003100);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70014,'Desarrollar el arte de organizar sensible y logicamente una combinacion coherente de sonidos','01/03/2006',True, 00299);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70015,'Desarrollar el arte de organizar sensible y logicamente una combinacion coherente de sonidos','01/03/2006',True, 006103);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70016,'Desarrollar conocimientos sobre numeros reales, complejos, construccion de derivadas','01/03/2006',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70017,'Conceptos basicos del analisis matematico y capacidad de emplear funciones para modelar fenomenos','01/03/2006',True, 005102);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70018,'Descubrir la ciencia de Dios y de las cosas divinas','01/03/2010',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70019,'Descubrir la ciencia de Dios y de las cosas divinas','01/03/2010',True, 00299);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70020,'Descubrir la ciencia de Dios y de las cosas divinas','01/03/2010',True, 003100);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70021,'Descubrir la ciencia de Dios y de las cosas divinas','01/03/2006',False, 003100);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70022,'Ciencia natural que estudia a las propiedades y el comportamiento de la energia y la materia','01/03/2006',False, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70025,'Ciencia natural que estudia a las propiedades y el comportamiento de la energia y la materia','01/03/2010',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70023,'Conocimientos basicos sobre la la base de datos asi como funciones basicas','01/03/2006',True, 00198);
INSERT INTO malla(
            id, descripcion, fecha, vigencia, carrera_id)
    VALUES (70024,'Conceptos sobre paginacion de datos e indices','01/03/2006',True, 00198);

INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3001,'07/07/2010','01/03/2010','Introduccion a la vida universitaria');
INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3002,'15/12/2011','15/08/2011','Teologia I');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3003,'10/07/2011','10/03/2011','Base de Datos II');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3004,'07/07/2012','10/03/2012','Fisica I');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3005,'10/07/2011','10/03/2011','Logica');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3006,'07/07/2012','10/03/2012','Formacion cristiana');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3007,'07/12/2012','16/08/2012','Musica');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3008,'10/07/2013','15/03/2013','Analisis Matematico'); 
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3009,'10/12/2013','17/08/2013','Calculo I');
 INSERT INTO periodo(
            id, fecha_fin, fecha_inicio, nombre)
    VALUES (3010,'10/12/2013','17/08/2013','Base de Datos I');
    
    INSERT INTO prerequisitos(
            curso_id, prerequisito_id)
    VALUES (2006, 2005);
INSERT INTO prerequisitos(
            curso_id, prerequisito_id)
    VALUES (2005, 2006);
INSERT INTO prerequisitos(
            curso_id, prerequisito_id)
    VALUES (2003, 2007);
INSERT INTO prerequisitos(
            curso_id, prerequisito_id)
    VALUES (2007, 2003);

INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1001,'Carrillo Pino','Jose Carrillo','San Juan','10/06/1992','Jose Enrique','cpj1234', 
            958563024,'jose.carrillo',00198,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1002,'Arana Gonzales','Maria Arana','Nstra Sra de la Asuncion','16/02/1990','Sthefany','ags4567', 
            958426691,'sthefany.arana',005102,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1003,'Medina Pampa','Paola Pampa','Nstra Sra de la Asuncion','04/06/1992','Rosario','mpr6789', 
            974562201,'rosario.medina',00299,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1004,'Garcia Toledo','Roberto Garcia','La Salle','21/12/1989','Stephanie','gts1470', 
            912458793,'stephanie.garcia',003100,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1005,'Loayza Soto','Jennifer Soto','San Carlos','19/03/1991','Rossmery','lsr8521', 
            958441203,'rossmery.loayza',004101,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1006,'Marticorena Rios','Miguel Marticorena','San Jose','30/04/1992','Jean','mrj9632', 
            94302659,'jean.marticorena',006103,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1007,'Quispe Condori','Carol Condori','San Juan','25/10/1992','Jhoel Darwin','qcj9510', 
            974635271,'jhoel.quispe',00198,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1008,'Jurado Aguirre','Jenny Aguirre','Nstra Sra de Fatima','20/03/1990','Stephany','jas1022', 
            946320152,'stephany.jurado',005102,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1009,'Jurado Aguirre','Percy Jurado','Santisimo Salvador','17/08/1996','Alejandra','jaa8463', 
            958500234,'alejandra.jurado',00299,3);
INSERT INTO alumno(
            id, apellido, apoderado, colegio, fecha_n, nombre, password, 
            telefono, usuario, carrera_id, role_id)
    VALUES (1010,'Tejada Begazo','Maria Begazo','Mercedario','31/10/1993','Maria Fernanda','tbm4867', 
            920136920,'maria.tejada',004101,3);

INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4001,2001,3001);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4002,2002,3005);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4003,2004,3007);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4004,2010,3003);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4005,2008,3004);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4006,2006,3009);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4007,2007,3002);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4008,2003,3006);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4009,2005,3008);
INSERT INTO cursodictado(
            id, curso_id, periodo_id)
    VALUES (4010,2009,3010);
    
    INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6001, 2001, 7001);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6002, 2001, 7002);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6003, 2001, 7003);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6004, 2001, 7004);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6005, 2001, 7005);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6006, 2002, 7006);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6007, 2003, 7007);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6008, 2003, 7008);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6009, 2003, 7009);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6010, 2003, 7010);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6011, 2003, 7011);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6012, 2004, 70012);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6013, 2004, 70013);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6014, 2004, 70014);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6015, 2004, 70015);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6016, 2005, 70016);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6017, 2006, 70017);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6018, 2007, 70018);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6019, 2007, 70019);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6020, 2007, 70020);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6021, 2007, 70021);

INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6022, 2008, 70022);

INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6023, 2008, 70025);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6024, 2009, 70023);
INSERT INTO cursomalla(
            id, curso_id, malla_id)
    VALUES (6025, 2010, 70024);

INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4001,1103);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4002,1101);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4003,1103);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4004,1107);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4005,1105);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4006,1104);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4007,1102);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4008,1102);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4009,1101);
INSERT INTO docente_por_curso_dictado(
            curso_dictado_id, docente_id)
    VALUES (4010,1106);
    
    INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1601,0,'20/02/13',1001,4002);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1602,0,'23/02/10',1002,4006);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1603,0,'20/08/11',1003,4003);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1604,0,'25/02/12',1004,4008);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1605,0,'23/08/13',1005,4008);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1606,0,'22/02/12',1006,4007);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1607,0,'24/08/11',1007,4010);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1608,0,'25/02/13',1008,4001);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1609,0,'25/02/13',1008,4003);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1610,0,'21/08/12',1009,4007);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1611,0,'20/08/10',1010,4001);
INSERT INTO matricula(
            id, estado, fecha, alumno_id, cursodictado_id)
    VALUES (1612,0,'24/02/13',1001,4010);

INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1901, 18,0.2, 1201,1601);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1902, 15,0.2, 1202,1601);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1903, 10,0.3, 1203,1601);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1904, 08,0.05, 1205,1602);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1905, 20,0.05, 1206,1602);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1906, 13.5,0.2, 1201,1603);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1907, 14.75,0.2, 1203,1603);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1908, 8.5,0.2, 1203,1604);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (1909, 15,0.2, 1204,1605);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19010, 17.5,0.2, 1201,1605);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19011, 13.8,0.2, 1202,1606);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19012, 10.5,0.2, 1201,1607);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19013, 14.6,0.3, 1203,1607);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19014, 12,0.2, 1201,1608);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19015, 20,0.3, 1203,1608);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19016, 13.75,0.2, 1202,1608);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19017,14,0.2, 1201,1609);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19018,13.5,0.3, 1203,1609);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19019,12,0.2, 1202,1609);
INSERT INTO nota(
            id, nota, peso, categoria_id, matricula_id)
    VALUES (19020, 10,0.2, 1202,1604);

INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1501,8001,4001,1301);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1502,8002,4002,1306);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1503,8003,4008,1303);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1504,8004,4003,1302);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1505,8005,4009,1307);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1506,8006,4006,1308);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1507,8007,4007,1309);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1508,8008,4005,1310);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (1509,8009,4010,1304);
INSERT INTO bloque(
            id, aula_id, cursodictado_id, horario_id)
    VALUES (15010,8010,4004,1305);


update alumno set password= 'ed6296326e7e82dab1a737d129ee74e314911403ac305a2e1ed18826d4165dec644f58cd3aea272a';
update docente set password= 'ed6296326e7e82dab1a737d129ee74e314911403ac305a2e1ed18826d4165dec644f58cd3aea272a';
update admin set password= 'ed6296326e7e82dab1a737d129ee74e314911403ac305a2e1ed18826d4165dec644f58cd3aea272a';