package ca.nbcc.shoppinglist;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

public class ShoppingList implements Parcelable {
    private  int count;
    private String name;

    public ShoppingList(int count, String name){
        this.count = count;
        this.name = name;
    }

    public String getName(){return name;}
    public int getCount(){return count;}

    public void writeToParcel(Parcel dest, int flag){
        dest.writeInt(count);
        dest.writeString(name);
    }

    public ShoppingList(Parcel parcel){
        count = parcel.readInt();
        name = parcel.readString();
    }

    public static final Parcelable.Creator<ShoppingList> CREATOR = new Parcelable.Creator<ShoppingList>(){
        @Override
        public ShoppingList createFromParcel(Parcel parcel){
            return new ShoppingList(parcel);
        }

        @Override
        public ShoppingList[] newArray(int size){
            return new ShoppingList[0];
        }
    };

    public int describeContents(){
        return hashCode();
    }
}
