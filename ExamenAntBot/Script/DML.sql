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


INSERT INTO saHormigaComida(HormigaTipo,CodigoHormiga,Region)VALUES
('LARVA','1111','SIERRA'),
('LARVA','1112','SIERRA'),
('LARVA','1113','COSTA'),
('LARVA','1114','COSTA'),
('LARVA','1115','SIERRA'),
('LARVA','1116','SIERRA'),
('LARVA','1117','COSTA'),
('LARVA','1118','COSTA'),
('LARVA','1119','SIERRA'),
('LARVA','1110','SIERRA'),
('LARVA','2222','SIERRA'),
('LARVA','2221','COSTA'),
('LARVA','2223','SIERRA'),
('LARVA','2224','SIERRA'),
('LARVA','2225','SIERRA'),
('LARVA','2226','SIERRA'),
('LARVA','2227','SIERRA'),
('LARVA','2228','SIERRA'),
('LARVA','2229','SIERRA'),
('LARVA','2201','SIERRA'),
('LARVA','2242','SIERRA'),
('LARVA','2250','AMAZONAS'),
('LARVA','3301','AMAZONAS'),
('LARVA','3331','COSTA'),
('LARVA','3332','AMAZONAS'),
('LARVA','3333','COSTA'),
('LARVA','3334','AMAZONAS'),
('LARVA','3335','COSTA'),
('LARVA','3336','AMAZONAS'),
('LARVA','3337','COSTA'),
('LARVA','3338','AMAZONAS'),
('LARVA','3339','COSTA'),
('LARVA','3352','AMAZONAS'),
('LARVA','3347','COSTA'),
('LARVA','3587','AMAZONAS'),
('LARVA','3398','COSTA'),
('LARVA','3247','AMAZONAS'),
('LARVA','37855','COSTA'),
('LARVA','4847','AMAZONAS'),
('LARVA','4987','COSTA'),
('LARVA','5787','COSTA'),
('LARVA','5234','AMAZONAS'),
('LARVA','4897','COSTA');

