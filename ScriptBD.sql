CREATE TABLE ADDRESS
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	street VARCHAR(30) NOT NULL,
	number_ VARCHAR(30) NOT NULL,
	cp VARCHAR(30) NOT NULL,
	autonomousCommunity VARCHAR(30) NOT NULL,
	CONSTRAINT pk_ADDRESS PRIMARY KEY (id)
);

CREATE TABLE UNIVERSITY
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(30) NOT NULL,
	address INTEGER NOT NULL,
	CONSTRAINT pk_UNIVERSITY PRIMARY KEY (id),
	CONSTRAINT fk_UNIVERSITY_ADDRESS FOREIGN KEY (address) REFERENCES ADDRESS(id),
	CONSTRAINT uc_address UNIQUE(address)
);

CREATE TABLE ROL
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(30) NOT NULL,
	CONSTRAINT pk_ROL PRIMARY KEY (id)
);

CREATE TABLE DEGREE
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(30) NOT NULL,
	university INTEGER NOT NULL,
	CONSTRAINT pk_DEGREE PRIMARY KEY (id),
	CONSTRAINT fk_DEGREE_UNIVERSITY FOREIGN KEY (university) REFERENCES UNIVERSITY(id)
);

CREATE TABLE USER_
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	nickname VARCHAR(30) NOT NULL,
	password VARCHAR(30) NOT NULL,
	name VARCHAR(30) NOT NULL,
	surname VARCHAR(30) NOT NULL,
	rol INTEGER NOT NULL,
	address INTEGER NOT NULL,
	university INTEGER NOT NULL,
	degree INTEGER NOT NULL,
	CONSTRAINT pk_USER_ PRIMARY KEY (id),
	CONSTRAINT fk_USER__ROL FOREIGN KEY (rol) REFERENCES ROL(id),
	CONSTRAINT fk_USER__ADDRESS FOREIGN KEY (address) REFERENCES ADDRESS(id),
	CONSTRAINT uc_address_USER_ UNIQUE(address),
	CONSTRAINT fk_USER__UNIVERSITY FOREIGN KEY (university) REFERENCES UNIVERSITY(id),
	CONSTRAINT fk_USER__DEGREE FOREIGN KEY (degree) REFERENCES DEGREE(id)
);

CREATE TABLE SUBJECT
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	name VARCHAR(30) NOT NULL,
	course INTEGER NOT NULL,
	teacher INTEGER NOT NULL,
	university INTEGER NOT NULL,
	degree INTEGER NOT NULL,
	CONSTRAINT pk_SUBJECT PRIMARY KEY (id),
	CONSTRAINT fk_SUBJECT_USER_TEACHER FOREIGN KEY (teacher) REFERENCES USER_(id),
	CONSTRAINT fk_SUBJECT_UNIVERSITY FOREIGN KEY (university) REFERENCES UNIVERSITY(id),
	CONSTRAINT fk_SUBJECT_DEGREE FOREIGN KEY (degree) REFERENCES DEGREE(id)
);

CREATE TABLE POST
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	title VARCHAR(30) NOT NULL,
	user_ INTEGER NOT NULL,
	date_ TIMESTAMP NOT NULL,
	content VARCHAR(250),
	pathImage VARCHAR(30),
	subject INTEGER NOT NULL,
	CONSTRAINT pk_POST PRIMARY KEY (id),
	CONSTRAINT fk_POST_USER_MYPOSTS FOREIGN KEY (user_) REFERENCES USER_(id),
	CONSTRAINT fk_POST_SUBJECT FOREIGN KEY (subject) REFERENCES SUBJECT(id)
);

CREATE TABLE COMMENT
(
	id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	user_ INTEGER NOT NULL,
	content VARCHAR(250),
	date_ TIMESTAMP NOT NULL,
	post INTEGER NOT NULL,
	CONSTRAINT pk_COMMENT PRIMARY KEY (id),
	CONSTRAINT fk_COMMENT_POST FOREIGN KEY (post) REFERENCES POST(id),
	CONSTRAINT fk_COMMENT_USER_ FOREIGN KEY (user_) REFERENCES USER_(id)
);

CREATE TABLE USER_POST_SUBJECT_PUBLICATIONRELATION(
    userId INTEGER NOT NULL,
    postID INTEGER NOT NULL,
    subjectID INTEGER NOT NULL,
    CONSTRAINT fk_USER_POST_SUBJECT_PUBLICATIONRELATION_USER_ FOREIGN KEY (userId) REFERENCES USER_(id),
    CONSTRAINT fk_USER_POST_SUBJECT_PUBLICATIONRELATION_POST FOREIGN KEY (postID) REFERENCES POST(id),
    CONSTRAINT fk_USER_POST_SUBJECT_PUBLICATIONRELATION_SUBJECT FOREIGN KEY (subjectID) REFERENCES SUBJECT(id),
    CONSTRAINT pk_USER_POST_SUBJECT_PUBLICATIONRELATION PRIMARY KEY (userId,postID,subjectID)
);

