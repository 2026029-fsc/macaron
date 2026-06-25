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
VALUE('2026015@fsc-educ.com', 'Hotoshock', '$2a$10$q7QnuI5FBO/LIwJZIXIc8eMXuqHh4zgATd7.VatCRX3GR4FqzXHb.', FALSE), 
  -- K1dF7xM26
  ('2026029@fsc-educ.com', '菰方貴大', '$2a$10$ZomjzB.Y7Jmj911d4zLjye1o5NUx9UKvRxeG3ZS9KohV2fY0Ig0bG', FALSE),
  -- doppoorochi
  ('2026056@fsc-educ.com', '愚地独歩', '$2a$10$o4dTynx6Z.A1h.Maj1sXPewfK.0STodu8SlMLsPL2Xd4fNYzKZiOq', FALSE),
  -- nishiyamadady
  ('2026042@fsc-educ.com', '岩本 剛', '$2a$10$GX2M13PseH64WulUReq5nuxDefIcH9kmDX9XHYpQFBr8C./0CwY5G', FALSE),
  -- doraemonjaian
  ('2026088@fsc-educ.com', '烈海王', '$2a$10$HOzCxAuVkJVHsMPf7Glb2OU6C4tLxAd.Li1KMmBEveHxtdTCC2RNS', TRUE),
  -- shorinjikenpo
  ('2026011@fsc-educ.com', '淵上 拓海', '$2a$10$0nuvkwiWOyGK756WDRX/mOMxM3gTKPOn0T/eU36jPxFWJ3G/LGaUa', FALSE),
  -- shibukawa01
  ('2026001@fsc-educ.com', '範馬勇次郎', '$2a$10$nGM6qRMHyZ9.wLO4oBiuNuIoBu1EUsinscs/tEdgfvn.sEiECWsZ6', TRUE),
  -- ogre_strongest
  ('2026035@fsc-educ.com', '今岡 蓮', '$2a$10$0.VJux875ILPntyKWpLd.OCJMhNq75Wa.6RWVOII74tiFHvXG/lPK', FALSE);
  -- baki0624



INSERT INTO Store (name, email, password, address, phone_number, payment, genre, coupon)
VALUE('エンポリオ', 'komokata@example.com', '$2a$10$aNH0ujgx55PqbsX9zUjUi.0m1CKrCex.vUua8rM03jlyV5NQw7Cue','福岡県福岡市博多区大字下臼井778-1', '0123456789','現金', 'イタリアン', '店内全品5%off'),
  -- takahirokomokata---burningdownthehouse
  ('宇治抹茶専門店　MIDORI', 'mukaeda@example.com', '$2a$10$BLf6rd/eAIx.k1m4HiPNquzjnpziWNlsEKhP.QXr0Vn.CJl.JYED2','東京都大田区羽田空港3-4-2', '0120222222','現金', 'カフェ', '宇治抹茶ドリンク1杯サービス'),
  -- masayoshimukaeda---teasweets
  ('SUTYA SUTYARI', 'nishiyama@example.com', '$2a$10$rpB8DdI4Xlfb3DTH6O8JyO3kaTI7JMNIz4O01IrBuCE2.3WKl.CQ.','Westminister, London SW1A 0AA, United Kingdom', '0120333333','クレジットカード', '野菜', '10%off'),
  -- ryuushinnnishiyama---glassesclush
  ('博多もつ鍋処 まかろん', 'macaron_hakata@example.com', '$2a$10$964lRkTqjRsP0UVqZ2ruSuN2rUMuN7TWtoTwKDqLE9lhS55rWz14O', '福岡県福岡市博多区中洲5丁目2-1', '0921234567', 'クレジットカード・電子マネー・現金', '居酒屋', 'ドタチャン限定：お好きなトッピング1品無料'),
  -- sweetstew2026
  ('極濃豚骨 麺屋オロチ', 'orochi_men@example.com', '$2a$10$HHBvzv7Q4HwBbp2PTUsKZ.uu7B.EihxjKsFcARJLhCtuqrHpb8IDS', '大阪府大阪市北区梅田3丁目1-1', '0698765432', '現金', 'ラーメン', '替玉1玉またはトッピング煮卵無料'),
  -- doppomendou
  ('Cafe Stand BAKI', 'baki_cafe@example.com', '$2a$10$AG6VQi8dloSMbdpIJZGdF.hhqvVYJN0pdXIJXJKJ5LSzjZjLtCzMS', '東京都渋谷区道玄坂2丁目29-1', '0311112222', 'クレジットカード・電子マネー', 'カフェ', 'お会計から10%OFF（他券併用不可）'),
  -- grapplercoffee
  ('本格インドカレー スパイスマサラ', 'masala_spice@example.com', '$2a$10$vGLDeL1OogmZeQ9yDEeFA.fedy1dxE2POActvGqFGUJQT4G5aRy1y', '福岡県福岡市博多区博多駅中央街1-1', '0927778888', '現金・QRコード決済', 'カレー', 'ランチタイム限定：焼きたてナン1枚おかわり無料'),
  -- hotcurry999
  ('STEAK HOUSE HANAYAMA', 'hanayama_sh@example.com', '$2a$10$E3btX87vyqlVMOv7mM88ceUciRV0Brp2N1zK9fzbAbpYORPmMa.nu', '2201 Kalakaua Ave, Honolulu, HI 96815, United States', '18089224422', 'クレジットカード', 'ステーキ', 'Welcome Drink 1杯サービス');
  -- standingchary

