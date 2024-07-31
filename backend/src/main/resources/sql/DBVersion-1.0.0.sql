-- Criação das tabelas
CREATE TABLE Recipes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    instructions TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Ingredients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE Recipe_Ingredients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    recipe_id INT,
    ingredient_id INT,
    quantity VARCHAR(255),
    FOREIGN KEY (recipe_id) REFERENCES Recipes(id),
    FOREIGN KEY (ingredient_id) REFERENCES Ingredients(id)
);

-- Inserção de dados na tabela Recipes
INSERT INTO Recipes (name, description, instructions, created_at, updated_at) VALUES
('Spaghetti Bolognese', 'A classic Italian pasta dish', 'Boil pasta, cook sauce, mix together.', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Caesar Salad', 'A fresh salad with a creamy dressing', 'Chop lettuce, mix dressing, toss together.', '2024-07-31 12:00:00', '2024-07-31 12:00:00');

-- Inserção de dados na tabela Ingredients
INSERT INTO Ingredients (name, created_at, updated_at) VALUES
('Spaghetti', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Ground Beef', '2024-07-31 12:00:00', '2024-07-31 12:00:00'),
('Lettuce', '2024-07-31 12:00:00', '2024-07-31 12:00:00');

-- Inserção de dados na tabela Recipe_Ingredients
INSERT INTO Recipe_Ingredients (recipe_id, ingredient_id, quantity) VALUES
(1, 1, '200g'),
(1, 2, '300g'),
(2, 3, '1 head');