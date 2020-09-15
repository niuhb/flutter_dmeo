import 'dart:collection';
import 'package:flutter/material.dart';

Map<String, Color> themeColorMap = {
  'gray': Colors.grey,
  'blue': Colors.blue,
  'blueAccent': Colors.blueAccent,
  'cyan': Colors.cyan,
  'deepPurple': Colors.purple,
  'deepPurpleAccent': Colors.deepPurpleAccent,
  'deepOrange': Colors.orange,
  'green': Colors.green,
  'indigo': Colors.indigo,
  'indigoAccent': Colors.indigoAccent,
  'orange': Colors.orange,
  'purple': Colors.purple,
  'pink': Colors.pink,
  'red': Colors.red,
  'teal': Colors.teal,
  'black': Colors.black,
};


class ColorDay {
  static final main_color = Color(0xFFF0B90A);
  static final bg_color = Color(0xFFF4F5F8);
  static final text_color = Color(0xFF353D49);
  static final normal_text_color = Color(0xFF959DA8);
  static final bg_card_color = Color(0xFFFFFFFF);
  static final hint_color = Color(0xFFBAC0C9);
  static final marker_border = Color(0xFFC8CFD5);
  static final line_color = Color(0xFFEBEEF2);
}

///黑天版色值
class ColorNight {
  static final main_color = Color(0xFFF0B90A);
  static final bg_color = Color(0xFF0B0D10);
  static final text_color = Color(0xFFFFFFFF);
  static final normal_text_color = Color(0xFF555962);
  static final bg_card_color = Color(0xFF131518);
  static final hint_color = Color(0xFF34353A);
  static final marker_border = Color(0xFF555962);
  static final line_color = Color(0xFF1F2125);
}
var exTheme = EXTheme();
class EXTheme {
  Map<String, Color> map = HashMap();

  init() {
    map["day_main"] = Colors.blue;
    map["night_main"] = Colors.deepPurple;

    map["day_text"] = Color(0xFFff0000);
    map["night_text"] = Color(0xFFFFFF00);

    map["day_bg"] = Color(0xFFFFFFFF);
    map["night_bg"] = Color(0xFFFFFFFF);
  }

  Color getColor(String color) {
    return map[color];
  }
}
