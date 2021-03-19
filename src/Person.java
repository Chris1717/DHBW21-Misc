import java.util.Date;

public class Person implements Comparable<Person> {

    String nachname;
    String vorname;
    Date geburtstag;

    enum REIHENFOLGE {
        NACHNAME, //0
        VORNAME, //1
        NACHNAME_VORNAME //2
    }

    static REIHENFOLGE vergleichseinstellung = REIHENFOLGE.NACHNAME;


    public Person(String nname, String vname, Date geb) {
        nachname = nname;
        this.vorname = vname;
        this.geburtstag = geb;
    }


    public static void main(String[] args) {
        System.out.println(REIHENFOLGE.NACHNAME.ordinal());


        Person tina = new Person("Schmidt", "Tina", new Date(1999, 1, 3));
        Person lisa = new Person("Schmidt", "Lisa", new Date(1999, 1, 3));
        Person hans = new Person("Baumann", "Hans", new Date(1999, 3, 3));
        System.out.println(tina);
        System.out.println(hans);

        System.out.println(lisa.compareTo(tina));
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " " + geburtstag;
    }


    @Override
    public int compareTo(Person p) {
        switch(vergleichseinstellung) {
            case NACHNAME:
                return this.nachname.compareTo(p.nachname);
            case VORNAME:
                return this.vorname.compareTo(p.vorname);
            default:
                if (this.nachname.equals(p.nachname)) {
                    return this.vorname.compareTo(p.vorname);
                } else
                    return this.nachname.compareTo(p.nachname);
            }
    }

    
}
