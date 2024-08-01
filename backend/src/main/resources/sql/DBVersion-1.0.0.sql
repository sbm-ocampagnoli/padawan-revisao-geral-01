-- Criação das tabelas
CREATE TABLE Recipe (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    instructions TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Ingredient (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Inserção de dados na tabela Recipe
INSERT INTO Recipe (name, description, instructions, created_at, updated_at) VALUES
('Spaghetti Bolognese', 'A classic Italian pasta dish', 'Boil pasta, cook sauce, mix together.', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Caesar Salad', 'A fresh salad with a creamy dressing', 'Chop lettuce, mix dressing, toss together.', '2024-07-31 12:00:00', '2024-07-31 12:00:00');

-- Inserção de dados na tabela Ingredient
INSERT INTO Ingredient (name, created_at, updated_at) VALUES
('Spaghetti', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Ground Beef', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Lettuce', '2024-07-31 12:00:00', '2024-07-31 12:00:00');