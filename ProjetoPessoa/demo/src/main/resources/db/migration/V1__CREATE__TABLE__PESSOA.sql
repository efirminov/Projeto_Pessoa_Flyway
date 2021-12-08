CREATE TABLE TB_PESSOA
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR,
    email VARCHAR ,
    telefone VARCHAR,
    curso VARCHAR

);

INSERT INTO TB_PESSOA (nome, email,  telefone, curso) VALUES ('evandro', '1234567', '12345678912',  'internet');
INSERT INTO TB_PESSOA (nome, email,  telefone,  curso) VALUES ('debora', '7419632', '74185236912',  'enfermagem');
