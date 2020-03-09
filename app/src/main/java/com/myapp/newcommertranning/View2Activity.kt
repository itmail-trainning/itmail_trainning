package com.myapp.newcommertranning

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.newcommertranning.Adapter.RecyclerAdapter

import kotlinx.android.synthetic.main.activity_view2.*
import kotlinx.android.synthetic.main.content_view2.*
import kotlinx.android.synthetic.main.item_search_list.*

class View2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view2)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // リストに表示するデータを作成
        val adapter = RecyclerAdapter(this, createData())

        // 作成したデータをリストにセット
        this.listRecycler.layoutManager = LinearLayoutManager(this)
        this.listRecycler.adapter = adapter

        // 検索ボタンクリックイベント
        this.btnSearch.setOnClickListener { view ->
            // 検索文字列
            val str = this.txtSearch.text.toString()
            // リストデータ
            val list = adapter.data
            // 検索結果
            val idx = list.indexOf(str)

            // 検索結果表示
            if (idx > 0) {
                // 存在した場合
                this.txtResult.text = idx.toString() + " 行目"
            } else {
                // 存在しない場合
                this.txtResult.text = "リストにありません"
            }
        }
    }

    private fun createData(): List<String> {
        // リストデータ
        val list = ArrayList<String>()
        // 作成スタートインデックス
        val startIndex = 0
        // データ数
        val maxCount = 10

        // データをループで作成
        for (i in startIndex .. maxCount + startIndex) {
            // リストデータに追加
            list.add("文字列${i + 1}")
        }

        // 作成したデータを返す
        return list.shuffled()
    }
}
