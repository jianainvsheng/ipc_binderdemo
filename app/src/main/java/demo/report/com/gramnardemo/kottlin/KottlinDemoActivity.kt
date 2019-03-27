package demo.report.com.gramnardemo.kottlin

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import demo.report.com.gramnardemo.R

/**
 * Created by yangjian on 2018/10/19.
 */
open class KottlinDemoActivity : FragmentActivity(){

    private lateinit var mTestText:TextView

    private lateinit var mNextScreenView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kottlin_demo)
        mTestText = this.findViewById(R.id.test_text)
        mNextScreenView = this.findViewById(R.id.test_text_next)
        mTestText.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                when(v?.id){

                    R.id.test_text ->{
                        Toast.makeText(this@KottlinDemoActivity,"kottlin",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        mNextScreenView.setOnClickListener{

            v: View? ->
            var intent = Intent(this@KottlinDemoActivity,KottlinNextDemoActivity::class.java)
            startActivity(intent)
        }
    }
}