INSERT INTO Sale(store_id, name, contents)
  VALUE(1, 'ハッピーアワー16時から18時', 'ビール299円！ハイボール199円！'),
  (2, '早朝価格全品50円引き', 'ドリンク290円'),
  (3, '夕方2時間タイムセール', '対象商品20%off'),
  (4, '【緊急】ドタキャン発生！今すぐ来店で半額', '本日19時予約の10名様キャンセルにつき、もつ鍋コース通常4,500円→2,250円で提供！先着2組様限定。'),
  (5, '【雨の日限定】20時までトッピング全乗せ無料', '現在ゲリラ豪雨のため空席あり！ラーメンご注文の方に、チャーシュー・煮卵・海苔の全乗せ（通常400円相当）を無料サービスします。'),
  (6, '【夜カフェ】21時以降テイクアウト限定半額', '本日焼き上げたクロワッサンとマフィンが対象。店内のフードロス削減にご協力ください！1個200円〜。'),
  (7, '遅めランチ限定！13時〜14時半は100円引き', 'お昼のピークを過ぎた13:00以降のご来店で、全てのカレーセットが100円引き＋ラッシー1杯サービス！'),
  (8, '【数量限定】極上サーロインステーキ30%OFF', '本日限定で特別仕入れのTボーン・サーロインステーキを30%OFFの特別価格でご提供します！無くなり次第終了。');




INSERT INTO Suddensale(store_id, name, contents, completed)
  VALUE(1, '5000円コース→4700円で提供！', '6名様キャンセル出ました！普段5000円のコースを4700円で提供します！', FALSE),
  (2, '8名様キャンセル出ました', '8名分のキャンセルが出たのでお席空いてます。コーヒーサービスします！', FALSE),
  (3, 'ホークスリーグ優勝おめでとうセール', '店内対象商品890円引き', FALSE),
  (4, '【緊急！15名キャンセル】料理代金30%OFF！', '今夜19時半からの団体予約15名様がキャンセルに…。お席が丸ごと空いてしまったため、今からご来店の方は料理全品30%OFFでご提供します！', FALSE),
  (5, '【お席すぐ案内できます】4名様キャンセル', '珍しくテーブル席に4名様のキャンセルが出たため、並ばずにすぐご案内可能です！お詫びとして「味付け玉子」を全員にサービスします！', FALSE),
  (6, '【限定1組】パーティールーム即時開放＆スイーツ付', '本日18時からの女子会プラン（6名様）がドタキャンとなりました。完全個室をすぐにご用意できます。特製デザートプレートを無料でお付けします！', FALSE),
  (7, '【助けてください】お弁当10個キャンセル・半額！', '企業様からご注文いただいた「バターチキンカレー弁当（1,000円）」10個が直前でキャンセルになってしまいました…。1個500円で店頭販売します！', FALSE),
  (8, '【ゲリラ】アビスパ福岡勝利記念！ドリンク全品半額', '地元の試合勝利を祝して、今から本日閉店まで緊急タイムセールを開催！お肉をご注文のお客様は、アルコールを含むドリンク全品を半額にします！', FALSE);



INSERT INTO StoreReview(store_id, comments,  evaluation, user_id)
  VALUE(1, '非常においしい', TRUE, 3),
  (2, '抹茶好きにはうれしい！おいしかった！', TRUE, 2),
  (3, '海外に初めてきたが、まぁまぁな味。イギリスにきたなら食べてもいい。', FALSE, 1),
  (4, 'ドタチャンで15名キャンセルの半額セールを見てダッシュしました！安すぎるし、もつがプリプリで最高に美味しかったです！リピ確定。', TRUE, 4),
  (5, 'ゲリラ豪雨のトッピング無料に惹かれて入店。濃厚な豚骨スープが体に染み渡る！並ばずにこのクオリティが食べられるのは素晴らしい。', TRUE, 5),
  (6, 'コーヒーの香りは悪くないが、男が一人で長居するには少し内装がお洒落すぎる。女子会向けの空間だな。', FALSE, 7),
  (7, '大量キャンセルでお弁当が半額になっていたので購入しました。1000円でも安いレベルの本格バターチキンカレーが500円で買えて大満足です！', TRUE, 6),
  (8, 'アビスパ福岡が勝ったので緊急セールのドリンク半額に釣られて来店（笑）。お肉のボリュームが凄くて、ビールが進みまくりました！', TRUE, 8),
  (6, '新しくオープンしたと聞いて来ました。お店の雰囲気がとても良く、料理も一品一品が丁寧に作られていて大満足です。また来ます！', TRUE, 2),
  (7, '味は悪くないが、混雑していたせいか注文してから料理が出てくるまでに30分以上待たされた。オペレーションを改善してほしい。', FALSE, 3),
  (8, 'ドタチャンがなければ絶対に知らなかった隠れ家的なお店。セールでお得に利用できましたが、通常料金でも通いたいレベルの名店でした！', TRUE, 4),
  (2, 'ここの抹茶パフェは本当に濃厚で定期的に食べたくなります。甘すぎず、お茶の香りがしっかり生きていてお気に入りです。', TRUE, 6),
  (1, 'アプリのタイムセールを見て急いで行ったのに、タッチの差で「ついさっき売り切れました」と言われてショック…。リアルタイムの在庫連動をもっと正確にしてほしい。', FALSE, 8);

-- =============================================================================