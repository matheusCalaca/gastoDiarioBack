CREATE TABLE IF NOT EXISTS GASTO
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id      BIGINT       NOT NULL,
    nome         VARCHAR(255) NOT NULL,
    valor        DECIMAL(10,2)       NOT NULL,
    data_compra   DATE         NOT NULL,
    categoria_id BIGINT       NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (categoria_id) REFERENCES categoria (id)
);

