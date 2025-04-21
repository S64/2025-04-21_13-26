# `2025-04-21_13-26`

See below files:

- [`/ep2basedlib/ep2basedlib/src/legacy/java/jp/s64/example/ep2basedlib/MyPlayerFactoryImpl.kt`](./ep2basedlib/ep2basedlib/src/legacy/java/jp/s64/example/ep2basedlib/MyPlayerFactoryImpl.kt)
- [`/ep2basedlib/ep2basedlib/src/styled/java/jp/s64/example/ep2basedlib/MyPlayerFactoryImpl.kt](./ep2basedlib/ep2basedlib/src/styled/java/jp/s64/example/ep2basedlib/MyPlayerFactoryImpl.kt)
- [`/media3app/app/build.gradle.kts](./media3app/app/build.gradle.kts)

## `make test-app-legacy`

```log
> Task :app:connectedLegacyDebugAndroidTest
Starting 2 tests on emulator-5554 - 15

jp.s64.example.media3app.LaunchTest > testLaunch[emulator-5554 - 15] FAILED 
	java.lang.ClassCastException: androidx.media3.ui.AspectRatioFrameLayout cannot be cast to com.google.android.exoplayer2.ui.AspectRatioFrameLayout
	at com.google.android.exoplayer2.ui.PlayerView.<init>(PlayerView.java:403)

emulator-5554 - 15 Tests 2/2 completed. (0 skipped) (1 failed)
Finished 2 tests on emulator-5554 - 15

> Task :app:connectedLegacyDebugAndroidTest
Tests on emulator-5554 - 15 failed: There was 1 failure(s).
Test run failed to complete. Instrumentation run failed due to Process crashed.
Logcat of last crash: 
Process: jp.s64.example.media3app, PID: 2300
java.lang.RuntimeException: Unable to start activity ComponentInfo{jp.s64.example.media3app/jp.s64.example.media3app.MainActivity}: java.lang.ClassCastException: androidx.media3.ui.AspectRatioFrameLayout cannot be cast to com.google.android.exoplayer2.ui.AspectRatioFrameLayout
	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4048)
	at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:4235)
	at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:112)
	at android.app.servertransaction.TransactionExecutor.executeNonLifecycleItem(TransactionExecutor.java:174)
	at android.app.servertransaction.TransactionExecutor.executeTransactionItems(TransactionExecutor.java:109)
	at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:81)
	at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2636)
	at android.os.Handler.dispatchMessage(Handler.java:107)
	at android.os.Looper.loopOnce(Looper.java:232)
	at android.os.Looper.loop(Looper.java:317)
	at android.app.ActivityThread.main(ActivityThread.java:8705)
	at java.lang.reflect.Method.invoke(Native Method)
	at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:580)
	at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:886)
Caused by: java.lang.ClassCastException: androidx.media3.ui.AspectRatioFrameLayout cannot be cast to com.google.android.exoplayer2.ui.AspectRatioFrameLayout
	at com.google.android.exoplayer2.ui.PlayerView.<init>(PlayerView.java:403)
	at com.google.android.exoplayer2.ui.PlayerView.<init>(PlayerView.java:323)
	at com.google.android.exoplayer2.ui.PlayerView.<init>(PlayerView.java:319)
	at jp.s64.example.ep2basedlib.MyPlayerFactoryImpl.createView(MyPlayerFactoryImpl.kt:10)
	at jp.s64.example.ep2basedlib.MyPlayerFactoryImpl.createView(MyPlayerFactoryImpl.kt:7)
	at jp.s64.example.media3app.MainActivity.onCreate(MainActivity.kt:25)
	at android.app.Activity.performCreate(Activity.java:9002)
	at android.app.Activity.performCreate(Activity.java:8980)
	at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1526)
	at androidx.test.runner.MonitoringInstrumentation.callActivityOnCreate(MonitoringInstrumentation.java:766)
	at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:4030)
	... 13 more


> Task :app:connectedLegacyDebugAndroidTest FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':app:connectedLegacyDebugAndroidTest'.
> There were failing tests. See the report at: file:///home/runner/work/2025-04-21_13-26/2025-04-21_13-26/media3app/app/build/reports/androidTests/connected/debug/flavors/legacy/index.html

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

BUILD FAILED in 30s
```

- https://github.com/S64/2025-04-21_13-26/actions/runs/14567431208/job/40858816883#step:7:553

## `make test-app-styled`

```log
> Task :app:connectedStyledDebugAndroidTest
Starting 2 tests on emulator-5554 - 15

Finished 2 tests on emulator-5554 - 15

BUILD SUCCESSFUL in 21s
```

- https://github.com/S64/2025-04-21_13-26/actions/runs/14567431208/job/40858817063#step:7:553
