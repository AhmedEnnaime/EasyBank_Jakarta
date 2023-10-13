CREATE TABLE agencies (
                          code SERIAL PRIMARY KEY,
                          name VARCHAR(255),
                          address VARCHAR(255),
                          phone VARCHAR(12)
);

CREATE TABLE employees (
                           matricule SERIAL PRIMARY KEY,
                           firstName VARCHAR(255),
                           lastName VARCHAR(255),
                           recruitmentDate DATE,
                           birthDate DATE,
                           email VARCHAR(255) UNIQUE,
                           phone VARCHAR(255),
                           address VARCHAR(255),
                           agency_code INT,
                           FOREIGN KEY (agency_code) REFERENCES agencies(code)
);

CREATE TABLE clients (
                         code SERIAL PRIMARY KEY,
                         firstName VARCHAR(255),
                         lastName VARCHAR(255),
                         birthDate DATE,
                         phone VARCHAR(255),
                         address VARCHAR(255),
                         employeeMatricule INT,
                         FOREIGN KEY (employeeMatricule) REFERENCES employees(matricule)
);

CREATE TABLE requests (
                          number SERIAL PRIMARY KEY,
                          credit_date DATE DEFAULT CURRENT_DATE,
                          amount DOUBLE PRECISION,
                          remarks VARCHAR(255),
                          duration INT,
                          state VARCHAR(255) DEFAULT 'PENDING',
                          client_code INT,
                          FOREIGN KEY (client_code) REFERENCES clients(code)
);
