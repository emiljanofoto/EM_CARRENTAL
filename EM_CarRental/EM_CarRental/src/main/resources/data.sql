

INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_MANAGER');
INSERT INTO role VALUES (3, 'ROLE_ADMIN');

INSERT INTO user (id, name, last_name, user_name, password, email, phone) VALUES (1, 'Admin', 'Account', 'admin', '$2a$10$s1fmnDqE9kYXOE6mid7IJ.tqzOQ/mDMvdbhKdm77NV25OgZ7t.kUa', 'admin123@o2.com', 999888777);
INSERT INTO user (id, name, last_name, user_name, password, email, phone) VALUES (2, 'Manager', 'Account', 'manager', '$2a$10$.AGeULinzfBhNsNxbl4nwOCDysbPZVSRC617jGxJtsWuXld8nlVyG', 'manager123@o2.com', 786403880);
INSERT INTO user (id, name, last_name, user_name, password, email, phone) VALUES (3, 'User', 'Account', 'user', '$2a$10$CKST7pzGTBUWSz3pQUbFHO/8Dkj.pXlUr00sNGO39Z2YpzsGu5kJO', 'user123@o2.com', 687003254);

INSERT INTO user_role VALUES (1,1), (1,2), (1,3), (2,1), (2,2), (3,1);

INSERT INTO car_package (id, package_name, price_per_day) VALUES (1, 'Ordinary', 100);
INSERT INTO car_package (id, package_name, price_per_day) VALUES (2, 'Sporty', 300);
INSERT INTO car_package (id, package_name, price_per_day) VALUES (3, 'Luxury', 500);

INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (1, 'PETROL', 'SUV', 3);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (1, Ford, Escort, Blue, 2015, true, 1, 1);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (2, 'DIESEL', 'Sport', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (2, 'BMW', 'M3', 'Black', 2018, true, 2, 2);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (3, 'PETROL', 'Convertible', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (3, 'Audi', 'A5', 'Red', 2019, true, 3, 3);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (4, 'ELECTRIC', 'Coupe', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (4, 'Tesla', 'Model S', 'White', 2020, true, 1, 4);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (5, 'LPG', 'Sedan', 4);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (5, 'Toyota', 'Camry', 'Silver', 2017, true, 2, 5);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (6, 'PETROL', 'SUV', 5);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (6, 'Jeep', 'Wrangler', 'Green', 2021, true, 3, 6);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (7, 'DIESEL', 'Sport', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (7, 'Mercedes-Benz', 'C-Class', 'Blue', 2016, true, 1, 7);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (8, 'ELECTRIC', 'Convertible', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (8, 'Porsche', '911', 'Yellow', 2022, true, 2, 8);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (9, 'LPG', 'Sedan', 4);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (9, 'Honda', 'Accord', 'White', 2019, true, 3, 9);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (10, 'PETROL', 'Coupe', 2);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (10, 'Chevrolet', 'Camaro', 'Red', 2018, true, 1, 10);
INSERT INTO car_category (id, fuel_type, body_type, number_of_doors) VALUES (11, 'DIESEL', 'SUV', 5);
INSERT INTO car (id, brand, model, color, year, is_available, car_package_id, car_category_id) VALUES (11, 'Land Rover', 'Range Rover', 'Black', 2020, true, 2, 11);