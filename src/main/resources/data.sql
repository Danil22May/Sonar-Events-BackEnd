/* ADMIN TABLE */

INSERT INTO admins (email, password, role) 
VALUES ('sonarevents@gmail.com', '$2a$12$CpLpmTSK3LqKcVcD/wJaj.URGybXR0fCtLnNynPvwlNQDJT8NGH.O', 'ROLE_ADMIN');

/* USERS TABLE */
INSERT INTO users (email, password, role) VALUES
('user2@example.com', 'password456', 'ROLE_USER');
/*EVENTS TABLE */

INSERT INTO events (title, date, available, past, max_participants, registered_participants, description, image) VALUES
('Concierto de Rock', '2024-09-15 20:00:00', TRUE, FALSE, 100, 25, 'Un emocionante concierto de rock con varias bandas locales.', 'rock_concierto.jpg'),
('Festival de Música Electrónica', '2024-09-20 22:00:00', TRUE, FALSE, 500, 450, 'Un festival con los mejores DJs de la escena electrónica.', 'electronica_festival.jpg'),
('Concierto de Música Clásica', '2024-12-12 20:00:00', TRUE, FALSE, 200, 150, 'Una noche con las obras maestras de la música clásica.', 'musica_clasica.jpg');

/* EMAIL TABLE */