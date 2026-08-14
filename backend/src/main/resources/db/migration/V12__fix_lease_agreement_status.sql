CREATE TYPE lease_status AS ENUM('ACTIVE','EXPIRED','TERMINATED');

ALTER TABLE lease_agreements DROP approved_contract;
ALTER TABLE lease_agreements ADD lease_status lease_status NOT NULL DEFAULT 'ACTIVE';