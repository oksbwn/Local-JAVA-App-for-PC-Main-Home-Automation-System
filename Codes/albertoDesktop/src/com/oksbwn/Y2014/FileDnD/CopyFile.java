package com.oksbwn.Y2014.FileDnD;
import java.io.IOException;

import javax.swing.JOptionPane;

import ch.fhnw.filecopier.CopyJob;
import ch.fhnw.filecopier.FileCopier;
import ch.fhnw.filecopier.Source;
public class CopyFile
{
  public void copy(String src,String des)
	{
	    Source[] sources = new Source[]
	    		{ new Source(src)};
	        String[] destinations = new String[]{
	           des
	        };
	        CopyJob copyJob = new CopyJob(sources, destinations);
	        FileCopier fileCopier = new FileCopier();
	        try {
				fileCopier.copy(copyJob);
			} catch (IOException e) 
			{
				JOptionPane.showMessageDialog(null,"Error Occured");
			}
	}
}
