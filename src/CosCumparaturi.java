import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CosCumparaturi {
    public static void main(String[] args) {
        List<String> cos = new ArrayList<>();
        String st;
        boolean b;
        faCos(cos);
        int n = 0;
        while (n!=-1) {
            n = meniu();
            switch (n) {
                case 1:
                    afiseazaCos(cos);
                    break;
                case 2:
                    System.out.print("Produsul cautat: ");
                    st = new Scanner(System.in).nextLine();
                    b = cautaProdus(cos,st);
                    System.out.println(b ? "Produsul este in cos!" : "Produsul nu este in cos!");
                    break;
                case 3:
                    System.out.print("Introduceti produsul pe care doriti sa il stergeti: ");
                    st = new Scanner(System.in).nextLine();
                    b = stergeProdus(cos, st);
                    System.out.println(b ? "Produsul a fost sters din cos!" : "Produsul nu a fost gasit in cos!");
                    break;
                case 4:
                    System.out.print("Produsul pe care doriti sa il modificati: ");
                    String st1 = new Scanner(System.in).nextLine();
                    if (!cautaProdus(cos, st1)) {
                        System.out.println("Produsul nu a fost gasit in cos!");
                    }
                    else {
                        System.out.print("Introduceti noul produs: ");
                        String st2 = new Scanner(System.in).nextLine();
                        modificaProdus(cos, st1, st2);
                        System.out.println("Produsul a fost modificat!");
                    }
                    break;
                case 5:
                    System.out.print("Produsul pe care doriti sa il adaugati in cos: ");
                    st = new Scanner(System.in).nextLine();
                    if (!st.equals("")) {
                        if (cautaProdus(cos, st)) {
                            System.out.println("Produsul mai exista deja, nu poate fi adaugat!");
                        }
                        else {
                            adaugaProdus(cos,st);
                            System.out.println("Produsul a fost adaugat in cos!");
                        }
                    }
                    else {
                        System.out.println("Nu ati introdus nimic!");
                    }
                    break;
                case -1:
                    break;
                default :
                    System.out.println("Ati introdus gresit!");

            }
        }


    }
    public static int meniu() {
        System.out.println("Alegeti:");
        System.out.println(" 1 - pentru afisare cos");
        System.out.println(" 2 - pentru cautare produs");
        System.out.println(" 3 - pentru stergere produs");
        System.out.println(" 4 - pentru modificare produs");
        System.out.println(" 5 - pentru adaugare produs");
        System.out.println("-1 - pentru iesire");
        int nr = new Scanner(System.in).nextInt();
        return nr;
    }

    public static void faCos(List cos) {
        cos.add("lapte");
        cos.add("branza");
        cos.add("unt");
        cos.add("apa");
        cos.add("ulei");
        cos.add("zahar");
    }

    public static void afiseazaCos(List cos){
        System.out.println(cos);
    }

    public static boolean cautaProdus(List cos, String st) {
        boolean b = false;
        if (cos.contains(st)) {
            b = true;
        }
        return b;
    }

    public static boolean stergeProdus(List cos, String st) {
        boolean b = false;
        if (cos.remove(st)) {
            b = true;
        }
        return b;
    }

    public static void modificaProdus(List cos, String st1, String st2) {
            int i = cos.indexOf(st1) ;
            cos.set(i,st2);
    }

    public static void adaugaProdus(List cos, String st) {
            cos.add(st);
    }
}
