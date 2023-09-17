INSERT INTO users(id, full_name, phone_number, email, password, role, is_active)
VALUES (1, 'Admin admin', '+996777112233', 'admin@gmail.com', '$2a$10$iSq3c1O3JLk8rCmvQrVyLOzF9gxv0yzKo9GWnkWYhd4nvM54GCt0a', 'ADMIN', TRUE),
       (2, 'User user', '+996777112233', 'user@gmail.com', '$2a$10$MG6yAfmkPH8HcrhWgzHfqOb9tf9ecCCNkjO3BhKZSWxgRu2zYvnUy', 'USER', TRUE);

INSERT INTO categories(id, name)
VALUES (1, 'Товарные знаки'),
       (2, 'Топология интегральных микросистем (ТИМС)'),
       (3, 'Наименование месть происхождение товаров (НМПТ)'),
       (4, 'Авторское право'),
       (5, 'Объекты смежных прав'),
       (6, 'Общеизвестные товарные знаки (ОТЗ)'),
       (7, 'База данных (БД)'),
       (8, 'Изобретение'),
       (9, 'Полезная модель'),
       (10, 'Промышленный образец'),
       (11, 'Программы ЭВМ'),
       (12, 'Селекционные достижения'),
       (13, 'Традиционные знания'),
       (14, 'Рационализаторские предложения'),
       (15, 'Лицензионные договора');

INSERT INTO contents(id, title, content_number, category_id, link_pdf)
VALUES (1, 'Товарные знаки', '20130106.10', 1, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (2, 'Товарные знаки', '20130107.10', 1, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (3, 'Товарные знаки', '20130109.10', 1, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (4, 'ТИМС', '20130111.10', 2, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (5, 'ТИМС', '20130112.10', 2, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (6, 'НМПТ', '20130113.10', 3, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (7, 'НМПТ', '20130114.10', 3, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (8, 'Авторское права', '20130115.10', 4, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf'),
       (9, 'Авторское права', '20130116.10', 4, 'https://baygo.s3.us-east-2.amazonaws.com/169495050190220130106.10_removed.pdf');