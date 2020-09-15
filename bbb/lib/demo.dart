import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:flutter/widgets.dart';

void log(dynamic str) {
  print("Demo>>>>  $str");
}

MethodChannel channel = MethodChannel("com.demo/config");

class DemoPage extends StatelessWidget {
  // This widget is the root of your application.
  Color _themeColor;
  String lang = "zh_CN";
  ThemeData themeData;
  String args;

  DemoPage({Key key, this.themeData, this.args}) : super(key: key);

  @override
  Widget build(BuildContext context) {
//    channel.setMethodCallHandler((call) => null)
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Flutter Demo',
      theme: themeData,
      routes: {
        "/demo": (context) => Demo(title: "demo"),
      },
    );
//
  }
}

class Demo extends StatefulWidget {
  final String title;

  const Demo({Key key, this.title}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _DemoState();
}

class _DemoState extends State<Demo> {
  String _name = "yad";

  @override
  void dispose() {
    super.dispose();
    log("dispose");
  }

  @override
  void initState() {
    super.initState();
    log("initState");
  }

  @override
  Widget build(BuildContext context) {
    log("build");

    return Scaffold(
      appBar: AppBar(
        leading: GestureDetector(
          onTap: () => SystemNavigator.pop(),
          child: Icon(Icons.arrow_back),
        ),

        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(
          widget.title,
        ),
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text("name : $_name"),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text("name : $_name"),
          ),
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: Text(widget.title),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {},
        tooltip: 'Increment',
        child: Icon(Icons.add),
      ),
    );
  }

  @override
  void didUpdateWidget(Demo oldWidget) {
    super.didUpdateWidget(oldWidget);
    log("didUpdateWidget");
  }

  @override
  void reassemble() {
    super.reassemble();
    log("reassemble");
  }

  @override
  void deactivate() {
    super.deactivate();
    log("deactivate");
  }

  @override
  void didChangeDependencies() {
    super.didChangeDependencies();
    log("didChangeDependencies");
  }
}
