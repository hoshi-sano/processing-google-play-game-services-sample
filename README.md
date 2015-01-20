# Processing-Android with Google Play Game Services Sample

## How to run a sample

see:
* https://developers.google.com/games/services/
* https://developer.android.com/google/play-services/setup.html

ja:
1. Google Developer Consoleでプロジェクトの登録を行う
2. リーダーボードや実績の作成を行う
3. res/values/ids.xmlを修正して、2.で得られたIDを記載する
4. project.propertiesを修正して、google-play-services_libへの相対パスを定義する
5. libs/processing-core.jar.dummyにダミーファイルが配置してあるので、processing-core.jarと置換する
6. 以下を実行する:
```
  $ cd /path/to/android-sdk/extras/google/google_play_services/libproject/google-play-services_lib
  $ android update project --target <API level> --path .
  $ cd /path/to/processing-google-play-game-services-sample
  $ android update project --target <API level> --path .
  $ ant debug
  $ adb install -r bin/AndroidTest-debug.apk
```

en:
1. Set up the project in Google Developer Console
2. Create leaderboards/achievements
3. Modify res/values/ids.xml and place your IDs
4. Modify project.properties and define the relative path to google-play-services_lib
5. Replace libs/processing-core.jar.dummy with your processing-core.jar
6. Execute:
```
  $ cd /path/to/android-sdk/extras/google/google_play_services/libproject/google-play-services_lib
  $ android update project --target <API level> --path .
  $ cd /path/to/processing-google-play-game-services-sample
  $ android update project --target <API level> --path .
  $ ant debug
  $ adb install -r bin/AndroidTest-debug.apk
```

## LICENSE

Copyright (c) 2015 Yuki Morohoshi
Released under the MIT license
http://opensource.org/licenses/mit-license.php
