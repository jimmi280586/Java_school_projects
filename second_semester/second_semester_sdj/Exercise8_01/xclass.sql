CREATE DATABASE IF NOT EXISTS sXclass;
USE sXclass;

CREATE TABLE IF NOT EXISTS Nationality
(
  CountryCode varchar(2) NOT NULL PRIMARY KEY, 
  Country varchar(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS Student
(
  StudyNumber int NOT NULL PRIMARY KEY,
  FirstName varchar(30) NOT NULL, 
  LastName varchar(30) NOT NULL, 
  CountryCode varchar(50) NOT NULL, 
  FOREIGN KEY (CountryCode) REFERENCES Nationality(CountryCode)
) ENGINE=InnoDB;


INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'DK','Denmark') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'DK' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'FR','France') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'FR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'HR','Croatia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'HR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'ET','Ethiopia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'ET' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'ES','Spain') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'ES' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'PL','Poland') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'PL' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'BG','Bulgaria') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'BG' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'RO','Romania') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'RO' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'LT','Lithuania') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'LT' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'LV','Latvia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'LV' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'SR','Serbia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'SR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'SK','Slovakia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'SK' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'GB','United Kingdom') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'GB' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'US','United States') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'US' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT '?','Not listed') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = '?' ) LIMIT 1;





INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 232014, 'Alex', 'Seiwert', 'FR') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 232014)  LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164626, 'Alexandra', 'Alstanei', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164626) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224469, 'Alexandru', 'Ungureanu', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224469) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224206, 'Alice', 'Christoffersen', 'DK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224206) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 231912, 'Alvaro', 'Camarasa', 'ES')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 231912) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 232001, 'Andreas', 'Guillot', 'FR')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 232001) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224339, 'Branislav', 'Machava', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224339) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224201, 'Catalin', 'Cervis', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224201) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224429, 'Cristian', 'Serban', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224429) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224436, 'Damyan', 'Sirakov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224436) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224160, 'David', 'Andreev', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224160) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224274, 'Dominik', 'Hurcik', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224274) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224408, 'Emanuel', 'Rad', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224408) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 226484, 'Ionela', 'Marinuta', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 226484) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224410, 'Jevgenijs', 'Ragozins', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224410) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 196852, 'Jimmi', 'Andersen', 'DK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 196852) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224355, 'Kalin', 'Mitkov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224355) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224312, 'Kamen', 'Kolev', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224312) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164662, 'Karolis', 'Kalanta', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164662) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224197, 'Kristofer', 'Carta', 'US')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224197) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224352, 'Laurynas', 'Mileris', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224352) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224475, 'Lukas', 'Varmeda', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224475) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224271, 'Magdalena', 'Houska', 'HR')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224271) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 225862, 'Mantas', 'Skimelis', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 225862) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208238, 'Marcin', 'Kraj', 'PL')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208238) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224351, 'Marek', 'Mikitovic', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224351) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 189602, 'Nicolae-Claudiu', 'Furca', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 189602) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224385, 'Nikola', 'Peevski', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224385) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224164, 'Ognian', 'Apostolov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224164) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224409, 'Rares-Alin', 'Radulescu', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224409) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208277, 'Renatas', 'Valatka', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208277) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224447, 'Ryen', 'Stork', 'GB')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224447) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224194, 'Sarunas', 'Burba', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224194) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224433, 'Slavomir', 'Simko', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224433) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224378, 'Staniskav', 'Ondrus', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224378) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT *  FROM (SELECT 224202, 'Teodor-Raul', 'Chicinas', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224202) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208234, 'Trifon', 'Kamenov', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208234) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224464, 'Tseno', 'Tsenov', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224464) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224165, 'Valeriu', 'Arhip', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224165) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224337, 'Vanja', 'Lukac', 'SR') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224337) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224313, 'Verinda', 'Kondzheli', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224313) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164634, 'Viktor', 'Cazan', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164634) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224181, 'Viktors', 'Bergholcs', 'LV') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224181) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224487, 'Zemichael', 'Tadesse', 'ET') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224487) LIMIT 1;



CREATE DATABASE IF NOT EXISTS sXclass;
USE sXclass;

