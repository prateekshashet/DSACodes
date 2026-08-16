import java.util.*;

public class Library {
    int bookid;
    String bookname;
    String authorname;
    double price;
    Library(int bookid,String bookname,String authorname,double price){
      this.bookid=bookid;
      this.bookname=bookname;
      this.authorname=authorname;
      this.price=price;
    }
    void display()
    {
      System.out.println("Details are:\n Book Name:"+bookname+" Book Id:"+bookid+" Author Name:"+authorname+" Price:"+price);
    }
    public static void main(String[] args) {
      Library l1=new Library(1,"Kite Runner","Khalil Gibran",1200.1);
      Library l2=l1;
      l1.display();
      l2.display();
      l2.bookid=3;
      l1.display();
      l2.display();
    }
}