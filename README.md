# Common-Dialog
Common-Dialog是一个支持链式调用的dialogFragment，提供丰富的属性设置。<br>

###[GitHub 项目地址](https://github.com/canceel/CommonDialog.git)






## 使用说明 Using

##### 完整配置

```java
CommonDialog commonDialog = new CommonDialog.Builder()
		//点击外部区域取消
                .setCanceledOnTouchOutside(false)
		//回调
                .setCallBack(this)
		//设置title
                .setTitleString("权限设置")
		//设置提示信息
                .setMessageString("在设置-应用-CommonDialog-权限中开启相机权限以正常使用拍照，扫一扫等功能")
		//按钮设置
                .setCancelString("取消")
		//按钮设置
                .setAgreeString("确定")
		//设置title颜色
                .setTitleColor(R.color.text_black)
		//设置提示信息颜色
                .setMessageColor(R.color.text_black)
		//设置取消按钮颜色
                .setCancelColor(R.color.text_normal)
		//设置同意按钮颜色
                .setAgreeColor(R.color.text_black)
		//设置title位置，默认左边
                .setTitlePosition(Gravity.LEFT)
		//设置图片大小
                .setImageSpecifications(Utils.dpToPx(mActivity, 50), Utils.dpToPx(mActivity, 50))
		//设置图片
                .setImage(R.mipmap.ic_launcher)
		//是否显示图片
                .showImage(true)
                .build();
        commonDialog.show(getSupportFragmentManager(), "all");
```

##### 开启图片显示

```java
// 提示图片默认不显示
.showImage(true)
```

##### 自定义提示图片

```java
// 提供默认提示图片，通过.setImage()修改
.setImage(R.mipmap.ic_launcher)
```

##### 设置图片大小

```java
// 提示图片默认自适应大小通过setImageSpecifications()设置大小
.setImageSpecifications(Utils.dpToPx(mActivity, 50), Utils.dpToPx(mActivity, 50))  
```

##### 文字颜色设置

```java
.setTitleColor(R.color.text_black)//设置title颜色，默认黑色
.setMessageColor(R.color.text_black)//设置提示信息颜色，默认黑色
.setCancelColor(R.color.text_normal)//设置取消按钮颜色，默认灰色
.setAgreeColor(R.color.text_black)//设置同意按钮颜色，默认黑色
```

##### 文字大小设置

~~~java
.setTitleSize(20)
.setAgreeSize(16)
.setCancelSize(13)
.setMsgSize(15)
~~~



##### 按钮点击处理

```java
通过添加setCallBack()处理按钮点击
.setCallBack(this)//回调
  
	@Override
    public void agree() {
        Toast.makeText(mActivity, "Agree", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancel() {
        Toast.makeText(mActivity, "Cancel", Toast.LENGTH_SHORT).show();
    }
```
```java
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and 
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute, 
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software 
is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE 
AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

```
