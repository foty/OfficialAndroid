列表加载图片，滑动时不加载图片设计:
```
view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Glide.with(this).resumeRequests(); //非滑动
                } else {
                    Glide.with(this).pauseRequests();
                }
            }
        });
```