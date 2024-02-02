public class Test {
    public static void main(String[] args){
        Schueler s=new Schueler();
        Schueler s1=new Schueler(15,"Simon","Lojnik");
        Schulklasse sk=new Schulklasse("1DHIF");
        if(sk.einfuegen(s)==true){
            System.out.println("Einfuegen is fine");
        }
        sk.einfuegen(s1);
        if(sk.entfernen(0)==s){
            System.out.println("entfernen is fine");
        }
        sk.einfuegen(s1);
        sk.einfuegen(s);
        System.out.println(sk.toString());
    }

}
