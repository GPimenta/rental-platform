CREATE TABLE IF NOT EXISTS rental_applicationa (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id BIGINT NOT NULL references users(id),
    unit_id BIGINT NOT NULL references units(id),
    current_status application_status,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);