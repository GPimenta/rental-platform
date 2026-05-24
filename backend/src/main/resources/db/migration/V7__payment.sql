CREATE TABLE IF NOT EXISTS payment (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    lease_id BIGINT NOT NULL REFERENCES lease_agreement(id),
    amount NUMERIC(15,2) NOT NULL,_
    due_date DATE NOT NULL,
    paid_at TIMESTAMP,
    current_status payment_status DEFAULT 'PENDING',
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
)