Android-Technical Assignment by Baraka
=========================


Introduction
-----------------
This is a sample task shows stock market tickers written by kotlin using the Uncle Bob's clean architecture approach.
This project takes advantage of latest Jetpack Architecture Component libraries and tools of the Android ecosystem.


Clean architecture
-----------------
![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture/clean_architecture.png)

Architectural approach
-----------------
![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture/clean_architecture_layers.png)

Architectural reactive approach
-----------------
![http://fernandocejas.com/2015/07/18/architecting-android-the-evolution/](https://github.com/android10/Sample-Data/blob/master/Android-CleanArchitecture/clean_architecture_layers_details.png)

Teck Stack
-----------------
Min API level is set to 21, so the presented approach is suitable for over 94% of devices running Android.

Jetpack:
Android KTX - provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
AndroidX - major improvement to the original Android Support Library, which is no longer maintained.
Jetpack Compose - Jetpack Compose is Android’s modern toolkit for building native UI. It simplifies and accelerates UI development on Android bringing your apps to life with less code, powerful tools, and intuitive Kotlin APIs. It makes building Android UI faster and easier. /
LiveData - lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services.
Room - persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
ViewModel - designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations.
Coroutines - managing background threads with simplified code and reducing needs for callbacks.
Coroutines Flow - cold asynchronous data stream that sequentially emits values and completes normally or with an exception
Dagger Hilt - dependency injector for replacement all Factory classes.
Retrofit - type-safe HTTP client.
JUnit - Quick and easy generation of test cases and test data.