CREATE TABLE USER_POST_LIKEDRELATION(
    userId INTEGER NOT NULL,
    postID INTEGER NOT NULL,
    CONSTRAINT fk_USER_POST_LIKEDRELATION_USER_ FOREIGN KEY (userId) REFERENCES USER_(id),
    CONSTRAINT fk_USER_POST_LIKEDRELATION_POST FOREIGN KEY (postID) REFERENCES POST(id),
    CONSTRAINT pk_USER_POST_LIKEDRELATION PRIMARY KEY (userId,postID)
);

CREATE TABLE USER_POST_FAVOURITERELATION(
    userId INTEGER NOT NULL,
    postID INTEGER NOT NULL,
    CONSTRAINT fk_USER_POST_FAVOURITERELATION_USER_ FOREIGN KEY (userId) REFERENCES USER_(id),
    CONSTRAINT fk_USER_POST_FAVOURITERELATION_POST FOREIGN KEY (postID) REFERENCES POST(id),
    CONSTRAINT pk_USER_POST_FAVOURITERELATION PRIMARY KEY (userId,postID)
);

CREATE TABLE USER_SUBJECT_FOLLOWEDRELATION(
    userId INTEGER NOT NULL,
    subjectID INTEGER NOT NULL,
    CONSTRAINT fk_USER_SUBJECT_FOLLOWEDRELATION_USER_ FOREIGN KEY (userId) REFERENCES USER_(id),
    CONSTRAINT fk_USER_SUBJECT_FOLLOWEDRELATION_SUBJECT FOREIGN KEY (subjectID) REFERENCES SUBJECT(id),
    CONSTRAINT pk_USER_SUBJECT_FOLLOWEDRELATION PRIMARY KEY (userId,subjectID)
);

INSERT INTO APP.ROL ( NAME) VALUES('Estudiante');
INSERT INTO APP.ROL ( NAME) VALUES('Profesor');
INSERT INTO APP.ROL ( NAME) VALUES('Administrador');

INSERT INTO APP.ADDRESS (STREET, NUMBER_, CP, AUTONOMOUSCOMMUNITY) VALUES('Polizón', '24', '35118', 'Canarias');
INSERT INTO APP.ADDRESS (STREET, NUMBER_, CP, AUTONOMOUSCOMMUNITY) VALUES('Tafira Alta', '25', '35118', 'Canarias');
INSERT INTO APP.ADDRESS (STREET, NUMBER_, CP, AUTONOMOUSCOMMUNITY) VALUES('Pinar', '25', '35118', 'Canarias');
INSERT INTO APP.ADDRESS (STREET, NUMBER_, CP, AUTONOMOUSCOMMUNITY) VALUES('Tafira Baja', '21', '35118', 'Canarias');

INSERT INTO APP.UNIVERSITY (NAME, ADDRESS) VALUES('ULPGC', 2);

INSERT INTO APP."DEGREE" (NAME, UNIVERSITY) VALUES('Ingeniería Informática', 1);

INSERT INTO APP.USER_ ( NICKNAME, PASSWORD, NAME, SURNAME, ROL, ADDRESS, UNIVERSITY, "DEGREE") VALUES( 'ignacio', '1234', 'ignacio', 'marin', 1, 1, 1, 1);
INSERT INTO APP.USER_ ( NICKNAME, PASSWORD, NAME, SURNAME, ROL, ADDRESS, UNIVERSITY, "DEGREE") VALUES( 'javier', '1234', 'javier', 'sanchez', 2, 3, 1, 1);
INSERT INTO APP.USER_ ( NICKNAME, PASSWORD, NAME, SURNAME, ROL, ADDRESS, UNIVERSITY, "DEGREE") VALUES( 'admin', '1234', 'admin', 'admin', 3, 4, 1, 1);

INSERT INTO APP.SUBJECT (NAME, COURSE, TEACHER, UNIVERSITY, "DEGREE") VALUES('Arquitectura del Sofware', 4, 2, 1, 1);

INSERT INTO APP.POST (TITLE, USER_, DATE_, CONTENT, PATHIMAGE, SUBJECT) VALUES('Practica 3 JPA', 1, '2020-05-22 16:48:05.591', 'Problema BD', NULL, 1);

INSERT INTO APP.USER_POST_SUBJECT_PUBLICATIONRELATION (USERID, POSTID, SUBJECTID) VALUES(1, 1, 1);

INSERT INTO APP.USER_SUBJECT_FOLLOWEDRELATION (USERID, SUBJECTID) VALUES(1, 1);








