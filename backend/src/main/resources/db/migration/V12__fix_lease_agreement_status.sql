CREATE TYPE lease_status AS ENUM('ACTIVE','EXPIRED','TERMINATED');

ALTER TABLE lease_agreements DROP approved_contract IF EXISTS approved_contract;
ALTER TABLE lease_agreements lease_status lease_status NOT NULL DEFAULT 'ACTIVE';