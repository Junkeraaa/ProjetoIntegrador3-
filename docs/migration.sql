-- Arquivo de migration para popular o banco

CREATE TABLE FIXED_INCOME (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price DECIMAL(5, 2) NOT NULL, --peço ação
    name VARCHAR(255) NOT NULL,--nome
    type VARCHAR(255) NOT NULL,--tipo
    fee DECIMAL(5, 2) NOT NULL--taxa
);

INSERT INTO USUARIOS (login, senha, balance)
VALUES
 ('Lucas123', 'Lucas1211', 0),
 ('Rafa123', 'Rafa123', 0),
 ('Gustavo123', 'Gustavo123', 0),
 ('Joao123', 'Joao123', 0),
 ('Pedro123', 'Pedro123', 0),
 ('Kaick123', 'Kaick123', 0);

 INSERT INTO STOCKS (name_stock, price_stock)
 VALUES
 ('APPL4', 83.2),
 ('MGLU3', 1.2),
 ('PETR4', 27.92),
 ('CIEL3', 16.33),
 ('ITUB4', 51.25),
 ('AMER3', 0.11),
 ('CURY3', 14.16),
 ('CEAB3', 2.27),
 ('GGPS3', 95.8),
 ('TASA4', 22.22);

  INSERT INTO FIXED_INCOME (price, name, type, fee)
 VALUES 
(200, 'Itaú ValorProtegidoCDB', 'CDB', 8.5),
(150, 'Santander RendimentoSeguroLCA', 'LCA', 9.2),
(300, 'Banco do Brasil GarantiaRendaCDB', 'CDB', 7.8),
(500, 'Caixa PremiumDebenture', 'Debenture', 6.5),
(800, 'BTG Pactual ConfiancaCRI', 'CRI', 10.5),
(250, 'Banco Inter ValorResilienteLCI', 'LCI', 8.9),
(4000, 'Original RendaConstanteLCA', 'LCA', 9.8),
(600, 'Safra EstabilidadeCDB', 'CDB', 7.2),
(700, 'Nubank RendimentoSolidoLCI', 'LCI', 9.5);

