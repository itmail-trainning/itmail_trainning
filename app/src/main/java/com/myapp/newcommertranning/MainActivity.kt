package com.myapp.newcommertranning

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.view.*


class MainActivity : AppCompatActivity(), Animation.AnimationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        var isOperatorBtnPushed: Boolean = false

        // ＋ボタンクリックイベント
        fabInfo.setOnClickListener { view ->
            if (isOperatorBtnPushed == false) {
                this.contentMain.setBackgroundResource(R.drawable.surprise)
                this.contentMain.txtHello.visibility = INVISIBLE
                this.contentMain.txtTitle.setTextColor(Color.WHITE)
                isOperatorBtnPushed = true
            } else {
                this.contentMain.background = null
                // センターの文字を表示
                this.contentMain.txtHello.visibility = VISIBLE
                // 社名を黒文字
                this.contentMain.txtTitle.setTextColor(Color.GRAY)
                isOperatorBtnPushed = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // メニュー選択処理
        return when (item.itemId) {
            // ティメル犬
            R.id.action_walk -> {
                val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
                val disp = wm.defaultDisplay

                val realSize = Point()
                disp.getRealSize(realSize)

                // アニメーション設定
                val realScreenWidth = realSize.x.toFloat()
                val translate = TranslateAnimation(realScreenWidth, 0F, 0F, 0F)
                translate.duration = 5000
                translate.fillAfter = true
                translate.setAnimationListener(this)

                // ティメル犬を表示
                imgWalk.visibility = VISIBLE
                // アニメーションスタート
                imgWalk.startAnimation(translate)

                return true
            }
            // リスト表示
            R.id.action_settings -> {
                val intent = Intent(this, View2Activity::class.java)
                startActivity(intent)

                return true
            }
            // その他
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
     * ティメル犬アニメーション終了時
     */
    override fun onAnimationEnd(p0: Animation?) {
        // 社名を表示
        this.contentMain.txtTitle.visibility = VISIBLE
    }

    /*
     * ティメル犬アニメーション開始時
     */
    override fun onAnimationStart(p0: Animation?) {
    }

    override fun onAnimationRepeat(p0: Animation?) {
    }
}
