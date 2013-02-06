Pinyin4j 笔记 之 format
==============

##类HanyuPinyinOutputFormat##
类说明：与汉语拼音输出有关的格式定义  
三个pirvate属性并有相应的getter和setter方法：  
>>HanyuPinyinVCharType
>>HanyuPinyinCaseType
>>HanyuPinyinToneType

构造函数初始化三个私有属性。

##类HanyuPinyinVCharType##
类说明：对v的输出处理  
只有一个protect属性name；  
有三个常量 
>>WITH_U_AND_COLON  
>>WITH_V  
>>WITH_U_UNICODE 

分别代表对拼音中V的不同处理。   
  
构造函数必须对name进行初始化  

##类HanyuPinyinCaseType##
类说明：控制汉语拼音输出大小写  
只有一个protect属性name  
有两个常量：  
>>UPPERCASE
>>LOWERCASE
  
分别表达大写和小写  
  
其构造函数必须对name进行初始化。

##类HanyuPinyinToneType##
类说明：控制汉语拼音音调的输出格式  
只有一个protect属性name   
有三个常量 
>>WITH_TONE_NUMBER  
>>WITHOUT_TONE  
>>WITH_TONE_MARK   

分别表达音调为数字，没有音调，音调标音。  
  




