package com.example.sistemarsip

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.BaseAdapter
import com.example.sistemarsip.activity.*
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.layout_adapter.view.*

class ActivityHomeScreen : AppCompatActivity() {

    var adapter: ImageAdapter? = null
    var homeAdapter = ArrayList<HomeScreenAdapter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        // load foods
        homeAdapter.add(HomeScreenAdapter("Jumlah Surat Masuk", R.drawable.masuk))
        homeAdapter.add(HomeScreenAdapter("Jumlah Surat Keluar", R.drawable.keluar))
        homeAdapter.add(HomeScreenAdapter("Jumlah Disposisi", R.drawable.disposisi))
        homeAdapter.add(HomeScreenAdapter("Jumlah Klarifikasi Surat", R.drawable.klarifikasi))
        homeAdapter.add(HomeScreenAdapter("Jumlah User Aktif", R.drawable.pengguna))
        adapter = ImageAdapter(this, homeAdapter)

        gvHome.adapter = adapter
        gvHome.setOnItemClickListener { parent, view, position, id ->
            if (position == 0) {
                //Toast.makeText(this, "Anda memilih: 0",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityJumlahSuratMasuk::class.java)
                startActivity(intent)
            } else if (position == 1) {
//                Toast.makeText(this, "Anda memilih: 1", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityJumlahSuratKeluar::class.java)
                startActivity(intent)
            } else if (position == 2) {
                //Toast.makeText(this, "Anda memilih: 2", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityJumlahDisposisi::class.java)
                startActivity(intent)
            } else if (position == 3) {
//                Toast.makeText(this, "Anda memilih: 3", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityJumlahKlarifikasi::class.java)
                startActivity(intent)
            } else if (position == 4) {
//                Toast.makeText(this, "Anda memilih: 3", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ActivityJumlahUserAktif::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return super.onOptionsItemSelected(item)
    }


    class ImageAdapter : BaseAdapter {
        var homeAdapter = ArrayList<HomeScreenAdapter>()
        var context: Context? = null

        constructor(context: Context, homeAdapter: ArrayList<HomeScreenAdapter>) : super() {
            this.context = context
            this.homeAdapter = homeAdapter
        }

        override fun getCount(): Int {
            return homeAdapter.size
        }

        override fun getItem(position: Int): Any {
            return homeAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val list = this.homeAdapter[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var homeView = inflator.inflate(R.layout.layout_adapter, null)
            homeView.imgList.setImageResource(list.image!!)
            homeView.tvName.text = list.name!!

            return homeView
        }
    }
}