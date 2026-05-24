CREATE TABLE IF NOT EXISTS lease_agreement (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES users(id),
    unit_id BIGINT NOT NULL REFERENCES unit(id),
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    approved_contract REFERENCES unit(id),
    rent_amount NUMERIC(10,2) NOT NULL,
    created_at  TIMESTAMP NOT NULL DEFAULT NOW()
)