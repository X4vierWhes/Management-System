CREATE TABLE users (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          profile VARCHAR(20) NOT NULL -- ADMIN, COLABORADOR, MORADOR
);

CREATE TABLE blocks (
                        id BIGSERIAL PRIMARY KEY,
                        identification VARCHAR(10) NOT NULL,
                        amt_floors INT NOT NULL,
                        apt_per_floor INT NOT NULL
);

CREATE TABLE units (
                          id BIGSERIAL PRIMARY KEY,
                          block_id BIGINT REFERENCES blocks(id),
                          generate_identification VARCHAR(20) NOT NULL,
                          floor INT NOT NULL
);

CREATE TABLE resident_unit (
                                 user_id BIGINT REFERENCES users(id),
                                 unit_id BIGINT REFERENCES users(id),
                                 PRIMARY KEY (user_id, unit_id)
);