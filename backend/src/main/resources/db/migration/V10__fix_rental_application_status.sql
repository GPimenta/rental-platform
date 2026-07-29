ALTER TABLE rental_applications
ALTER COLUMN current_status SET DEFAULT 'PENDING',
ALTER COLUMN current_status SET NOT NULL;