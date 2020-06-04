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
	        implementation 'com.github.bhan-agl:Kotlin-Util-Extensions:1.0.1'
	}
  ```
  
## Common Extensions
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

Try and Catch
```
tryAndCatch<NoInternetException>({
            val userInfo = iRepository.getUserInfo()
        }, { noInternetException ->
            showToast(noInternetException.message ?: "Something went wrong")
        })
```

## Common View Etx 
<img src="https://user-images.githubusercontent.com/57934056/83789800-da98ea00-a6b4-11ea-8cf4-9582bd876c35.png"/>

## One liner view binding    
##### For Single liner binding in activity 
<img src="https://user-images.githubusercontent.com/57934056/83788933-9eb15500-a6b3-11ea-86ac-54a988f19871.png"/>   
 
##### For Single liner binding in fragment    
<img src="https://user-images.githubusercontent.com/57934056/83788940-a113af00-a6b3-11ea-9a86-83a647617b6a.png"/>




