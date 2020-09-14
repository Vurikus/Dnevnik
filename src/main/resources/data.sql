DROP TABLE IF EXISTS learner, teacher, subject, class, marks;

CREATE TABLE class(
  idClass SERIAL PRIMARY KEY,
  className VARCHAR (10) not null
);

CREATE TABLE learner(
  idLearner SERIAL PRIMARY KEY,
  name VARCHAR (50) not null,
  idClass integer DEFAULT (null),
  FOREIGN KEY (idClass) REFERENCES class(idClass)
);

CREATE TABLE teacher(
  idTeacher SERIAL PRIMARY KEY,
  nameTeacher VARCHAR not null
);

CREATE TABLE subject (
  idSubject SERIAL PRIMARY KEY,
  subjectName VARCHAR not null,
  idTeacher INTEGER DEFAULT (null),
  FOREIGN KEY (idTeacher) REFERENCES teacher(idTeacher)
);

CREATE TABLE marks(
  idMark SERIAL PRIMARY KEY,
  dateMark DATE,
  idSubject INTEGER not null,
  idLearner INTEGER not null,
  FOREIGN KEY (idSubject) REFERENCES subject(idSubject),
  FOREIGN KEY (idLearner) REFERENCES learner(idLearner)
);
