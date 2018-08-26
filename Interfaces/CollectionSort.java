import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MyObject{
    int score;
    int id;
    MyObject(int score,int id){
        this.score=score;
        this.id=id;
    }

    @Override
    public String toString() {
        return "ID is "+this.id+"Score is "+this.score;
    }
}
public class CollectionSort {
    public static void main(String[] args) {
        ArrayList<MyObject> myList=new ArrayList<MyObject>();
        for(int i=1;i<=10;i++){
            MyObject obj=new MyObject((i*i)%101,i);
            myList.add(obj);
        }
        for(int i=0;i<10;i++){
            MyObject obj=myList.get(i);
            System.out.println(obj);
        }
        //Sorting the ArrayList as per score
        Collections.sort(myList, new Comparator<MyObject>() {
            @Override
            public int compare(MyObject o1, MyObject o2) {
                if(o1.score<o2.score){
                    return 1;
                }
                else if(o1.score==o2.score){
                    return 0;
                }
                else {
                    return -1;
                }
            }
        });
        for (int i=0;i<10;i++){
            System.out.println(myList.get(i));
        }
    }
}
