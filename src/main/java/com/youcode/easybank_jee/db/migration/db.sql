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

CREATE TABLE accounts (
                          accountNumber SERIAL PRIMARY KEY,
                          balance DOUBLE PRECISION,
                          creationDate DATE DEFAULT CURRENT_DATE,
                          status VARCHAR(255) DEFAULT 'ACTIVE',
                          clientCode INT,
                          employeeMatricule INT,
                          agency_code INT,
                          FOREIGN KEY (clientCode) REFERENCES clients(code),
                          FOREIGN KEY (employeeMatricule) REFERENCES employees(matricule),
                          FOREIGN KEY (agency_code) REFERENCES agencies(code)
);

CREATE TABLE savingsAccounts (
                                 accountNumber INT PRIMARY KEY,
                                 interestRate DOUBLE PRECISION,
                                 FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE
);

CREATE TABLE currentAccounts (
                                 accountNumber INT PRIMARY KEY,
                                 overdraft DOUBLE PRECISION,
                                 FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber)
                                     ON DELETE CASCADE
                                     ON UPDATE CASCADE
);

CREATE TABLE operations (
                            operationNumber SERIAL PRIMARY KEY,
                            creationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            amount DOUBLE PRECISION,
                            employeeMatricule INT,
                            FOREIGN KEY (employeeMatricule) REFERENCES employees(matricule)
);

CREATE TABLE missions (
                          code SERIAL PRIMARY KEY,
                          nom VARCHAR(255),
                          description VARCHAR(255)
);

CREATE TABLE missionAssignments (
                                    id SERIAL PRIMARY KEY,
                                    debut_date TIMESTAMP,
                                    end_date TIMESTAMP,
                                    employee_matricule INT REFERENCES employees(matricule),
                                    mission_code INT REFERENCES missions(code)
);

CREATE TABLE transfers (
                           id SERIAL PRIMARY KEY,
                           transfer_date DATE,
                           employee_matricule INT,
                           agency_code INT,
                           FOREIGN KEY (agency_code) REFERENCES agencies(code),
                           FOREIGN KEY (employee_matricule) REFERENCES employees(matricule)
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

CREATE TABLE payments (
                          id SERIAL PRIMARY KEY,
                          from_account INT NOT NULL,
                          to_account INT NOT NULL,
                          operationNumber INT NOT NULL,
                          FOREIGN KEY (from_account) REFERENCES accounts(accountNumber),
                          FOREIGN KEY (to_account) REFERENCES accounts(accountNumber),
                          FOREIGN KEY (operationNumber) REFERENCES operations(operationNumber)
);

CREATE TABLE simpleOperations (
                                  type VARCHAR(255),
                                  accountNumber INT,
                                  operationNumber INT NOT NULL,
                                  FOREIGN KEY (accountNumber) REFERENCES accounts(accountNumber),
                                  FOREIGN KEY (operationNumber) REFERENCES operations(operationNumber)
);

