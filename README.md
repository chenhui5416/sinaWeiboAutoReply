sinaWeiboAutoReply
==================

新浪微博指定用户微博自动评论功能，可以根据你指定的好友，对其最新发布的每一条微博进行指定内容的评论

API说明：使用新浪微博JAVA API ，开发工具为myeclipse，环境要求java6.0以上。

文件中product 内有编译完成文件，但由于新浪微博的API限制，该应用没有上线新浪微博，所以测试用户只能指定，需要进行测试可以联系我，或者修改Config.properties中的开发者信息，并在自己的开发者测试中添加相应测试用户

调试说明，请先填写新浪微博API验证相关配置：在Config.properties里
client_ID ：appkey                           
client_SERCRET ：app_secret
redirect_URI : 回调地址
