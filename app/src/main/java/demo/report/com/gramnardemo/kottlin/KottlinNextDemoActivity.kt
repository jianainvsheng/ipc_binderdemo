package demo.report.com.gramnardemo.kottlin

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import demo.report.com.gramnardemo.R

/**
 * Created by yangjian on 2018/10/19.
 */
open class KottlinNextDemoActivity : FragmentActivity(){

    private lateinit var mTestText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kottlin_next_demo)
        mTestText = this.findViewById(R.id.test_text)
        mTestText.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                when(v?.id){

                    R.id.test_text ->{
                        Toast.makeText(this@KottlinNextDemoActivity, "next", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}