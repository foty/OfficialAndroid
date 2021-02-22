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