package a.a.fff

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import kotlinx.android.synthetic.main.activity_main1.*
import org.json.JSONObject

class MainActivity1 : AppCompatActivity() {

    lateinit var flutterEngine: FlutterEngine
    lateinit var channel: MethodChannel
    private var ENGINE_ID = "bk_engine_id"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        lang_zh.performClick()
        skin_day.performClick()
        et.setText("tony")

        initFlutter()

        lang.setOnCheckedChangeListener { _, _ -> callFlutter() }
        skin.setOnCheckedChangeListener { _, _ -> callFlutter() }

        go_demo.setOnClickListener {
//            flutterEngine.dartExecutor.executeDartEntrypoint(
//                DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "feed")
//            )
//            gotoFlutter(true)


            channel.invokeMethod("start","feed")
            var intent = Intent(this,MainActivity2::class.java)


            intent.putExtra("root","feed")

            startActivity(intent)
        }

        go.setOnClickListener {
            gotoFlutter(true)
        }
        go1.setOnClickListener {
            gotoFlutter(false)
        }

        go2.setOnClickListener {
            gotoCustomFlutter()
        }

        go3.setOnClickListener {
            gotoCustomRouter()
        }

        call.setOnClickListener {
            callFlutter()
        }

    }

    private fun gotoCustomRouter() {
        channel.invokeMethod("start", "feed")
        gotoFlutter(true)
    }

    private fun callFlutter() {
        channel.invokeMethod("config", makeConfig().toString());
    }

    private fun initFlutter() {
        // Instantiate a FlutterEngine.
//        if(FlutterEngineCache.getInstance().contains(ENGINE_ID)){
//            return
//        }
        flutterEngine = FlutterEngine(this)

        Log.e("MMMM1", "$flutterEngine")

        flutterEngine.navigationChannel.setInitialRoute("/home")

        flutterEngine.dartExecutor.executeDartEntrypoint(
//            DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "demo")
            DartExecutor.DartEntrypoint.createDefault()
        )

        channel = MethodChannel(flutterEngine.dartExecutor, "com.demo/config")

        channel.setMethodCallHandler { call, result ->
            Log.e(
                "MMMM",
                "configChannel,  method: ${call.method} ,  arg: ${call.arguments}}"
            )


            when (call.method) {
                "config" -> {
                    var config: JSONObject = makeConfig()
                    result.success(config.toString())
                }
                else -> {
                    result.success("unknown method : ${call.method}");
                }
            }
        }

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put(ENGINE_ID, flutterEngine)
    }

    private fun makeConfig(): JSONObject {
        var config = JSONObject()
        config.put("skin", if (skin_day.isChecked) "day" else "night")
        config.put("lang", if (lang_zh.isChecked) "zh" else "en")
        config.put("name", et.editableText.toString())
        return config
    }


    private fun gotoCustomFlutter() {
        var lang = "zh"
        var skin = "day"
        var name = et.editableText.toString()

        when {
            lang_en.isChecked -> lang = "en"
            lang_zh.isChecked -> lang = "zh"

            skin_day.isChecked -> skin = "day"
            skin_night.isChecked -> skin = "night"
        }

        var intent = Intent(this, MainActivity2::class.java)
        intent
            .putExtra("skin", skin)
            .putExtra("lang", lang)
            .putExtra("name", name)

        startActivity(intent)

    }

    private fun gotoFlutter(cache: Boolean) {
        var lang = "zh"
        var skin = "day"
        var name = et.editableText.toString()

        when {
            lang_en.isChecked -> lang = "en"
            lang_zh.isChecked -> lang = "zh"

            skin_day.isChecked -> skin = "day"
            skin_night.isChecked -> skin = "night"
        }

        launcherFlutter(lang, skin, name, cache)
    }

    private fun launcherFlutter(lang: String, skin: String, name: String, cache: Boolean = false) {
        var intent: Intent
//        主动调用flutter方法
//        channel.invokeMethod("setConfig",makeConfig().toString())


        if (cache) {
//        用缓存过的engine
            intent = FlutterActivity.withCachedEngine(ENGINE_ID).build(this)
        } else {

//        缺省启动方式new engine
//        var intent = FlutterActivity.createDefaultIntent(this)
//        每次用new engine
            intent = FlutterActivity.withNewEngine().initialRoute("/home").build(this)
        }




        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        FlutterEngineCache.getInstance().get(ENGINE_ID)?.destroy()
    }
}