package edu.umb.homework1

import android.os.Bundle

import android.view.View
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.news_articles) {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragTran = supportFragmentManager.beginTransaction()
        fragTran.add(R.id.fragment_container,ArticleFragment())
        fragTran.commit()
    }

    fun onArticleSelected(position: Int) {

        val newFrag = when (position) {
            0,1 -> CalculateFragment()
            2 -> ArticleFragment()
            else -> ArticleFragment()
        }

        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.fragment_container, newFrag)
        trans.addToBackStack(null)
        trans.commit()
    }

    fun convert(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val textView = findViewById<TextView>(R.id.textView)
        val input = editText.text.toString().toDoubleOrNull()

        if (input != null){
            val currFrag = supportFragmentManager.findFragmentById(R.id.fragment_container)

            if (currFrag is CalculateFragment) {
                val celToFar = (supportFragmentManager.findFragmentById(R.id.headlines_fragment)
                        as HeadlinesFragment).listView.checkedItemPosition == 0
                val result = if (celToFar) {
                    val far = (input * 9/5) + 32
                    String.format("%.2f", far)
                } else {
                    val cel = (input - 32) * 5/9
                    String.format("%.2f", cel)
                }
                textView.text = result
            }
        }


    }

}