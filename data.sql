INSERT INTO incident (type, location, severity, status, date_time) VALUES
('Accident', '123 Main St', 'High', 'Active', '2025-05-09 10:00:00'),
('Crime', '456 Elm St', 'Medium', 'Resolved', '2025-05-08 15:30:00');

INSERT INTO personnel (name, role) VALUES
('John Doe', 'Officer'),
('Jane Smith', 'Medic');

INSERT INTO response_unit (type, status, arrival_time) VALUES
('Ambulance', 'Available', NULL),
('Fire Truck', 'Assigned', '2025-05-09 10:15:00');