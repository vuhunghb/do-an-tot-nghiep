package irestads.defination;

public class BooleanToShow {
	public static String booleanToShow(boolean value,String showTrue, String showFalse){
		if(value==true){
			return showTrue;
		}else {
			return showFalse;
		}
		
	}

}
