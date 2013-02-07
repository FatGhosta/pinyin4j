#pinyin4j 笔记#
##类TextHelper#

1\. 获取拼音音标数  
>>String extractToneNumber(String hanyuPinyinWithToneNumber)  

2\. 获取简化拼音字符串  
>>String extractPinyinString(String hanyuPinyinWithToneNumber)  

##类ResourceHelper##
1\.获取字典文件的BufferedInputStream  
>>BufferedInputStream getResourceInputStream(String resourceName)  

##类PinyinRomanizationResource##
一个private的Document属性  
构造器通过类ResourceHelper初始化Document属性  
有一个单例工厂，内部类PinyinRomanizationSystemResourceHolder  

