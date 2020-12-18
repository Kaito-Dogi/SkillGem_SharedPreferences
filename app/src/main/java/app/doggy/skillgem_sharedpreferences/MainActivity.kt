package app.doggy.skillgem_sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferencesの実体はxmlファイルである。
        //アプリ内のメモリにxmlファイルで書き込み、読み出す。

        //DataStoreという名前でインスタンス化する。
        //MODE_PRIVATE：このアプリからのみ、読み書き可能。
        val dataStore: SharedPreferences = getSharedPreferences("DataStore",Context.MODE_PRIVATE)

        //保存の処理。
        saveButton.setOnClickListener {
            //editTextのテキストを取得する。
            val saveText: String = editText.text.toString()
            saveTextView.text = saveText

            //取得したテキストを"Input"に書き込む。
            val editor = dataStore.edit()
            editor.putString("Input", saveText)

            //書き込んだテキストを保存する。
            editor.apply() //非同期：直ぐに書き込む必要性がない場合に用いる。
            //editor.commit() //同期
        }

        //読み出しの処理。
        readButton.setOnClickListener {
            //保存したテキストを"Input"から読み出す。
            val readText: String? = dataStore.getString("Input", "NoData")
            readTextView.text = readText
        }
    }
}