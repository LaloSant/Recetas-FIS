CREATE TABLE USUARIOS (
    ID_USUARIO  NUMBER		 	CONSTRAINT USRS_ID_PK		PRIMARY KEY,
    NOMBRE      VARCHAR2(50) 	CONSTRAINT USRS_NOMBRE_NN 	NOT NULL,
    CONTRASENIA VARCHAR2(50)	CONSTRAINT USRS_CONT_NN 	NOT NULL,
    AP_PAT      VARCHAR2(50) 	CONSTRAINT USRS_APPAT_NN 	NOT NULL,
    CORREO 		VARCHAR2(50) 	CONSTRAINT USRS_CORREO_NN 	NOT NULL
);

CREATE TABLE RECETAS (
    ID_RECETA		NUMBER			CONSTRAINT RECETAS_ID_PK	PRIMARY KEY,
    ID_USUARIO		NUMBER		    CONSTRAINT RECETAS_IDUSR_NN	NOT NULL,
    NOMBRE			VARCHAR2(40)	CONSTRAINT RECETAS_NOM_NN	NOT NULL,
    PROCEDIMIENTO	VARCHAR2(200)	CONSTRAINT RECETAS_PROC_NN	NOT NULL,
    INGREDIENTES	VARCHAR2(200)	CONSTRAINT RECETAS_ING_NN	NOT NULL,
    CONSTRAINT RECETAS_IDUSR_FK FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO)
);

DROP TABLE USUARIOS;
DROP TABLE RECETAS;

INSERT INTO USUARIOS VALUES ( 1,'Juan','pass123','Perez','juan.perez@email.com' );
INSERT INTO USUARIOS VALUES ( 2,'Maria','maria456','Lopez','maria.lopez@email.com' );
INSERT INTO USUARIOS VALUES ( 3,'Carlos','car789','Gomez','carlos.gomez@email.com' );
INSERT INTO USUARIOS VALUES ( 4,'Ana','ana321','Martinez','ana.martinez@email.com' );
INSERT INTO USUARIOS VALUES ( 5,'Luis','luis654','Ramirez','luis.ramirez@email.com' );

INSERT INTO RECETAS VALUES ( 1,1,'Tarta de Manzana','Mezclar ingredientes y hornear 40 minutos.','Manzana, Harina, Azúcar, Huevo');
INSERT INTO RECETAS VALUES ( 2,2,'Ensalada César','Cortar ingredientes y mezclar con aderezo.','Lechuga, Pollo, Queso, Aderezo César');
INSERT INTO RECETAS VALUES ( 3,3,'Sopa de Verduras','Cocinar verduras en agua por 30 minutos.','Zanahoria, Papa, Apio, Agua');
INSERT INTO RECETAS VALUES ( 4,4,'Pizza Casera','Preparar masa, agregar ingredientes y hornear.','Harina, Tomate, Queso, Jamón');
INSERT INTO RECETAS VALUES ( 5,5,'Arroz con Leche','Cocinar arroz en leche con azúcar y canela.','Arroz, Leche, Azúcar, Canela');