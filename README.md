# Proiect_Acreditare_Varasciuc_Lidia

Numele şi prenumele absolventului: Varasciuc Lidia

Tema lucrării:
Automated Acceptance Testing Framework utilizând Serenity BDD

Descrierea lucrării :
Am construit o arhitectura de testare automată in Java, care ruleaza scripturi automate pentru a rula urmatoarele teste:
1. Inregistrarea cu succes in aplicatie
2. Inregistrarea cu o adresa de email invalida
3. Inregistrarea avand campul parola necompletat
4. Inregistrarea avand o parola scurta

5. Logarea in sistem cu credentiale valide
6. Logarea cu o adresa de email invalida
7. Logarea avand campul Username necompletat
8. Logarea avand campul parola necompletat
9. Delogarea din aplicatie

10. Cautarea produselor dupa un cuvant dat ca parametru si verificarea tuturor produselor gasite daca contin respectivul cuvant
11. Navigarea catre urmatoarea pagina folosind butoanele de navigare din partea de jos a paginii Shop
12. Navigarea catre pagina Home folosind breadcrumb-ul din pagina Shop
13. Ordonarea produselor in ordine descrescatoare din pagina Shop utilizand dropdown-ul dedicat ordonarii si verificare ca primul produs afisat in pagina este cel mai mare din lista de produse

14. Adaugarea unui singur produs in cosul de cumparaturi si verificarea acestuia ca a fost adaugat cu succes
15. Modificarea cantitatii unui produs din pagina cosului de cumparaturi si verificarea pretului
16. Stergerea produsului adaugat in cosul de cumparaturi

17. Verificarea ca fluxul de Checkout a fost realizat cu succes avand toate informatiile obligatorii completate
18. Un test parametrizat pentru fluxul de Checkout avand campurile obligatorii necompletate: testul ruleaza de 7 ori pentru fiecare camp necompletat: firstNameField, lastNameField, addressField, cityField, postcodeField, phoneField, emailField

Tehnologii folosite :
Java, Selenium, JUnit, Serenity
