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

//        holder.textView.text = "      "+item.datadecode+makeBlank(item)+item.time

        var text = "<font color=#D4AC0D> ${item.datadecode}</font> "+ "<font color=#00000>--</font> "+
                "<font color=#D4AC0D> ${item.time}</font> "

        holder.textView.setText(Html.fromHtml(text))
    }

//    fun makeBlank( item : History) : String{
//        var blank = "                "
//
//
//        return blank
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }
}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)
