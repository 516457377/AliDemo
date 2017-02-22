# AliDemo
附上两张原图

<img alt="App image" src="/gif/a.png" width="250">
<img alt="App image" src="/gif/b.png" width="250">
##1仿支付宝ui#
![第一次效果](/gif/222.gif)
##2 第一个页面
勉勉强强写出来了第一个页面，然后发现不同的屏幕适配是个难题，然后ui图片因为不是专业的网上随便找的。。所以看起来也很难看。。
#
![第二次效果](/gif/002.gif)
##3.修改了一个东西如图，转账那一栏可以滑动了。
有一个问题就是，NestedScrollView里面嵌套了一个LinearLayout的和Recyclerview，然后首次打开LinearLayout会被顶到隐藏掉，直接显示Recyclerview，需要下来LinearLayout才会出来。解决办法。先把Recyclerview，gone掉，然后在mBarLayout的滑动监听里面监听到展开了页面然后将Recyclerview显示出来，就完美了。
#
![003](/gif/003.gif)
