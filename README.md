# Virtual_Catalog

Numele: Marin Marius Daniel
Grupa: 322CC
Gradul de dificultate al temei: mediu
Timp alocat: 35-40h

Mod de implementare
	Clasele principale ce merita mentionate sunt: 

	Catalog, in care se stocheaza cursurile, fiind construita folosind sablonul de proiectare Singleton in care se instantiaza un singur obiect de acest tip
	Course, nucleul proiectului, care contine toate informatiile necesare despre detaliile legate de curs
	User, care defineste modul de construire al tuturor utilizatorilor ( Student, Parent, Teacher, Asistent )

	Sabloanele principale ce merita mentionate sunt:

	Observer, care permite trimitea unei Notificari ( codare a notei unui student) si o stocheaza intr un vector de notificari al parintilor studentului (in cazul in care parintele se afla in vectorul de observatori)
	Visitor, care permite validarea notelor de catre asistent sau profesor, din 2 dictionare in cursurile corespunzatoare


	Interfata grafica:

	Pentru pagina de student, se insereaza intr o zona text numele elevului, apoi se apasa pe buton de search, afisandu se ulterior butoane cu fiecare curs ; la apasarea unui astfel de buton, se ofera detalii legate de situatia studentului la acel curs
	Pentru pagina de parinte, se insereaza intr o zona text numele parintelui, iar daca acesta se afla in vectorul de observatori, va aparea un buton care odata apasat va afisa o fereastra cu detaliile tuturor notificarilor primite in ordine cronologica
	Pentru pagina de profesor / asistent se scrie numele in zona text ; daca exista se vor afisa 2 butoane ; unul afiseaza detaliile fiecarui student de la fiecare curs si altul care valideaza notele din dictionarul specific profesorului / asistentului

	IDE & Testare

	Intellij Idea 
	 testarea a fost personalizata pentru fiecare pagina in functia main a claselor
