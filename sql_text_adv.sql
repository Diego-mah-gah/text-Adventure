CREATE TABLE produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);
CREATE TABLE cena (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao TEXT NOT NULL
);
CREATE TABLE inventario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    produto_id INT,
    FOREIGN KEY (produto_id) REFERENCES Produto(id)
);


select *from produto
INSERT INTO produto (nome) VALUES ('FORMA'),
INSERT INTO produto (nome) VALUES ('BATEDEIRA'),
INSERT INTO produto (nome) VALUES ('TIGELA'),
INSERT INTO produto (nome) VALUES ('OVO'),
INSERT INTO produto (nome) VALUES ('OLEO'),
INSERT INTO produto (nome) VALUES ('FARINHA'),
INSERT INTO produto (nome) VALUES ('ACUCAR'),
INSERT INTO produto (nome) VALUES ('MASSA'),
INSERT INTO produto (nome) VALUES ('CREME DE NINHO'),
INSERT INTO produto (nome) VALUES ('CHOCOLATE');

select *from cena
INSERT INTO cena (descricao) VALUES ('José Luiz queria fazer algo especial para sua mãe, Ana. Decidiu preparar um bolo para surpreendê-la. A caminho da cozinha, sentiu uma leve preguiça. Ele tem a opção de descansar no quarto ou seguir para a cozinha.');

INSERT INTO cena (descricao) VALUES ('Já na cozinha, José Luiz decidiu que era hora de começar a preparação! Ele começou a pensar nos utensílios domésticos que seriam necessários para o processo. Olhou para o armário e viu uma FORMA, algumas TIGELAs e também a BATEDEIRA.');

INSERT INTO cena (descricao) VALUES ('José Luiz posicionou todos os utensílios sobre a mesa e começou a separar os ingredientes. Ele pegou o OVO, o OLEO, a FARINHA, o ACUCAR e a MASSA para bolos com sabor de baunilha. Agora, ele precisa adicionar esses ingredientes na tigela para começar a mistura.');

INSERT INTO cena (descricao) VALUES ('Percebeu que com aqueles ingredientes, só seria possível a realização de um bolinho simples. Decidiu então fazer uma cobertura saborosa, para valorizar seu bolinho. Ficou indeciso sobre usar CREME DE NINHO ou CHOCOLATE.');

INSERT INTO cena (descricao) VALUES ('Com a massa pronta, você untou a forma e despejou a massa. Agora precisa preparar a cobertura de CREME DE NINHO.');

select * from inventario

INSERT INTO inventario (produto_id) VALUES (1), 
INSERT INTO inventario (produto_id) VALUES (2),
INSERT INTO inventario (produto_id) VALUES (3), 


INSERT INTO inventario (produto_id) VALUES (4), 
INSERT INTO inventario (produto_id) VALUES (5), 
INSERT INTO inventario (produto_id) VALUES (6), 
INSERT INTO inventario (produto_id) VALUES (7),
INSERT INTO inventario (produto_id) VALUES (8),
INSERT INTO inventario (produto_id) VALUES (9),
INSERT INTO inventario (produto_id) VALUES (10);

CREATE TABLE cena_produto (
    cena_id INT,
    produto_id INT,
    PRIMARY KEY (cena_id, produto_id),
    FOREIGN KEY (cena_id) REFERENCES Cena(id) ON DELETE CASCADE,
    FOREIGN KEY (produto_id) REFERENCES Produto(id) ON DELETE CASCADE
);
select * from cena_produto
INSERT INTO cena_produto (cena_id, produto_id) VALUES (1, 1), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (2, 2), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (2, 3), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (3, 4), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (3, 5),
INSERT INTO cena_produto (cena_id, produto_id) VALUES (3, 6), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (3, 7), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (3, 8), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (4, 9), 
INSERT INTO cena_produto (cena_id, produto_id) VALUES (4, 10); 


