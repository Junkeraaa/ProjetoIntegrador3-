
--TB Usuários
CREATE TABLE USUARIOS (
id INT AUTO_INCREMENT PRIMARY KEY,
login VARCHAR(255) NOT NULL,
senha VARCHAR(255) NOT NULL,
balance DECIMAL(10,2) NOT NULL
);

--TB Renda variável
CREATE TABLE STOCKS (
   id INT AUTO_INCREMENT PRIMARY KEY,
    name_stock VARCHAR(255) NOT NULL,--nome da ação
    price_stock DECIMAL(10, 2) NOT NULL--preço/ação
); 
--TB Ações Renda Variável do Cliente
CREATE TABLE STOCKS_CLIENT (
   id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,  -- Chave estrangeira para a tabela de usuários
    stock_id INT NOT NULL,--nome da ação
    qtd INT NOT NULL,--quantidade
    FOREIGN KEY (user_id) REFERENCES USUARIOS(id),
    FOREIGN KEY (stock_id) REFERENCES STOCKS(id)
); 

--TB Renda Fixa
CREATE TABLE FIXED_INCOME (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(5, 2) NOT NULL, --peço ação
    name VARCHAR(255) NOT NULL,--nome
    type VARCHAR(255) NOT NULL,--tipo
    fee DECIMAL(5, 2) NOT NULL--taxa
);

--TB Papéis Renda Fixa do Cliente
CREATE TABLE FIXED_INCOME_CLIENT (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,  -- Chave estrangeira para a tabela de usuários
    fixed_income_id INT NOT NULL, --Chave estrangeira para associar a renda fixa
    amount DECIMAL(10, 2) NOT NULL,--montante
    yeld DECIMAL(10, 2) NOT NULL,--rendimento
    FOREIGN KEY (user_id) REFERENCES USUARIOS(id),
    FOREIGN KEY (fixed_income_id) REFERENCES FIXED_INCOME(id)
);


