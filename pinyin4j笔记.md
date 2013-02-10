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

##类PinyinRomanizationType##
拼音罗马化类型，包括如下几种：  
>>HANYU_PINYIN  
>>WADEGILES_PINYIN  
>>MPS2_PINYIN  
>>YALE_PINYIN  
>>TONGYONG_PINYIN  
>>GWOYEU_ROMATZYH  

##类PinyinRomanizationTranslator##
拼音罗马化类型之间转换的工具  
   
##类ChineseToPinyinResource##
一个private的Properties属性    
构造器读取字典文件，初始化Properties属性。  
一个单例工厂模式控制实例。  
Field类，定义了左括号、右括号、逗号。  
1\. 该方法返回ch的所有拼音发音
>> String[] getHanyuPinyinStringArray(char ch)    
  
2\. 该方法将char类型字符转换成16进制int类型，返回给方法getHanyuPinyinStringArray使用  
>> private String getHanyuPinyinRecordFromChar(char ch)  
  
##类GwoyeuRomatzyhResource##
有个private的Document属性  
构造器通过类ResourceHelper初始化Document属性  
有一个单例工厂，内部类GwoyeuRomatzyhSystemResourceHolder  
  
##类GwoyeuRomatzyhTranslator##
通用拼音与国语罗马拼音类型之间转换的工具   

##类PinyinFormatter##
1\. 将文字字符串，通过HanyuPinyinOutputFormat的定义，转换成拼音字符串。  
>>static String formatHanyuPinyin(String pinyinStr,HanyuPinyinOutputFormat outputFormat)  
  
2\. 处理音调。  
>>private static String convertToneNumber2ToneMark(final String pinyinStr)  

  
##类PinyinHelper##
类说明：作为这个pinyin4j的最重要的类，引入了生成各种拼音格式的方法。  
  
1\. 通过ChineseToPinyinResource生成未格式化的拼音字符串。  
private static String[] getUnformattedHanyuPinyinStringArray(char ch)  
  
2\.  生成格式化的拼音字符串  
static private String[] getFormattedHanyuPinyinStringArray(char ch,
            HanyuPinyinOutputFormat outputFormat)  
          
3\. 转换目标格式拼音字符串   
private static String[] convertToTargetPinyinStringArray(char ch,
            PinyinRomanizationType targetPinyinSystem)
  
4\. 获得首字母 
static private String getFirstHanyuPinyinString(char ch,
            HanyuPinyinOutputFormat outputFormat)
