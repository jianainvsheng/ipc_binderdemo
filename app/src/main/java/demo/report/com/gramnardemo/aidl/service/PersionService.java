package demo.report.com.gramnardemo.aidl.service;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import demo.report.com.gramnardemo.PersonInterface;
import demo.report.com.gramnardemo.bean.Person;
import demo.report.com.gramnardemo.callback.OnPersonListener;

/**
 * Created by yangjian on 2018/10/22.
 */

public class PersionService extends Service {

    private List<Person> mPersonList = new ArrayList<>();

    private Binder mBinder = new PersonInterface.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }

        @Override
        public void addPersion(Person persion, OnPersonListener callback) throws RemoteException {

            if (mPersonList.size() >= 20) {
                if (callback != null) {
                    callback.addSuccess(false, "不能超过20条数据");
                }
                return;
            }

            if (persion.getName() == null || "".equals(persion.getName())) {

                if (callback != null) {
                    callback.addSuccess(false, "请输入名字");
                }
                return;
            }

            if (persion.getAge() == null || "".equals(persion.getAge())) {
                if (callback != null) {
                    callback.addSuccess(false, "请输入年龄");
                }
                return;
            }

            for (Person person : mPersonList) {

                if (persion.getAge().equals(person.getAge()) &&
                        persion.getName().equals(person.getName())) {
                    if (callback != null) {
                        callback.addSuccess(false, "已经有相同的信息了");
                    }
                    return;
                }
            }
            mPersonList.add(persion);
            if (callback != null) {
                callback.addSuccess(true, "添加成功");
            }

        }

        @Override
        public void remove(Person persion, OnPersonListener callback) throws RemoteException {

            if (persion.getName() == null || "".equals(persion.getName())) {

                if (callback != null) {
                    callback.addSuccess(false, "请输入名字");
                }
                return;
            }

            if (persion.getAge() == null || "".equals(persion.getAge())) {
                if (callback != null) {
                    callback.addSuccess(false, "请输入年龄");
                }
                return;
            }
            for (Person person : mPersonList) {

                if (persion.getAge().equals(person.getAge()) &&
                        persion.getName().equals(person.getName())) {
                    mPersonList.remove(person);
                    if (callback != null) {
                        callback.onRemoveSuccess(true, "删除成功");
                    }
                    return;
                }
            }
            if (callback != null) {
                callback.onRemoveSuccess(false,"输入的信息不存在");
            }
        }

        @Override
        public List<Person> getPersionList() throws RemoteException {
            return mPersonList;
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return mBinder;
    }
}
