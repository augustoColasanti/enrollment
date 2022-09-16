DROP TABLE IF EXISTS student;

CREATE TABLE student(
   id BIGSERIAL PRIMARY KEY,
   name TEXT NOT NULL,
   start_date DATE NOT NULL
);

INSERT INTO student(name, start_date) VALUES ('Tsunioshi Tanaka', '1963-05-23');
INSERT INTO student(name, start_date) VALUES ('Marissa Sanches', '2014-07-05');
INSERT INTO student(name, start_date) VALUES ('Augusto Sanches', '2005-06-01');