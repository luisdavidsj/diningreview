-- Insertar usuarios
INSERT INTO USERS (ID, DISPLAYNAME, CITY, STATE, ZIPCODE, PEANUTALLERGY, EGGALLERGY, DAIRYALLERGY) 
VALUES (1, 'john_doe', 'New York', 'NY', '10001', TRUE, FALSE, TRUE),
       (2, 'jane_smith', 'Los Angeles', 'CA', '90001', FALSE, TRUE, FALSE),
       (3, 'mike_johnson', 'Chicago', 'IL', '60601', TRUE, TRUE, TRUE);

-- Insertar restaurantes
INSERT INTO RESTAURANT (ID, NAME, ADDRESS, ZIPCODE, PEANUTSCORE, EGGSCORE, DAIRYSCORE, OVERALLSCORE) 
VALUES (1, 'Best Burgers', '123 Main St', '10001', 4.5, 4.0, NULL, 4.25),
       (2, 'Vegan Delight', '456 Green Ave', '90001', NULL, 3.8, 4.2, 4.0),
       (3, 'Gluten-Free Bites', '789 Healthy Rd', '60601', 4.7, 4.5, 4.8, 4.67);

-- Insertar reseñas de restaurantes
INSERT INTO DINING_REVIEW (ID, DISPLAYNAME, RESTAURANTID, PEANUTSCORE, EGGSCORE, DAIRYSCORE, COMENTARY, STATUS) 
VALUES (1, 'john_doe', 1, 5, 4, NULL, 'Amazing burgers!', 'APPROVED'),
       (2, 'jane_smith', 2, NULL, 3, 4, 'Great vegan options.', 'PENDING'),
       (3, 'mike_johnson', 3, 4, 5, 5, 'Perfect for allergies!', 'APPROVED');
