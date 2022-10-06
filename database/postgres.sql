CREATE DATABASE "linketinder"

CREATE TABLE "candidatos" (
  "id" serial PRIMARY KEY,
  "email" varchar UNIQUE NOT NULL,
  "senha" varchar NOT NULL,
  "nome" varchar NOT NULL,
  "sobrenome" varchar NOT NULL,
  "nascimento" varchar NOT NULL,
  "cpf" varchar UNIQUE NOT NULL,
  "pais" varchar NOT NULL,
  "cep" varchar NOT NULL,
  "descricao" varchar
);

CREATE TABLE "candidatos_competencias" (
  "id_candidatos" int,
  "id_competencias" int
);

CREATE TABLE "competencias" (
  "id" serial PRIMARY KEY,
  "nome" varchar NOT NULL
);

CREATE TABLE "empresas" (
  "id" serial PRIMARY KEY,
  "nome" varchar NOT NULL,
  "cnpj" varchar UNIQUE NOT NULL,
  "email" varchar UNIQUE NOT NULL,
  "senha" varchar NOT NULL,
  "descricao" varchar,
  "pais" varchar NOT NULL,
  "cep" varchar NOT NULL
);

CREATE TABLE "vagas" (
  "id" serial PRIMARY KEY,
  "id_empresas" int,
  "nome" varchar NOT NULL,
  "descricao" varchar NOT NULL,
  "local" varchar NOT NULL
);

CREATE TABLE "vagas_competencias" (
  "id_competencias" int,
  "id_vagas" int
);

ALTER TABLE "candidatos_competencias" ADD FOREIGN KEY ("id_candidatos") REFERENCES "candidatos" ("id");

ALTER TABLE "candidatos_competencias" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "vagas" ADD FOREIGN KEY ("id_empresas") REFERENCES "empresas" ("id");

ALTER TABLE "vagas_competencias" ADD FOREIGN KEY ("id_competencias") REFERENCES "competencias" ("id");

ALTER TABLE "vagas_competencias" ADD FOREIGN KEY ("id_vagas") REFERENCES "vagas" ("id");
