package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleObserver
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.ActivityDessertBinding
import timber.log.Timber

class DessertActivity : AppCompatActivity(), LifecycleObserver {

    private var revenue = 0
    private var dessertsSold = 0
    private lateinit var binding: ActivityDessertBinding
    private lateinit var dessertTimer: DessertTimer

    data class Dessert(val imageId: Int, val price: Int, val startProductionAmount: Int)

    private val allDesserts = listOf(
        Dessert(R.drawable.cupcake, 5, 0),
        Dessert(R.drawable.donut, 10, 5),
        Dessert(R.drawable.eclair, 15, 20),
        Dessert(R.drawable.froyo, 30, 50),
        Dessert(R.drawable.gingerbread, 50, 100),
        Dessert(R.drawable.honeycomb, 100, 200),
        Dessert(R.drawable.icecreamsandwich, 500, 500),
        Dessert(R.drawable.jellybean, 1000, 1000),
        Dessert(R.drawable.kitkat, 2000, 2000),
        Dessert(R.drawable.lollipop, 3000, 4000),
        Dessert(R.drawable.marshmallow, 4000, 8000),
        Dessert(R.drawable.nougat, 5000, 16000),
        Dessert(R.drawable.oreo, 6000, 20000)
    )
    private var currentDessert = allDesserts[0]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            revenue = savedInstanceState.getInt(KEY_REVENUE)
        }
        Timber.i(" called")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dessert)

        binding.dessertButton.setOnClickListener {
            onDessertClicked()
        }
        dessertTimer = DessertTimer(lifecycle)
        binding.revenue = revenue
        binding.amountSold = dessertsSold
        binding.dessertButton.setImageResource(currentDessert.imageId)
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i(" Called")
    }

    override fun onStart() {
        super.onStart()
        // 액티비티가 백그라운드에서 다시 포그라운드로 넘어올 때마다 dessertTimer start됨
//        dessertTimer.startTimer()
        Timber.i(" Called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        Timber.i(" Called")
    }

    override fun onPause() {
        super.onPause()
        // 다이얼로그를 띄워면 dessertTimer 멈춤
        //        dessertTimer.stopTimer()
        Timber.i(" Called")
    }

    override fun onStop() {
        super.onStop()
        // 다이얼로그를 띄워도 멈추지 않음, 액티비티가 백그라운드로 넘어갈 때만 dessertTimer 멈춤
//        dessertTimer.stopTimer()
        Timber.i(" Called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Bundle은 RAM에 있음
        // 100 KB 이하 메모리를 저장하는 걸 권장한다.
        outState.putInt(KEY_REVENUE, revenue)

        Timber.i(" Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i(" Called")
    }

    /**
     * Updates the score when the dessert is clicked. Possibly shows a new dessert.
     */
    private fun onDessertClicked() {
        // Update the score
        revenue += currentDessert.price
        dessertsSold++

        binding.revenue = revenue
        binding.amountSold = dessertsSold

        // Show the next dessert
        showCurrentDessert()
    }

    /**
     * Determine which dessert to show.
     */
    private fun showCurrentDessert() {
        var newDessert = allDesserts[0]
        for (dessert in allDesserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                newDessert = dessert
            }
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            else break
        }

        // If the new dessert is actually different than the current dessert, update the image
        if (newDessert != currentDessert) {
            currentDessert = newDessert
            binding.dessertButton.setImageResource(newDessert.imageId)
        }
    }

    /**
     * Menu methods
     */
    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText(getString(R.string.share_text, dessertsSold, revenue))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                this,
                getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenuButton -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val KEY_REVENUE = "key_revenue"
    }
}
// defaultLifecycleobserver
