import 'dart:ui';

import 'package:bbb/demo.dart';
import 'package:flutter/material.dart';

// MethodChannel channel = MethodChannel("com.demo/config");
// ThemeData currentTheme = day;

// @pragma('vm:entry-point')
// void feed() {
//   String route = window.defaultRouteName;
//   log("run demo..... route : $route");
//   Uri uri = Uri.parse(route);
//   Map params = uri.queryParameters;
//   if (params["skin"] == "day") {
//     currentTheme = day;
//   } else {
//     currentTheme = night;
//   }
//
//   runApp(DemoPage(
//     themeData: currentTheme,
//     args: route,
//   ));
// }

void main() {
  log("run main..... ${window.defaultRouteName}");

  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  void initState() {
    super.initState();
    log(">>>>>_MyAppState");
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'title',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(),
      // home: _widgetForRoute(""),
      home: EEE(),
    );
  }
}

class EEE extends StatefulWidget {
  @override
  _EEEState createState() => _EEEState();
}

class _EEEState extends State<EEE> with WidgetsBindingObserver {
  ScrollController _controller;

  @override
  void initState() {
    WidgetsBinding.instance.addObserver(this);
    super.initState();
    _controller = ScrollController();
  }

  @override
  void didChangeAppLifecycleState(AppLifecycleState state) {
    log(">>>>>>>>$state");
    switch (state) {
      case AppLifecycleState.resumed:
        break;

      case AppLifecycleState.inactive:
        // _controller?.jumpTo(_controller.position.minScrollExtent);
        break;
      case AppLifecycleState.paused:
        break;

      case AppLifecycleState.detached:
        break;
    }
    super.didChangeAppLifecycleState(state);
  }

  Key kk = UniqueKey();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("title"),
      ),
      body: ListView.builder(
        controller: _controller,
        itemBuilder: (context, index) => ListTile(
          title: Text("index .: $index"),
        ),
        itemCount: 100,
      ),
    );
  }

  @override
  void deactivate() {
    super.deactivate();
  }

  @override
  void dispose() {
    super.dispose();
    WidgetsBinding.instance.removeObserver(this);
  }
}
