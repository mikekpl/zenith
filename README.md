# Zenith
> All in one utility tool for Android. If you find anything we can add / improve, feel free to do a pull request :)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Zenith-brightgreen.svg?style=popout-square)](https://android-arsenal.com/details/1/7019)
[![Android Arsenal](https://img.shields.io/badge/Twitter-mike14u-blue.svg?style=popout-square)](https://www.twitter.com/mike14u)
[![Android Arsenal](https://img.shields.io/badge/Github-mike14u-ff69b4.svg?style=popout-square)](https://github.com/mike14u)


Zenith is a library for Android written in Kotlin for ready made helpers and make development easier. It covers wide ranges of support
from widgets to raw utility classes. If there are things we can improve or add to the library, feel free, just let me know.

## Getting Started

Make sure to have Android Studio

Gradle

```
repositories {
    maven { url "https://jitpack.io" }
}
```

```
implementation 'com.github.mike14u:zenith:1.1.6'
```

## Usage example

This library mostly contains utility examples, below are 2 Class examples:

**CheckNetwork**

```
CheckNetwork.isInternetAvailable(...) // Returns true or false whether it is or it isn't
```

**DebugLog**

```
DebugLog.showException(context, class, throwable) // Shows Throwable / Exception with context and class details
DebugLog.showError(context, string) // Shows Log in error form (RED) so we can determine it easily
DebugLog.printStackTrace(exception) // Shows error message of exception
DebugLog.justPrint("message") // Shows a log in error format
```

_For more examples and usage, please refer to the [Wiki](https://github.com/mike14u/zenith/wiki)._

## Meta

Distributed under the Apache License. See ``LICENSE`` for more information.

## Contributing

1. Fork it (<https://github.com/mike14u/zenith/fork>)
2. Create your feature branch (`git checkout -b feature/fooBar`)
3. Commit your changes (`git commit -am 'Add some fooBar'`)
4. Push to the branch (`git push origin feature/fooBar`)
5. Create a new Pull Request