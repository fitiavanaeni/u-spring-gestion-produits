CREATE TABLE produit (
                         id_produit BIGINT AUTO_INCREMENT PRIMARY KEY,
                         nom_produit VARCHAR(55),
                         prix_produit DOUBLE,
                         date_creation DATE
);


INSERT INTO produit (nom_produit, prix_produit, date_creation)
VALUES
        ('Ordinateur', 1500.0, '2025-10-14'),
        ('Clavier', 50.0, '2025-10-10'),
        ('Souris', 30.0, '2025-10-12'),
        ('Écran', 300.0, '2025-10-11');