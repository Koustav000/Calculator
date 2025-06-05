package com.telusko;
import jakarta.servlet.http.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet("/calculate")
public class Calculator extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		char a=req.getParameter("num1").charAt(0);
		char b=req.getParameter("num2").charAt(0);
		PrintWriter out=res.getWriter();
		res.setContentType("text/plain");
		if((int)a>=65 && (int)a<=122  && (int)b>=65 && (int)b<=122)
		{
			out.println("Enter a valid number");
		}
		String x=req.getParameter("num1");
		String y=req.getParameter("num2");
		if(isFloat(x) || isFloat(y))
		{
			float i=Float.parseFloat(req.getParameter("num1"));
			float j=Float.parseFloat(req.getParameter("num2"));
			char exp=req.getParameter("expression").charAt(0);
			if(exp=='+')
			{
				float k=i+j;
				String formatted=String.format("%.3f",k);
				float d=Float.parseFloat(formatted);
				if(k % 1==0)
					out.printf("Result is: "+(int)k);
				else
					out.printf("Result is: "+remove(d));
			}
			else if(exp=='-')
			{
				float k=i-j;
				String formatted=String.format("%.3f",k);
				float d=Float.parseFloat(formatted);
				if(Math.abs(k-Math.round(k))<1e-3)
					out.printf("Result is: "+(int)k);
				else
					out.printf("Result is: "+remove(d));
			}
			else if(exp=='/')
			{
				if(j==0.0 || j==0)
				{
					out.println("Divided by zero is not possible");
				}
				else
				{
					float k=i/j;
					String formatted=String.format("%.3f",k);
					float d=Float.parseFloat(formatted);
					if(k % 1==0)
						out.printf("Result is: "+(int)k);
					else
						out.printf("Result is: "+remove(k));
				}
			}
			else if(exp=='*')
			{
				float k=i*j;
				String formatted=String.format("%.3f",k);
				float d=Float.parseFloat(formatted);
				if(k % 1==0)
					out.printf("Result is: "+(int)k);
				else
					out.printf("Result is: "+remove(k));
			}
			else if(exp=='%')
			{
				float k=i%j;
				String formatted=String.format("%.3f",k);
				float d=Float.parseFloat(formatted);
				if(k % 1==0)
					out.printf("Result is: "+(int)k);
				else
					out.printf("Result is: "+remove(k));
			}
			else if(exp=='^')
			{
				float k=(float) Math.pow(i,j);
				String formatted=String.format("%.3f",k);
				float d=Float.parseFloat(formatted);
				if(k % 1==0)
					out.printf("Result is: "+(int)k);
				else
					out.printf("Result is: "+remove(k));
			}
		}
		else {
			int i=Integer.parseInt(req.getParameter("num1"));
			int j=Integer.parseInt(req.getParameter("num2"));
			char exp=req.getParameter("expression").charAt(0);
		if(exp=='+')
		{
			int k=i+j;
			out.println("Result is: "+k);
		}
		else if(exp=='-')
		{
			int k=i-j;
			out.println("Result is: "+k);
		}
		else if(exp=='/')
		{
			if(j==0.0 || j==0)
			{
				out.println("Divided by zero is not possible");
			}
			else
			{
				int k=i/j;
				out.println("Result is: "+k);
			}
		}
		else if(exp=='*')
		{
			int k=i*j;
			out.println("Result is: "+k);
		}
		else if(exp=='%')
		{
			int k=i%j;
			out.println("Result is: "+k);
		}
		else if(exp=='^')
		{
			int k=(int)Math.pow(i,j);
			out.println("Result is: "+k);
		}
		}
}
	public static boolean isFloat(String m) {
        try {
            //float num = Float.parseFloat(m);
            // Check if it contains a decimal or scientific notation
            return m.contains(".") || m.toLowerCase().contains("e");
        } catch (NumberFormatException e) {
            return false;
        }
    }
	public static String remove(float c)
	{
		if(c==(int)c)
			return String.format("%d",(int)c);
		else
			return Float.toString(c);
	}
	}
