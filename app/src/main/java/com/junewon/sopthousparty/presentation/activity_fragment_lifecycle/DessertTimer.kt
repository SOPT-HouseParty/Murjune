package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import timber.log.Timber

class DessertTimer(lifecycle: Lifecycle) : LifecycleObserver {

    var secondsCount = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    init {
        // DessertTimer(LifecycleObserver)가 생성자로 주입된 DessertActivity의 lifecycle을 관찰하도록 함
        lifecycle.addObserver(this)
    }

    fun startTimer() {
        // 참고로, Runnable 객체를 보내는 방법과 Message 객체를 보내는 방법 2가지가 있습니다.
        // Runnable 객체를 Handler에 보내면 대상 쓰레드(여기서는 Main 쓰레드)에서 수신한 Runnable객체의 run()이 바로 실행하도록 한다.
        runnable = Runnable {
            // 여기가 이제 메인 쓰레드에서 수행되는 코드임
            secondsCount++
            Timber.i("Timer is at : $secondsCount")
            handler.postDelayed(runnable, 1000) // 이제 다시 runnable객체를 핸들러에 보냄 (Like 재귀 형식 ㅎ ㅎ)
        }
        handler.postDelayed(runnable, 1000) // 1초 대기 후, runnable객체를 핸들러에 보냄~
    }

    fun stopTimer() {
        // Removes all pending posts of runnable from the handler's queue, effectively stopping the
        Timber.i(" ")
        handler.removeCallbacks(runnable)
    }
}
