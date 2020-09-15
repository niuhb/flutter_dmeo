package a.a.fff

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import io.flutter.embedding.android.FlutterActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {

//            startActivity(FlutterActivity.createDefaultIntent(context?: return@setOnClickListener))

            startActivity(
                FlutterActivity.withCachedEngine(MY_ENGINE_ID)
                    .build(context ?: return@setOnClickListener)
            )
        }
    }
}