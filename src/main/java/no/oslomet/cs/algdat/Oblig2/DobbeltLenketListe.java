package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }


    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen


    private static void fratilKontroll(int antall, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new IndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {

            Objects.requireNonNull(a,"Ikke tilatt null verdier");

        //setter hode og hale sin verdi = null
        hode = hale = new Node<>(null);

        for (int i = 0; i < a.length; i++) {  // resten av verdiene

            if (a[i] != null) {
                hale.forrige = hale;
                hale = hale.neste = new Node<>(a[i]);
                antall++;
            }
        }
        if(antall == 0) {
            hode = hale = null;
        }else {
            hode = hode.neste;
        }
    }


    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);
        DobbeltLenketListe<T> liste = new DobbeltLenketListe<>();
        int lengde = til - fra;
        if (lengde > 0) {
            for (int i = fra; i < til; i++) {
                Node<T> temp = finnNode(i);
                liste.leggInn(temp.verdi);
            }
        }
        endringer = 0;
        return liste;
    }




    private Node<T> finnNode(int indeks)
    {
        //programkode 3.3.3a
        Node<T> p = hode;

        for (int i = 0; i < indeks; i++) p = p.neste;

        return p;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi,"Ikke tilatt null verdier");

        if (antall == 0) {
            hode = hale = new Node<>(verdi, null, null);
        }
        else {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }

        antall++;
        endringer++;

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi,"Null verdi");
        if (indeks < 0)
        {
            throw new IndexOutOfBoundsException("Indeksen " +
                    indeks + " er negativ");
        }
        else if (indeks > antall)
        {
            throw new IndexOutOfBoundsException("Indeksen " +
                    indeks + " > antall(" + antall + ")noder");
        }
        else if (antall == 0)  // returnerer en tom liste
        {
            hode = hale = new Node<>(verdi, null, null);
        }
        else if (indeks == 0) //verdien skal legges først
        {
            hode = hode.forrige = new Node<>(verdi, null, hode);
        }
        else if (indeks == antall) //verdien skal legges bakkers
        {
            hale = hale.neste = new Node<>(verdi, hale, null);
        }
        else{
            Node<T> p = finnNode(indeks);  // ny verdi til venstre for p
            p.forrige = p.forrige.neste = new Node<>(verdi, p.forrige, p);
        }

        antall++;
        endringer++;
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);

        return finnNode(indeks).verdi;
    }

    @Override
    public int indeksTil(T verdi) {
        if (verdi == null) return -1;

        Node<T> p = hode;

        for (int i = 0; i < antall; i++, p = p.neste){
            if (p.verdi.equals(verdi))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        indeksKontroll(indeks, false);
        Objects.requireNonNull(nyverdi,"Null verdi");

        Node<T> p = finnNode(indeks);

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        endringer++;
        return gammelverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if (verdi == null) return false;

        Node<T> p = hode;

        while (p != null)  // leter etter verdien
        {
            if (p.verdi.equals(verdi)) break;
            p = p.neste;
        }

        if (p == null)
        {
            return false;        // verdi er ikke i listen
        }
        else if (antall == 1)  // bare en node i listen
        {
            hode = hale = null;
        }
        else if (p == hode)    // den første skal fjernes
        {
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (p == hale)    // siste skal fjernes
        {
            hale = hale.forrige;
            hale.neste = null;
        }
        else
        {
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        p.verdi = null;              // for resirkulering
        p.forrige = p.neste = null;  // for resirkulering

        antall--;      // en verdi mindre i listen
        endringer++;   // ny endring i listen

        return true;   // vellykket fjerning
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks,false);

        Node<T> p = hode;

        if (antall == 1)  // bare en node i listen
        {
            hode = hale = null;
        }
        else if (indeks == 0)  // den første skal fjernes
        {
            hode = hode.neste;
            hode.forrige = null;
        }
        else if (indeks == antall - 1)  // den siste skal fjernes
        {
            p = hale;
            hale = hale.forrige;
            hale.neste = null;
        }
        else
        {
            p = finnNode(indeks);  // bruker hjelpemetode
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }

        T verdi = p.verdi;           // skal returneres
        p.verdi = null;              // for resirkulering
        p.forrige = p.neste = null;  // for resirkulering

        antall--;      // en verdi mindre i listen
        endringer++;   // ny endring i listen

        return verdi;
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append('[');

        if (!tom()) {
            s.append(hode.verdi);

            for (Node<T> p = hode.neste; p != null; p = p.neste) {
                s.append(',').append(' ').append(p.verdi);
            }
        }

        s.append(']');
        return s.toString();
    }

    public String omvendtString() {
        StringBuilder s = new StringBuilder();
        s.append('[');

        if (!tom()) {
            s.append(hale.verdi);

            for (Node<T> p = hale.forrige; p != null; p = p.forrige)
            {
                s.append(',').append(' ').append(p.verdi);
            }
        }

        s.append(']');
        return s.toString();
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }


    private class DobbeltLenketListeIterator implements Iterator<T>
    {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator()
        {
            denne = hode;     // denne starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks)
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public boolean hasNext()
        {
            return denne != null;  // denne koden skal ikke endres!
        }

        @Override
        public T next()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException("Ikke laget ennå!");
        }

    } // DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }
}



