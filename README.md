# PaymentTracker
Web application for tracking payments

Spustenie programu:
BE: tlacidlom run
FE: prikazom "npm start" v terminali

Potrebne pre funkcnost: 
V subore application.properties je potrebne zmenit "spring.jpa.hibernate.ddl-auto=none" na "spring.jpa.hibernate.ddl-auto=update", 
pre vytvorenie datoveho modelu a zmenit URL databazy.

Do tabuliek role a payment_type je potrebne pridat nasledovne data.
INSERT INTO role VALUES(1, "Admin")
INSERT INTO role VALUES(2, "User")

INSERT INTO payment_type VALUES(1, "Jedlo")
INSERT INTO payment_type VALUES(2, "Zábava")
INSERT INTO payment_type VALUES(3, "Náradie")
INSERT INTO payment_type VALUES(4, "Elektronika")
INSERT INTO payment_type VALUES(5, "Drogéria")
INSERT INTO payment_type VALUES(6, "Palivo")
INSERT INTO payment_type VALUES(7, "Účty")
INSERT INTO payment_type VALUES(8, "Iné")