# AlienEscape
Simple runner with a few tests to demonstrate the use of JUnit/Mockito in a libGDX application.

Based on http://williammora.com/a-running-game-with-libgdx-part-1.  
Added a few tests and made minor changes to the original code.

## Troubleshooting

If you have errors/issues related to the web version (which hasn't been tested):

In `settings.gradle`, change:
```
include 'desktop', 'android', 'html', 'core'
```
To:
```
include 'desktop', 'android', 'core'
```

Then, in the top-level (at the root of the project) `build.gradle`, remove:
```groovy
project(":html") {
...
}
```
