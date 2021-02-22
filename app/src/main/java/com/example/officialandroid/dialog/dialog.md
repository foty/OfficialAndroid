
系统的dialog的宽度默认是固定的，即使你自定义布局的怎么修改宽高也不起作用，如果想修改弹出窗体大小，
可以使用下面方法在调用dialog.show()方法之后来实现改变对话框的宽高的需求.

* 设置Dialog的size
```
dialog.getWindow().setLayout(width,height);
``` 
如果上述代码不生效，可使用下面方法(推荐用这个) 
```
//在 dialog.show()之后设置(注意设置时机)
  Window window = dialog.getWindow();
  WindowManager.LayoutParams lp = window.getAttributes();
  lp.gravity = Gravity.CENTER;
  lp.width = LayoutParams.MATH_PARENT;//宽高可设置具体大小
  lp.height = LayoutParams.MATH_PARENT;
  window.setAttributes(lp);
```
上面是固定dialog大小的设置。如果在内容少的情况下，dialog还是一样大会显得页面很空洞，体验不好。这时可以通过设
置padding控制dialog的大小：
```
  Window window = dialog.getWindow();
  window.getDecorView().setPadding(0, 50, 0, 50); //设置上下padding(单位:px)
  WindowManager.LayoutParams lp = window.getAttributes();
  lp.gravity = Gravity.CENTER; //设置重心
  lp.width = WindowManager.LayoutParams.MATH_PARENT;//宽高可设置具体大小
  lp.height = WindowManager.LayoutParams.MATH_PARENT;
  window.setAttributes(lp);
```
