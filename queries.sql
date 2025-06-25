CREATE TABLE ESTUDIANTE (
    numControl VARCHAR(9) PRIMARY KEY,
    nombre VARCHAR(50) CONSTRAINT est_nombre_nn NOT NULL,
    apPat VARCHAR(50) CONSTRAINT est_apPat_nn NOT NULL,
    apMat VARCHAR(50) CONSTRAINT est_apMat_nn NOT NULL,
    correo VARCHAR(50) CONSTRAINT est_correo_nn NOT NULL,
    creditos INT CONSTRAINT est_creditos_ck CHECK(creditos >= 0)
);

CREATE TABLE MATERIA (
    idMateria INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre VARCHAR(50) CONSTRAINT mat_nom_nn NOT NULL
);

CREATE TABLE REGISTRO (
    idRegistro    INTEGER PRIMARY KEY AUTOINCREMENT,
    idMateria     INTEGER CONSTRAINT reg_idMat_fk REFERENCES MATERIA(idMateria),
    idEstudiante  VARCHAR(9) CONSTRAINT reg_idEst_fk REFERENCES ESTUDIANTE(numControl)
);

DROP TABLE MATERIA;

INSERT INTO ESTUDIANTE (numControl, nombre, apPat, apMat, correo, creditos) VALUES
('23281287', 'Ana', 'Gomez', 'Lopez', 'ana.gomez@email.com', 30),
('23281288', 'Luis', 'Martinez', 'Perez', 'luis.martinez@email.com', 45),
('23281289', 'Maria', 'Hernandez', 'Sanchez', 'maria.hernandez@email.com', 60),
('23281290', 'Carlos', 'Diaz', 'Ramirez', 'carlos.diaz@email.com', 20),
('23281291', 'Sofia', 'Torres', 'Vega', 'sofia.torres@email.com', 50);

INSERT INTO MATERIA (nombre) VALUES
('Matematicas'),
('Fisica'),
('Quimica'),
('Historia'),
('Informatica');

INSERT INTO REGISTRO (idMateria, idEstudiante) VALUES
(1, '23281287'),
(2, '23281288'),
(3, '23281288'),
(4, '23281287'),
(5, '23281290');