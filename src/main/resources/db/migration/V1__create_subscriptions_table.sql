CREATE TABLE subscriptions (
       id          BIGINT AUTO_INCREMENT PRIMARY KEY,
       user_sub    VARCHAR(255)        NOT NULL,
       name        VARCHAR(255)        NOT NULL,
       price       DECIMAL(10,2)       NOT NULL,
       category    ENUM('gaming','streaming','learning','ai','phone','storage'),
       priority    ENUM('worth','not_worth'),
       created_at  TIMESTAMP           DEFAULT CURRENT_TIMESTAMP,
       updated_at  TIMESTAMP           DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);