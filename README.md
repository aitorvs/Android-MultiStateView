# MultiStateView
This project is a fork of [Android-MultiStateView](https://github.com/MeetMe/Android-MultiStateView)

# Gradle Dependency

### Repository

```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```

### Dependency

```gradle
dependencies {

    // ... other dependencies here

    compile('com.github.aitorvs.multistateview:0.1.0')
}
```
--

# Basics

It is a wrapper Layout that helps you changing the view content depending on its state. Possible states are:

- state **Network Error**, shows a network error banner
- state **General Error**, shows a general error banner
- state **Loading**, shows a loading spinner
- state **Content**, shows the content of the child view

![Loading state](screenshots/sample_loading.png)&nbsp;&nbsp;![General error state](screenshots/sample_general_error.png)

![Network error state](screenshots/sample_network_error.png)&nbsp;&nbsp;![Content state](screenshots/sample_content.png)

## Usage

Set `MultiStateView` as parent of the layout you want to give state content. `MultiStateView` extends from `FrameLayout` so it can be placed as layout most external parent.

**Example**

- This is your original layout:

```xml
    <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/multistateview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:context="com.meetme.android.multistateview.sample.MainActivity"
        tools:showIn="@layout/activity_main">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@string/hello_world"
            android:textColor="#f33"
            android:textSize="24sp"
            android:textStyle="bold" />

    </FrameLayout>
```

- This would be your **multi-state** layout:

```xml
    <com.meetme.android.multistateview.MultiStateView xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/multistateview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingBottom="@dimen/activity_vertical_margin"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        app:layout_behavior="@string/appbar_scrolling_view_behavior"
        tools:context="com.meetme.android.multistateview.sample.MainActivity"
        tools:showIn="@layout/activity_main">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:text="@string/hello_world"
            android:textColor="#f33"
            android:textSize="24sp"
            android:textStyle="bold" />

    </com.meetme.android.multistateview.MultiStateView>
```

You can get a reference to the layout like so:

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //...

        mMultiStateView = (MultiStateView) findViewById(R.id.multistateview);
    }

```

and now you can set the state of the layout like so:

- change to **network error** state:

```java
    //...
    mMultiStateView.setState(MultiStateView.ContentState.ERROR_NETWORK);
    //...
```

- change to **general error** state:

```java
    //...
    mMultiStateView.setState(MultiStateView.ContentState.ERROR_GENERAL);
    //...
```

- change to **loading** state:

```java
    //...
    mMultiStateView.setState(MultiStateView.ContentState.LOADING);
    //...
```

- change to **content** state:

```java
    //...
    mMultiStateView.setState(MultiStateView.ContentState.CONTENT);
    //...
```

### Retry

Default behaviour is to show a retry button. You could register a listener for that button like so:

```java
        //... more code here
        
        mMultiStateView.setOnTapToRetryClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Retry", Toast.LENGTH_SHORT).show();
            }
        });
```

If otherwise you don't want to use that button, it can be disabled and removed from the state view.

```java
        //... more code here
        
        mMultiStateView.disableTapToRetry(true);
```

## License

 Apache 2.0

    Copyright 2013 aitorvs, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
