ALTER TABLE users
ADD COLUMN balance numeric(10, 2) NOT NULL DEFAULT 0.00
CHECK (balance >= 0);
