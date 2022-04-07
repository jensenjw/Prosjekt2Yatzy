DROP SCHEMA IF EXISTS yatzy CASCADE;
CREATE SCHEMA yatzy;
SET search_path = yatzy;
-- An overview of all registered players
CREATE TABLE player
(
   playerId SERIAL,
   username VARCHAR (20),
   password CHAR (96), -- (16 salt + 32 hash) * 2 chars
   name VARCHAR (10),
   email VARCHAR (20),
   lobbyId INTEGER,
   warnings INTEGER,
   PRIMARY KEY (playerId)
);
-- A single lobby that consists of all the players in the lobby
CREATE TABLE lobby
(
   lobbyId SERIAL,
   lobbyname VARCHAR(40) UNIQUE,
   owner INTEGER,
   PRIMARY KEY (lobbyId),
   FOREIGN KEY (owner) REFERENCES player (playerId)
);
-- A single players scoreCard, When a player joins a lobby, the scorecard is generated
CREATE TABLE scoreCard
(
   playerId INTEGER,
   ones INTEGER,
   --enere
   twos INTEGER,
   --toere
   threes INTEGER,
   --treere
   fours INTEGER,
   --firere
   fives INTEGER,
   --femere
   sixes INTEGER,
   --seksere
   bonus INTEGER,
   --bonus
   one_pair INTEGER,
   --ett par
   two_pairs INTEGER,
   --to par
   three_of_a_kind INTEGER,
   --tre like
   four_of_a_kind INTEGER,
   --fire like
   small_straight INTEGER,
   --liten straight
   big_straight INTEGER,
   --stor straight
   full_house INTEGER,
   --hus
   chance INTEGER,
   --sjanse
   yatzy INTEGER,
   --yatzy
   PRIMARY KEY (playerId),
   FOREIGN KEY (playerId) REFERENCES player (playerId)
);

ALTER TABLE player
ADD FOREIGN KEY (lobbyId) REFERENCES lobby(lobbyId)