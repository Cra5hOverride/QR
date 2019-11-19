package buu.informatics.s59160965.qrcodescanner.screens.history

import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.database.History

class HistoryAdapter : RecyclerView.Adapter<TextItemViewHolder>() {
    var data =  listOf<History>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]

        var text = "<font color=#00000>${position + 1} : </font> "+"<font color=#1951B2> ${item.datadecode}</font> "+ "<font color=#00000>--</font> "+
                "<font color=#1951B2> ${item.time}</font> "

        holder.textView.setText(Html.fromHtml(text))
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
