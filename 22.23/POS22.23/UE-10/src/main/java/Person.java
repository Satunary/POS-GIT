import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    private String name;
    private LocalDate geburtsDatum;

    public Person(String name, LocalDate geburtsDatum) {
        setName(name);
        setGeburtsDatum(geburtsDatum);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null){
            throw new IllegalArgumentException("Nicht gültig");
        }
        this.name = name;
    }

    public LocalDate getGeburtsDatum() {
        return geburtsDatum;
    }

    public void setGeburtsDatum(LocalDate geburtsDatum) {
        if (geburtsDatum==null || geburtsDatum.isBefore(LocalDate.of(1957,1,1)) || geburtsDatum.isAfter(LocalDate.of(2007,1,1))){
            throw new IllegalArgumentException("nicht gültiges alter");
        }
        this.geburtsDatum = geburtsDatum;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nGeboren am: "+geburtsDatum.toString();
    }

    public void print(){
        System.out.println(toString());
    }

    public abstract double lohn();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(geburtsDatum, person.geburtsDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, geburtsDatum);
    }
}
