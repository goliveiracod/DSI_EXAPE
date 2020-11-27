CREATE DATABASE dsi_exape;

USE dsi_exape;

CREATE TABLE contacts (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  primary_cellphone VARCHAR(20) NOT NULL,
  secondary_cellphone VARCHAR(20),
  primary_phone VARCHAR(20),
  secondary_phone VARCHAR(20),
  CONSTRAINT id_pk PRIMARY KEY (id)
);

ALTER TABLE contacts ADD COLUMN address varchar(500);

