package com.nyahonk.rxweather.ui.history_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nyahonk.rxweather.R
import com.nyahonk.rxweather.models.WeatherVO


class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val differ: AsyncListDiffer<WeatherVO> = AsyncListDiffer(this, object : DiffUtil.ItemCallback<WeatherVO>() {

        override fun areItemsTheSame(oldItem: WeatherVO, newItem: WeatherVO): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: WeatherVO, newItem: WeatherVO): Boolean {
            return (oldItem.cityName == newItem.cityName
                    && oldItem.countryName == newItem.countryName
                    && oldItem.dateTime == newItem.dateTime)
        }

    })

    override fun getItemCount() = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_card_history, parent, false)
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    fun submitItem(items: List<WeatherVO>) {
        differ.submitList(items)
    }

    inner class HistoryViewHolder(view: View) : ViewHolder(view) {

        lateinit var locationTV: TextView
        lateinit var dateTV: TextView

        fun bind(item: WeatherVO) {
            with(itemView) {
                locationTV = findViewById(R.id.rv_card_history_city_name)
                dateTV = findViewById(R.id.rv_card_history_date)
            }

            locationTV.text = item.cityName
            dateTV.text = item.dateTime

        }
    }
}