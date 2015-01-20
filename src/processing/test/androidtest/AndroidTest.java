package processing.test.androidtest;

import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import com.google.android.gms.plus.internal.*; 
import com.google.android.gms.drive.events.*; 
import com.google.android.gms.wallet.fragment.*; 
import com.google.android.gms.games.snapshot.*; 
import com.google.android.gms.games.achievement.*; 
import com.google.android.gms.wearable.*; 
import com.google.android.gms.panorama.*; 
import com.google.android.gms.games.internal.*; 
import com.google.android.gms.identity.intents.model.*; 
import com.google.android.gms.games.internal.request.*; 
import com.google.android.gms.games.leaderboard.*; 
import com.google.android.gms.tagmanager.*; 
import com.google.android.gms.wearable.internal.*; 
import com.google.android.gms.games.multiplayer.turnbased.*; 
import com.google.android.gms.maps.model.*; 
import com.google.android.gms.appstate.*; 
import com.google.android.gms.common.*; 
import com.google.android.gms.maps.model.internal.*; 
import com.google.android.gms.wallet.*; 
import com.google.android.gms.ads.mediation.customevent.*; 
import com.google.android.gms.location.*; 
import com.google.android.gms.analytics.ecommerce.*; 
import com.google.android.gms.gcm.*; 
import com.google.android.gms.drive.query.internal.*; 
import com.google.android.gms.games.quest.*; 
import com.google.android.gms.fitness.service.*; 
import com.google.android.gms.fitness.*; 
import com.google.android.gms.plus.model.people.*; 
import com.google.android.gms.plus.model.moments.*; 
import com.google.android.gms.drive.realtime.internal.event.*; 
import com.google.android.gms.games.internal.experience.*; 
import com.google.android.gms.games.internal.constants.*; 
import com.google.android.gms.internal.*; 
import com.google.android.gms.actions.*; 
import com.google.android.gms.wallet.wobs.*; 
import com.google.android.gms.drive.query.*; 
import com.google.android.gms.ads.mediation.*; 
import com.google.android.gms.games.internal.events.*; 
import com.google.android.gms.common.internal.safeparcel.*; 
import com.google.android.gms.common.annotation.*; 
import com.google.android.gms.ads.*; 
import com.google.android.gms.common.data.*; 
import com.google.android.gms.identity.intents.*; 
import com.google.android.gms.ads.identifier.*; 
import com.google.android.gms.drive.*; 
import com.google.android.gms.drive.realtime.internal.*; 
import com.google.android.gms.games.internal.player.*; 
import com.google.android.gms.security.*; 
import com.google.android.gms.fitness.request.*; 
import com.google.android.gms.common.images.*; 
import com.google.android.gms.fitness.data.*; 
import com.google.android.gms.drive.metadata.internal.*; 
import com.google.android.gms.cast.*; 
import com.google.android.gms.maps.internal.*; 
import com.google.android.gms.deviceconnection.features.*; 
import com.google.android.gms.games.internal.game.*; 
import com.google.ads.*; 
import com.google.android.gms.ads.purchase.*; 
import com.google.android.gms.auth.*; 
import com.google.android.gms.ads.mediation.admob.*; 
import com.google.android.gms.games.internal.data.*; 
import com.google.android.gms.games.appcontent.*; 
import com.google.android.gms.games.*; 
import com.google.ads.mediation.*; 
import com.google.ads.mediation.customevent.*; 
import com.google.android.gms.dynamic.*; 
import com.google.android.gms.games.internal.multiplayer.*; 
import com.google.android.gms.games.internal.notification.*; 
import com.google.android.gms.fitness.result.*; 
import com.google.ads.mediation.admob.*; 
import com.google.android.gms.games.multiplayer.*; 
import com.google.android.gms.plus.*; 
import com.google.android.gms.common.api.*; 
import com.google.android.gms.appindexing.*; 
import com.google.android.gms.games.event.*; 
import com.google.android.gms.drive.widget.*; 
import com.google.android.gms.games.internal.api.*; 
import com.google.android.gms.analytics.*; 
import com.google.android.gms.drive.internal.*; 
import com.google.android.gms.drive.metadata.*; 
import com.google.android.gms.games.multiplayer.realtime.*; 
import com.google.android.gms.ads.search.*; 
import com.google.android.gms.ads.doubleclick.*; 
import com.google.android.gms.games.request.*; 
import com.google.android.gms.maps.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

