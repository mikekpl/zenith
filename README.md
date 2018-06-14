# Zenith

## All in one utility tool for Android (more to come soon!)

Gradle

```
repositories {
    maven { url "https://jitpack.io" }
}
```

```
implementation 'com.github.ekimual:zenith:1.0.1'
```

## Class Usage

### zenith > utils
#### DebugLog
Used for logging, reporting error messages and making sure production version doesn't show any logs.

In Application Class
```
DebugLog.isProduction = false // If set to true it won't show logs since its for production.
```
In any class
```
DebugLog.showException(context, class, throwable) // Shows Throwable / Exception with context and class details
DebugLog.showError(context, string) // Shows Log in error form (RED) so we can determine it easily
DebugLog.printStackTrace(exception) // Shows error message of exception
```

#### CheckNetwork
Used for checking internet availability.

```
CheckNetwork.isInternetAvailable(...) // Returns true or false whether it is or it isn't
```

#### EndlessRecyclerOnScrollListener
Used for endless scrolling for ListViews / RecyclerViews (Pagination)

```
recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener ...) // Callback onLoadMore, do what you want upon paginating.
```

#### NetworkStateReceiver
An interface used for checking network state (internet connected, internet disconnected)

```
networkAvailable() // Do something when you get connected
networkUnavailable() // Do something when you get disconnected
```
==============================================================

### zenith > adapters
#### GenericListAdapter
Instead of extending to RecyclerView.Adapter, use GenericListAdapter! Easily define your models through your adapters.

```
Class : GenericListAdapter<*> // * can be User, Employee, People etc model classes
```

### zenith > dialogs
#### FixedHoloDatePickerDialog
Forces the date pickers to be Holo Themed

### zenith > widgets
#### NoScrollTextView
Simply a TextView that cannot be scrolled

Usage layout in XML
```
<NoScrollTextView ...>
```

#### TextViewLinkHandler
Automatically handle links that are present in TextView e.g. websites, emails.