-- database: ../database/EXOBOT.sqlite
/*
CopyRight
autor:MRGONORREA
fecha:22/202/2024
*/
DROP TABLE IF EXISTS AntBot;
DROP TABLE IF EXISTS IABot; 

DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS HormigaTipo;

DROP TABLE IF EXISTS Persona;

DROP TABLE IF EXISTS PersonaTipo;

CREATE TABLE IABot (
     IdIABot        integer primary key autoincrement
    ,Nombre         TEXT NOT NULL UNIQUE
    ,Estado         VARCHAR(1) NOT NULL DEFAULT('A')
    ,Observacion    TEXT
    ,FechaCrea      datetime default current_timestamp
);
CREATE TABLE AntBot (
     IdAntBot       integer primary key autoincrement
    ,IdIABot        integer NOT NULL
    ,Nombre         TEXT NOT NULL
    ,Serie          TEXT NOT NULL
    ,Estado         VARCHAR(1) NOT NULL DEFAULT('A')
    ,CONSTRAINT  fk_IABot
     FOREIGN KEY (IdIABot)
     REFERENCES  IABot(IdIABot)
);

CREATE TABLE HormigaTipo (
     IdHormigaTipo       INTEGER primary key autoincrement
    ,IdHormigaTipoPadre  INTEGER REFERENCES HormigaTipo(IdHormigaTipo)
    ,Nombre              TEXT NOT NULL UNIQUE
    ,Estado             VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea           datetime default current_timestamp
);

CREATE TABLE Hormiga (
     IdHormiga      INTEGER primary key autoincrement
    ,IdHormigaTipo  INTEGER NOT NULL REFERENCES HormigaTipo(IdHormigaTipo)
    ,Codigo         TEXT NOT NULL UNIQUE
    ,Nombre         TEXT NOT NULL 
    ,Estado         VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea      datetime default current_timestamp
);


CREATE TABLE UsuarioSistema (
    IdUsuarioSistema        INTEGER primary key autoincrement
    ,IdHormigaTipo          INTEGER NOT NULL REFERENCES HormigaTipo(IdHormigaTipo)
    ,Contraseña             TEXT NOT NULL UNIQUE
    ,Estado                 VARCHAR(1) NOT NULL DEFAULT('A')
    ,FechaCrea              datetime default current_timestamp
    ,FechaModifica          DATE
);


CREATE TRIGGER limite_filas
BEFORE INSERT ON HormigaTipo
WHEN (SELECT COUNT(*) FROM HormigaTipo) >= 5
BEGIN
    SELECT RAISE(ABORT, 'Se ha alcanzado el límite máximo de filas en la tabla HormigaTipo');
END;
CREATE TRIGGER limite_filas
BEFORE INSERT ON PersonaTipo
WHEN (SELECT COUNT(*) FROM PersonaTipo) >= 3
BEGIN
    SELECT RAISE(ABORT, 'Se ha alcanzado el límite máximo de filas en la tabla PersonaTipo');
END;