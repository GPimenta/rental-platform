CREATE TABLE IF NOT EXISTS payments (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    lease_id BIGINT NOT NULL REFERENCES lease_agreements(id),
    amount NUMERIC(15,2) NOT NULL,
    due_date DATE NOT NULL,
    paid_at TIMESTAMP,
    current_status payment_status DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);