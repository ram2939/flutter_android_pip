package com.bostrot.flutterandroidpip;
import android.util.Rational;
import android.annotation.TargetApi;
import android.os.Build;
import android.app.PictureInPictureParams;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;


/** FlutterAndroidPipPlugin */
public class FlutterAndroidPipPlugin implements MethodCallHandler {
  /** Plugin registration. */
  static Registrar _registrar;
	int y;	
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_android_pip");
    channel.setMethodCallHandler(new FlutterAndroidPipPlugin());
    _registrar = registrar;
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("enterPictureInPictureMode")) {
        if (Build.VERSION.SDK_INT > 24)
	y=call.argument("ratio");
          _registrar.activity().enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(y,1)).build());
        result.success("Android " + android.os.Build.VERSION.RELEASE);
      } else {
        result.notImplemented();
      }
    }
  }

