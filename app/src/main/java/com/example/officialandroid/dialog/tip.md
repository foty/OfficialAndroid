
系统的dialog的宽度默认是固定的，即使你自定义布局的怎么修改宽高也不起作用，如果想修改弹出窗体大小，
可以使用下面这段代码在调用dialog.show()方法之后来实现改变对话框的宽高的需求.

```
dialog.getWindow().setLayout(width,height);
```