CREATE TABLE IF NOT EXISTS Nationality
(
  CountryCode varchar(2) NOT NULL PRIMARY KEY, 
  Country varchar(50) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS Student
(
  StudyNumber int NOT NULL PRIMARY KEY,
  FirstName varchar(30) NOT NULL, 
  LastName varchar(30) NOT NULL, 
  CountryCode varchar(50) NOT NULL, 
  FOREIGN KEY (CountryCode) REFERENCES Nationality(CountryCode)
) ENGINE=InnoDB;


INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'DK','Denmark') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'DK' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'FR','France') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'FR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'HR','Croatia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'HR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'ET','Ethiopia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'ET' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'ES','Spain') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'ES' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'PL','Poland') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'PL' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'BG','Bulgaria') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'BG' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'RO','Romania') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'RO' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'LT','Lithuania') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'LT' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'LV','Latvia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'LV' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'SR','Serbia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'SR' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'SK','Slovakia') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'SK' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'GB','United Kingdom') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'GB' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT 'US','United States') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = 'US' ) LIMIT 1;
INSERT INTO Nationality (CountryCode, Country) SELECT * FROM (SELECT '?','Not listed') AS tmp WHERE NOT EXISTS (SELECT CountryCode FROM Nationality WHERE CountryCode = '?' ) LIMIT 1;





INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 232014, 'Alex', 'Seiwert', 'FR') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 232014)  LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164626, 'Alexandra', 'Alstanei', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164626) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224469, 'Alexandru', 'Ungureanu', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224469) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224206, 'Alice', 'Christoffersen', 'DK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224206) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 231912, 'Alvaro', 'Camarasa', 'ES')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 231912) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 232001, 'Andreas', 'Guillot', 'FR')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 232001) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224339, 'Branislav', 'Machava', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224339) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224201, 'Catalin', 'Cervis', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224201) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224429, 'Cristian', 'Serban', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224429) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224436, 'Damyan', 'Sirakov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224436) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224160, 'David', 'Andreev', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224160) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224274, 'Dominik', 'Hurcik', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224274) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224408, 'Emanuel', 'Rad', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224408) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 226484, 'Ionela', 'Marinuta', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 226484) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224410, 'Jevgenijs', 'Ragozins', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224410) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 196852, 'Jimmi', 'Andersen', 'DK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 196852) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224355, 'Kalin', 'Mitkov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224355) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224312, 'Kamen', 'Kolev', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224312) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164662, 'Karolis', 'Kalanta', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164662) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224197, 'Kristofer', 'Carta', 'US')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224197) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224352, 'Laurynas', 'Mileris', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224352) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224475, 'Lukas', 'Varmeda', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224475) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224271, 'Magdalena', 'Houska', 'HR')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224271) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 225862, 'Mantas', 'Skimelis', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 225862) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208238, 'Marcin', 'Kraj', 'PL')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208238) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224351, 'Marek', 'Mikitovic', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224351) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 189602, 'Nicolae-Claudiu', 'Furca', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 189602) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224385, 'Nikola', 'Peevski', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224385) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224164, 'Ognian', 'Apostolov', 'BG')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224164) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224409, 'Rares-Alin', 'Radulescu', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224409) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208277, 'Renatas', 'Valatka', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208277) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224447, 'Ryen', 'Stork', 'GB')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224447) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224194, 'Sarunas', 'Burba', 'LT')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224194) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224433, 'Slavomir', 'Simko', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224433) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224378, 'Staniskav', 'Ondrus', 'SK')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224378) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT *  FROM (SELECT 224202, 'Teodor-Raul', 'Chicinas', 'RO')
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224202) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 208234, 'Trifon', 'Kamenov', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 208234) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224464, 'Tseno', 'Tsenov', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224464) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224165, 'Valeriu', 'Arhip', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224165) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224337, 'Vanja', 'Lukac', 'SR') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224337) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224313, 'Verinda', 'Kondzheli', 'BG') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224313) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 164634, 'Viktor', 'Cazan', 'RO') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 164634) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224181, 'Viktors', 'Bergholcs', 'LV') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224181) LIMIT 1;
INSERT INTO Student (StudyNumber, FirstName, LastName, 
CountryCode) SELECT * FROM (SELECT 224487, 'Zemichael', 'Tadesse', 'ET') 
AS tmp WHERE NOT EXISTS (SELECT 
StudyNumber FROM Student WHERE StudyNumber = 224487) LIMIT 1;

