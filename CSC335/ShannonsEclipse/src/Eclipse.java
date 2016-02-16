/*
 * Eclipse.java
 * This example shows Reflection by 
 * mimicking an autofill popup window from Eclipse.
 * In particular, it prompts the user for the fully qualified
 * name of a class and it prints all the fields and methods of 
 * that class.  
 * 
 * Non-statics entities are printed before statics, and 
 * fields are printed before methods. 
 * Within each group, items are alphabetized by name.
 */

import java.lang.reflect.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Eclipse {
	// you always want a small main...
	public static void main(String[] args) {
		Eclipse reflect = new Eclipse();
		reflect.interaction();
	}

	/*
	 * Main interaction:  Have the user enter a class
	 * name (fully specified) and then print its information.
	 */
	public void interaction(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the fully specified class to use or 'q' to quit.");
		String className = scan.nextLine();
		try{
			Class<?> theClass = Class.forName(className);
			Field[] fields = theClass.getFields();
			Method[] methods = theClass.getMethods();

			// The boolean argument tells whether or not to look at static
			// or non-static entities.
			Arrays.stream(fields).filter(x -> Modifer.isStatic(x.getModifiers())).forEach(printField(true, x));
			printField(false, fields);
			printMethod(false, methods);
			printField(true, fields);
			printMethod(true, methods);
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("I don't know that class name.  Quitting...");
			// uncomment this for debugging.  Keep it commented for release.
			//e.printStackTrace();
		}
		scan.close();
	}

	// This method prints all the fields whose static-ness matches the 
	// boolean argument.  It sorts them by name first.  If it prints
	// a static field it prints 'S:' first.
	// Format is:
	// <NAME> : <TYPE> - <DECLARING-CLASS>
	
	public void printField(boolean isStatic, Field field) {
		// Print the information
		if (isStatic) {
			System.out.print("S:");
		}
		System.out.print(field.getName() + " : ");
		System.out.print(field.getType().getName() + " - ");
		System.out.println(field.getDeclaringClass().getName());		
	}

	// This method prints all the methods whose static-ness matches the 
	// boolean argument.  It sorts them by name first.  If it prints
	// a static method it prints 'S:' first.
	// Format is:
	// <NAME>(<PARA-TYPE>, <PARA-TYPE>, <...> ) : <RETURN-TYPE> - <DEC-CLASS>

	public void printMethods(boolean isStatic, Method method) {
		// Print the method information
		if (isStatic) {
			System.out.print("S:");
		}
		System.out.print(method.getName() + "(");
		Class<?> ret = method.getReturnType();
		Class<?>[] params = method.getParameterTypes();
		for (int i = 0; i < params.length - 1; i++) {
			System.out.print(params[i] + ", ");
		}
		if (params.length != 0) {
			System.out.print(params[params.length - 1]);
		}
		System.out.print(") : " + ret + " - "
				+ method.getDeclaringClass().getName());
		System.out.println();
			
		
	}
}
