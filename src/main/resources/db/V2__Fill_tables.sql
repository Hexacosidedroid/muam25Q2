BEGIN TRANSACTION;
-- Очистка таблиц (выполнить при необходимости)
-- TRUNCATE TABLE payments, order_items, reviews, orders, products, categories, sellers, users RESTART IDENTITY;

-- 1. Пользователи
INSERT INTO users (email, password_hash, full_name, is_seller) VALUES
                                                                   ('alex.petrov@mail.ru', '5f4dcc3b5aa765d61d8327deb882cf99', 'Алексей Петров', false),
                                                                   ('ekaterina.ivanova@gmail.com', '482c811da5d5b4bc6d497ffa98491e38', 'Екатерина Иванова', true),
                                                                   ('dmitry.sokolov@yandex.ru', '9f86d081884c7d659a2feaa0c55ad015', 'Дмитрий Соколов', false),
                                                                   ('olga.kuznetsova@mail.com', '5e884898da28047151d0e56f8dc62927', 'Ольга Кузнецова', true),
                                                                   ('maxim.volkov@bk.ru', '25d55ad283aa400af464c76d713c07ad', 'Максим Волков', false)
    ON CONFLICT DO NOTHING;

-- 2. Продавцы
INSERT INTO sellers (user_id, company_name, tax_id, bank_details) VALUES
                                                                      (2, 'TechGadgets LLC', '7701123456', 'Сбербанк: 40817810200000012345'),
                                                                      (4, 'HomeComfort Ltd', '7715987654', 'Тинькофф: 40702810500000098765')
    ON CONFLICT DO NOTHING;

-- 3. Категории
INSERT INTO categories (name, parent_id) VALUES
                                             ('Электроника', NULL),
                                             ('Бытовая техника', NULL),
                                             ('Компьютеры', 1),
                                             ('Смартфоны', 1),
                                             ('Холодильники', 2)
    ON CONFLICT DO NOTHING;

-- 4. Товары
INSERT INTO products (seller_id, category_id, title, description, price, stock_quantity) VALUES
                                                                                             (1, 3, 'Ноутбук ASUS VivoBook', '15.6" Full HD, Intel Core i5, 8GB RAM, 512GB SSD', 64999.99, 15),
                                                                                             (1, 4, 'Смартфон Xiaomi Redmi Note 12', '6.67" AMOLED, Snapdragon 685, 128GB', 21999.00, 30),
                                                                                             (2, 5, 'Холодильник Beko RCNA400K20W', 'No Frost, 381 л, класс A+', 45990.00, 8),
                                                                                             (1, 3, 'Игровая мышь Logitech G502', '11 программируемых кнопок, RGB подсветка', 5990.00, 42),
                                                                                             (2, 2, 'Кофеварка Bosch TKA3A034', 'Капучинатор, 1350 Вт, черный', 12990.00, 12),
                                                                                             (2, 5, 'Стиральная машина LG F2J6HS0W', 'Загрузка 8 кг, паровая обработка', 37990.00, 5)
    ON CONFLICT DO NOTHING;

-- 5. Заказы
INSERT INTO orders (user_id, status, total_amount) VALUES
                                                       (1, 'DELIVERED', 86998.99),
                                                       (3, 'SHIPPED', 5990.00),
                                                       (5, 'PAID', 37990.00),
                                                       (1, 'PENDING', 21999.00)
    ON CONFLICT DO NOTHING;

-- 6. Элементы заказа
INSERT INTO order_items (order_id, product_id, quantity, price) VALUES
                                                                    (1, 1, 1, 64999.99),
                                                                    (1, 2, 1, 21999.00),
                                                                    (2, 4, 1, 5990.00),
                                                                    (3, 6, 1, 37990.00),
                                                                    (4, 2, 1, 21999.00)
    ON CONFLICT DO NOTHING;

-- 7. Отзывы
INSERT INTO reviews (product_id, user_id, rating, comment) VALUES
                                                               (1, 1, 5, 'Отличный ноутбук, работает без нареканий'),
                                                               (2, 1, 4, 'Хороший телефон за свои деньги, но батарея держит недолго'),
                                                               (4, 3, 5, 'Лучшая игровая мышь, которую я использовал!'),
                                                               (3, 5, 3, 'Холодильник хороший, но шумноват'),
                                                               (6, 5, 4, 'Стирает чисто, но интерфейс сложноват')
    ON CONFLICT DO NOTHING;

-- 8. Платежи
INSERT INTO payments (order_id, amount, method, transaction_id, status) VALUES
                                                                            (1, 86998.99, 'CARD', 'txn_20230604123456', 'COMPLETED'),
                                                                            (2, 5990.00, 'CARD', 'txn_20230604567890', 'COMPLETED'),
                                                                            (3, 37990.00, 'APPLE_PAY', 'txn_20230604987654', 'COMPLETED')
    ON CONFLICT DO NOTHING;
END TRANSACTION;