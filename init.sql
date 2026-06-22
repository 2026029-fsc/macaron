-- =============================================================================
-- dotachan サンプルデータベース
--
-- 主にINSERTで追加するものとし、SELECT等でJdbcに出力することを想定。
--
-- =============================================================================

SET NAMES utf8mb4;
  
DROP DATABASE IF EXISTS dotachan;
CREATE DATABASE dotachan DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

USE dotachan;


-- テーブル =====================================================================

CREATE TABLE User(
  id        INT           NOT NULL    AUTO_INCREMENT    PRIMARY KEY,
  mail      VARCHAR(254)  NOT NULL    UNIQUE,
  name      VARCHAR(30)   NOT NULL,
  password  VARCHAR(255)  NOT NULL,
  reviewed  BOOLEAN       NOT NULL
);

CREATE TABLE Store(
  id            INT             NOT NULL    AUTO_INCREMENT    PRIMARY KEY,
  name          VARCHAR(100)    NOT NULL,
  email         VARCHAR(254)    NOT NULL    UNIQUE,
  password      VARCHAR(255)    NOT NULL,
  address       VARCHAR(100)    NOT NULL,
  phone_number  BIGINT          NOT NULL,
  payment       VARCHAR(100)    NOT NULL,
  price_range   INT,
  genre         VARCHAR(100)    NOT NULL,
  coupon        VARCHAR(1000),
  free_desc     VARCHAR(1000)
);

CREATE TABLE Sale(
  id            INT             NOT NULL    AUTO_INCREMENT    PRIMARY KEY,
  store_id      INT             NOT NULL,
  name          VARCHAR(100)    NOT NULL,
  contents      VARCHAR(1000)   NOT NULL,
  FOREIGN KEY (store_id)   REFERENCES Store(id)
);

CREATE TABLE Suddensale(
  id            INT             NOT NULL    AUTO_INCREMENT    PRIMARY KEY,
  store_id      INT,
  name          VARCHAR(100)    NOT NULL,
  contents      VARCHAR(1000)   NOT NULL,
  completed     BOOLEAN         NOT NULL,
  FOREIGN KEY (store_id)  REFERENCES Store(id)
);

CREATE TABLE StoreReview(
  id            INT             NOT NULL    AUTO_INCREMENT    PRIMARY KEY,
  store_id      INT,
  comments      VARCHAR(1000)   NOT NULL,
  evaluation    BOOLEAN         NOT NULL,
  user_id       INT             NOT NULL,
  FOREIGN KEY (store_id)  REFERENCES Store(id),
  FOREIGN KEY (user_id)  REFERENCES User(id)
);

-- =============================================================================


-- サンプル投入 =================================================================

INSERT INTO User (mail, name, password, reviewed)
VALUES('komo@com', 'komo', '$2y$10$KyVGOWdiYzM20FelSjynGefbVigdTviw4ZkbGE/JotuKe3MjiOia.', TRUE), 
  -- komokatatakahiro
  ('masa@com', 'masa', '$2y$10$oRIrthmAt1fIomV/Lt.pBeC1LDQ46.mAra7FOcfPMngupPRrzvqzm', FALSE),
  -- mukaedamasayoshi
  ('nishi@com', 'nishi', '$2y$10$rsFA7/2tSllqZkYFa/oTiurOCJTMYfPFuqXkcM96pLMVxn8vbYAXW', TRUE);
  -- nishiyamaryuushin



INSERT INTO Store (name, email, password, address, phone_number, payment, genre)
VALUE('こもかた', 'komo@example.com', '$2y$10$59st1xNeyQUQ3Uup5V2LT.t6/nP1CgrOevMN2MbD6RGgLpxXWjVay','福岡県', '0120444444','現金', '海鮮'),


INSERT INTO Store (name, email, password, address, phone_number, payment, genre)
VALUE('こもかた', 'komo@example.com', '$2y$10$59st1xNeyQUQ3Uup5V2LT.t6/nP1CgrOevMN2MbD6RGgLpxXWjVay','福岡県', '0120444444','現金', '海鮮'),
  -- takahirokomokata
  ('むかえだ', 'masa@example.com', '$2y$10$2Y3eRJuXHlXw3/aqomj1Re92Yflz89gIwaPLbvsXw1/rIZv2WlwAW','佐賀県', '0120444445','現金', '肉'),
  -- masayoshimukaeda
  ('にしやま', 'nishi@example.com', '$2y$10$UdEiioBDH.U1cj5sRYdiqOHbbxA.zkyKof3lwUAZ1hsn8UjQ2g9B6','福岡県', '0120444446','paypay', '野菜');
  -- ryuushinnnishiyama



INSERT INTO Sale(store_id, name, contents)


INSERT INTO Sale(store_id, name, contents)
  VALUE(1, 'タイムセール', '一割引き'),
  (2, 'ハッピーアワー', 'ドリンク290円'),
  (3, '夕方セール', '対象商品20%off');



INSERT INTO Suddensale(store_id, name, contents, completed)


INSERT INTO Suddensale(store_id, name, contents, completed)
  VALUE(1, '余った', '余りました助けて', FALSE),
  (2, 'ドタキャン', '助けて', FALSE),
  (3, '終わり', 'むり', FALSE);



INSERT INTO StoreReview(store_id, comments,  evaluation, user_id)
  VALUE(1, 'まず', FALSE, 3),
  (2, 'いいね', TRUE, 2),
  (3, 'うま', TRUE, 1);

-- =============================================================================
