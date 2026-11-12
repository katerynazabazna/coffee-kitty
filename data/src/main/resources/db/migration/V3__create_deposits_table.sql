SET TIME ZONE 'UTC';

CREATE TABLE deposits (
    id uuid NOT NULL PRIMARY KEY,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    user_id uuid NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    amount numeric(10, 2) NOT NULL CHECK (amount > 0)
);
