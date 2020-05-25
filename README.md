<h3 align="center">Kotlin-Util-Extensions </h1><br>
<p align="center">library for common extensions in kotlin </p>



#### Implementation
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```    
  
  
  ```
  dependencies {
	        implementation 'com.github.bhan-agl:Kotlin-Util-Extensions:1.0.0'
	}
  ```
  
#### Usage 
To start a new activity from an activity 
```
    startActivityEtx<SecondActivivty>()
```    

To start a new activity from fragment
```
    activity?.startActivityEtx<SecondActivivty>()
```    

To check network connectivity 
``` 
   {activity/fragment/context}.hasNetwork()
```

##### Common View Etx 
``` 
View.gone()
```

```
View.invisible()
```
```
View.visible()
```
```
View.isVisible()
```
```
View.isGone()
```
```
View.isInvisible()
```

