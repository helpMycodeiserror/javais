import java.util.Scanner;

class Cart {
    int boxx;
    Item tem;
    int inbug ; 

    Cart(int box, Item temm) {
        boxx = box ;
        tem = temm ;
    }
    void printStats(){
        System.out.print(inbug+" "+(tem.price*inbug)+" "+(tem.kasung*inbug)+" "+((tem.price*inbug)+(tem.kasung*inbug))+" ");
        if(inbug == 0){
            System.out.println("0");
        }
         else if(inbug*tem.want2buy <= boxx){
            System.out.println("1");
        }
        else{
            System.out.println("2+");
        }
        
    }
    boolean adjustQuan(int n){
        if(n > 0 ){
            if(n <= tem.theyhave){
                tem.cutStock(n);
                inbug +=n;
                return true;
            }
            else{
                return false;
            }
        }
        else if(n < 0 ){
            if(-n > inbug){
                return false ;
            }
            else{
                inbug = inbug + n ;
                tem.theyhave = tem.theyhave - n ;
            }
        }
        return true ;
    }
}

class Item {
    String name;
    String code;
    int price;
    int kasung;
    int want2buy;
    int theyhave;
    boolean valid;

    Item(String namee, String codename, int pricee, int kasungg, int buy, int have) {
        name = namee;
        code = codename;
        price = pricee;
        kasung = kasungg;
        want2buy = buy;
        theyhave = have;
        basicCheck(namee, codename, pricee, kasungg, buy);
    }

    boolean basicCheck(String namee, String codename, int pricee, int kasungg, int buy) {
        if (namee.length() >= 3 && codename.length() >= 3 && pricee > 0 && buy > 0 && kasungg >= 0) {
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }

    boolean cutStock(int n) {
        if (n > theyhave) {
            return false;
        } else {
            theyhave = theyhave - n;
            return true;
        }

    }

    void printInfo() {
        System.out.println(name + " " + code + " " + price);
        System.out.println(kasung + " " + want2buy + " " + theyhave + " " + valid);
    }

}

public class Item1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        String id = scan.next();
        int price = scan.nextInt();
        int shipping = scan.nextInt();
        int volume = scan.nextInt();
        int quan = scan.nextInt();
        Item item = new Item(name, id, price, shipping,
        volume, quan);
        int capacity = scan.nextInt();
        Cart cart = new Cart(capacity, item);
       
        int n = scan.nextInt();
        for(int i = 0; i < n; ++i) {
        int q = scan.nextInt();
        System.out.println(cart.adjustQuan(q));
        cart.printStats();

        }
    }
}
