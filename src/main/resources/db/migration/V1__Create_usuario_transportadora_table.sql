CREATE TABLE usuarios (
    usuario_id VARCHAR(36) PRIMARY KEY,
    nome_completo VARCHAR(255),
    telefone VARCHAR(30) UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL, 
    tipo_perfil VARCHAR(50) NOT NULL
);

CREATE TABLE transportadoras(
    transportadora_id VARCHAR(36) PRIMARY KEY,
    cnpj VARCHAR(20) NOT NULL UNIQUE,
    razao_social VARCHAR(255) NOT NULL UNIQUE,
    status_cadastro VARCHAR(25) NOT NULL, 
    data_cadastro DATE NOT NULL
);

ALTER TABLE usuarios
ADD transportadora_id VARCHAR(36);

ALTER TABLE usuarios
ADD CONSTRAINT fk_usuario_transportadora
FOREIGN KEY (transportadora_id) REFERENCES transportadoras(transportadora_id);
