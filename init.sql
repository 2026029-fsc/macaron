  CREATE DATABASE dotachan;

  USE dotachan;

  CREATE TABLE User(
    id VARCHAR(254) NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    reviewed BOOLEAN NOT NULL
  );
      INSERT INTO User (id, name, password, reviewed)
    VALUES('komo@com', 'komo', 'komo', TRUE),
    ('masa@com', 'masa', 'masa', FALSE),
    ('nishi@com', 'nishi', 'nishi', TRUE);

    CREATE TABLE Store(
   id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(254) NOT NULL,
   password VARCHAR(30) NOT NULL,
   address VARCHAR(100)NOT NULL,
   phone_number INT NOT NULL,
   payment VARCHAR(100) NOT NULL,
   price_range INT,
   genre VARCHAR(100) NOT NULL,
   coupon VARCHAR(1000),
   free_desc VARCHAR(1000)
  );
    INSERT INTO Store (name, email, password, address, phone_number, payment, genre)
  VALUE('こもかた', 'komo@example.com', 'takahiro','福岡県', '0120444444','現金', '海鮮'),
  ('むかえだ', 'masa@example.com', 'masayosi','佐賀県', '0120444445','現金', '肉'),
  ('にしやま', 'nishi@example.com', 'ryuushinn','福岡県', '0120444446','paypay', '野菜');

  CREATE TABLE Sale(
    store_id INT           NOT NULL,
    name     VARCHAR(100)  NOT NULL,
    contents VARCHAR(1000) NOT NULL,
    FOREIGN KEY (store_id)   REFERENCES Store(id)
  );
    INSERT INTO Sale(store_id, name, contents)
  VALUE(2, 'タイムセール', '一割武器'),
  (3, 'ハッピーアワー', 'ドリンク290円'),
  (4, '夕方セール', '対象商品20%off');

   CREATE TABLE Suddensale(
    store_id INT,
    name VARCHAR(100) NOT NULL,
    contents VARCHAR(1000) NOT NULL,
    completed BOOLEAN NOT NULL,
    FOREIGN KEY (store_id)  REFERENCES Store(id)
  );
    INSERT INTO Suddensale(store_id, name, contents, completed)
  VALUE(2, '余った', '余りました助けて', FALSE),
  (3, 'ドタキャン', '助けて', FALSE),
  (4, '終わりや', 'あかん', FALSE);

  CREATE TABLE StoreReview(
    store_id INT,
    comments VARCHAR(1000) NOT NULL,
    evaluation BOOLEAN NOT NULL,
    user_id VARCHAR(254) NOT NULL,
    FOREIGN KEY (store_id)  REFERENCES Store(id),
    FOREIGN KEY (user_id)  REFERENCES User(id)
  );
  INSERT INTO StoreReview(store_id, comments,  evaluation, user_id)
  VALUE(2, 'まず', FALSE, 'nishi@com'),
  (3, 'いいね', TRUE, 'masa@com'),
  (4, 'うま', TRUE, 'komo@com');

  SHOW TABLE;
