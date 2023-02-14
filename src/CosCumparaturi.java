import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CosCumparaturi {
    public static void main(String[] args) {
        List<String> cos = new ArrayList<>();
        String st, st1, st2, sAfis;
        int nCit, nAfis;
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
                    nCit = 1;
                    st = citesteProd(nCit);
                    b = cautaProdus(cos,st);
                    sAfis = "gasit";
                    afiseazaMesaj(b, sAfis);
                    break;
                case 3:
                    nCit = 2;
                    st = citesteProd(nCit);
                    b = stergeProdus(cos, st);
                    sAfis = "sters";
                    afiseazaMesaj(b, sAfis);
                    break;
                case 4:
                    nCit = 3;
                    st1 = citesteProd(nCit);
                    if (!cautaProdus(cos, st1)) {
                        nAfis = 1;
                        afiseazaMesaj(nAfis);
                    }
                    else {
                        nCit = 4;
                        st2 = citesteProd(nCit);
                        modificaProdus(cos, st1, st2);
                        nAfis = 2;
                        afiseazaMesaj(nAfis);
                    }
                    break;
                case 5:
                    nCit = 5;
                    st = citesteProd(nCit);
                    if (!st.equals("")) {
                        if (cautaProdus(cos, st)) {
                            nAfis = 3;
                            afiseazaMesaj(nAfis);
                        }
                        else {
                            adaugaProdus(cos,st);
                            nAfis = 4;
                            afiseazaMesaj(nAfis);
                        }
                    }
                    else {
                        nAfis = 5;
                        afiseazaMesaj(nAfis);
                    }
                    break;
                case -1:
                    break;
                default :
                    nAfis = 6;
                    afiseazaMesaj(nAfis);
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
        int nr = 0;
        try {
            nr = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            return nr;
        }
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

    public static String citesteProd(int opt) {
        switch (opt) {
            case 1:
                System.out.print("Produsul pe care doriti sa il cautati: ");
                break;
            case 2:
                System.out.print("Produsul pe care doriti sa il stergeti: ");
                break;
            case 3:
                System.out.print("Produsul pe care doriti sa il modificati: ");
                break;
            case 4:
                System.out.print("Introduceti noul produs: ");
                break;
            case 5:
                System.out.print("Produsul pe care doriti sa il adaugati: ");
                break;
        }
        String sCitit = new Scanner(System.in).nextLine();
        return sCitit;
    }

    public static void afiseazaMesaj(boolean b, String s) {
            System.out.println(b? "Produsul a fost " + s + "!": "Produsul nu a fost gasit!");
    }

    public static void afiseazaMesaj (int n) {
        switch (n) {
            case 1:
                System.out.println("Produsul nu a fost gasit!");
                break;
            case 2:
                System.out.println("Produsul a fost modificat!");
                break;
            case 3:
                System.out.println("Produsul exista deja, nu mai poate fi adaugat!");
                break;
            case 4:
                System.out.println("Produsul a fost adaugat!");
                break;
            case 5:
                System.out.println("Nu ati introdus nimic!");
                break;
            case 6:
                System.out.println("Ati introdus gresit optiunea!");
                break;
        }
    }
}

