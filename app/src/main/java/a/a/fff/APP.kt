package a.a.fff

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

var MY_ENGINE_ID = "my_engine_id"

class APP : Application() {
    var flutterEngine: FlutterEngine? = null

    override fun onCreate() {
        super.onCreate()
        initFlutter()
    }

    private fun initFlutter() {

        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)


        flutterEngine?.navigationChannel?.setInitialRoute("/eee")

        flutterEngine?.dartExecutor?.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put(MY_ENGINE_ID, flutterEngine)

    }

}