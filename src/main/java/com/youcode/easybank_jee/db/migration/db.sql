CREATE TABLE employees (
                           matricule SERIAL PRIMARY KEY,
                           firstName VARCHAR(255),
                           lastName VARCHAR(255),
                           recruitmentDate DATE,
                           birthDate DATE,
                           email VARCHAR(255) UNIQUE,
                           phone VARCHAR(255),
                           address VARCHAR(255)
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