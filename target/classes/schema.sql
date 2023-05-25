DROP TABLE IF EXISTS prices;

CREATE TABLE prices (
                        PRICE_LIST INT AUTO_INCREMENT  PRIMARY KEY,
                        BRAND_ID int NOT NULL,
                        START_DATE timestamp NOT NULL,
                        END_DATE timestamp NOT NULL,
                        PRODUCT_ID VARCHAR(10) NOT NULL,
                        PRIORITY int NOT NULL,
                        PRICE decimal(13,3) NOT NULL,
                        CURR VARCHAR(3) NOT NULL

);
