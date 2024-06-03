package Assignment;

import org.json.simple.*;

public class JSON {
	
	public static void main(String arg[]) {
		JSONObject student = new JSONObject();
		student.put("Name", "jhon");
		student.put("Age", new Integer(19));
		student.put("Marks", new Integer(67));
		student.put("School", "S K High School");
		
		System.out.println("Student Object : " + student);
		
		String JSONText = JSONValue.toJSONString(student);
		
		System.out.println("JSON String : " + JSONText);
	}
	
}
