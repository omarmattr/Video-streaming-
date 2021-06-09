package com.ps.omarmattr.videostreaming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide
import com.ps.omarmattr.videostreaming.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(mBinding.root)
        mBinding.apply {
            val bundle =Bundle()
            btn1.setOnClickListener {

                bundle.putStringArrayList("url" , arrayListOf(
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
                ))
                val fm = VideoDialog()
                fm.arguments = bundle
                fm.show(supportFragmentManager,"")
            }
            btn2.setOnClickListener {
                bundle.putStringArrayList("url" , arrayListOf(
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg"
                ))
                val fm = VideoDialog()
                fm.arguments = bundle
                fm.show(supportFragmentManager,"")
            }
            btn3.setOnClickListener {
                bundle.putStringArrayList("url" , arrayListOf(
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg"
                ))
                val fm = VideoDialog()
                fm.arguments = bundle
                fm.show(supportFragmentManager,"")
            }
            btn4.setOnClickListener {
                bundle.putStringArrayList("url" , arrayListOf(
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerEscapes.jpg"
                ))
                val fm = VideoDialog()
                fm.arguments = bundle
                fm.show(supportFragmentManager,"")
            }
        }
    }


}