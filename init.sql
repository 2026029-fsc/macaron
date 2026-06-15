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