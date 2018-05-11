import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Utilities extends HttpServlet 
{
	private	PrintWriter p;
	private	HttpServletRequest req;

	public  Utilities(HttpServletRequest request,PrintWriter pw)
	{       req=request;
			p=pw;
		
	}
	public void printHtml(String file)throws IOException
	{
		String result=HtmlToString(file);
		
		p.print(result);
		
	}

	public String HtmlToString(String file) throws IOException{
		byte[] encoded  =Files.readAllBytes(Paths.get(file));
		return new String(encoded);	
	}


}