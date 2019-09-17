# AlienEscape
Simple runner with a few tests to demonstrate the use of JUnit/Mockito in a libGDX application.

Based on http://williammora.com/a-running-game-with-libgdx-part-1.  
Added a few tests and made minor changes to the original code.

## Troubleshooting

### Building for Android
If you want to build for Android, you will need to install the Android SDK and specify the installation path in the Gradle configuration (e.g., by adding a line similar to `sdk.dir=<your_path>/Android/Sdk` in a `local.properties` file at the root of the project).

### Errors with Android SDK
If you do not want to build for Android but are getting errors related to the missing SDK (since the project is intended to be cross-platform), you will either need to install it anyway (see above) or remove the Android submodule from the Gradle project:

In `settings.gradle`, remove or comment out `'android'` from the following line:
```
include 'desktop', 'android', 'html', 'core'
```

Then, in the top-level (at the root of the project) `build.gradle` file, remove or comment out:
```groovy
project(":android") {
...
}
```
### Errors with the web version
If you have errors/issues related to the web version (which hasn't been tested):

In `settings.gradle`, remove or comment out `'html'` from the same line:
```
include 'desktop', 'android', 'html', 'core'
```

Then, in the top-level (at the root of the project) `build.gradle`, remove or comment out:
```groovy
project(":html") {
...
}
```
