SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `user_product`;
DROP TABLE IF EXISTS `product_category`;
DROP TABLE IF EXISTS `payment`;
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user`;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `user` (
                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                        `tsid` VARCHAR(255) NOT NULL,
                        `email` VARCHAR(255) NOT NULL,
                        `nickname` VARCHAR(255) NOT NULL,
                        `phone_number` VARCHAR(20),
                        `merchant_name` VARCHAR(255),
                        `merchant_address` VARCHAR(255),
                        `company_registration_number` VARCHAR(255),
                        `created_time` DATETIME NOT NULL,
                        `update_time` DATETIME NOT NULL,
                        UNIQUE INDEX `idx_user_tsid` (`tsid`)
);

CREATE TABLE `category` (
                            `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                            `tsid` VARCHAR(255) NOT NULL,
                            `name` VARCHAR(255) NOT NULL,
                            `parent_id` BIGINT,
                            `created_time` DATETIME NOT NULL,
                            `update_time` DATETIME NOT NULL,
                            UNIQUE INDEX `idx_category_tsid` (`tsid`),
                            FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`) ON DELETE SET NULL
);

CREATE TABLE `product` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `tsid` VARCHAR(255) NOT NULL,
                           `name` VARCHAR(255) NOT NULL,
                           `retail_price` DECIMAL(10,2) NOT NULL,
                           `sold_price` DECIMAL(10,2) NOT NULL,
                           `discount_rate` DECIMAL(5,2),
                           `category_id` BIGINT,
                           `created_time` DATETIME NOT NULL,
                           `update_time` DATETIME NOT NULL,
                           UNIQUE INDEX `idx_product_tsid` (`tsid`),
                           FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE SET NULL
);

CREATE TABLE `user_product` (
                                `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                `tsid` VARCHAR(255) NOT NULL,
                                `user_id` BIGINT NOT NULL,
                                `product_id` BIGINT NOT NULL,
                                `created_time` DATETIME NOT NULL,
                                `update_time` DATETIME NOT NULL,
                                UNIQUE INDEX `idx_user_product_tsid` (`tsid`),
                                FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
                                FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);

CREATE TABLE `product_category` (
                                    `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    `tsid` VARCHAR(255) NOT NULL,
                                    `product_id` BIGINT NOT NULL,
                                    `category_id` BIGINT NOT NULL,
                                    `created_time` DATETIME NOT NULL,
                                    `update_time` DATETIME NOT NULL,
                                    UNIQUE INDEX `idx_product_category_tsid` (`tsid`),
                                    FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
                                    FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
);

CREATE TABLE `payment` (
                           `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                           `tsid` VARCHAR(255) NOT NULL,
                           `amount` DECIMAL(10,2) NOT NULL,
                           `payment_time` DATETIME NOT NULL,
                           `user_id` BIGINT NOT NULL,
                           `create_time` DATETIME NOT NULL,
                           `update_time` DATETIME NOT NULL,
                           UNIQUE INDEX `idx_payment_tsid` (`tsid`),
                           FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
);

CREATE TABLE `inventory` (
                             `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                             `tsid` VARCHAR(255) NOT NULL,
                             `quantity` INT NOT NULL,
                             `location` VARCHAR(255),
                             `inventory_status` VARCHAR(50) NOT NULL,
                             `received_time` DATETIME NOT NULL,
                             `create_time` DATETIME NOT NULL,
                             `update_time` DATETIME NOT NULL,
                             UNIQUE INDEX `idx_inventory_tsid` (`tsid`)
);
