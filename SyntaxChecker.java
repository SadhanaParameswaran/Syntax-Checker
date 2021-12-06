package Project;    
import java.util.*;
public class SyntaxChecker 
{
	public static void main(String args[])
    {
        String expression;
        String expre;
        String[] a = new String[100];
        Scanner sc = new Scanner(System.in);
        int choice;
        do
        {  
            System.out.println("Enter your choice: ");
            System.out.println("1. brackets checking");
            System.out.println("2. while loop checking");
            System.out.println("3. for loop checking");
            System.out.println("4. do while loop checking");
            System.out.println("5. if statement checking");
            System.out.println("6. keyword checker");
            System.out.println("7. datatype checker");
            System.out.println("8. identifier checker");
            System.out.println("9. exit");
            choice = sc.nextInt();
            
            switch(choice)
            {
            	case 1: System.out.println("Enter your expression to check brackets: ");    
            			expression = sc.next();
            			boolean result = SyntaxChecker.isDelimiterMatching(expression);
            			System.out.println(expression +" == "+result);
            			System.out.println();
            			break;
          		
                case 2: System.out.println("Enter your while expression: "); 
                	    expre = sc.next();
                	    SyntaxChecker.whileLoopChecker(expre);
    			        System.out.println();			
			            break;
            			
            	case 3: System.out.println("Enter your for expression: "); 
                	    expre = sc.next();             
                	    SyntaxChecker.forLoopChecker(expre);
    			        System.out.println();			
			            break;
			            
            	case 4: System.out.println("Enter your do-while expression: ");
            			expre = sc.next();
            			SyntaxChecker.DoWhileLoopChecker(expre);
    			        System.out.println();			
			            break;
			            
            	case 5: System.out.println("Enter your if expression: ");
    					expre = sc.next();
    					SyntaxChecker.IfStatementChecker(expre);
    					System.out.println();			
    					break;
    					
            	case 6: System.out.println("Enter your keyword: ");
            	        String v = sc.next();
            	        SLIST obj = new SLIST();
            	        obj.keywordsCharacters();	
            	        obj.KeywordChecker(v); 			
					    System.out.println();			
					    break;
					   
            	case 7: System.out.println("Enter your datatype: ");
            	        String z = sc.next();
     	                a[0] = z;
     	                SyntaxChecker.DataTypeChecker(a);
     	                System.out.println();			
						break;
						
            	case 8: System.out.println("Enter your identifier: ");
				        String Y = sc.next();
				        SLIST obj1 = new SLIST();
				        obj1.keywordsCharacters();				        
				        obj1.IdentifierChecker(Y);
				        System.out.println();			
						break;
				        
    		    default: System.out.println("Invalid Input!");
            }
        }
        while(choice!=9);
        sc.close();
    }
    public static boolean isDelimiterMatching(String inputExpr) 
    {
        int stackSize = inputExpr.length();
        Stack theStack = new Stack(stackSize);
        for (int j = 0; j < inputExpr.length(); j++) 
        {
            char ch = inputExpr.charAt(j);
            switch (ch) 
            {
                case '{':
                case '[':
                case '(':
                          theStack.push(ch);
                          break;
                case '}':
                case ']':
                case ')':
                          if (!theStack.isStackEmpty()) 
                          {
                             char stackContent = theStack.pop();
                             if ((ch == '}' && stackContent != '{') || (ch == ']' && stackContent != '[') 
                            		 || (ch == ')' && stackContent != '('))
                             {
                                 System.out.println("\nMismatch found");
                                 return false;
                             }
                          } 
                          else 
                          { 
                             System.out.println("\nMismatch found ");
                             return false;
                          }
                          break;
                default:  break;
            }
        }
        if (!theStack.isStackEmpty())
        {
            System.out.println("\nError: missing right delimiter");
            System.out.println();
            return false;
        }
        return true;
    }
    public static boolean whileLoopChecker(String input)
    {
    	int flag=0;
    	int stackSize = input.length();
    	if( (input.length()<6) ||(input.charAt(0) != 'w') || (input.charAt(1) != 'h') ||
    	    (input.charAt(2) != 'i')  || (input.charAt(3) != 'l')  || (input.charAt(4) != 'e')) 
    	{
       	 	System.out.println("\nError in 'while' keyword usage");
       	 	return false;
    	}
    	else 
    	{ 
    	        if((input.charAt(5)!='(') && (input.charAt(stackSize- 1 ) != ')')) 
    	        {
    	        	System.out.println("\nSyntax error, Brackets are missing");
    	            flag++;
    	        } 
    	        else if(input.charAt(5)!='(') 
    	        {
    	        	System.out.println("\nOpening parenthesis absent after 'while' keyword");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize-1) != ')')
    	        {
    	            System.out.println("\nClosing parenthesis absent at the end of while");
    	            flag++;
    	        }
    	        else if((input.charAt(7)) != '>' && (input.charAt(7))!='<' && 
    	                ((input.charAt(7))!='=' || (input.charAt(8))!='=') && 
    	                ((input.charAt(7))!='!' || (input.charAt(8))!='='))
    	        { 
    	            System.out.println("\nError in the usage of symbol");
    	            flag++;
    	        } 
    	        if(flag == 0)
    	        {
    	            System.out.println("\nNo error!");
    	        }
    	  }
    	return true;
    }
    
    public static boolean forLoopChecker(String input)
    {
        int bracket1 = 0, bracket2 = 0, flag = 0;
        int stackSize = input.length();
        if( (input.length()<3)       || (input.charAt(0) != 'f') ||
            (input.charAt(1) != 'o') || (input.charAt(2) != 'r')) 
        {
        	 System.out.println("\nError in 'for' keyword usage");
        	 return false;
        } 
        else 
        {
        	for(int i=0;i<stackSize;i++)
        	{
        		char ch = input.charAt(i);
        		if(ch == '(')
        		{
        			bracket1 ++;
        		}
        		else if(ch == ')')
        		{
        			bracket2 ++;
        		}
        		else if(ch == ';')
        		{
        		}
        		else if(ch == ' ')
        		{
        			continue;
        		}
        		else	 
        		{	
        			continue;
        		}
        	}
            if((input.charAt(3)!='(') && (input.charAt(stackSize- 1 ) != ')')) 
        	{
        		System.out.println("\nSyntax error, Brackets are missing");
        		flag++;
        	}
        	else if(input.charAt(3)!='(') 
        	{
        		System.out.println("\nOpening parenthesis absent after 'for' keyword");
        		flag++;
        	}
        	else if(input.charAt(stackSize-1 ) != ')')
        	{
        		System.out.println("\nClosing parenthesis absent at the end of for");
        		flag++;             
        	}
        	else if((input.charAt(stackSize-5))!=';' || (input.charAt(stackSize-9))!=';' && (input.charAt(stackSize-10))!=';')
            { 
                System.out.println("\nSemicolon Error");
                flag++;
            }
        	else if(bracket1 != 1 || bracket2 != 1 || bracket1 != bracket2)
        	{ 
        		System.out.println("\nParentheses Count Error");
        		flag++;
        	}
        	if(flag == 0)
        	{
        		System.out.println("\nNo error!");
        	}   
        	return true;
        }
    }
    public static boolean DoWhileLoopChecker(String input)
    {
    	int flag = 0;
    	int stackSize = input.length();
    	
    	if((input.length()<3) || (input.charAt(0) != 'd') || (input.charAt(1) != 'o'))
    	{
    		System.out.println("\nError in 'do' keyword usage");
       	 	return false;
    	}
    	else
    	{
    	        if((input.charAt(2)!='{') && (input.charAt(stackSize- 13) != '}') && (input.charAt(stackSize- 12 ) != '}')) 
    	        {
    	        	System.out.println("\nSyntax error, Brackets are missing");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize-1) != ';')
    	        {
    	        	System.out.println("\nMissing semicolon after while");
    	        	flag++;
    	        }
    	        else if(input.charAt(2) != '{')
    	        {
    	            System.out.println("\nOpening parenthesis absent after 'do' keyword");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize-13)!='}' && input.charAt(stackSize-12)!='}') 
    	        {
    	        	System.out.println("\nClosing parenthesis absent after 'do' statement");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize- 2 ) != ')')
    	        {
    	            System.out.println("\nClosing parenthesis absent at end of while condition");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize- 7)!='(' && input.charAt(stackSize- 6)!='(') 
    	        {
    	        	System.out.println("\nOpening parenthesis absent after 'while' keyword");
    	            flag++;
    	        }
    	        else if(((input.charAt(stackSize-4) != '>') && (input.charAt(stackSize-5) != '>'))
    	        		                                    &&
    	        		((input.charAt(stackSize-4) != '<') && (input.charAt(stackSize-5) != '<'))
    	        		                                    &&
    	        		((input.charAt(stackSize-5) != '!') && (input.charAt(stackSize-6) != '!'))
    	        		                                    &&
    	        		((input.charAt(stackSize-4) != '=') && (input.charAt(stackSize-5) != '='))
    	        		                                    &&
    	        		((input.charAt(stackSize-5) != '=') && (input.charAt(stackSize-6) != '='))
    	        		                                    &&
    	        		((input.charAt(stackSize-4) != '=') && (input.charAt(stackSize-5) != '=')))
    	        { 
    	            System.out.println("\nError in the usage of symbol");
    	            flag++;
    	        } 
    	        if( (input.length()<6) || (input.charAt(stackSize-12) != 'w') && (input.charAt(stackSize-11) != 'w') ||
    	            (input.charAt(stackSize-11) != 'h') && (input.charAt(stackSize-10) != 'h') ||
    	            (input.charAt(stackSize-10) != 'i') && (input.charAt(stackSize-9) != 'i') ||
    	            (input.charAt(stackSize-9) != 'l')  && (input.charAt(stackSize-8) != 'l') ||
    	            (input.charAt(stackSize-8) != 'e')  && (input.charAt(stackSize-7) != 'e')) 
    	           	{
    	              	 System.out.println("\nError in 'while' keyword usage");
    	              	 return false;
    	           	}
    	        if(flag == 0)
    	        {
    	            System.out.println("\nNo error!");
    	        }
    	  }
    	return true;
    }
    public static boolean IfStatementChecker(String input)
    {
    	int flag = 0;
    	int stackSize = input.length();
    	if( (input.length()<3) ||(input.charAt(0) != 'i') || (input.charAt(1) != 'f') ) 
    	{
       	 	System.out.println("\nError in 'if' keyword usage");
       	 	return false;
    	}
    	else 
    	{ 	    
    	        if((input.charAt(2)!='(') && (input.charAt(stackSize- 1 ) != ')')) 
    	        {
    	        	System.out.println("\nSyntax error, Brackets are missing");
    	            flag++;
    	        }
    	        else if(input.charAt(stackSize- 1 ) != ')')
    	        {
    	            System.out.println("\nClosing parenthesis absent at the end of statement");
    	            flag++;
    	        }
    	        else if(input.charAt(2)!='(') 
    	        {
    	        	System.out.println("\nOpening parenthesis absent after 'if' keyword");
    	            flag++;
    	        }
    	        else if(((input.charAt(stackSize-4) != '>') || (input.charAt(stackSize-3) != '>'))
                        									&&
                        ((input.charAt(stackSize-4) != '<') || (input.charAt(stackSize-3) != '<'))
                        									&&
                        ((input.charAt(stackSize-5) != '!') || (input.charAt(stackSize-4) != '!'))
                        									&&
                        ((input.charAt(stackSize-4) != '=') || (input.charAt(stackSize-3) != '='))
                        									&&
                        ((input.charAt(stackSize-5) != '=') || (input.charAt(stackSize-4) != '='))
                        									&&
                        ((input.charAt(stackSize-4) != '=') || (input.charAt(stackSize-3) != '=')))
    	        { 
    	            System.out.println("\nError in the usage of symbol");
    	            flag++;
    	        }  
    	        if(flag == 0)
    	        {
    	            System.out.println("\nNo error!");
    	        }
    	  }
    	return true;
    }    
    public static boolean DataTypeChecker(String[] a)
    {
    	String[] ss= {"int", "char", "boolean", "float", "double", "short", "long", "byte"};
    	if(ss[0].equals(a[0]) || ss[1].equals(a[0]) || ss[2].equals(a[0]) || ss[3].equals(a[0]) ||
    	   ss[4].equals(a[0]) || ss[5].equals(a[0]) || ss[6].equals(a[0]) || ss[7].equals(a[0]) ) 
    	{
    		System.out.println("\n'"+a[0]+ "' is a datatype!");
    	}
    	else 
    	{
    		System.out.println("\n'"+a[0]+ "' is not a datatype");
    	}
    	return true;
    }
}
class Stack
{
    int stackSize;
    char[] stackArr;
    int top;
    public Stack(int size) 
    {
        stackSize = size;
        stackArr = new char[stackSize];
        top = -1;
    }
    public void push(char entry) 
    {
        stackArr[++top] = entry;
    }
    public char pop() 
    {
        char entry = stackArr[top--];
        return entry;
    }
    public char peek() 
    {
        return stackArr[top];
    }
    public boolean isStackEmpty() 
    {
        return (top == -1);
    }
    public boolean isStackFull() 
    {
        return (top == stackSize - 1);
    }
}
class Node
{
    String data;
    Node next;
    Node()
    { 
        data = "";
        next = null;
    }
    Node(String element)
    { 
        data = element;
        next = null;
    }
    Node(String element, Node n)
    { 
        data = element;
        next = n;
    }
}
class SLIST
{
    Node head;
    SLIST()
    {
        head = null;
    }
    SLIST(String s)
    { 
        head = new Node(s);    
    }
    void insertfront(String s)
    {
        Node temp = new Node(s);
        temp.next = head;
        head = temp;
    }
    public boolean IdentifierChecker(String input)
    {
    	 Node temp = head;
         if((input.charAt(0)>='A' && input.charAt(0)<='Z') || (input.charAt(0)>='a' && input.charAt(0)<='z') ||  (input.charAt(0) == '$') || (input.charAt(0) == '_'))
         {
             while(temp!=null)
             {
                 if(input.compareTo(temp.data)==0)
                 {
                	 System.out.println("\nKeyword '"+input+"' is used, therefore it isn't a valid identifier");
                     return false;
                 }
                 temp=temp.next;
             }
             temp = head;
             while(temp!=null)
             {
                 for(int i=1; i<input.length(); i++)
                 {
                     	if((Character.toString(input.charAt(i))).compareTo(temp.data)==0||(int)input.charAt(i)==34||(int)input.charAt(i)==92)
                     	{
                     		System.out.println("\nSpecial character other than '_' and '$' is used, it is not an identifier");
                     	    return false;
                     	}
                 }
                 temp=temp.next;
             }
         }
         else
         {
        	 System.out.println("\n'"+input+"', the starting voilates the rules of an identifier");
             return false;
         }
         System.out.println("\n'"+input+"' is a valid identifier!");
         return true;
    }
    public boolean KeywordChecker(String a)
    {  
    	Node temp = head;
    	while(temp != null)
    	{
    		if(a.compareTo(temp.data)==0)
            {
        		System.out.println("\n'"+a+ "' is a keyword!");
        		return false;
        	}
    		temp=temp.next;
    	}  		
    	System.out.println("\n'"+a+ "' is not a keyword");

    	return true;
    }
    void keywordsCharacters()
    {
        insertfront("abstract");
        insertfront("int");
        insertfront("char");
        insertfront("continue");
        insertfront("for");
        insertfront("new");
        insertfront("switch");
        insertfront("assert");
        insertfront("default");
        insertfront("goto");
        insertfront("package");
        insertfront("synchronized");
        insertfront("boolean");
        insertfront("do");
        insertfront("if");
        insertfront("private");
        insertfront("this");
        insertfront("break");
        insertfront("double");
        insertfront("implements");
        insertfront("protected");
        insertfront("throw");
        insertfront("byte");
        insertfront("else");
        insertfront("import");
        insertfront("public");
        insertfront("throws");
        insertfront("case");
        insertfront("enum");
        insertfront("instanceof");
        insertfront("return");
        insertfront("transient");
        insertfront("catch");
        insertfront("extends");
        insertfront("int");
        insertfront("short");
        insertfront("try");
        insertfront("char");
        insertfront("final");
        insertfront("interface");
        insertfront("static");
        insertfront("void");
        insertfront("class");
        insertfront("finally");
        insertfront("long");
        insertfront("strictfp");
        insertfront("volatile");
        insertfront("const");
        insertfront("float");
        insertfront("native");
        insertfront("super");
        insertfront("while");
        insertfront("*");
        insertfront(" ");
        insertfront("@");
        insertfront("%");
        insertfront("!");
        insertfront("#");
        insertfront("^");
        insertfront("&");
        insertfront("(");
        insertfront(")");
        insertfront("-");
        insertfront("~");
        insertfront("`");
        insertfront("+");
        insertfront("/");
        insertfront("{");
        insertfront("}");
        insertfront("[");
        insertfront("]");
        insertfront("");
        insertfront("'");
        insertfront(";");
        insertfront(":");
        insertfront(",");
        insertfront(".");
        insertfront(">");
        insertfront("<");
        insertfront("?");
        insertfront("|");
        insertfront("=");
    }
}
