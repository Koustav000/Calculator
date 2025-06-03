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
		if((int)a>=65 && (int)a<=122  && (int)b>=65 && (int)b<=122)
		{
			out.println("Enter a valid number");
		}
		Double i=Double.parseDouble(req.getParameter("num1"));
		Double j=Double.parseDouble(req.getParameter("num2"));
		char exp=req.getParameter("expression").charAt(0);
		if(exp=='+')
		{
			Double k=i+j;
			out.println("Result is: "+k);
		}
		else if(exp=='-')
		{
			Double k=i-j;
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
				Double k=i/j;
				out.println("Result is: "+k);
			}
		}
		else if(exp=='*')
		{
			Double k=i*j;
			out.println("Result is: "+k);
		}
		else if(exp=='%')
		{
			Double k=i%j;
			out.println("Result is: "+k);
		}
		else if(exp=='^')
		{
			Double k=Math.pow(i,j);
			out.println("Result is: "+k);
		}
}
}