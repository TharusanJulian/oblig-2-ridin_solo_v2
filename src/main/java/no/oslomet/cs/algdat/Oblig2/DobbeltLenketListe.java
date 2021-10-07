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

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        this();

        if (a == null){
            //  tom liste
            Objects.requireNonNull("Ikke tilatt null verdier");
        }
        //setter hode og hale sin verdi = null
        hode = hale = new Node<>(null);

        for (int i =0; i < a.length; i++){  // resten av verdiene

            if(a[i] != null) {
                hode = new Node<>(a[i]);
                antall++;
            }
        }
    }

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }
    private Node<T> finnNode(int indeks)
    {
        Node<T> p;

        if (indeks <= antall / 2)
        {
            p = hode;
            for (int i = 0; i < indeks; i++)
            {
                p = p.neste;
            }
        }
        else
        {
            p = hale;
            for (int i = antall - 1; i > indeks; i--)
            {
                p = p.forrige;
            }
        }
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
        Objects.requireNonNull(verdi,"Null verdi");

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
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
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

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe



