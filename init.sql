CREATE TABLE questions (
  id         BIGINT       AUTO_INCREMENT PRIMARY KEY,
  title      VARCHAR(255) NOT NULL,
  body       TEXT         NOT NULL,
  created_at DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO questions (title, body) VALUES
  ('Spring Boot で MySQL に接続するには？', 'application.properties に何を書けばよいですか。'),
  ('Docker Compose で MySQL を起動したい', 'compose.yaml の書き方を教えてください。');

  CREATE DATABASE dotachan;
  USE dotachan;
  CREATE TABLE User(
    id VARCHAR(50) NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    reviewed BOOLEAN NOT NULL
  );

    CREATE TABLE Store(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(30) NOT NULL,
   address VARCHAR(100)NOT NULL,
   phone_range INT NOT NULL,
   payment VARCHAR(100) NOT NULL,
   price_range INT,
   genre VARCHAR(100) NOT NULL,
   coupon VARCHAR(1000),
   free_desc VARCHAR(1000)
  );

  CREATE TABLE Sale(
    store_id INT           NOT NULL,
    name     VARCHAR(100)  NOT NULL,
    contents VARCHAR(1000) NOT NULL,
    FOREIGN KEY (store_id)   REFERENCES Store(id)
  );

   CREATE TABLE Suddensale(
    store_id INT,
    name VARCHAR(100) NOT NULL,
    contents VARCHAR(1000) NOT NULL,
    completed BOOLEAN NOT NULL,
    FOREIGN KEY (store_id)  REFERENCES Store(id)
  );

  CREATE TABLE StoreReview(
    store_id INT,
    comments VARCHAR(1000) NOT NULL,
    evaluation BOOLEAN NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (store_id)  REFERENCES Store(id),
    FOREIGN KEY (user_id)  REFERENCES User(id)
  );
  SHOW TABLES;
