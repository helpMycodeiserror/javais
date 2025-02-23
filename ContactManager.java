import java.util.Scanner;

class ContactBook {
    String[] name;
    String[] telStrings;

    ContactBook(String[] namee, String[] tell) {
        name = namee;
        telStrings = tell;
    }

    void getAllContact() {
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + " " + telStrings[i]);
        }
    
    }

    void getContact(String ckname) {
        boolean can = false ;
        for (int i = 0; i < name.length; i++) {
            if (ckname.equals(name[i])) {
                System.out.println(telStrings[i]);
                can = true;
                break;
            }
        }
        if(!can){
            System.out.println("Invalid contact");
        }
    }

    static boolean onlyDigits(String cktell) {
        for (int i = 0; i < cktell.length(); i++) {
            char want = cktell.charAt(i);
            if (want < '0' || want > '9') {
                return false;
            }

        }
        return true;
    }

    void editNumber(String editname, String editel) {
        boolean can = false;
        for (int i = 0; i < name.length; i++) {
            if (editname.equals(name[i])) {
                can = true;
                if (onlyDigits(editel)  && (editel.charAt(0) == '0')
                        && (editel.length() == 10 || editel.length() == 9)) {
                    telStrings[i] = editel;
                    System.out.println(name[i] + " new number is " + telStrings[i]);
                    break;

                } else {
                    System.out.println("Invalid number");
                }
                
            }
        }
        if (!can) {
            System.out.println("Invalid contact");
        }
    }
}

public class ContactManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int want = sc.nextInt();
        String[] namer = new String[want];
        String[] telll = new String[want];
        for (int i = 0; i < want; i++) {
            String name = sc.next();
            String tel = sc.next();
            namer[i] = name;
            telll[i] = tel;
        }
        ContactBook book = new ContactBook(namer, telll);
        int edit = sc.nextInt();
        for (int i = 0; i < edit; i++) {
            int want2edit = sc.nextInt();
            if (want2edit == 1) {
                String nameey = sc.next();
                book.getContact(nameey);
            } else if (want2edit == 2) {
                String nameer = sc.next();
                String tellt = sc.next();
                book.editNumber(nameer, tellt);
            } else if (want2edit == 3) {
                book.getAllContact();
            } else {
                System.out.println("Invalid command");
            }
        }

    }
}
