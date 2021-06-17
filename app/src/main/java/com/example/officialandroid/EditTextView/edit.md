EditTextView


* 输入字母自动转换成大写。   
这个法子有点枯燥，要将输入的26个字母由小写输出成大写。 
```
EditText.setTransformationMethod(new ReplacementTransformationMethod() {
            @Override
            protected char[] getOriginal() {
                char[] originalCharArr = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
                'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
                return originalCharArr;
            }
 
            @Override
            protected char[] getReplacement() {
                char[] replacementCharArr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 
                'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
                return replacementCharArr;
            }
        });
    }
```
这让我想到了一个更将平常的方法：添加addTextChangedListener,在它的afterTextChanged()方法，由小写转成大写。相对setTransformationMethod(),个人觉得麻
烦些。

* 系统键盘要求右下角显示“搜索”按钮  
1、在xml文件的EditTextView添加下面设置
```
android:imeOptions="actionSearch"
android:singleLine="true"
android:maxLines="1"
```
对于`singleLine``maxLines`这两个属性有些机型不一样，可能只使用其中一个或者不使用都有效，属于非必药条件，更有可能与
焦点有关，这个具体试验即可。`imeOptions`是必要条件。然后添加按钮的监听事件，主要是setOnKeyListener接口监听：
```kotlin
 EditText.setOnKeyListener { v, keyCode, event ->
     if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
         // 执行逻辑
     }
     false
 }
```