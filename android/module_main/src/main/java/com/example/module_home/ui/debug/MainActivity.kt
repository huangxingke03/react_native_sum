package com.example.module_home.ui.debug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.content.PagePath
import com.example.module_home.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.welcome).setOnClickListener {
            ARouter.getInstance().build(PagePath.ModuleMainPage.WELCOME_PAGE).navigation()
        }
    }
}