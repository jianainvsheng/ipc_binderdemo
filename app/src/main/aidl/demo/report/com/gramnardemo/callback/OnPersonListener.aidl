// OnPersonListener.aidl
package demo.report.com.gramnardemo.callback;

// Declare any non-default types here with import statements

interface OnPersonListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

            void onRemoveSuccess(boolean isSuccess,String message);

            void addSuccess(boolean isSucess,String message);
}
