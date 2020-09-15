import 'package:flutter/material.dart';

class Feed extends StatelessWidget {
  final String data;

  Feed(this.data);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Text('Feed: $data')),
    );
  }
}

class Home extends StatelessWidget {
  final String data;

  Home(this.data);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(child: Text('Home: $data')),
    );
  }
}
