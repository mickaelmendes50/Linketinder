-- Cadidatos
INSERT INTO candidatos (nome, email, senha, cpf, nascimento, cep, descricao, pais, sobrenome) VALUES ('João', 'joao@worker.com', 'j123', '123.456.789-01', '23-08-2000', '74659-156', 'Legal e extrovertido', 'brasil', 'Borges');
INSERT INTO candidatos (nome, email, senha, cpf, nascimento, cep, descricao, pais, sobrenome) VALUES ('Maria', 'maria@worker.com', 'm123', '456.789.101-11', '31-12-1999', '86551-785', 'Chata e introvertida', 'eua', 'Pereira');
INSERT INTO candidatos (nome, email, senha, cpf, nascimento, cep, descricao, pais, sobrenome) VALUES ('Pedro', 'pedro@worker.com', 'p123', '789.101.112-13', '25-05-2001', '95125-532', 'Sábio e inteligente', 'italia', 'Silva');
INSERT INTO candidatos (nome, email, senha, cpf, nascimento, cep, descricao, pais, sobrenome) VALUES ('Marta', 'marta@worker.com', 'ma123', '101.112.131-41', '20-07-1995', '75369-159', 'Educada e amorosa', 'canada', 'Andrade');
INSERT INTO candidatos (nome, email, senha, cpf, nascimento, cep, descricao, pais, sobrenome) VALUES ('José', 'jose@worker.com', 'jo123', '112.131.415-01', '30-01-1998', '96325-452', 'Triste e dramático', 'brasil', 'Mendes');

-- Competencias
INSERT INTO competencias (nome) VALUES ('Java');
INSERT INTO competencias (nome) VALUES ('C++');
INSERT INTO competencias (nome) VALUES ('C#');
INSERT INTO competencias (nome) VALUES ('Python');
INSERT INTO competencias (nome) VALUES ('Ruby');
INSERT INTO competencias (nome) VALUES ('JavaScript');
INSERT INTO competencias (nome) VALUES ('TypeScript');

-- Empresas
INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES ('Hiper Festa', 'hiperfesta@employer.com', 'h123', '12.345.678/0001-10', 'Brasil', '96325-452', 'Rede de festa');
INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES ('Google', 'google@employer.com', 'g123', '22.345.678/0001-10', 'Estados Unidos', '75369-159', 'Tecnologia');
INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES ('Ford', 'ford@employer.com', 'f123', '32.345.678/0001-10', 'Estados Unidos', '86551-785', 'Carros');
INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES ('Xiaomi', 'xiaomi@employer.com', 'x123', '42.345.678/0001-10', 'China', '74659-156', 'Celulares');
INSERT INTO empresas (nome, email, senha, cnpj, pais, cep, descricao) VALUES ('Polishop', 'polishop@employer.com', 'p123', '52.345.678/0001-10', 'São Paulo', '95125-532', 'Eletrodomesticos');

-- Vagas
INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES (1, 'Administrador', 'Administrar recursos da empresa', 'Goiânia');
INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES (2, 'Engenheiro de Software', 'Projetar e planejar o desenvolvimento do software', 'São Paulo');
INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES (3, 'Engenheiro Mecânico', 'Projetar sistemas motores automobilísticos', 'Brasília');
INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES (4, 'Analista de Requisitos', 'Levantar e Analisar requisitos para o desenvolvimento de sistemas', 'São Paulo');
INSERT INTO vagas (id_empresas, nome, descricao, local) VALUES (5, 'Vendedor', 'Vender nossos produtos', 'Anápolis');