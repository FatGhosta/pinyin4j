package net.sourceforge.pinyin4j;

import java.util.Properties;


public class ChineseWithPolyphonesToPinyinResource {
	
	private Properties unicodeToHanyuPinyinWithPolyphonesTable = null;

	private Properties getUnicodeToHanyuPinyinWithPolyphonesTable() {
		return unicodeToHanyuPinyinWithPolyphonesTable;
	}

	private void setUnicodeToHanyuPinyinWithPolyphonesTable(
			Properties unicodeToHanyuPinyinWithPolyphonesTable) {
		this.unicodeToHanyuPinyinWithPolyphonesTable = unicodeToHanyuPinyinWithPolyphonesTable;
	}
	
	private ChineseWithPolyphonesToPinyinResource(){
		initializeResource();
	}

	private void initializeResource() {
		try {
			final String resourceName = "/ployphones_to_hanyu_pinyin.txt";
			
			setUnicodeToHanyuPinyinWithPolyphonesTable(new Properties());
			getUnicodeToHanyuPinyinWithPolyphonesTable().load(ResourceHelper.getResourceInputReader(resourceName));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	String getHanyuPinyinStringWithPolyphones(String string){
		for(int i=0; i<string.length(); i++){
			String pinyinRecord = getHanyuPinyinRecordFromChar(string.charAt(i));
			
			if(null != pinyinRecord){
				int indexOfLeftBracket = pinyinRecord.indexOf(Field.LEFT_BRACKET);
	            int indexOfRightBracket = pinyinRecord.lastIndexOf(Field.RIGHT_BRACKET);
	            
	            String polyphonesStrings = pinyinRecord.substring(indexOfLeftBracket+ Field.LEFT_BRACKET.length(), indexOfRightBracket);
	            String[] polyphonesString = polyphonesStrings.split(Field.COMMA);
	            for(int j=0; j<polyphonesString.length; j++){
	            	String[] phrase = polyphonesString[j].split(Field.COLON);
	            	if(phrase[0].contains(String.valueOf(string.charAt(i)))){
	            		if(string.substring(i, i+2).equals(phrase[0])||string.substring(i, i+3).equals(phrase[0])
	            				||string.substring(i-1, i+1).equals(phrase[0])||string.substring(i-2, i+1).equals(phrase[0])){
	            			string = string.replaceAll(phrase[0], phrase[1]);
	            		}
	            	}
	            }
			}
		}
		return string;
	}
	
	private String getHanyuPinyinRecordFromChar(char ch) {
//		String key = Integer.toHexString(ch).toUpperCase();
		String foundRecord = getUnicodeToHanyuPinyinWithPolyphonesTable().getProperty(String.valueOf(ch));
		
		return foundRecord;
	}

	static ChineseWithPolyphonesToPinyinResource getInstance(){
		return ChineseWithPolyphonesToPinyinResourceHolder.instance;
	}
	
	private static class ChineseWithPolyphonesToPinyinResourceHolder{
		static final ChineseWithPolyphonesToPinyinResource instance = new ChineseWithPolyphonesToPinyinResource();
	}
	
	class Field
    {
        static final String LEFT_BRACKET = "(";

        static final String RIGHT_BRACKET = ")";

        static final String COMMA = ",";
        
        static final String COLON = ":";
    }
	
	public static void main(String[] args) {
		String string = "笑傲江湖调查五岳剑派";
		String result = ChineseWithPolyphonesToPinyinResource.getInstance().getHanyuPinyinStringWithPolyphones(string);
		System.out.println(result);
	}
}
