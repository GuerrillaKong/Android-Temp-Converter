package edu.umb.homework1
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

class HeadlinesFragment : ListFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // We need to use a different list item layout for devices older than Honeycomb
        val layout =android.R.layout.simple_list_item_activated_1
        // Create an array adapter for the list view, using the Ipsum headlines array
        listAdapter = ArrayAdapter(requireActivity(), layout, Ipsum.Headlines)
    }

    override fun onStart() {
        super.onStart()

        // When in two-pane layout, set the listview to highlight the selected list item
        // (We do this during onStart because at the point the listview is available.)
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)


    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        // Notify the parent activity of selected item
        (activity as MainActivity).onArticleSelected(position)

        // Set the item as checked to be highlighted when in two-pane layout
        l.setItemChecked(position, true)
    }
}