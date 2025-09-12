
  CREATE TABLE cargas(
  	carga_id VARCHAR(36) PRIMARY KEY,
  	descricao VARCHAR(255),
  	observacao VARCHAR(255), 
  	quantidade DECIMAL(12,3) NOT NULL
  );