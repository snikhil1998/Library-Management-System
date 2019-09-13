DROP DATABASE librarydb;
CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE librarian(
	libfname varchar(30) NOT NULL,
	libminit char(1),
	liblname varchar(30) NOT NULL,
	password varchar(16)
);

CREATE TABLE book(
	bid int NOT NULL,
	name varchar(50) NOT NULL,
	author varchar(50) NOT NULL,
	publisher varchar(50) NOT NULL,
	price float NOT NULL,
	edition varchar(50) DEFAULT NULL,
	totalcount int DEFAULT 0,
	availablecount int DEFAULT 0,
	constraint pk_bid PRIMARY KEY (bid)
);

CREATE TABLE bookcopy(
	ebid int NOT NULL,
	copyid varchar(12) NOT NULL,
	status boolean NOT NULL,
	constraint pk_copyid PRIMARY KEY (copyid)
);

CREATE TABLE member(
	mid int NOT NULL,
	fname varchar(30) NOT NULL,
	minit char(1),
	lname varchar(30) NOT NULL,
	memberType varchar(10) NOT NULL,
	addr varchar(50) NOT NULL,
	phoneno varchar(10) NOT NULL,
	noofbooksissued int DEFAULT 0,
	maxissued int DEFAULT 0,
	constraint pk_mid PRIMARY KEY (mid)
);

CREATE TABLE bookissued(
	cid varchar(12) NOT NULL,
	emid int NOT NULL,
	issueid int NOT NULL,
	dataofissue varchar(10) NOT NULL,
	dateofreturn varchar(10) DEFAULT NULL,
	constraint pk_issueid PRIMARY KEY (issueid)
);

CREATE TABLE supplier(
	sid int NOT NULL,
	sname varchar(50) NOT NULL,
	saddr varchar(50) NOT NULL,
	sphno varchar(10) NOT NULL,
	constraint pk_sid PRIMARY KEY (sid)
);

CREATE TABLE bookorder(
	esid int NOT NULL,
	bname varchar(50) NOT NULL,
	bprice float NOT NULL,
	quantity int NOT NULL,
	dateoforder varchar(10) DEFAULT NULL
);

INSERT INTO librarian(libfname, libminit, liblname, password) VALUES ("Radhika", "M", "Patel", "9N!nEtW02");

INSERT INTO book(bid, name, author, publisher, price, edition, totalcount, availablecount) VALUES
(23456, "Introduction to Computability Theory", "Dag Norman", "Pearson", 140.24, "1st Edition", 4, 4),
(52345, "Hacking Secrets Exposed", "Srikanth Ramesh", "Pearson", 120.10, "1st Edition", 4, 4),
(79438, "Machine Learning", "Oliver Theobald", "Pearson", 150.84, "2nd Edition", 4, 4),
(57894, "Linear Algebra", "Gilbert Strang", "Pearson", 130.43, "4th Edition", 4, 4);

INSERT INTO bookcopy(ebid, copyid, status) VALUES
(23456, "23456-1", true),
(23456, "23456-2", true),
(23456, "23456-3", true),
(23456, "23456-4", true),
(52345, "52345-1", true),
(52345, "52345-2", true),
(52345, "52345-3", true),
(52345, "52345-4", true),
(79438, "79438-1", true),
(79438, "79438-2", true),
(79438, "79438-3", true),
(79438, "79438-4", true),
(57894, "57894-1", true),
(57894, "57894-2", true),
(57894, "57894-3", true),
(57894, "57894-4", true);

INSERT INTO member(mid, fname, minit, lname, memberType, addr, phoneno, noofbooksissued, maxissued) VALUES
(468324, "John",'B',"Smith", "Student", "731 Fondren", "9873247584", 0, 3),
(768935, "Franklin",'T',"Wong", "Lecturer", "638 Fondren", "9854632754", 0, 4),
(673980, "Alicia",'J',"Zelaya", "Lecturer", "3321 Fondren", "8932453235", 0, 4),
(768905, "Jennifer",'S',"Wallace", "Professor", "21 Fondren", "7589234894", 0, 4);

INSERT INTO supplier(sid, sname, saddr, sphno) VALUES (5789324, "Book Suppliers", "Koramangala", "9823546723");

INSERT INTO bookorder(esid, bname, bprice, quantity, dateoforder) VALUES
(5789324, "Introduction to Computability Theory", 140.24, 4, "2018-11-28"),
(5789324, "Hacking Secrets Exposed", 120.10, 4, "2018-11-28"),
(5789324, "Machine Learning", 150.84, 4, "2018-11-28"),
(5789324, "Linear Algebra", 130.43, 4, "2018-11-28"),
(5789324, "Fundamentals of Database Systems", 171.84, 4, "2018-11-29");

alter table bookcopy
	add constraint fk_ebid FOREIGN KEY (ebid) REFERENCES book(bid);

alter table bookorder
	add constraint fk_esid FOREIGN KEY (esid) REFERENCES supplier(sid);

alter table bookissued
	add constraint fk_cid FOREIGN KEY (cid) REFERENCES bookcopy(copyid);

alter table bookissued
	add constraint fk_emid FOREIGN KEY (emid) REFERENCES member(mid);