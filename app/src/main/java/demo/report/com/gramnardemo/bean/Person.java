package demo.report.com.gramnardemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yangjian on 2018/10/22.
 */

public class Person implements Parcelable{

    private String name = "";

    private String age = "";

    public Person() {
    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
