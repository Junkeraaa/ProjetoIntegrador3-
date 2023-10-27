CREATE TABLE USUARIOS (
id INT AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
balance DECIMAL(10,2) NOT NULL
);

--TB Renda variável
CREATE TABLE STOCKS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,  -- Chave estrangeira para a tabela de usuários
    name_stock VARCHAR(255) NOT NULL,--nome da ação
    qtd INT NOT NULL,--quantidade
    price_stock DECIMAL(10, 2) NOT NULL,--preço/ação
    FOREIGN KEY (user_id) REFERENCES USUARIOS(id)
);

--TB Renda Fixa
CREATE TABLE FIXED_INCOME (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,  -- Chave estrangeira para a tabela de usuários
    name VARCHAR(255) NOT NULL,--nome
    type VARCHAR(255) NOT NULL,--tipo
    fee DECIMAL(5, 2) NOT NULL,--taxa
    amount DECIMAL(10, 2) NOT NULL,--montante
    yeld DECIMAL(10, 2) NOT NULL,--rendimento
    FOREIGN KEY (user_id) REFERENCES USUARIOS(id)
);


