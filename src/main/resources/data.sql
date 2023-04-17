insert into users(name,birthdate,is_deleted)
values('John Doe','1990-05-01',false),('Jane Doe','1992-06-01',false);

INSERT INTO devices(make, model, serial_number, price, quantity, check_me_out,is_deleted)
VALUES('Samsung', 'Galaxy S21', 123456789012345, 89900, 10, false,false),('Apple', 'iPhone 12 Pro', 234567890123456, 109900, 5, true,false),
      ('Google', 'Pixel 5', 345678901234567, 79900, 20, false,false),
      ('OnePlus', '8T', 456789012345678, 59900, 15, true,false),('Motorola', 'Moto G Power', 567890123456789, 24900, 25, true,false);
CREATE TABLE Records (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         transaction VARCHAR(50) NOT NULL,
                         datetime DATE NOT NULL,
                         notes VARCHAR(50) NOT NULL,
                         assignee_id BIGINT NOT NULL REFERENCES mainDash_devices(id) ON DELETE PROTECT
);