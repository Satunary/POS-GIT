package at.spenger;


public class LiederListe {
    //Voller zugriff auf Node d.h. kein get/set da nur hier verwendbar
    private static class Node{
        private Lied data;
        private Node next;

        public Node(Lied lied, Node next) {
            this.data = lied;
            this.next = next;
        }

    }

    private Node root;


    public LiederListe() {
        this.root=null;
    }

    public void add(Lied l){
        Node n = new Node(l,root);
        root=n;
    }

    public Lied pop(){
        Node n = root;
        root=root.next;
        return n.data;
    }

    public Lied peek(){
        return root.data;
    }

    public int anzahlLieder(){
        int anzahl=0;
        for(Node p=root;p!=null;p=p.next){
            anzahl++;
        }
        return anzahl;
    }

    public boolean vorhanden(Lied l){

        for(Node p=root;p!=null;p=p.next){
            if(l.equals(p.data)){
                return true;
            }
        }
        return false;
    }

    public Lied del(String titel){
        if(titel==null){
            return null;
        }
        Node pVor=null;
        Node p=root;
        while (p!=null&&!p.data.getTitel().equals(titel)){
            pVor=p;
            p=p.next;
        }
        if(p==null){
            return null;
        }
        if(pVor==null){
            root=p.next;
        }else{
            pVor.next=p.next;
        }

        return p.data;
    }
}
