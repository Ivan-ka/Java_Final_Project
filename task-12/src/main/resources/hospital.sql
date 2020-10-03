
CREATE SCHEMA Hospital;

CREATE TABLE Hospital.Patient (
  id INT NOT NULL AUTO_INCREMENT,
  fullName VARCHAR(50) NOT NULL,
  dateOfBirth DATE NOT NULL,
  gender VARCHAR(10) NOT NULL,
  email VARCHAR(100) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE Hospital.Diagnosis (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE Hospital.Specialty (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE Hospital.Doctor (
  id INT NOT NULL AUTO_INCREMENT,
  fullName VARCHAR(50) NOT NULL,
  specialtyID INT NOT NULL,
  experience INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT specialtyFK
    FOREIGN KEY (specialtyID)
    REFERENCES Hospital.Specialty (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE Hospital.Appointment (
  id INT NOT NULL AUTO_INCREMENT,
  dat DATE NOT NULL,
  doctorID INT NOT NULL,
  patientID INT NOT NULL,
  diagnosisID INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT doctorFK
    FOREIGN KEY (doctorID)
    REFERENCES Hospital.Doctor (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT patientFK
    FOREIGN KEY (patientID)
    REFERENCES Hospital.Patient (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT diagnosisFK
    FOREIGN KEY (diagnosisID)
    REFERENCES Hospital.Diagnosis (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE Hospital.Basket (
  id INT NOT NULL AUTO_INCREMENT,
  dat DATE NOT NULL,
  doctorID INT NOT NULL,
  patientID INT NOT NULL,
  diagnosisID INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT doctorrFK
    FOREIGN KEY (doctorID)
    REFERENCES Hospital.Doctor (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT patienttFK
    FOREIGN KEY (patientID)
    REFERENCES Hospital.Patient (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT diagnosissFK
    FOREIGN KEY (diagnosisID)
    REFERENCES Hospital.Diagnosis (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES ('Bibik Maksim', '2003-01-17', 'MALE', 'bm@mail.ru');
INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES ('Savchenko Anastasiya', '1997-02-19', 'FEMALE', 'sa@mail.ru');
INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES ('Karpov Anton', '1989-04-02', 'MALE', 'ka@mail.ru');
INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES ('Filatov Aleksandr', '1983-05-25', 'MALE', 'fa@mail.ru');
INSERT INTO Hospital.Patient (fullName, dateOfBirth, gender, email) VALUES ('Zajceva Nadezhda', '1967-07-20', 'FEMALE', 'zn@mail.ru');

INSERT INTO Hospital.Diagnosis (name) VALUES ('osteochondrosis');
INSERT INTO Hospital.Diagnosis (name) VALUES ('astigmatism');
INSERT INTO Hospital.Diagnosis (name) VALUES ('encephalopathy');
INSERT INTO Hospital.Diagnosis (name) VALUES ('eustachitis');
INSERT INTO Hospital.Diagnosis (name) VALUES ('neurosis');

INSERT INTO Hospital.Specialty (name) VALUES ('therapist');
INSERT INTO Hospital.Specialty (name) VALUES ('ophthalmologist');
INSERT INTO Hospital.Specialty (name) VALUES ('neurologist');
INSERT INTO Hospital.Specialty (name) VALUES ('otolaryngologist');
INSERT INTO Hospital.Specialty (name) VALUES ('psychotherapist');

INSERT INTO Hospital.Doctor (fullName, specialtyID, experience) VALUES ('Kobyalko Mariya', (SELECT id FROM Hospital.Specialty WHERE name = 'therapist'), 7);
INSERT INTO Hospital.Doctor (fullName, specialtyID, experience) VALUES ('Kundelev Fedor', (SELECT id FROM Hospital.Specialty WHERE name = 'ophthalmologist'), 9);
INSERT INTO Hospital.Doctor (fullName, specialtyID, experience) VALUES ('Samusenko Antonina', (SELECT id FROM Hospital.Specialty WHERE name = 'neurologist'), 11);
INSERT INTO Hospital.Doctor (fullName, specialtyID, experience) VALUES ('Baranov Evgenij', (SELECT id FROM Hospital.Specialty WHERE name = 'otolaryngologist'), 15);
INSERT INTO Hospital.Doctor (fullName, specialtyID, experience) VALUES ('Kovbenya Vitalij', (SELECT id FROM Hospital.Specialty WHERE name = 'psychotherapist'), 17);

INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) VALUES ('2020-01-07',
(SELECT id FROM Hospital.Doctor WHERE fullName = 'Kobyalko Mariya'),
(SELECT id FROM Hospital.Patient WHERE fullName = 'Bibik Maksim'),
(SELECT id FROM Hospital.Diagnosis WHERE name = 'osteochondrosis'));

INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) VALUES ('2020-01-17',
(SELECT id FROM Hospital.Doctor WHERE fullName = 'Kundelev Fedor'),
(SELECT id FROM Hospital.Patient WHERE fullName = 'Savchenko Anastasiya'),
(SELECT id FROM Hospital.Diagnosis WHERE name = 'astigmatism'));

INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) VALUES ('2020-02-06',
(SELECT id FROM Hospital.Doctor WHERE fullName = 'Samusenko Antonina'),
(SELECT id FROM Hospital.Patient WHERE fullName = 'Karpov Anton'),
(SELECT id FROM Hospital.Diagnosis WHERE name = 'encephalopathy'));

INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) VALUES ('2020-05-21',
(SELECT id FROM Hospital.Doctor WHERE fullName = 'Baranov Evgenij'),
(SELECT id FROM Hospital.Patient WHERE fullName = 'Filatov Aleksandr'),
(SELECT id FROM Hospital.Diagnosis WHERE name = 'eustachitis'));

INSERT INTO Hospital.Appointment (dat, doctorID, patientID, diagnosisID) VALUES ('2020-05-15',
(SELECT id FROM Hospital.Doctor WHERE fullName = 'Kovbenya Vitalij'),
(SELECT id FROM Hospital.Patient WHERE fullName = 'Zajceva Nadezhda'),
(SELECT id FROM Hospital.Diagnosis WHERE name = 'neurosis'));
