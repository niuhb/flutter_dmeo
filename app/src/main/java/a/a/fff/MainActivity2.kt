package a.a.fff

import android.content.Context
import android.os.Bundle
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import io.flutter.view.FlutterMain
import org.json.JSONObject

class MainActivity2 : FlutterActivity() {


    var skin: String = ""
    var lang: String = ""
    var name: String = ""
    var root: String = ""

    lateinit var channel: MethodChannel
    var ENGINE_ID = "bk_engine_id"


//    override fun getDartEntrypointFunctionName(): String {
//        Log.e("MMMM","getDartEntrypointFunctionName $root")
//        return root
//    }
////
//    override fun getInitialRoute(): String {
//        Log.e("MMMM","getInitialRoute $root")
//        return "$root"
//    }

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        Log.e("MMMM","$flutterEngine")
        GeneratedPluginRegistrant.registerWith(flutterEngine)
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        return super.provideFlutterEngine(context)
    }

//    override fun getCachedEngineId(): String? {
//        return ENGINE_ID
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        skin = intent.getStringExtra("skin")
//        lang = intent.getStringExtra("lang")
//        name = intent.getStringExtra("name")
        root = intent.getStringExtra("root")

        println("skin $skin, lang $lang, name $name")

        initMethodChannel()


    }

    private fun initFlutterEngine() {

        flutterEngine?.navigationChannel?.setInitialRoute("/demo?skin=${skin}&lang=${lang}&name=${name}")


        flutterEngine?.dartExecutor?.executeDartEntrypoint(
            DartExecutor.DartEntrypoint(FlutterMain.findAppBundlePath(), "demo")
//            DartExecutor.DartEntrypoint.createDefault()
        )


    }

    private fun makeConfig(): JSONObject {
        var config = JSONObject()
        config.put("skin", skin)
        config.put("lang", lang)
        config.put("name", name)
        return config
    }

    private fun initMethodChannel() {
        channel = MethodChannel(flutterEngine?.dartExecutor, "com.demo/config")
        channel.setMethodCallHandler { call, result ->
            Log.e(
                "MMMM",
                "configChannel,  method: ${call.method} ,  arg: ${call.arguments} }"
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
    }
}