// ↑ここまで自動で追加されたもの

// ここからは自前で追加したもの
import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender;
import android.view.View;
import android.view.SurfaceHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;

public class AndroidTest extends PApplet implements
  GoogleApiClient.ConnectionCallbacks,
  GoogleApiClient.OnConnectionFailedListener,
  View.OnClickListener {

  // Google APIs を利用するためのクライアント
  private GoogleApiClient mGoogleApiClient;

  // サインイン用のリクエストコード
  private static int RC_SIGN_IN = 9001;

  private static int RC_UNUSED = 5001;

  // ログを記録する際のタグ
  private static final String TAG = "AndroidTest";

  private boolean mResolvingConnectionFailure = false;
  private boolean mAutoStartSignInFlow = true;
  private boolean mSignInClicked = false;

  boolean DEBUG = true;

  /**
   * 現状特にOverrideする必要はないが、何かあれば
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  /**
   * 同上
   */
  protected void onStart() {
    Log.d(TAG, "onStart()");
    super.onStart();
  }

  protected void onStop() {
    Log.d(TAG, "onStop()");
    super.onStop();
    if (mGoogleApiClient.isConnected()) {
      mGoogleApiClient.disconnect();
    }
  }

  /**
   * サインイン、サインアウトボタンのクリック時の処理
   */
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.button_sign_in:
        // サインインフローの開始
        Log.d(TAG, "Sign-in button clicked");
        mSignInClicked = true;
        mGoogleApiClient.connect();
        // サインインが完了してから(onConnectedで)サインインボタンを隠
        // してサインアウトボタンを表示する
        // よってここでは表示に関する処理は行わない
        break;
      case R.id.button_sign_out:
        // サインアウトフローの開始
        Log.d(TAG, "Sign-out button clicked");
        mSignInClicked = false;
        Games.signOut(mGoogleApiClient);
        mGoogleApiClient.disconnect();
        // サインインしてない状態でサインアウト処理を行うとエラーが発生
        // するので、サインアウトボタンを隠してサインインボタンを表示
        showSignInBar();
        break;
    }
  }

  public void onConnected(Bundle bundle) {
    Log.d(TAG, "onConnected() called. Sign in successful!");
    // サインインが完了したらサインアウトボタンを表示する
    showSignOutBar();
  }

  public void onConnectionSuspended(int i) {
    Log.d(TAG, "onConnectionSuspended() called. Trying to reconnect.");
    mGoogleApiClient.connect();
  }

  /**
   * 接続失敗時の処理
   */
  public void onConnectionFailed(ConnectionResult connectionResult) {
    Log.d(TAG, "onConnectionFailed() called, result: " + connectionResult);

    if (mResolvingConnectionFailure) {
      // 既に接続失敗が解決している場合
      return;
    }

    // サインインボタンが押された場合、または自動開始フラグが有効になっ
    // ていた場合、サインインのフローを開始する
    if (mSignInClicked || mAutoStartSignInFlow) {
      mAutoStartSignInFlow = false;
      mSignInClicked = false;
      mResolvingConnectionFailure = true;

      // 接続失敗の解決を試みる
      if (!resolveConnectionFailure(this, mGoogleApiClient, connectionResult,
                                    RC_SIGN_IN, getString(R.string.signin_other_error))) {
        mResolvingConnectionFailure = false;
      }
    }

    showSignInBar();
  }

  /**
   * 接続失敗の解決
   */
  public boolean resolveConnectionFailure(Activity activity,
                                          GoogleApiClient client,
                                          ConnectionResult result,
                                          int requestCode,
                                          String fallbackErrorMessage) {
    if (result.hasResolution()) {
      try {
        result.startResolutionForResult(activity, requestCode);
        return true;
      } catch (IntentSender.SendIntentException e) {
        client.connect();
        return false;
      }
    } else {
      // 解決不可能ならエラーメッセージを表示
      int errorCode = result.getErrorCode();
      Dialog dialog = GooglePlayServicesUtil.getErrorDialog(errorCode,
                                                            activity, requestCode);
      if (dialog != null) {
        dialog.show();
      } else {
        showAlert(activity, fallbackErrorMessage);
      }
      return false;
    }
  }

  /**
   * TODO: コメント
   */
  protected void onActivityResult(int requestCode, int responseCode, Intent intent) {
    if (requestCode == RC_SIGN_IN) {
      Log.d(TAG,
            "onActivityResult with requestCode == RC_SIGN_IN, responseCode=" +
            responseCode + ", intent=" + intent);
      mSignInClicked = false;
      mResolvingConnectionFailure = false;
      if (responseCode == RESULT_OK) {
        mGoogleApiClient.connect();
      } else {
        Log.d(TAG, "ActivityResultError");
      }
    }
  }

  /**
   * アラートメッセージの表示
   */
  public void showAlert(final Activity activity, final String message) {
    runOnUiThread(new Runnable() {
      public void run() {
        (new AlertDialog.Builder(activity)).setMessage(message)
          .setNeutralButton(android.R.string.ok, null).create().show();
      }
    });
  }

  /**
   * サインイン用のバーの表示
   */
  private void showSignInBar() {
    Log.d(TAG, "Showing sign in bar");
    runOnUiThread(new Runnable() {
      public void run() {
        getWindow().findViewById(R.id.sign_in_bar).setVisibility(View.VISIBLE);
        getWindow().findViewById(R.id.sign_out_bar).setVisibility(View.GONE);
      }
    });
  }

  /**
   * サインアウト用のバーの表示
   */
  private void showSignOutBar() {
    Log.d(TAG, "Showing sign out bar");
    runOnUiThread(new Runnable() {
      public void run() {
        getWindow().findViewById(R.id.sign_in_bar).setVisibility(View.GONE);
        getWindow().findViewById(R.id.sign_out_bar).setVisibility(View.VISIBLE);
      }
    });
  }

  //////////////////////////////////////////////////////////////

  // ここからProcessing用のメソッド

  /**
   * ボタンに割り当てる処理を実行するクラス
   */
  public class Executor {
    Activity activity;

    public Executor(Activity activity) {
      this.activity = activity;
    }

    public void run() {}
  };

  /**
   * 実績のアンロックやリーダーボードの取得を行うためのボタンに利用する
   * クラス
   */
  public class Button {
    int CENTER_X = sketchWidth() / 2; // 画面横軸の中心座標
    int WIDTH = 200;                  // ボタンの幅
    int HEIGHT = 80;                  // ボタンの高さ
    int BASE_COLOR = 255;             // ボタンの色
    int TEXT_COLOR = 50;              // ラベルの色
    int TEXT_SIZE  = 32;              // ラベルの大きさ
    int y, w, h;
    String label;
    Executor executor;

    Button(int y, String label, Executor executor) {
      this.y = y;
      this.label = label;
      this.executor = executor;
    }

    /**
     * ボタンに割り当てられた処理の実行
     */
    void exec() {
      executor.run();
    }

    /**
     * ボタンの描画
     */
    void draw() {
      pushMatrix();

      rectMode(CENTER);
      fill(BASE_COLOR);
      rect(CENTER_X, y, WIDTH, HEIGHT);

      fill(TEXT_COLOR);
      textAlign(CENTER, CENTER);
      textSize(TEXT_SIZE);
      text(label, CENTER_X, y, WIDTH, HEIGHT);

      popMatrix();
    }

    /**
     * タップ位置の判定
     */
    boolean mouseOver() {
      return (mouseX >= (CENTER_X - WIDTH/2) &&
              mouseX <= (CENTER_X + WIDTH/2) &&
              mouseY >= (y - HEIGHT/2) &&
              mouseY <= (y + HEIGHT/2));
    }
  }

  boolean setClickListener = false;
  int rectX = 0;
  Button[] buttons = new Button[5];

  public void setup() {
    // Google API クライアントの生成
    mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN)
            .addApi(Games.API).addScope(Games.SCOPE_GAMES)
            .build();

    final LayoutInflater layoutInflater = LayoutInflater.from(this);

    // UIに関するコードをUIスレッドで実行
    runOnUiThread(new Runnable() {
      public void run() {
        View view = layoutInflater.inflate(R.layout.sign_in_out_bar, null);
        RelativeLayout.LayoutParams lp =
          new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                                          LayoutParams.WRAP_CONTENT);
        getWindow().addContentView(view, lp);
      }
    });

    // サインインフローの開始
    mGoogleApiClient.connect();

    // サインイン、サインアウト以外の各種ボタンの表示
    setupButtons();
  }

  /**
   * 画面に表示するボタンの生成
   */
  public void setupButtons() {
    Executor unlockAchievementA = new Executor(this) {
      public void run() {
        Log.d(TAG, "try unlock achievementA");
        if (mGoogleApiClient.isConnected()) {
          showAlert(activity, getString(R.string.unlock_achievement_a));
          // 実績「achievementA」をアンロックする
          Games.Achievements.unlock(mGoogleApiClient,
                                    getString(R.string.achievement_a));
        }
      }
    };
    buttons[0] = new Button(250, getString(R.string.label_achievement_a), unlockAchievementA);

    Executor unlockAchievementB = new Executor(this) {
      public void run() {
        Log.d(TAG, "try unlock achievementB");
        if (mGoogleApiClient.isConnected()) {
          showAlert(activity, getString(R.string.unlock_achievement_b));
          // 実績「achievementB」をアンロックする
          Games.Achievements.unlock(mGoogleApiClient,
                                    getString(R.string.achievement_b));
        }
      }
    };
    buttons[1] = new Button(350, getString(R.string.label_achievement_b), unlockAchievementB);

    Executor unlockAchievementC = new Executor(this) {
      public void run() {
        Log.d(TAG, "try unlock achievementC");
        if (mGoogleApiClient.isConnected()) {
          showAlert(activity, getString(R.string.unlock_achievement_c));
          // 実績「achievementC」をアンロックする
          Games.Achievements.unlock(mGoogleApiClient,
                                    getString(R.string.achievement_c));
        }
      }
    };
    buttons[2] = new Button(450, getString(R.string.label_achievement_c), unlockAchievementC);

    Executor submitScore = new Executor(this) {
      public void run() {
        Log.d(TAG, "try submit Score");
        if (mGoogleApiClient.isConnected()) {
          // スコアをリーダーボードに送信する
          int score = (int)(random(0, 100)); // スコアは0〜100のランダム
          Games.Leaderboards.submitScore(mGoogleApiClient,
                                         getString(R.string.test_leader_board),
                                         score);
          showAlert(activity, getString(R.string.submit_succeeded));
        }
      }
    };
    buttons[3] = new Button(550, getString(R.string.label_submit_score), submitScore);

    Executor showScores = new Executor(this) {
      public void run() {
        Log.d(TAG, "try show Scores");
        if (mGoogleApiClient.isConnected()) {
          // リーダーボードを表示する
          startActivityForResult(
            Games.Leaderboards.getLeaderboardIntent(mGoogleApiClient, getString( R.string.test_leader_board)),
            RC_UNUSED // 任意のリクエストコード
          );
        }
      }
    };
    buttons[4] = new Button(650, getString(R.string.label_show_scores), showScores);
  }

  public void draw() {
    // マルチスレッドでViewが追加されるので、タイミングによっては
    // SignInButtonなどがfindViewByIdで取得できない。よって取得できるま
    // で繰り返し、取得できたタイミングでイベントリスナーをセットする。
    trySetClickListenerToSignInOutBar();

    // draw()が呼び出されていることの確認用
    // 特に意味はない
    rectAnimation();

    // 実績解除、リーダーボード用ボタンの描画
    for (int i = 0; i < buttons.length; i++) {
      buttons[i].draw();
    }
  }

  /**
   * サインインボタンとサインアウトボタンにクリック時の処理をセットする
   */
  public void trySetClickListenerToSignInOutBar() {
    if (setClickListener) return;

    Log.d(TAG, "try setClickListener");
    SignInButton buttonSignIn = (SignInButton) getWindow().findViewById(R.id.button_sign_in);
    View buttonSignOut = getWindow().findViewById(R.id.button_sign_out);
    if (buttonSignIn != null && buttonSignOut != null) {
      buttonSignIn.setOnClickListener(this);
      buttonSignOut.setOnClickListener(this);
      setClickListener = true;
    } else {
      Log.d(TAG, "could not find buttonSignIn or buttonSignOut, retry next frame.");
    }
  }

  /**
   * 四角が画面左から右へ動くだけのアニメーション
   */
  public void rectAnimation() {
    background(100);
    rectX++;
    if ((rectX + 50) >= sketchWidth()) { rectX = 0; }
    rect(rectX, 500, 50, 50);
  }

  public void mousePressed() {
    // ボタンが押されていた場合はボタンに割り当てられた処理を実行
    for (int i = 0; i < buttons.length; i++) {
      if (buttons[i].mouseOver()) {
        buttons[i].exec();
      };
    }
  }
}
