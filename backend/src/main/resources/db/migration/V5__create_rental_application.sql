CREATE TABLE IF NOT EXISTS rental_application (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL references users(id),
    unit_id BIGINT NOT NULL references unit(id),
    current_status application_status,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
)