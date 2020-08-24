DROP TABLE IF EXISTS Geolocalization;

CREATE TABLE Geolocalization (
id LONG AUTO_INCREMENT PRIMARY KEY,
deviceid LONG NOT NULL,
latitude VARCHAR(250) NOT NULL,
longitude VARCHAR(250) NOT NULL,
logdate DATE NOT NULL
);

INSERT INTO Geolocalization (deviceid, latitude, longitude, logdate) VALUES
(111, '55.223', '35.3', '2015-12-17'),
(222, '155.1', '2.10002', '2015-12-17'),
(333, '81.21', '2.10', '2015-12-17'),
(444, '12.21', '21.12', '2015-12-17');