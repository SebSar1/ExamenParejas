-- database: ../Data/EXOBOT.sqlite

insert INTO IABot ( Nombre,Observacion ) VALUES("IA-RUSO" ,"" );

INSERT INTO AntBot(IdIABot,Nombre,Serie) 
VALUES(1,"exabot1","Serie E1"),
(1,"exabot2","Serie E2"),
(1,"exabot3","Serie E3"),
(1,"exabot4","Serie E4"),
(1,"exabot5","Serie E5"),
(1,"exabot6","Serie E6");


SELECT * FROM AntBot;

SELECT  IdExaBot, IdIABot, Nombre, Serie FROM ExaBot;


INSERT INTO HormigaTipo(Nombre,IdHormigaTipoPadre)
VALUES  ( "Reina",null ),
        ( "Rastreadora",1 ),
        ( "Larva",1 ),
        ( "Soldado",1 ),
        ( "Zangano",1 );
SELECT * FROM PersonaTipo;

INSERT INTO PersonaTipo(Nombre)
VALUES  ( "Mecatronico"),
        ( "Experto en ingles"),
        ( "Experto en Español");
SELECT * FROM PersonaTipo;
INSERT INTO Persona  
( IdPersonaTipo, Cedula, Nombre) VALUES
( 1,  "11111", "pepe"),
( 2,  "22222", "juan"),
( 3,  "33333", "pedro");

INSERT INTO Hormiga  
( IdHormigaTipo,Codigo, Nombre) VALUES
( 1,  "11111", "lola"),
( 2,  "22222", "paco"),
( 3,  "33333", "jeremy");

SELECT * FROM Persona;

INSERT INTO UsuarioSistema(IdHormigaTipo,Contraseña,FechaModifica)VALUES
(1,'contrasena1',CURRENT_TIMESTAMP),
(2,'contrasena2',CURRENT_TIMESTAMP),
(3,'contrasena3',CURRENT_TIMESTAMP),
(4,'contrasena4',CURRENT_TIMESTAMP),
(5,'contrasena5',CURRENT_TIMESTAMP);


INSERT INTO saHormigaComida(HormigaTipo,CodigoHormiga,Comio,Region)VALUES
('LARVA','1111','CARNE','SIERRA'),
('LARVA','1112','HIERBA','SIERRA'),
('LARVA','1113','PIZZA','COSTA'),
('LARVA','1114','PIZZA','COSTA'),
('LARVA','1115','CARNE','SIERRA'),
('LARVA','1116','HIERBA','SIERRA'),
('LARVA','1117','HIERBA','COSTA'),
('LARVA','1118','HIERBA','COSTA'),
('LARVA','1119','HIERBA','SIERRA'),
('LARVA','1110','CARNE','SIERRA'),
('LARVA','2222','PIZZA','SIERRA'),
('LARVA','2221','PIZZA','COSTA'),
('LARVA','2223','PIZZA','SIERRA'),
('LARVA','2224','PIZZA','SIERRA'),
('LARVA','2225','PIZZA','SIERRA'),
('LARVA','2226','CARNE','SIERRA'),
('LARVA','2227','PIZZA','SIERRA'),
('LARVA','2228','PIZZA','SIERRA'),
('LARVA','2229','PIZZA','SIERRA'),
('LARVA','2201','CARNE','SIERRA'),
('LARVA','2242','HIERBA','SIERRA'),
('LARVA','2250','HIERBA','AMAZONAS'),
('LARVA','3301','HIERBA','AMAZONAS'),
('LARVA','3331','HIERBA','COSTA'),
('LARVA','3332','HIERBA','AMAZONAS'),
('LARVA','3333','CARNE','COSTA'),
('LARVA','3334','CARNE','AMAZONAS'),
('LARVA','3335','CARNE','COSTA'),
('LARVA','3336','CARNE','AMAZONAS'),
('LARVA','3337','CARNE','COSTA'),
('LARVA','3338','CARNE','AMAZONAS'),
('LARVA','3339','CARNE','COSTA'),
('LARVA','3352','CARNE','AMAZONAS'),
('LARVA','3347','CARNE','COSTA'),
('LARVA','3587','PIZZA','AMAZONAS'),
('LARVA','3398','PIZZA','COSTA'),
('LARVA','3247','PIZZA','AMAZONAS'),
('LARVA','37855','LARVAS DE ABEJA','COSTA'),
('LARVA','4847','LARVAS DE ABEJA','AMAZONAS'),
('LARVA','4987','LARVAS DE ABEJA','COSTA'),
('LARVA','5787','LARVAS DE ABEJA','COSTA'),
('LARVA','5234','LARVAS DE ABEJA','AMAZONAS'),
('LARVA','4897','LARVAS DE ABEJA','COSTA');

