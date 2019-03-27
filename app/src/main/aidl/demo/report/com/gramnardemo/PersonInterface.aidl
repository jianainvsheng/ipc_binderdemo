// PersionInterface.aidl
package demo.report.com.gramnardemo;

// Declare any non-default types here with import statements
import demo.report.com.gramnardemo.bean.Person;
import demo.report.com.gramnardemo.callback.OnPersonListener;

interface PersonInterface {

/**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


     void addPersion(in Person persion,OnPersonListener callback);

     void remove(in Person persion,OnPersonListener callback);

     List<Person> getPersionList();

}
