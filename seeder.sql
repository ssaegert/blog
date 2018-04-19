use blog;

INSERT INTO posts(title, body) VALUES
  ('Post 1', 'Post 1 Description'),
  ('Post 2', 'Post 2 Description'),
  ('Post 3', 'Post 3 Description'),
  ('Post 4', 'Post 4 Description'),
  ('Post 5', 'Post 5 Description'),
  ('Post 6', 'Post 6 Description'),
  ('Post 7', 'Post 7 Description');

insert into categories(category)
VALUES ('RPG'),
  ('Puzzle'),
  ('Fighting'),
  ('Shooter'),
  ('Simulation'),
  ('Strategy'),
  ('Racing'),
  ('Sports'),
  ('Party Game'),
  ('Trivia');

update ads
set category = 'Simulation' where id = 1;
