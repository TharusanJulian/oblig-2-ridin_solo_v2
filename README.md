[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5881312&assignment_repo_type=AssignmentRepo)
# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer.
Oppgaven er levert av følgende studenter:
* Tharusan Julian, s351886, s351886@oslomet.no


# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Tharusan Julian har hatt i oppgave å gjøre 1,2,3,4,5,6,8. Altså alle oppgavene som 
* krevdes for en person. 

# Oppgavebeskrivelse

For å løse oppgave 1 brukte jeg en for loop og en if-setning for å differensiere null verdiene og 
variablene. For å løse denne oppgaven tar jeg inspirasjon fra kompendiet(enkeltlenkede lister(3.3)).
Denne koden returnere antall og tom sjekker om antallet = 0. 
Hvis antall = null vil tom voiden være 0. 

For å løse oppgave 2 endrer jeg først på pekerne og Objects.requirednull(altså legger til en feilmelding) 
for null verdier. Derretter lager jeg en tostring og en omvendtstring metode. Som har i jobb å gjøre om 
verdiene om til en string verdi som ser ut som en array. Denne string verdien skal printes som et "[1,2,3]".
Omvendtstring gjør altså det motsatte med verdiene. Så det printes fra halen til hode så [3,2,1]-. 
For å løse denne oppgaven så bruker jeg inspirasjon fra kompendiet for å være spesifikk. Ukeoppgavene altså 
3.3.2.

For å løse oppgave 3. Så lager jeg funksjonen Node<T>finnNode(intindeks). Finn noden metoden har i oppgave
å finne verdien i et objekt. Så det du gjør er at du angir posisjonen deretter får du verdien ut. Dette gjør 
jeg ved å lage en for løkke som går igjennom alle verdiene i objektet/arrayet. Metoden Public hent(int indeks)
har i oppgave å hente verdien som finnNode finner. Så finnNode gir en posisjon og hent ruturnerer verdien til 
tallet finn node har funnet. Oppdater metoden oppdaterer verdien til tallene som har blitt satt in ved
hjelp av finnNode. Jeg lager en subliste som har i oppgave å ta funksjonene fra et tall som er gitt og til 
et tall som er gitt. Begge to er gitt for at det skal fungere. Fratilkontrollen sjekker om det ikke er noe 
feil med verdiene som er gitt. For eksempel om til er mindre enn fra. 

Denne oppgaven strever jeg ganske mye med og har brukt utrolig lenge på å løse og det nærmeste jeg har kommet 
til å løse er dette. Jeg bruker inspirasjon fra 3.3.3 i kompendiet. Jeg prøvde å løse oppgaven på en annen 
metode men fikk failed gjentatte ganger. 


For å løse oppgave 4 må jeg finne posisjonen til variablene. Dette gjør jeg ved å lage en int indekTil
(T verdi). Derretter legger jeg inn en verdi og sjekker den om verdien eksisterer i tabellen. Hvis ikke 
tallet eksisterer i tabellen returnerer den false ved hjelp av boolean inneholder(T verdi) og vis den 
inneholder så returnere true hvis verdien eksisterer i tabellen. For å løse denne oppgaven tar jeg
inspirasjon fra kompendiet. Får å være spesifikk del 3.3.3 og opgavene knyttet til den delen av kompendiet.

For å løse oppgave 5 så bruker jeg funksjonen public void leggInn(int indeks, T verdi). Meningen med koden 
er at du skal velge/gå til en posisjon du setter inn og endrer på verdien til denne posisjonen. 
. La oss si du har rekken [1,2,3] og ønsker å endre endre posisjonen 2 og endre tallet til 5. Da vil vi
få listen [1,2,5]. Også passet på at jeg gikk igjennom sjekklisten som står skrevet i oppgave teksten. Og 
la til spesifikk kode(fullførte kravene). For å løse denne oppgaven tar jeg igjen inspirasjon fra 
kompendiet. For å være spesisikk Programkode 3.3.2 g). 


For å løse denne oppgaven bruker jeg inspirasjon fra kompendiet. For å være spesifikk så bruker jeg 3.3.3. 

Bolean fjern(T verdi) har i oppgave å fjerne noden med den oppgitte verdien og returne true. T fjern(int indeks)
fjerner noden som ligger i den gitte indeksen og returener verdien som lå i den noden. 

Begge metodene tar hensyn til spesialtillfeiller.
feks hvis første eller siste node skal fjernes, eller om listen allerde er tom.


Oppgave 8
8a,
For å løse oppgave 8a så lager jeg til metoden T next(). Og jeg sørger for at den sjekker om iteratorendringen er
lik endringer og hvis ikke kastes en ConcurrentModificationException. Også hvis ikke det er flere igjen i listen
kastes det NoSuchElementException. Og til slutt setter jeg fjernOK til sann. For å løse denne oppgaven tar 
jeg inspirasjon fra kompendiet. For å være mer spesifikk programkode 3.3.4c

8b
I denne oppgavem lager jeg metoden Iterator<T> iterator. Og jeg sørger for at denne returnerer listen (instans av 
iteratorklassen)

8c
I denne oppgaven lager jeg konstruktøren private DobbeltLenketListeIterator(int indeks). Deretter setter jeg pekeren
denne til den tilhørende indeksen. 

8d
Lager tilslutt metoden Iterator<T> iterator (int indeks). Jeg sjekker at indeksen er lovlig. Bruker deretter
metoden indekskontroll(). Ved hjelp fra oppgave c returneres det en instanse av iteratorklassen. 

Oppgave 7 måtte fylles for at oppgave 8 skulle bestå testen. Dermed måtte jeg også gjøre oppgave 7. I denne oppgaven 
skal man nullstille alle verdiene gjøre alle verdiene om til ingen ting. For å løse denne oppgaven bruker jeg 
inspirasjon fra kompendiet for å være spesifikk fra oppgave 3.3.2. 








