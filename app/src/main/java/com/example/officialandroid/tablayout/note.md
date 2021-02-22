TabLayout   


* 修改TabLayout的Indicator宽度(KT写法)
```
private fun setTabIndicator(tabs: TabLayout, leftDip: Int, rightDip: Int) {
 try {
     val tabStrip: Field = tabs.javaClass.getDeclaredField("slidingTabIndicator") //28以前用mTabStrip
     tabStrip.isAccessible = true
     val llTab = tabStrip.get(tabs) as LinearLayout?

     val left = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip.toFloat(),
      Resources.getSystem().displayMetrics).toInt()
     val right = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip.toFloat(),
      Resources.getSystem().displayMetrics).toInt()

     for (i in 0 until llTab!!.childCount) {
     val child = llTab.getChildAt(i)
     child.setPadding(0, 0, 0, 0)
      val params = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f)
      params.leftMargin = left
      params.rightMargin = right
      child.layoutParams = params
      child.invalidate()
     }
 } catch (e: NoSuchFieldException) {
     e.printStackTrace()
 } catch (e: IllegalAccessException) {
     e.printStackTrace()
 } catch (e: NullPointerException) {
     e.printStackTrace()
 }
    }
```

* 调整TabLayout选中后tab的字体大小，粗细等(KT)

正常情况下是无法直接修改Tab中的大小的。有个偏方是替换掉原Tab中的TextView，由外部设置Tab进去，最后通过Tab以
findViewById的形式找到需要改变的TextView加以改变。(注意这里是TabLayout+ViewPager情况)
```
//替换tab
  for (i in 0 until fragmentsPagerAdapter.count) { // fragmentsPagerAdapter是ViewPager的适配器。
      val tabAt = tabLayout.getTabAt(i)
      tabAt?.setCustomView(R.layout.tab_text) //view的xml布局
      if (i == 0) { //默认选中的Tab样式
          tabAt?.customView!!.findViewById<TextView>(R.id.tvTab).isSelected = true
          tabAt.customView!!.findViewById<TextView>(R.id.tvTab)
          .setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
      }
      val textView = tabAt?.customView!!.findViewById<View>(R.id.tvTab) as TextView
      textView.text = titleList[i]
  }

//监听修改
  tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
      override fun onTabReselected(p0: TabLayout.Tab) {
      }
      override fun onTabUnselected(p0: TabLayout.Tab) {//未选中
          updateTabView(p0, false)
      }
      override fun onTabSelected(p0: TabLayout.Tab) { //选中
          updateTabView(p0, true)
      }
  }) 
  
// 更新方法实现
   private fun updateTabView(tab: TabLayout.Tab, isSelect: Boolean) {
        if (tab.customView == null) return
        val tv_tab = tab.customView?.findViewById<View>(R.id.tvTab) as TextView
        if (isSelect) {
            tv_tab.isSelected = true
            tv_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f) //改变字体大小
        } else {
            tv_tab.isSelected = false
            tv_tab.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
        }
   }   
```