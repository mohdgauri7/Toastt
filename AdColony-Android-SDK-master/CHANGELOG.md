# Change Log
## 4.6.5 (2021/10/21)
* AD_ID permission support for Android 12.
* Various internal, edge case bugfixes that have not been publicly reported by publishers.

## 4.6.4 (2021/09/15)
* Improved JSON synchronization to fix edge case ConcurrentModificationException.

## 4.6.3 (2021/08/30)
* Altered user agent retrieval logic to avoid issues with WebView reported during initialization.

## 4.6.2 (2021/08/23)
* Fixed NullPointerException exposed in 4.6.0.

## 4.6.1 (2021/08/10)
* Fix NullPointerException and NoClassDefFoundError exposed by 4.6.0 on devices below API 19.

## 4.6.0 (2021/08/03)
* Note: Potentially requires Gradle Plugin version updates. See [this blog post](https://android-developers.googleblog.com/2020/07/preparing-your-build-for-package-visibility-in-android-11.html) for more information.
* Internal communication adjustments to improve CPU usage and battery life
* Threading optimization to minimize number of concurrent threads and memory usage
* Additional ad request safety to avoid potential timeouts
* Fixed issue where interstitial ad show attempts would fail without feedback when a network filter mismatch occurred
* Added support for app install demand from additional stores
* Fixed edge case ANR on Unity
* Fixed edge case ConcurrentModificationException
* Optimized data returned via collectSignals()
* Various other bug fixes and performance improvements

## 4.5.0 (2021/04/02)
* Optimized data returned via collectSignals()
* Altered session measurement logic to reach parity with iOS.
* Fixed edge case NoSuchElementException due to thread synchronization issue
* Fixed edge case Error when clearCustomMessageListeners() is called

## 4.4.1 (2021/01/28)
* Fixed edge case exception thrown when using asynchronous collectSignals

## 4.4.0 (2021/01/12)
* Minimized exposure to specific Android APIs through our JavascriptInterface due to policy changes from Google
* Added asynchronous AdColony.collectSignals() and deprecated synchronous version
* Various bugfixes

## 4.3.1 (2020/12/08)
* Added device_audio (boolean) to AdColony.collectSignals() output
* Fixed exception while clicking on a display ad

## 4.3.0 (2020/10/09)
* Moved WebView user agent retrieval to background thread.
* Added logAppOpen() and logAdImpression() methods to AdColonyEventTracker API.
* Updated OM SDK to v1.3.11
* Internal optimization of network request timeouts.

## 4.2.4 (2020/09/10)
* Fixed internal error leading to an issue with our Unity Plugin from v4.2.3.

## 4.2.3 (2020/09/02)
* Fixed edge case ANR witnessed by some surrounding WebView instantiation.

## 4.2.2 (2020/08/03)
* Fixed issue with banner clickthroughs under specific circumstances when AdColony is configured with an Application reference.

## 4.2.1 (2020/07/23)
* Removed use of StandardCharsets for compatibility with older Android API versions.

## 4.2.0 (2020/07/07)
* Deprecated AdColonyUserMetadata.
* Deprecated GDPR specific methods in AdColonyAppOptions in favor of a more generic solution that allows for inclusion of information related to other privacy laws. Please see our page on [privacy laws](https://github.com/AdColony/AdColony-Android-SDK/wiki/Privacy-Laws) for more information.
* Updated and added support for OM SDK v1.3.4.
* Added collectSignals() helper for certain advanced bidding mediation integrations.
* Various bugfixes.

## 4.1.4 (2020/02/25)
* Updated OM SDK to v1.3.1.
* Fixed [issue #72](https://github.com/AdColony/AdColony-Android-SDK/issues/72).

## 4.1.3 (2020/01/17)
* Updated OM SDK to v1.3.0

## 4.1.2 (2019/12/17)
* Improved handling of exception originally addressed in [3.3.8](https://github.com/AdColony/AdColony-Android-SDK/blob/master/CHANGELOG.md#338-20190117)

## 4.1.1 (2019/12/06)
* Fixed issue [#65](https://github.com/AdColony/AdColony-Android-SDK/issues/65)
* Amazon Advertising Id collection.
* Slightly reduced SDK size.
* Updated OM SDK.
* Various Bugfixes.

## 4.1.0 (2019/09/23)
* Added banner ads.
* Implemented the Open Measurement SDK for viewability measurement and received certification from IAB.

## 4.0.0 (2019/09)
* Closed beta.

## 3.3.11 (2019/07/15)
* Fixed ConcurrentModificationException that was exposed with a server-side update.
* Fixed an issue related to partial downloads that potentially caused AdColony to become disabled.

## 3.3.10 (2019/04/09)
* Improved WebView behavior for duties previously handled by our shared object libraries.

## 3.3.9 (2019/03/20)
* Fixed NullPointerException that stopped ads from being served on Android Lollipop devices with the 3.3.7 and 3.3.8 SDKs.

## 3.3.8 (2019/01/17)
* Handled RuntimeExceptions that can occur during WebView initialization if the device reports that it is missing the WebView package

## 3.3.7 (2018/12/06)
* Significant stability improvements related to memory consumption.
* Reduced ad request response times.
* Removed shared object (.so) libraries, reducing the size of our SDK distribution by 94% in the process, as well as addressing issues [#25](https://github.com/AdColony/AdColony-Android-SDK-3/issues/25), [#33](https://github.com/AdColony/AdColony-Android-SDK-3/issues/33), and [#38](https://github.com/AdColony/AdColony-Android-SDK-3/issues/38).

## 3.3.6 (2018/11/07)
* Added additional configure() signatures that accept an Application context instead of Activity.
* Deprecated AdColonyAdViewActivity, AdColonyNativeAdView, and onAudioStarted/onAudioStopped() callbacks.
* Handle API level 28 changes for [default cleartext traffic behavior](https://developer.android.com/about/versions/pie/android-9.0-changes-28#framework-security-changes).
* Several bug fixes and stability improvements.

## 3.3.5 (2018/06/27)
* Fixed RejectedExecutionException in issue [#37](https://github.com/AdColony/AdColony-Android-SDK-3/issues/37).
* Made Android SDK changes needed to fix the Unity OnConfigurationCompleted callback issue in [#35](https://github.com/AdColony/AdColony-Unity-SDK-3/issues/35).
* Several bug fixes and stability improvements.

## 3.3.4 (2018/05/18)
* Added a new API to pass user consent as required for compliance with the European Union's General Data Protection Regulation (GDPR).
* Fixed new NullPointerException mentioned in issue [#29](https://github.com/AdColony/AdColony-Android-SDK-3/issues/29#issuecomment-381380548).
* Several bug fixes and stability improvements.

## 3.3.3 (2018/04/13)
* Fixed issue [#29](https://github.com/AdColony/AdColony-Android-SDK-3/issues/29).
* Several other bug fixes.

## 3.3.2 (2018/03/16)
* Several bug fixes.

## 3.3.0 (2017/12/13)
* Added Integral Ad Science (IAS) for viewability measurement.
* Fixed storage overuse issue reported by a small number of publishers upgrading from 2.x -> 3.x.
* Added an app option that allows publishers to disable screen sleeps during ad playback.
* Several bug fixes, memory usage optimizations, and stability improvements.

## 3.2.1 (2017/08/28)
* Fixed AAR hosted on Bintray.

## 3.2.0 (2017/08/24)
* Android Oreo compatibility along with several bugs fixes, stabilty and security improvements.
* User experience improvements via enhanced skippability controls and a new mute/unmute feature.
* Post-install events APIs.
* Crash reporting and a new, convenient test mode feature.

## 3.1.2 (2017/04/06)
* Updates for Unity and Adobe Air plugins.

## 3.1.1 (2017/03/28)
* Removed Compass™ APIs.

## 3.1.0 (2017/03/06)
* MOAT viewability support.
* Added viewable impression tracking metric.
* Added support for our dashboard's play frequency zone setting.
* Fixed edge case IllegalStateException and NullPointerException on our MediaPlayer handler when our interstitial Activity is destroyed.
* No longer setting HTTPUrlConnection redirect property globally.
* Lowered our library's minimum SDK version to fix build issues with apps that support earlier versions. Devices below API 14 will still be blocked at runtime from viewing ads.

## 3.0.7 (2016/12/20)
* Increased safety in the case where our interstitial Activity is destroyed while paused due to memory pressure.

## 3.0.6 (2016/11/30)
* Fixed an edge case NPE in our interstitial Activity.
* General stability improvements.

## 3.0.5 (2016/11/09)
* Exposed onLeftApplication and onClicked ad callbacks.
* Fixed possible ad display issue for apps that configure AdColony post onCreate.

## 3.0.4 (2016/10/10)
* Initial public release.
* Fixed issue with our x86 builds.
* Various stability improvements/bug fixes.
* Added messaging features to Compass, which includes both in-app messages and push notifications.

## 3.0.3.2 (2016/09/14)
* Support for vertical ads and improved ad orientation controls.
* Added armeabi-v7a builds.
* Added support for multi-screen.
* Changed package name to com.adcolony.sdk.
* Removed theme requirement for AdColony Activity manifest declarations.

## 3.0.2.2 (2016/08/10)
* Ensure out of date files from earlier SDK installs are invalidated.

## 3.0.2.1: (2016/07/28)
* Added support for native ads.
* Added support for in-app purchase promo ads.
* Added support for custom messages.
* Introduction of AdColony Compass™.
* Various stability improvements/bug fixes.
