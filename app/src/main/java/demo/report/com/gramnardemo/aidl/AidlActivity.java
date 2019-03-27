package demo.report.com.gramnardemo.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import demo.report.com.gramnardemo.PersonInterface;
import demo.report.com.gramnardemo.R;
import demo.report.com.gramnardemo.aidl.service.PersionService;
import demo.report.com.gramnardemo.bean.Person;
import demo.report.com.gramnardemo.callback.OnPersonListener;

/**
 * Created by yangjian on 2018/10/22.
 */

public class AidlActivity extends FragmentActivity implements ServiceConnection {


    private PersonInterface mInterface;

    private Person mPerson = new Person();

    private EditText mName,mAge;

    private TextView mContentView;

    private OnPersonListener mOnPersonListener = new OnPersonListener.Stub()

    {


        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void onRemoveSuccess(boolean isSuccess, String message) throws RemoteException {

            Toast.makeText(AidlActivity.this,message,Toast.LENGTH_SHORT).show();
            if(isSuccess){

                try {
                    setContent(mInterface.getPersionList());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void addSuccess(boolean isSucess, String message) throws RemoteException {

            Toast.makeText(AidlActivity.this,message,Toast.LENGTH_SHORT).show();
            if(isSucess){

                try {
                    setContent(mInterface.getPersionList());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_layout);
        this.mAge = this.findViewById(R.id.age);
        this.mName = this.findViewById(R.id.name);
        this.mContentView = this.findViewById(R.id.aidl_content);
        Intent intent1 = new Intent(getApplicationContext(), PersionService.class);
        startService(intent1);
        bindService(intent1, this, BIND_AUTO_CREATE);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
    }

    public void onClick(View view) {

        mPerson.setAge(mAge.getText().toString());
        mPerson.setName(mName.getText().toString());
        if(view.getId() == R.id.aidl_add){
            //添加
            if(mInterface != null){

                try {
                    mInterface.addPersion(mPerson,mOnPersonListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }else if(view.getId() == R.id.aidl_remove){
            //移除
            if(mInterface != null){
                try {
                    mInterface.remove(mPerson,mOnPersonListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {

        mInterface = PersonInterface.Stub.asInterface(service);
        try {
            setContent(mInterface.getPersionList());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void setContent(List<Person> list){

        if(list == null || list.size() <= 0){

            mContentView.setText("null");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        for(Person person : list){

            buffer.append("name : " + person.getName() + "--age : " + person.getAge() + " ;");
        }

        mContentView.setText(buffer);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

        mInterface = null;
    }

}
