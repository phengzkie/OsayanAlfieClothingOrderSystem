DROP TABLE IF EXISTS staff;
CREATE TABLE staff (
	staffid INTEGER PRIMARY KEY AUTO_INCREMENT,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	number CHAR(50) NOT NULL,
	address VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
	orderid INTEGER PRIMARY KEY AUTO_INCREMENT,
	clothesid INTEGER NOT NULL,
	userid INTEGER NOT NULL,
	quantity INTEGER NOT NULL,
	size VARCHAR(50) NOT NULL,
	orderdate DATE
);

DROP TABLE IF EXISTS clothes;
CREATE TABLE clothes (
	clothesid INTEGER PRIMARY KEY AUTO_INCREMENT,
	productname VARCHAR(255) NOT NULL,
	type VARCHAR(255) NOT NULL,
	color VARCHAR(50) NOT NULL,
	design VARCHAR(50),
	price DECIMAL(10, 2) NOT NULL,
	gender VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	userid INTEGER PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL,
	password CHAR(128) NOT NULL,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	number CHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL
);

INSERT INTO users ( username, password, firstname, lastname, email, number, address ) VALUES ( 'alfie', 'alfie123', 'alfie', 'osayan', 'abc@gmail.com', 09451112432, 'Muntinlupa' );
INSERT INTO users ( username, password, firstname, lastname, email, number, address ) VALUES ( 'daniel', 'daniel123', 'daniel', 'manalo', 'djm@gmail.com', 09451434241, 'Pampanga' );

INSERT INTO staff ( firstname, lastname, email, number, address ) VALUES ( 'ivan', 'oliveros', 'iv@gmail.com', 09270987567, 'Las Pinas' );
INSERT INTO staff ( firstname, lastname, email, number, address ) VALUES ( 'bowwi', 'kaligbak', 'bk@gmail.com', 09274966557, 'Calamba' );

INSERT INTO clothes ( productname, type, color, design, price, gender ) VALUES ( 'Shirt 1', 'Shirt', 'Black', 'Minimalist', 500, 'Male' );
INSERT INTO clothes ( productname, type, color, design, price, gender ) VALUES ( 'Shirt 2', 'Shirt', 'Red', 'Foodporn', 600, 'Male' );
INSERT INTO clothes ( productname, type, color, design, price, gender ) VALUES ( 'Windbreaker Jacket', 'Others', 'White', null, 350, 'Female' );
INSERT INTO clothes ( productname, type, color, design, price, gender ) VALUES ( 'Jogger Pants', 'Others', 'Gray', null, 600, 'Female' );

INSERT INTO orders ( clothesid, userid, quantity, size, orderdate ) VALUES ( 1, 1, 2, 'Medium', '2018-06-21' ),
( 3, 2, 1, 'Small', '2018-06-20' );
