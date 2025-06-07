BEGIN TRANSACTION;
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password_hash VARCHAR(255) NOT NULL,
                       full_name VARCHAR(100) NOT NULL,
                       created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       is_seller BOOLEAN NOT NULL DEFAULT FALSE
);
-- Продавцы (расширение пользователей)
CREATE TABLE sellers (
                         seller_id SERIAL PRIMARY KEY,
                         user_id INT NOT NULL UNIQUE REFERENCES users(user_id) ON DELETE CASCADE,
                         company_name VARCHAR(100),
                         tax_id VARCHAR(30),
                         bank_details TEXT
);
-- Категории товаров
CREATE TABLE categories (
                            category_id SERIAL PRIMARY KEY,
                            name VARCHAR(50) NOT NULL UNIQUE,
                            parent_id INT REFERENCES categories(category_id) ON DELETE SET NULL
);
-- Товары
CREATE TABLE products (
                          product_id SERIAL PRIMARY KEY,
                          seller_id INT NOT NULL REFERENCES sellers(seller_id) ON DELETE CASCADE,
                          category_id INT NOT NULL REFERENCES categories(category_id) ON DELETE RESTRICT,
                          title VARCHAR(200) NOT NULL,
                          description TEXT,
                          price NUMERIC(10,2) NOT NULL CHECK (price > 0),
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          stock_quantity INT NOT NULL CHECK (stock_quantity >= 0) DEFAULT 0,
                          is_active BOOLEAN NOT NULL DEFAULT TRUE
);
-- Заказы
CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id INT NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
                        status VARCHAR(20) NOT NULL DEFAULT 'PENDING' CHECK (
                            status IN ('PENDING', 'PAID', 'SHIPPED', 'DELIVERED', 'CANCELLED')
                            ),
                        total_amount NUMERIC(12,2) NOT NULL,
                        created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- Элементы заказа
CREATE TABLE order_items (
                             order_item_id SERIAL PRIMARY KEY,
                             order_id INT NOT NULL REFERENCES orders(order_id) ON DELETE CASCADE,
                             product_id INT NOT NULL REFERENCES products(product_id) ON DELETE RESTRICT,
                             quantity INT NOT NULL CHECK (quantity > 0),
                             price NUMERIC(10,2) NOT NULL CHECK (price > 0)
);
-- Отзывы
CREATE TABLE reviews (
                         review_id SERIAL PRIMARY KEY,
                         product_id INT NOT NULL REFERENCES products(product_id) ON DELETE CASCADE,
                         user_id INT NOT NULL REFERENCES users(user_id) ON DELETE CASCADE,
                         rating SMALLINT NOT NULL CHECK (rating BETWEEN 1 AND 5),
                         comment TEXT,
                         created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         UNIQUE(product_id, user_id)
);
-- Платежи
CREATE TABLE payments (
                          payment_id SERIAL PRIMARY KEY,
                          order_id INT NOT NULL UNIQUE REFERENCES orders(order_id) ON DELETE CASCADE,
                          amount NUMERIC(12,2) NOT NULL,
                          method VARCHAR(20) NOT NULL CHECK (method IN ('CARD', 'PAYPAL', 'APPLE_PAY')),
                          transaction_id VARCHAR(100) NOT NULL UNIQUE,
                          status VARCHAR(20) NOT NULL CHECK (status IN ('PENDING', 'COMPLETED', 'FAILED')),
                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
END TRANSACTION;

BEGIN TRANSACTION;
CREATE INDEX idx_products_title ON products USING gin(to_tsvector('english', title));
CREATE INDEX idx_orders_user ON orders(user_id);
CREATE INDEX idx_reviews_product ON reviews(product_id);
END TRANSACTION;