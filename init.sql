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
  id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(100)    NOT NULL,
  email         VARCHAR(254)    NOT NULL  UNIQUE,
  password      VARCHAR(255)    NOT NULL,
  address       VARCHAR(100)    NOT NULL,
  phone_number  BIGINT NOT NULL,
  payment       VARCHAR(100)    NOT NULL,
  price_range   INT,
  genre         VARCHAR(100)    NOT NULL,
  coupon        VARCHAR(1000),
  free_desc     VARCHAR(1000)
);

CREATE TABLE Sale(
  id            INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
  store_id      INT             NOT NULL,
  name          VARCHAR(100)    NOT NULL,
  contents      VARCHAR(1000)   NOT NULL,
  FOREIGN KEY (store_id)   REFERENCES Store(id)
);

CREATE TABLE Suddensale(
  id            INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
  store_id      INT,
  name          VARCHAR(100)    NOT NULL,
  contents      VARCHAR(1000)   NOT NULL,
  completed     BOOLEAN         NOT NULL,
  FOREIGN KEY (store_id)  REFERENCES Store(id)
);

CREATE TABLE StoreReview(
  id            INT             NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
VALUES('2026015@fsc-educ.com', 'Hotoshock', 'hanayamakaoru', FALSE), 
  -- komokatatakahiro
  ('2026029@fsc-educ.com', '菰方貴大', 'doppoorochi', FALSE),
  -- mukaedamasayoshi
  ('2026056@fsc-educ.com', '愚地独歩', 'hannmabaki', FALSE);
  -- nishiyamaryuushin



INSERT INTO Store (name, email, password, address, phone_number, payment, genre, coupon)
VALUE('エンポリオ', 'komokata@example.com', 'burningdownthehouse','福岡県福岡市博多区大字下臼井778-1', '0123456789','現金', 'イタリアン', '店内全品5%off'),
  -- takahirokomokata
  ('宇治抹茶専門店　MIDORI', 'mukaeda@example.com', 'teasweets','東京都大田区羽田空港3-4-2', '0120222222','現金', 'スイーツ', '宇治抹茶ドリンク1杯サービス'),
  -- masayoshimukaeda
  ('SUTYA SUTYARI', 'nishiyama@example.com', 'glassesclush','Westminister, London SW1A 0AA, United Kingdom', '0120333333','クレジットカード', '野菜', '10%off');
  -- ryuushinnnishiyama



INSERT INTO Sale(store_id, name, contents)
  VALUE(1, 'ハッピーアワー16時から18時', 'ビール299円！ハイボール199円！'),
  (2, '早朝価格全品50円引き', 'ドリンク290円'),
  (3, '夕方2時間タイムセール', '対象商品20%off');



INSERT INTO Suddensale(store_id, name, contents, completed)
  VALUE(1, '5000円コース→4700円で提供！', '6名様キャンセル出ました！普段5000円のコースを4700円で提供します！', FALSE),
  (2, '8名様キャンセル出ました', '8名分のキャンセルが出たのでお席空いてます。コーヒーサービスします！', FALSE),
  (3, 'ホークスリーグ優勝おめでとうセール', '店内対象商品890円引き', FALSE);



INSERT INTO StoreReview(store_id, comments,  evaluation, user_id)
  VALUE(1, '非常においしい', TRUE, 3),
  (2, '抹茶好きにはうれしい！おいしかった！', TRUE, 2),
  (3, '海外に初めてきたが、まぁまぁな味。イギリスにきたなら食べてもいい。', FALSE, 1);

-- =============================================================================